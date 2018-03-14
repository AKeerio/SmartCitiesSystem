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
    
    /**
     * Returns the previous traffic readings data.
     * @return The int value for the traffic reading.
     */
    public static int getTrafficData() {
        int newReading = (int)(Math.sin(Math.random() * 10) * 10);
        if(newReading + previousTrafficReading > 600 || newReading + previousTrafficReading < 0) {
            newReading = -newReading;
        }
        previousTrafficReading = (previousTrafficReading + newReading);
        return previousTrafficReading;
    }
    
    /**
     * Returns the previous temperature readings data.
     * @return The double value for the temperature reading.
     */
    public static double getTemperatureData() {
        double newReading = (Math.sin(Math.random() * 10) * 2);
        if(newReading + previousTemperatureReading > 40 || newReading + previousTemperatureReading < -20) {
            newReading = -newReading;
        }
        previousTemperatureReading = (previousTemperatureReading + newReading);
        return previousTemperatureReading;
    }
    
    /**
     * Returns the previous humidity readings data.
     * @return The double value for the humidity reading.
     */
    public static double getHumidityData() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousHumidityReading > 100 || newReading + previousHumidityReading < 30) {
            newReading = -newReading; // Humidity is a percentage. Below 30% is very unlikely.
        }
        previousHumidityReading = (previousHumidityReading + newReading);
        return previousHumidityReading;
    }
    
    /**
     * Returns the previous air quality readings data.
     * @return The double value for the air quality reading.
     */
    public static int getAirQualityData() {
        int newReading = (int)(Math.sin(Math.random() * 10) * 10);
        if(newReading + previousAirQualityReading > 500 || previousAirQualityReading < 0) {
            newReading = -newReading;
        }
        previousAirQualityReading = (previousAirQualityReading + newReading);
        return previousAirQualityReading;
    }
    
    /**
     * Returns the previous river level readings data.
     * @return The double value for the river level reading.
     */
    public static double getRiverLevelReading() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousRiverLevelReading > 10 || newReading + previousRiverLevelReading < 1) {
            newReading = -newReading;
        }
        previousRiverLevelReading = (previousRiverLevelReading + newReading);
        return previousRiverLevelReading;
    }
    
    /**
     * Returns the previous river flow readings data.
     * @return The double value for the river flow reading.
     */
    public static double getRiverFlowReading() {
        double newReading = Math.sin(Math.random() * 10);
        if(newReading + previousRiverFlowReading > 3 || newReading + previousRiverFlowReading < 0.6) {
            newReading = -newReading;
        }
        previousRiverFlowReading = (previousRiverFlowReading + newReading);
        return previousRiverFlowReading;
    }
}
