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
    private final int GROW_BY;
    private int rulesCount;
    Rule[] rules;
    public ActuatorHandler(){
        GROW_BY=10;
        rulesCount=0;
        rules=new Rule[GROW_BY];
    }
    Actuator actuator;
    public void sendData(AverageReading[] avgReadings){
        for (int i = 0; i < avgReadings.length; i++) {
            for (int j = 0; j < rulesCount; j++) {
                Rule temp = (Rule) rules[j];
            if(avgReadings[i].getMetric().equals(temp.Metric))
                actuator.setStatus(temp.checkRule(avgReadings[i]));
            }
        }
    }
    
    public void addRule(float min, float max, String Metric)
    {
        if(Metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric passed is null.");
        }
        if(rulesCount >= rules.length) {
            Rule[] temp = new Rule[rules.length + GROW_BY];
            System.arraycopy(rules, 0, temp, 0, rulesCount);
            rules = temp;
        }
        Rule rule = new Rule(min, max, Metric);
        rules[rulesCount]=rule;
        rulesCount++;
    }
}
