package cssd.subtask.pkg3;
import java.util.HashMap;

// Louis

public class SensorStation {
    
    private SensorHandler[] sensors;
    //private ActuatorHandler[] actuators;
    private final HashMap<String, Integer> metricTypes; // Used to speed up collection of data.
    private int sensorCount;
    private int actuatorCount;
    private final int CHANGE_BY = 1;
    
    public SensorStation() {
        sensors = new SensorHandler[0];
        sensorCount = 0;
        actuatorCount = 0;
        metricTypes = new HashMap<>();
    }
    
    /**
     * Returns an array of Reading objects containing the last known readings for
     * each sensor managed by this sensor station.
     * @return Returns an array of Reading objects, or null if no sensors are connected.
     */
    public Reading[] collectIndividualSensorData() {
        if(sensors.length > 0)
        {
            Reading[] readings = new Reading[sensors.length];
            for(int i = 0; i < sensors.length; ++i) {
                readings[i] = sensors[i].getLastReading();
            }
            return readings;
        }
        return null;
    }
    
    /**
     * Returns an array of AverageReading objects, each containing the average reading
     * recorded for that specific metric type. For example, if there were 12 cars recorded over
     * 4 sensors then the average reading for cars would be 3.
     * @return Returns an array of AverageReading objects, or null if there are no sensors connected.
     */
    public AverageReading[] getAllAverageData() {
        if(sensors.length > 0)
        {
            AverageReading[] avgReadings = new AverageReading[metricTypes.size()];
            int[] hits = new int[metricTypes.size()];
            metricTypes.forEach((k,v) -> (avgReadings[(int)v] = new AverageReading()).setMetric((String)k)); // Initialise the avgReadings array.
            for(int i = 0; i < sensors.length; ++i) {
                Reading reading = sensors[i].getLastReading();
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
        if(sensors.length > 0)
        {
            AverageReading[] readings = new AverageReading[metricTypes.size()];
            metricTypes.forEach((k,v) -> (readings[(int)v] = new AverageReading()).setMetric((String)k));
            for(int i = 0; i < sensors.length; ++i) {
                Reading reading = sensors[i].getLastReading();
                readings[(int)metricTypes.get(reading.getMetrics())].incValue(reading.getValue());
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
            System.arraycopy(sensors, 0, temp, 0, sensorCount);
            sensors = temp;
        }
        sensors[sensorCount++] = sensor;
        String metricType = sensor.getLastReading().getMetrics(); // We're simply accessing the reading, not changing it.
        if(!metricTypes.containsKey(metricType)) {
            metricTypes.put(metricType, metricTypes.size());
        }
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
            System.arraycopy(sensors, 0, temp, 0, sensorCount);
            sensors = temp;
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
    }
}
