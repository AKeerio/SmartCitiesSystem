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
    int Id;
    
    public Rule(Float minIn, Float maxIn, String MetricIn, int IdIn){
        min=minIn;
        max=maxIn;
        Metric=MetricIn;
        Id=IdIn;
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
    public int getId(){
        return Id;
    }
}
