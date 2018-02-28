package cssd.subtask.pkg3;

// Louis

public class Emulator {
    
    private static int previousTrafficReading = 5; // Cars
    private static double previousTemperatureReading = 15.3; // Celsius
    private static double previousHumidityReading = 65; // %rh (Relative Humidity)
    private static int previousAirQualityReading = 25; // Air Quality Index (0 - 500)
    private static double previousRiverLevelReading = 1.3; // Metres
    private static double previousRiverFlowReading = 0.9; // Litres/sec
    
    // I've used sine so the values fluctuate between positive and negative.
    // Values will remain within set parameters.
    
    public static int getTrafficData() {
        int newReading = (int)(Math.sin(Math.random() * 10) * 10);
        if(newReading + previousTrafficReading > 600 || newReading + previousTrafficReading < 0) {
            newReading = -newReading;
        }
        previousTrafficReading = (previousTrafficReading + newReading);
        return previousTrafficReading;
    }
    
    public static double getTemperatureData() {
        double newReading = (Math.sin(Math.random() * 10) * 2);
        if(newReading + previousTemperatureReading > 40 || newReading + previousTemperatureReading < -20) {
            newReading = -newReading;
        }
        previousTemperatureReading = (previousTemperatureReading + newReading);
        return previousTemperatureReading;
    }
    
    public static double getHumidityData() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousHumidityReading > 100 || newReading + previousHumidityReading < 30) {
            newReading = -newReading; // Humidity is a percentage. Below 30% is very unlikely.
        }
        previousHumidityReading = (previousHumidityReading + newReading);
        return previousHumidityReading;
    }
    
    public static int getAirQualityData() {
        int newReading = (int)(Math.sin(Math.random() * 10) * 10);
        if(newReading + previousAirQualityReading > 500 || previousAirQualityReading < 0) {
            newReading = -newReading;
        }
        previousAirQualityReading = (previousAirQualityReading + newReading);
        return previousAirQualityReading;
    }
    
    public static double getRiverLevelReading() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousRiverLevelReading > 10 || newReading + previousRiverLevelReading < 1) {
            newReading = -newReading;
        }
        previousRiverLevelReading = (previousRiverLevelReading + newReading);
        return previousRiverLevelReading;
    }
    
    public static double getRiverFlowReading() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousRiverFlowReading > 3 || newReading + previousRiverFlowReading < 0.6) {
            newReading = -newReading;
        }
        previousRiverFlowReading = (previousRiverFlowReading + newReading);
        return previousRiverFlowReading;
    }
}
