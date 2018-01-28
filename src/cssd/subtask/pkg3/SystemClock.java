package cssd.subtask.pkg3;
import java.sql.Timestamp;

// Louis

public class SystemClock {
    
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
}
