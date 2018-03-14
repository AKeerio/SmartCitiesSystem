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
    
    public final Reading getSensorReading() {
        Reading random = new Reading();
        String metric = new String[] {"Cars", "Temperature", "Humidity", "Air Quality Index", "River Level", "River Flow"}[(int)(Math.random() * 10) % 4];
        random.attachLocation(new String[] {"District 1", "District 2", "District 3", "District 4"}[(int)(Math.random() * 10) % 4]);
        random.attachMetrics(metric);
        random.attachTimestamp(SystemClock.getTimestamp());
        switch(metric) {
            case "Cars":
                random.attachValue(Emulator.getTrafficData());
                break;
            case "Temperature":
                random.attachValue(Emulator.getTemperatureData());
                break;
            case "Humidity":
                random.attachValue(Emulator.getHumidityData());
                break;
            case "Air Quality Index":
                random.attachValue(Emulator.getAirQualityData());
                break;
            case "River Level":
                random.attachValue(Emulator.getRiverLevelReading());
                break;
            case "River Flow":
                random.attachValue(Emulator.getRiverFlowReading());
                break;
        }
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
