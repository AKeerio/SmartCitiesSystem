package cssd.subtask.pkg3;

import javax.swing.JFrame;

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
    private int usersCount = 0;
    private User[] users= new User[0];
    private User[] loggedOn = new User[10];
    private JFrame[] windows;
    private int windowCount;
    private int usersLoggedOn = 0;
    
    SmartCity()
    {
        GROW_BY = 1;
        networks = new SensorNetwork[0];
        windows = new JFrame[0];
        windowCount = 0;
        
        addNewUser(new Admin (618, "Christopher Franklin", "d0nk3y", true));
        addNewUser(new Admin (436, "Aijaz", "c@t", false));
        addNewUser(new User (326, "Christopher Beattie", "m0nk3y"));
        addNewUser(new User (326, "Louis", "password123"));
        addNewUser(new Admin (618, "admin", "pass", true));
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
        if (networksCount >= networks.length) // TODO: This needs sorting out completely.
        {
            resizeNetworks();
        }
        networks[networksCount] = new SensorNetwork(Id);
        networksCount++;
    }
    
    /**
     * Adds a new Station to a designated network. 
     * @param  network The desired network you want to add the station to.
     */
    void addNewStation(String networkId, String stationId){
        for(SensorNetwork sn : networks) {
            if(sn != null && sn.getId().compareTo(networkId) == 0) {
                sn.addNewStation(stationId);
            }
        }
    }
    
    /**
     * Adds a new Sensor to a designated station. 
     * @param  network The desired network you want to add the sensor to.
     * @param  station The desired station you want to add the sensor to.
     * @param  sensor ???????.
     */
    void addNewSensor(String networkId, String stationId, String sensorId, String sensorLocation)
    {
        for (int i =0; i<networksCount; i++)
        {
            if (networks[i].getId().equals(networkId))
            {
                for(SensorStation ss : networks[i].getAllStations()) {
                    if(ss.getId().compareTo(stationId) == 0) {
                        SensorHandler sh = new SensorHandler(new Sensor(sensorLocation), sensorId);
                        sh.addListener(new SensorChangeListener(ss));
                        ss.addNewSensor(sh);
                        return;
                    }
                }
            }
        }
    }
    
    /**
     * Adds a new User to the array of users. 
     * @param  addMe The user you want to add.
     */
    void addNewUser(User addMe)
    {
        if (usersCount >= users.length)
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
                break;
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
                for (int j = i; j<networksCount-1; j++)
                {
                    networks[j]=networks[j+1];
                }
                networksCount--;
                SensorNetwork[] temp = new SensorNetwork[networksCount];
                System.arraycopy(networks, 0, temp, 0, networksCount);
                networks = temp;
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
                break;
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
                break;
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
               usersCount--;
               break;
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
                break;
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
        System.arraycopy(networks, 0, temp, 0, networksCount);
        networks = temp;
    }
    
    public void addWindow(JFrame window) {
        if(windowCount >= windows.length) {
            JFrame[] temp = new JFrame[windows.length + 1];
            System.arraycopy(windows, 0, temp, 0, windowCount);
            windows = temp;
        }
        windows[windowCount++] = window;
    }
    
    // Listener type thing. Notifies all windows it's time to refresh.
    public void notifyRefresh() {
        for(JFrame fr : windows) {
            if(fr instanceof ControlPanel) {
               ((ControlPanel) fr).refreshGui();
            } else if(fr instanceof GUIData) {
                ((GUIData) fr).refreshGui();
            }
        }
    }
    
    
    /**
     * Resizes the array of users. 
     */
    void resizeUsers()
    {
        User[] temp = new User[users.length+GROW_BY];
        System.arraycopy(users, 0, temp, 0, usersCount);
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
