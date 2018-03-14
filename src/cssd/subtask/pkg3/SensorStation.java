package cssd.subtask.pkg3;
import java.util.HashMap;
import java.util.ArrayList;

// Louis

public class SensorStation {
    
    private SensorHandler[] sensors;
    private ActuatorHandler[] actuators;
    private Reading[] accumulatedData;
    private final HashMap<String, Integer> metricTypes; // Used to speed up collection of data.
    private int sensorCount;
    private int actuatorCount;
    private Pulse pulse;
    private final int CHANGE_BY = 1;
    private final String id;
    
    public SensorStation(String id) {
        sensors = new SensorHandler[0];
        actuators = new ActuatorHandler[0];
        accumulatedData = new Reading[0];
        sensorCount = 0;
        actuatorCount = 0;
        metricTypes = new HashMap<>();
        this.id = id;
    }
    
    
    /**
     * Returns an array of Reading objects containing the last known readings for
     * each sensor managed by this sensor station. Some indices in the array may be null.
     * @return Returns an array of Reading objects, or null if no sensors are connected.
     */
    public Reading[] collectIndividualSensorData() {
        return accumulatedData.length > 0 ? accumulatedData : null;
    }
    
    /**
     * Returns an array of AverageReading objects, each containing the average reading
     * recorded for that specific metric type. For example, if there were 12 cars recorded over
     * 4 sensors then the average reading for cars would be 3.
     * @return Returns an array of AverageReading objects, or null if there are no sensors connected.
     */
    public AverageReading[] getAllAverageData() {
        if(accumulatedData.length > 0)
        {
            AverageReading[] avgReadings = new AverageReading[metricTypes.size()];
            int[] hits = new int[metricTypes.size()];
            metricTypes.forEach((k,v) -> (avgReadings[(int)v] = new AverageReading()).setMetric((String)k)); // Initialise the avgReadings array.
            for(int i = 0; i < accumulatedData.length; ++i) {
                Reading reading = accumulatedData[i];
                int index = (int)metricTypes.get(reading.getMetrics());
                avgReadings[index].incValue(reading.getValue());
                hits[index]++;
            }
            for(int i = 0; i < avgReadings.length; ++i) {
                avgReadings[i].setValue(avgReadings[i].getValue() / hits[i]);
            }
            return avgReadings;
        }
        return null;
    }
    
    /**
     * Returns an array of Reading objects that contain the total value across all sensors
     * for that specific metric. For example, if sensors 1, 2 and 3 record 5, 2, 3 cars, the
     * total for the cars metric would be 10.
     * @return An array of Reading objects, or null if there are no sensors connected.
     */
    public AverageReading[] accumulateTotalPerMetric() {
        if(accumulatedData.length > 0)
        {
            AverageReading[] readings = new AverageReading[metricTypes.size()];
            metricTypes.forEach((k,v) -> (readings[(int)v] = new AverageReading()).setMetric((String)k));
            for(int i = 0; i < accumulatedData.length; ++i) {
                Reading reading = accumulatedData[i];
                if(reading != null) {
                    readings[(int)metricTypes.get(reading.getMetrics())].incValue(reading.getValue());
                }
            }
            return readings;
        }
        return null;
    }
    
    /**
     * Adds a new sensor to the sensor station. 
     * @param sensor The SensorHandler to add.
     * @throws IllegalArgumentException if sensor is null.
     */
    public void addNewSensor(SensorHandler sensor) throws IllegalArgumentException {
        if(sensor == null) {
            throw new IllegalArgumentException("Sensor passed is null.");
        }
        if(sensorCount >= sensors.length) {
            int newLength = sensors.length + CHANGE_BY;
            SensorHandler[] temp = new SensorHandler[newLength];
            Reading[] rTemp = new Reading[newLength];
            System.arraycopy(sensors, 0, temp, 0, sensorCount);
            System.arraycopy(accumulatedData, 0, rTemp, 0, sensorCount);
            sensors = temp;
            accumulatedData = rTemp;
        }
        sensors[sensorCount++] = sensor;
        String metricType = sensor.getLastReading().getMetrics(); // We're simply accessing the reading, not changing it.
        if(!metricTypes.containsKey(metricType)) {
            metricTypes.put(metricType, metricTypes.size());
        }
        pulse = new Pulse();
        pulse.start(sensors); // This is the only way the design permits.
    }   
    
