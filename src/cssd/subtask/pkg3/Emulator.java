package cssd.subtask.pkg3;

public class Emulator {
    
    private static int previousTrafficReading = 0;
    private static double previousTemperatureReading = 0;
    private static double previousHumidityReading = 0;
    private static double previousAirQualityReading = 0;
    private static double previousRiverLevelReading = 0;
    private static double previousRiverFlowReading = 0;
    
    // Traffic, Temperature, Humidity, Air Quality (Pollutant levels), River Levels, River Flow Rates.
    
    public static int getTrafficData() {
        previousTrafficReading = (previousTrafficReading + ((int)(Math.random() * 10) % 10));
        return previousTrafficReading;
    }
    
    public static double getTemperatureData() {

    }
    
    public static double getHumidityData() {
        
    }
    
    public static double getAirQualityData() {
        
    }
    
    public static double getRiverLevelReading() {
        
    }
    
    public static double getRiverFlowReading() {
        
    }
}
