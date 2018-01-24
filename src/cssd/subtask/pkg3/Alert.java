package cssd.subtask.pkg3;
import java.sql.Timestamp;

public class Alert {
    
    private int sensorId;
    private Timestamp time;
    
    public void attachTimestamp(Timestamp time) {
        this.time = time;
    }
    
    public void attachSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
    
    public int getSensorId() {
        return this.sensorId;
    }
    
    public Timestamp getTimestamp() {
        return this.time;
    }
    
}
