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
    
    public void setMetric(String metric) {
        this.metric = metric;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public String getMetric() {
        return this.metric;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void incValue(double value) {
        this.value += value;
    }
    
}
