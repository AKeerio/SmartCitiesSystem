package cssd.subtask.pkg3;

public class SensorHandler {
    
    private SensorChangeListener listener;
    private Sensor sensor;
    
    public void addListener(SensorChangeListener listener) {
        this.listener = listener;
    }
    
    public Reading update(Reading reading) {
        reading.attachTimestamp(SystemClock.getTimestamp());
        return reading;
    }
    
    public Reading getLastReading() {
        return sensor.getLastReading();
    }
    
    public void notifyListener() {
        Reading reading = getLastReading();
        listener.Trigger(reading);
    }
    
}
