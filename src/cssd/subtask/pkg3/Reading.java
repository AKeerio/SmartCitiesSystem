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
    
    /**
     * Attach the time stamp for the desired reading.
     * @param time The int value you want to set.
     */
    public void attachTimestamp(Timestamp time) {
        this.time = time;
    }
    
    /**
     * Attach the sensor handler for the desired reading.
     * @param sensor The sensor handler you want to set.
     */
    public void attachSensor(SensorHandler sensor) {
        this.associatedSensor = sensor;
    }
    
    /**
     * Attach the location for the desired reading.
     * @param location The string value you want to set.
     */
    public void attachLocation(String location) {
        this.location = location;
    }
    
    /**
     * Attach the metrics for the desired reading.
     * @param metrics The string value you want to set.
     */
    public void attachMetrics(String metrics) {
        this.metrics = metrics;
    }
    
    /**
     * Attach the value for the desired reading.
     * @param value The double value you want to set.
     */
    public void attachValue(double value) {
        this.value = value;
    }
    
    /**
     * Increase the value for the desired reading.
     * @param value The double value you want to increase it by.
     */
    public void incValue(double value) {
        this.value += value;
    }
    
     /**
     * Returns the time stamp from the desired reading.
     * @return  The time stamp value from the desired reading.
     */
    public Timestamp getTimestamp() {
        return this.time;
    }
    
    /**
     * Returns the location from the desired reading.
     * @return  The location value from the desired reading.
     */
    public String getLocation() {
        return this.location;
    }
    
    /**
     * Returns the metrics from the desired reading.
     * @return  The metrics value from the desired reading.
     */
    public String getMetrics() {
        return this.metrics;
    }
    
    /**
     * Returns the value from the desired reading.
     * @return  The value from the desired reading.
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * Returns the sensor from the desired reading.
     * @return  The sensor from the desired reading.
     */
    public SensorHandler getSensor() {
        return this.associatedSensor;
    }
    
}
