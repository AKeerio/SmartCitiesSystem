package cssd.subtask.pkg3;
import java.sql.Timestamp;

public class Reading {
    
    // Louis
    
    private Timestamp time;
    private String location;
    private SensorHandler associatedSensor;
    private String metrics;
    private double value;
    
    public Reading() {
        
    }
    
    public void attachTimestamp(Timestamp time) {
        this.time = time;
    }
    
    public void attachSensor(SensorHandler sensor) {
        this.associatedSensor = sensor;
    }
    
    public void attachLocation(String location) {
        this.location = location;
    }
    
    public void attachMetrics(String metrics) {
        this.metrics = metrics;
    }
    
    public void attachValue(double value) {
        this.value = value;
    }
    
    public void incValue(double value) {
        this.value += value;
    }
    
    public Timestamp getTimestamp() {
        return this.time;
    }
    
    public String getLocation() {
        return this.location;
    }
    
    public String getMetrics() {
        return this.metrics;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public SensorHandler getSensor() {
        return this.associatedSensor;
    }
    
}
