package cssd.subtask.pkg3;

public class Sensor {
    
    private final String location;
    private Reading previousReading;
    private int sensorId;
    
    public Sensor(String location) {
        this.location = location;
        this.previousReading = this.getSensorReading();
    }
    
    public Reading getSensorReading() {
        // Interface with emulator.
        // Set value of previous to value returned by emulator.
        return new Reading();
    }
    
    public String getSensorLocation() {
        return this.location;
    }
    
    public Reading getLastReading() {
        return this.previousReading;
    }
}
