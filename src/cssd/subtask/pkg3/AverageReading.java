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
public class AverageReading {
    float Value;
    String Metric;

    
    public AverageReading(String metric, float measure)
    {
        Value = measure;
        Metric = metric;
    }
}

