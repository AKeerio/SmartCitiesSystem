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

     /**
     * Returns the array of rules  
     */
    Rule[] getRules() {
        return rules;
    }

    /**
     * Returns the count of rules  
     */
    int getRulesCount() {
        return rulesCount;
    }

    /**
     * Sets the rules for the Actuator Handler
     * @param rules The array of rules that you want the ACtuator Handler to have.
     */
    void setRules(Rule[] rules) {
        this.rules=rules;
    }
    
    /**
     * Sets the rule count for the current Actuator Handler
     * @param rulesCount The integer value you want the rule count to be.
     */
    void setRulesCount(int rulesCount) {
        this.rulesCount=rulesCount;
    }
    
    /**
     * Gets the Id of the current Actuator Handler
     * @return A string value of the Actuator Handlers id.
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * Adds a new to this Actuator Handler array of rules
     * @param rule The rule you want to add.
     */
    void addNewRule(Rule rule) {
        if(rulesCount >= rules.length) {
            Rule[] temp = new Rule[rules.length + GROW_BY];
            System.arraycopy(rules, 0, temp, 0, rulesCount);
            rules = temp;
        }
        rules[rulesCount++] = rule;
    }
    
    /**
     * Returns an array of rules for this Actuator Handler.
     * @return Returns an array of rules.
     */
    Rule[] getAllRules() {
       return this.rules;
    }
    
    /**
     * Sets the rule count for the current Actuator Handler
     * @return Returns an integer value of the rule count. 
     */
    int getRuleCount(){
        return this.rulesCount;
    }

    /**
     * Deletes a desired rule from a desired station.
     * @param rule The desired rule you want to delete.
     * @param station The station you want to delete the rule from.
     */
    void deleteRule(Rule rule, SensorStation station) {
     station.deleteRule(rule, this);
    }
}
