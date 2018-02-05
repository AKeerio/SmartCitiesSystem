/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

/**
 *
 * @author b5016315
 */
public class StationData {
    /*
    This class wokrs like an interaface between GUI and SensorStation. 
    GUI has to use this class to takl to any particular station
    */
    private SensorStation station;
    private Reading[] individualSensorData;
    private AverageReading[] averageReadings;
    public StationData(SensorStation stationIn){          
        station=stationIn;//This is passed from GUI
    }
    
    public void gatherData(){
        individualSensorData=station.collectIndividualSensorData();
        averageReadings=station.getAllAverageData();
    }
    /*
    Passes rule to add from GUI to SensorStation
    Also needs to know which actuator to add the rule to
    */
    public void addRule(Float min, Float max, String Metric,ActuatorHandler actuator){ 
        station.addRule(max, min, Metric, actuator);
    }
    /*
    Passes rule from GUI to SensorStation to be removed
    Also needs to know which actuator to delete the rule from which
    can be avoided if we search through all rules for all the actuators
    */
    
    public void deleteRule(Rule rule,ActuatorHandler actuator){  
        station.deleteRule(rule,actuator);
    }

    public void deleteAlert(Alert alert){
        station.deleteAlert(alert);
    }
    /*
    These two funcitons will used by GUI
    */
    public Reading[] getIndividualSensorData()
    {
        return individualSensorData;
    }
    
    public AverageReading[] getAverageReadings(){
        return averageReadings;
    }
}

// New code is uploaded, I have finished all my work, I've gone home.