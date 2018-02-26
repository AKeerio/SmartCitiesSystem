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
    private String Id;
    
    SensorNetwork(String IdIn)
    {
        stationsCount =0;
        GROW_BY=10;
        stations = new SensorStation[GROW_BY];
        Id = IdIn;
    }
    SensorStation[] getAllStations()
    {
        return stations;
    }
    int getStationsCount()
    {
        return stationsCount;
    }
    void addNewStation(String Id)
    {
        if (stationsCount > 0.9*stations.length)
        {
            resize();
        }
       SensorStation station = new SensorStation(Id);
        stations[stationsCount] = station;
        stationsCount++;
    }
    void addNewSensor(SensorStation station, SensorHandler sensor) 
    {
        String temp = station.getId();
        for (int i =0; i<stationsCount; i++)
        {
            if (stations[i].getId().equals(temp))
            {
             stations[i].addNewSensor(sensor);   
             i=stationsCount;
            }
        }
    }
    
    void addNewActuator(SensorStation station, ActuatorHandler actuator)
    {
        String temp = station.getId();
        for (int i =0; i<stationsCount; i++)
        {
            if (stations[i].getId().equals(temp))
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
            if (stations[i].getId().equals(station.getId()))
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
            if (stations[i].getId().equals(station.getId()))
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
            if (stations[i].getId() == null ? station.getId() == null : stations[i].getId().equals(station.getId()))
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

    String getId() {
        return Id;
    }
}
