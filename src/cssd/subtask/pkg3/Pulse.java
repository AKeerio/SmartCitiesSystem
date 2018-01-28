package cssd.subtask.pkg3;

// Louis

public class Pulse {
    
    private SensorHandler[] sensors;
    private final PulseThread worker;
    
    public Pulse() {
        worker = new PulseThread();
    }
    
    public void start(SensorHandler[] sensors) {
        this.sensors = sensors;
        worker.start();
    }
    
    private class PulseThread extends Thread {
        
        @Override
        public void run() {
            while(true) {
                for(SensorHandler sensor : sensors) {
                    if(sensor.tick()) {
                        sensor.notifyListener();
                    }
                }
            }
        }
        
    }
    
}
