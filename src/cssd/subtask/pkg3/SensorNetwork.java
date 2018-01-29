/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

/**
 *
 * @author b4041317
 */
public class SensorNetwork {
    private SensorStation[] Stations;
    
    SensorStation[] getAllStations()
    {
        return Stations;
    }
    
    void addNewStation(SensorHandler sensor)    //
    {
        Stations[0].addNewSensor(sensor);
    }
    
}
