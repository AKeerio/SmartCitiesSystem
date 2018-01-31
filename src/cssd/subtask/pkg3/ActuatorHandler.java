/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import java.util.Vector;

/**
 *
 * @author Aijaz
 */
public class ActuatorHandler {
    private int GROW_BY;
    private int rulesCount;
    private Rule[] rules;
    private int Id;
    public ActuatorHandler(int IdIn){
        Id=IdIn;
        rules = new Rule[GROW_BY];
        rulesCount=0;
        GROW_BY=10;
    }
    Actuator actuator;
    public void sendData(AverageReading[] avgReadings){
        for (int i = 0; i < avgReadings.length; i++) {
            for (int j = 0; j < rulesCount; j++) {
                Rule temp = rules[j];
            if(avgReadings[i].getMetric().equals(temp.Metric))
                actuator.setStatus(temp.checkRule(avgReadings[i]));
            }
        }
    }
    
    public void addRule(Float min, Float max, String Metric, int Id)
    {
        Rule rule = new Rule(min, max, Metric, Id);
        if(Metric.isEmpty() || actuator == null)
        {
            throw new IllegalArgumentException("One or more argument is null");
        }
        
        if(rulesCount>=rules.length)
        {
            Rule[] temp = new Rule[rules.length+GROW_BY];
            System.arraycopy(temp, 0, rules, 0, rulesCount);
            rules=temp;
        }
        rules[rulesCount]=rule;
        rulesCount++;
    }
    
    public Rule[] getRules()
    {
        return rules;
    }
    public int getId()
    {
        return Id;
    }
}
