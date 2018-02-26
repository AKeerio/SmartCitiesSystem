/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Aijaz
 */
public class ActuatorHandler {
    private final int GROW_BY;
    private int rulesCount;
    Rule[] rules;
    private final String id;
    private Actuator actuator;
    
    public ActuatorHandler(String id){
        GROW_BY=10;
        rulesCount=0;
        rules=new Rule[GROW_BY];
        this.id = id;
        this.actuator = new Actuator();
    }
    
    public void sendData(AverageReading[] avgReadings){
        for (int i = 0; i < avgReadings.length; i++) {
            for (int j = 0; j < rulesCount; j++) {
                Rule temp = (Rule) rules[j];
            if(avgReadings[i].getMetric().equals(temp.metric))
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

    Rule[] getRules() {
        return rules;
    }

    int getRulesCount() {
        return rulesCount;
    }

    void setRules(Rule[] rules) {
        this.rules=rules;
    }

    void setRulesCount(int rulesCount) {
        this.rulesCount=rulesCount;
    }
    
    public String getId() {
        return this.id;
    }
    
    
    void addNewRule(Rule rule) {
        if(rulesCount >= rules.length) {
            Rule[] temp = new Rule[rules.length + GROW_BY];
            System.arraycopy(rules, 0, temp, 0, rulesCount);
            rules = temp;
        }
        rules[rulesCount++] = rule;
    }

    Rule[] getAllRules() {
       return this.rules;
    }
    
    int getRuleCount(){
        return this.rulesCount;
    }

    void deleteRule(Rule rule, SensorStation station) {
     station.deleteRule(rule, this);
    }
}
