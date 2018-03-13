package cssd.subtask.pkg3;

// Louis

public class AverageReading {
    
    private String metric;
    private double value;
    
    public AverageReading(String metric, double value) {
        this.metric = metric;
        this.value = value;
    }
    
    
    public AverageReading() {
        
    }
    
    /**
     * Set the average readings metric.
     * @param metric The string value that you want to set the metric to.
     */
    public void setMetric(String metric) {
        this.metric = metric;
    }
    
    /**
     * Set the average readings value.
     * @param value The double value that you want to set the value to.
     */
    public void setValue(double value) {
        this.value = value;
    }
    
    /**
     * Returns the average readings metric.
     * @return The string value of metric.
     */
    public String getMetric() {
        return this.metric;
    }
    
    /**
     * Returns the average readings value.
     * @return The double value for average reading.
     */
    public double getValue() {
        return this.value;
    }
    
    /**
     * Increase the average readings value.
     * @param value The double value you want to increase it by.
     */
    public void incValue(double value) {
        this.value += value;
    }
    
}
