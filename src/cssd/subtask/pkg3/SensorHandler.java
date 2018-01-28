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
    
    // tick should return the time since the pulse was last called.
    // So the pulse calls the notify listener and the tick then is the
    // amount of time since the listner was last notified. The pulse class
    // should call the tick function for each sensor handler and compare it
    // to the pulse time for that same sensor handler. If the tick is equal
    // to the pulse time, it should notify the listener.
    
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
