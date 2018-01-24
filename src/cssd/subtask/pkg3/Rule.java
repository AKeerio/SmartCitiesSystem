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
    String Metric;
    
    public Rule(float minIn, float maxIn, String MetricIn){
        min=minIn;
        max=maxIn;
        Metric=MetricIn;
    }
    public boolean checkRule(AverageReading reading)
    {
        if(min!=null)
        {
            if(reading.Value<min)
                return true;
            else
                return false;
        }
        
        if(max!=null    )
        {
            if(reading.Value>max)            
                return true;
            else
                return false;
        }
        return false;
    }
}
