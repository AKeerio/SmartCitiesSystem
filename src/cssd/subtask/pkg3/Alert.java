package cssd.subtask.pkg3;
import java.sql.Timestamp;

// Louis

public class Alert {
    
    private String sensorId;
    private Timestamp time;
    
    public void attachTimestamp(Timestamp time) {
        this.time = time;
    }
    
    public void attachSensorId(String sensorId) {
        this.sensorId = sensorId;
    }
    
    public String getSensorId() {
        return this.sensorId;
    }
    
    public Timestamp getTimestamp() {
        return this.time;
    }

}

