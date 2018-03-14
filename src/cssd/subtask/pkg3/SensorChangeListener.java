package cssd.subtask.pkg3;

public class SensorChangeListener {
    
    private final SensorStation hook;
    
    /**
     *Sets the hook of the current Sensor Change Listener to the desired Sensor Station 
     * @param hook The desired Sensor Station you want to set.
     */
    public SensorChangeListener(SensorStation hook) {
        this.hook = hook;
    }
   
    /**
     *Adds the reading to the current hook.
     * @param reading The desired reading you want to set.
     */
    public void Trigger(Reading reading) {
        hook.addData(reading);
    }
    
}
