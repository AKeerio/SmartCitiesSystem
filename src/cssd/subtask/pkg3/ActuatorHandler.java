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
    Vector rules = new Vector();
    Actuator actuator;
    public void sendData(AverageReading[] avgReadings){
        for (int i = 0; i < avgReadings.length; i++) {
            for (int j = 0; j < rules.size(); j++) {
                Rule temp = (Rule) rules.get(j);
            if(avgReadings[i].getMetric().equals(temp.Metric))
                actuator.setStatus(temp.checkRule(avgReadings[i]));
            }
        }
    }
    
    public void addRule(float min, float max, String Metric)
    {
        Rule rule = new Rule(min, max, Metric);
        rules.add(rule);
    }
}
