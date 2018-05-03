package cssd.subtask.pkg3;

public class SensorChangeListener {
    
    private final SensorStation hook;
    
    public SensorChangeListener(SensorStation hook) {
        this.hook = hook;
    }
   
    public void Trigger(Reading reading) {
        hook.addData(reading);
    }
    
}
