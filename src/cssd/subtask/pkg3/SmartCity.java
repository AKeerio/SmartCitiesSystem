package cssd.subtask.pkg3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author b4041317
 */
public class SmartCity {

    private final int GROW_BY;
    private SensorNetwork[] networks;
    private int networksCount = 0;
    private int usersCount =0;
    private User[] users;
    SmartCity()
    {
        GROW_BY = 10;
        networks = new SensorNetwork[GROW_BY];
    }
    
    SensorNetwork[] getAllNetworks()
    {
        return networks;
    }
    
    void addNewNetwork(SensorNetwork network)
    {
          if (networksCount > 0.9*networks.length)
        {
            resizeNetworks();
        }
        networks[networksCount] = network;
        networksCount++;
    }
    void addNewStation(SensorNetwork network, SensorStation station){
             int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].addNewStation(station);
                i=networksCount;
            }
        }
    }
    void addNewSensor(SensorNetwork network, SensorStation station, SensorHandler sensor)
    {
        int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].addNewSensor(station, sensor);
                i=networksCount;
            }
        }
    }
    
    void addNewUser(User addMe)
    {
             if (usersCount > 0.9*users.length)
        {
            resizeUsers();
        }
        users[usersCount] = addMe;
        usersCount++;
    }
    
    void addNewActuator(SensorNetwork network, SensorStation station, ActuatorHandler handler)
    {
        int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].addNewActuator(station, handler);
                i=networksCount;
            }
        }
    }
    
    void deleteNetwork(SensorNetwork network)
    {    
          for(int i=0; i<networksCount; i++)
        {
            if (networks[i].getId() == network.getId())
            {
                for (int j = i; j<networksCount-2; j++)
                {
                    networks[j]=networks[j+1];
                }
                i=networksCount;
                networksCount--;
            }
        }
    }
    void deleteStation (SensorNetwork network, SensorStation station)
    {
        int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].deleteStation(station);
                i=networksCount;
            }
        }
    }
    
    void deleteSensor (SensorNetwork network, SensorStation station, SensorHandler sensor)
    {
        int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].deleteSensor(station, sensor);
                i=networksCount;
            }
        }
    }
    void deleteUser (User userIn)
    {
        int Id = userIn.getId();
        for (int i=0; i< usersCount; i++)
        {
            if (users[i].getId() == Id)
            {
               for(int j=i; j<usersCount-2; j++)
               {
                   users[j]=users[j+1];
               }
               i=usersCount;
               usersCount--;
            }
        }
    }
    void deleteActuator (SensorNetwork network, SensorStation station, ActuatorHandler handler)
    {
        int temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId()==temp)
            {
                networks[i].deleteActuator(station, handler);
                i=networksCount;
            }
        }
    }
    
    void resizeNetworks()
    {
        SensorNetwork[] temp = new SensorNetwork[networks.length+GROW_BY];
        System.arraycopy(temp, 0, networks, 0, networksCount);
        networks = temp;
    }
    
    void resizeUsers()
    {
        User[] temp = new User[networks.length+GROW_BY];
        System.arraycopy(temp, 0, users, 0, networksCount);
        users=temp;
    }
    
}
