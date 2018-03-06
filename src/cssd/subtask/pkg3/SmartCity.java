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
    private int networksCreated =0;
    private int usersCount =2;
    private User[] users= new User[10];
    
    SmartCity()
    {
        GROW_BY = 10;
        networks = new SensorNetwork[GROW_BY];
        users[0]= new Admin (618, "Christopher Franklin", "d0nk3y", true);
        users[1]= new Admin (436, "Aijaz", "c@t", false);
        users[0]= new User (326, "Christopher Beattie", "m0nk3y");
        users[1]= new User (326, "Louis", "m0nk3y");
        usersCount = 2;
    }
    
    SensorNetwork[] getAllNetworks()
    {
        return networks;
    }
    
    void addNewNetwork(String Id)
    {
        if (networksCount > 0.9*networks.length)
        {
            resizeNetworks();
        }
        networks[networksCount] = new SensorNetwork(Id);
        networksCount++;
        this.networksCreated++;
    }
    void addNewStation(SensorNetwork network){
             String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
            {
                networks[i].addNewStation(temp);
                i=networksCount;
            }
        }
    }
    void addNewSensor(SensorNetwork network, SensorStation station, SensorHandler sensor)
    {
        String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
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
        String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
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
            if (networks[i].getId().equals(network.getId()))
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
        String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
            {
                networks[i].deleteStation(station);
                i=networksCount;
            }
        }
    }
    
    void deleteSensor (SensorNetwork network, SensorStation station, SensorHandler sensor)
    {
        String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
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
        String temp = network.getId();
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(temp))
            {
                networks[i].deleteActuator(station, handler);
                i=networksCount;
            }
        }
    }
    int getNetworksCount(){
        return this.networksCount;
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
    
    User login(String name, String password)
    {
        int i=0;
        boolean found=false;
        while(i<this.usersCount)
        {
            if (users[i].logIn(name, password)==true)
                return users[i];
            else i++;
        }
        return null;
    }
}
