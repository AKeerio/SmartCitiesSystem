package cssd.subtask.pkg3;

    // Louis

public class SensorHandler {
    
    private SensorChangeListener listener;
    private final Sensor sensor;
    private long pulse;
    private long lastTime;
    private final long DEFAULT_PULSE;
    
    public SensorHandler(Sensor sensor) {
        DEFAULT_PULSE = 1000;
        lastTime = System.currentTimeMillis();
        pulse = DEFAULT_PULSE;
        this.sensor = sensor;
    }
    
    public void addListener(SensorChangeListener listener) {
        this.listener = listener;
    }
    
    public Reading update(Reading reading) {
        reading.attachTimestamp(SystemClock.getTimestamp());
        return reading;
    }
    
    public boolean tick() {
        return (System.currentTimeMillis() - lastTime) >= pulse;
    }
    
    public void incrementPulse(double time) {
        pulse += time;
    }
    
    public void resetPulseIncrement() {
        pulse = DEFAULT_PULSE;
    }
    
    public Reading getLastReading() {
        return sensor.getLastReading();
    }
    
    public void notifyListener() {
        lastTime = System.currentTimeMillis();
        Reading reading = getLastReading();
        listener.Trigger(reading); // If you get an error here, you've not set the listener.
    }
    
}
