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
    private SensorStation[] stations;
    private int stationsCount;
    private final int GROWBY;
    
    SensorNetwork()
    {
        stationsCount =0;
        GROWBY=10;
        stations = new SensorStation[GROWBY];
    }
    SensorStation[] getAllStations()
    {
        return stations;
    }
    void addNewStation(SensorStation station)
    {
        if (stationsCount > 0.9*stations.length)
        {
            resize();
        }
        stations[stationsCount] = station;
        stationsCount++;
    }
    void addNewSensor(SensorHandler sensor) 
    {
        stations[0].addNewSensor(sensor);
    }
    
    void addNewActuator(ActuatorHandler actuator)
    {
        stations[0].addNewActuator(actuator);
    }
    
    void deleteStation (SensorStation station)
    {
        for(int i=0; i<stationsCount; i++)
        {
            if (stations[i].getId() == station.getId())
            {
                for (int j = i; j<stationsCount-1; j++)
                {
                    stations[j]=stations[j+1];
                }
                stationsCount--;
                i=stationsCount;
            }
        }
    }
    void deleteSensor(SensorStation station, SensorHandler sensor)
    {
        for(int i=0; i<stationsCount; i++)
        {
            if (stations[i].getId() == station.getId())
            {
                stations[i].deleteSensor(sensor);
                i=stationsCount;
            }
        }
    }
    void deleteActuator(SensorStation station, ActuatorHandler handles)
    {
        for(int i=0; i<stationsCount; i++)
        {
            if (stations[i].getId() == station.getId())
            {
                stations[i].deleteActuator(handles);
                i=stationsCount;
            }
        }
    }
    private void resize()
    {
        SensorStation[] temp = new SensorStation[stations.length+GROWBY];
        System.arraycopy(temp, 0, stations, 0, stationsCount);
        stations = temp;
    }    
}
