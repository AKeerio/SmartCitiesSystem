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
    private final int GROW_BY;
    private int id;
    
    SensorNetwork(int reference)
    {
        stationsCount =0;
        GROW_BY=10;
        stations = new SensorStation[GROW_BY];
        id = reference;
    }
    SensorStation[] getAllStations()
    {
        return stations;
    }
    int getStationsCount()
    {
        return stationsCount;
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
    void addNewSensor(SensorStation station, SensorHandler sensor) 
    {
        int temp = station.getId();
        for (int i =0; i<stationsCount; i++)
        {
            if (stations[i].getId()==temp)
            {
             stations[i].addNewSensor(sensor);   
             i=stationsCount;
            }
        }
    }
    
    void addNewActuator(SensorStation station, ActuatorHandler actuator)
    {
        int temp = station.getId();
        for (int i =0; i<stationsCount; i++)
        {
            if (stations[i].getId()==temp)
            {
                stations[i].addNewActuator(actuator);
                i=stationsCount;
            }
        }
    }
    
    void deleteStation (SensorStation station)
    {
        for(int i=0; i<stationsCount; i++)
        {
            if (stations[i].getId() == station.getId())
            {
                for (int j = i; j<stationsCount-2; j++)
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
        SensorStation[] temp = new SensorStation[stations.length+GROW_BY];
        System.arraycopy(temp, 0, stations, 0, stationsCount);
        stations = temp;
    }    

    int getId() {
        return id;
    }
}
