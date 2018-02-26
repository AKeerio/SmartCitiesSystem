/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

/**
 *
 * @author Aijaz
 */
public class Rule {
    
    Float min;
    Float max;
    String metric;
    
    public Rule(Float minIn, Float maxIn, String MetricIn){
        min=minIn;
        max=maxIn;
        metric=MetricIn;
    }
    public boolean checkRule(AverageReading reading)
    {
        if(min!=null)
        {
            if(reading.getValue()<min)
                return true;
            else
                return false;
        }
        
        if(max!=null    )
        {
            if(reading.getValue()>max)            
                return true;
            else
                return false;
        }
        return false;
    }

    String getRuleData() {
        return "Min: "+this.min+" Max: "+this.max+" Metric: "+this.metric;
    }
}
