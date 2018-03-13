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
    private User[] loggedOn = new User[10];
    private int usersLoggedOn = 0;
    
    SmartCity()
    {
        GROW_BY = 10;
        networks = new SensorNetwork[GROW_BY];
        
        users[0]= new Admin (618, "Christopher Franklin", "d0nk3y", true);
        users[1]= new Admin (436, "Aijaz", "c@t", false);
        users[2]= new User (326, "Christopher Beattie", "m0nk3y");
        users[3]= new User (326, "Louis", "password123"); // Boss mode.
        users[4]= new Admin (618, "admin", "pass", true);
        usersCount = 5;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SmartCity sc = new SmartCity();
                new Gui(sc).setVisible(true);
                
            }
        });
    }
    
    /**
     * Returns an array of Sensor Network objects, each containing their own array of Sensor Stations .
     * @return Returns an array of Sensor Networks objects.
     */
    SensorNetwork[] getAllNetworks()
    {
        return networks;
    }
    
     /**
     * Adds a new Network object to the Smart City. 
     * @param  id The id of the new sensor that is being added.
     */
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
    /**
     * Adds a new Station to a designated network. 
     * @param  network The desired network you want to add the station to.
     */
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
    
    /**
     * Adds a new Sensor to a designated station. 
     * @param  network The desired network you want to add the sensor to.
     * @param  station The desired station you want to add the sensor to.
     * @param  sensor The sensor handler that you want to add.
     */
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
    
    /**
     * Adds a new User to the array of users. 
     * @param  addMe The user you want to add.
     */
    void addNewUser(User addMe)
    {
             if (usersCount > 0.9*users.length)
        {
            resizeUsers();
        }
        users[usersCount] = addMe;
        usersCount++;
    }
    
    /**
     * Adds a new User to the array of users. 
     * @param  addMe The user you want to add.
     */
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
    
    /**
     * Deletes a network from the network arrays. 
     * @param  network The network you want to delete.
     */
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
    
    /**
     * Deletes a station from the desired network. 
     * @param  network The network you want to delete the station from.
     * @param  station The station you want to delete.
     */
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
    
    /**
     * Deletes a sensor from the desired station. 
     * @param  network The network you want to delete the sensor from.
     * @param  station The station you want to delete the sensor from.
     * @param  station The sensor you want to delete.
     */
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
    
    /**
     * Deletes a desired user. 
     * @param  userIn The user you want to delete.
     * 
     */
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
    
    /**
     * Deletes a desired actuator. 
     * @param  network The network you want to delete the actuator from.
     * @param  station The station you want to delete the actuator from.
     * @param  handler The handler you want to delete.
     */
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
    
    /**
     * Returns the number of networks. 
     * @return integer value of the network count.
     */
    int getNetworksCount(){
        return this.networksCount;
    }
    
    /**
     * Resizes the array of networks. 
     */
    void resizeNetworks()
    {
        SensorNetwork[] temp = new SensorNetwork[networks.length+GROW_BY];
        System.arraycopy(temp, 0, networks, 0, networksCount);
        networks = temp;
    }
    
    
    /**
     * Resizes the array of users. 
     */
    void resizeUsers()
    {
        User[] temp = new User[networks.length+GROW_BY];
        System.arraycopy(temp, 0, users, 0, networksCount);
        users=temp;
    }
    
    /**
    * Logs a user into the system.
    @param name The username for the user.
    @param password The password for the user.
    @return Returns a security rating. -1 means the user doesn't exist. 0 is a standard user. 1 is a standard admin, 2 is a root admin.
    */
    int login(String name, String password)
    {
        for(User usr : users) {
            if(usr.logIn(name, password))
            {
                loggedOn[usersLoggedOn++] = usr;
                if(usr instanceof Admin) {
                    return ((Admin)usr).RootAdmin ? 2 : 1;
                }
                return 0;
            }
        }
        return -1;
    }
}