    /**
     * Deletes a sensor from the sensor station.
     * @param sensor The sensor object to delete.
     * @throws IllegalArgumentException if sensor is null.
     */
    public void deleteSensor(SensorHandler sensor) throws IllegalArgumentException {
        if(sensor == null) {
            throw new IllegalArgumentException("Sensor passed is null.");
        }
        String metricType = sensor.getLastReading().getMetrics();
        for(int i = 0; i < sensors.length; ++i) {
            if(sensors[i] == sensor) {
                for(int j = i; j < sensors.length - 1; ++j) {
                    sensors[j] = sensors[j + 1];
                }
            }
        }
        if(sensors.length - --sensorCount >= CHANGE_BY) {
            int newLength = sensors.length - CHANGE_BY;
            SensorHandler[] temp = new SensorHandler[newLength];
            Reading[] rTemp = new Reading[newLength];
            System.arraycopy(sensors, 0, temp, 0, sensorCount);
            System.arraycopy(accumulatedData, 0, rTemp, 0, sensorCount);
            sensors = temp;
            accumulatedData = rTemp;
        }
        // Check if another sensor uses the same metric type as the one we're removing.
        boolean secondDependency = false;
        for(SensorHandler sh : sensors) {
            String shMetricType = sh.getLastReading().getMetrics();
            if(shMetricType.equals(metricType)) {
                secondDependency = true;
                break;
            }
        }
        // If this sensor is the only one that uses that metric, remove it from the map.
        if(!secondDependency) {
            metricTypes.remove(metricType);
        }
        pulse = new Pulse();
        pulse.start(sensors); // This is the only way the design permits.
    }
    
    public void addData(Reading data) { 
        int index = -1;
        for(int i = 0; i < sensorCount; ++i) {
            if(accumulatedData[i] != null) {
                if(accumulatedData[i].getSensor() == data.getSensor()) {
                    accumulatedData[i] = data;
                    return;
                }
            }
            else
            {
                index = i;
            }
        }
        accumulatedData[index] = data;
    }

    void addNewActuator(ActuatorHandler actuator) {
        if(actuatorCount >= actuators.length) {
            ActuatorHandler[] temp = new ActuatorHandler[actuators.length + CHANGE_BY];
            System.arraycopy(actuators, 0, temp, 0, actuatorCount);
            actuators = temp;
        }
        actuators[actuatorCount++] = actuator;
    }

    void deleteActuator(ActuatorHandler handles) {
        if(actuators.length - actuatorCount >= CHANGE_BY) {
            ActuatorHandler[] temp = new ActuatorHandler[actuators.length - CHANGE_BY];
            System.arraycopy(actuators, 0, temp, 0, actuatorCount);
            actuators = temp;
        } 
        for(int i = 0; i < actuatorCount; ++i) {
            if(actuators[i] == handles) {
                for(int j = i; j < actuatorCount - 1; ++j) {
                    actuators[j] = actuators[j + 1];
                }
            }
        }
        actuatorCount--;
    }
    
    public Alert[] getAllAlerts() {
        ArrayList<Alert> alertsList = new ArrayList<>();
        for(SensorHandler sh : sensors) {
            if(sh.getAlert() != null) {
                alertsList.add(sh.getAlert());
            }
        }
        return alertsList.size() > 0 ? alertsList.toArray(new Alert[alertsList.size()]) : null;
    }

    void deleteRule(Rule rule, ActuatorHandler actuator) {
        Rule[] rules=actuator.getAllRules();
        int rulesCount=actuator.getRuleCount();
        for (int i = 0; i < rulesCount; i++) {
            String currRule="Min: "+rules[i].min+" Max: "+rules[i].max+" Metric: "+rules[i].metric;
            if(currRule.equals(rule.getRuleData()))
            {
                for(int j = i; j < rulesCount - 1; ++j) {
                    rules[j] = rules[j + 1];
                }
            }
        }        
        rulesCount--;
        actuator.setRulesCount(rulesCount);
        
        //update the actuator in the current array of actuators
        for (int i = 0; i < actuatorCount; i++) {
            if(actuators[i].getId().equals(actuator.getId()))
            {
                actuators[i]=actuator;
            }
        }
        /* 
        //We might need to delete this code but I ma keeping it just incase we need it
        for (int i = 0; i < actuatorCount; i++) {
            if(actuators[i].getId().equals(actuator.getId()))
            {
                Rule[] rules= actuators[i].getRules();//did this to avoid creating global variables
                int rulesCount=actuators[i].getRulesCount();
                for (int j = 0; j < rulesCount; j++) {
                    if(rules[j]==rule)
                    {
                        for (int k = i; k<rulesCount-2; k++)
                        {
                            rules[k]=rules[k+1];
                        }
                        rulesCount--;
                        i=rulesCount;
                    }
                }
                actuators[i].setRules(rules);
                actuators[i].setRulesCount(rulesCount);
                break;
            }
        }
        */
    }
    
    void addRule(Float max, Float min, String Metric, ActuatorHandler actuator) {
        boolean added=false;//Stop the loop once the rule has been added
        for (int i = 0; i < actuatorCount; i++) {
            //if(actuators[i].getId()==actuator.getId()){ 
            if(actuators[i]==actuator){
                  actuators[i].addRule(min, max, Metric);
                  break;
            }
        }
    }

    void deleteAlert(Alert alert) {
        //once getAllAlerts function is done we can find an alert and delte it
    }
    
    SensorHandler[] getAllSensors()
    {
        return this.sensors;
    }
    
    public ActuatorHandler[] getAllActuators()
    {
        return this.actuators;
    }
    int getSensorCount()
    {
        return this.sensorCount;
    }

    int getActuatorsCount() {
        return this.actuatorCount;
    }
    
    String getId() {
        return id;
    }
}
