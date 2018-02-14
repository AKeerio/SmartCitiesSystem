package cssd.subtask.pkg3;

    // Louis

public class Sensor {
    
    private final String location;
    private Reading previousReading;
    
    public Sensor(String location /*, String sensorId*/) {
        this.location = location;
        //this.sensorId=sensorId;
        this.previousReading = this.getSensorReading();
    }
    
    public Reading getSensorReading() {
        Reading random = new Reading();
        random.attachLocation(new String[] {"Road1", "Road2", "Road3", "Road4"}[(int)(Math.random() * 10) % 4]);
        random.attachMetrics("Cars");
        random.attachTimestamp(SystemClock.getTimestamp());
        random.attachValue((int)(Math.random() * 10) % 11);
        this.previousReading = random;
        return random;
    }
    
    public String getSensorLocation() {
        return this.location;
    }
    
    public Reading getLastReading() {
        return this.previousReading;
    }
    
  /*  public String getSensorId() {
        return this.sensorId;
    }*/
}
