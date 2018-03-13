package cssd.subtask.pkg3;
import java.sql.Timestamp;

// Louis

public class Alert {
    
    private String sensorId;
    private Timestamp time;
    
    /**
     * Sets the timestamp for the current alert.
     * @param time The time value that you want to set for this alert.
     */
    public void attachTimestamp(Timestamp time) {
        this.time = time;
    }
    
    /**
     * Sets the Id for the current alert.
     * @param sensorId The string value that you want to set for the current alert.
     */
    public void attachSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
    
    /**
     * Returns the current Alerts id.
     * @return The string value of the current alert.
     */
    public String getSensorId() {
        return this.sensorId;
    }
    
    /**
     * Returns the current Alerts time stamp.
     * @return The time value of the current alert.
     */
    public Timestamp getTimestamp() {
        return this.time;
    }

}

