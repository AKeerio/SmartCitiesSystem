/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import static java.lang.Float.parseFloat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author b4014007
 */
public class ControlPanel extends javax.swing.JFrame {

    private final SmartCity smartCity = new SmartCity();    
    private SensorNetwork[] networks = smartCity.getAllNetworks();
    private SensorStation[] stations;
    private SensorHandler[] sensors;
     private ActuatorHandler[] actuators;
    private Rule[] rules;
    
    private final DefaultListModel networksModel=new DefaultListModel();
    private final DefaultListModel stationsModel=new DefaultListModel();
    private final DefaultListModel sensorsModel=new DefaultListModel();
    private final DefaultListModel actuatorsModel=new DefaultListModel();
    private final DefaultListModel rulesModel = new DefaultListModel();
    /**
     * Creates new form ControlPanel
     */
    
    public ControlPanel() {
        initComponents();      
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanelLabel = new javax.swing.JLabel();
        addStation = new javax.swing.JButton();
        addNetwork = new javax.swing.JButton();
        addUser = new javax.swing.JButton();
        deleteNetwork = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        deleteStation = new javax.swing.JButton();
        netWorksPane = new javax.swing.JScrollPane();
        networksList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        stationsList = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sensorsList = new javax.swing.JList<>();
        addSensor = new javax.swing.JButton();
        deleteSensor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        addRule = new javax.swing.JButton();
        addActuator = new javax.swing.JButton();
        deleteRule = new javax.swing.JButton();
        deleteActuator = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        actuatorsList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        rulesList = new javax.swing.JList<>();
        showGUIData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlPanelLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        controlPanelLabel.setText("Control  Panel");

        addStation.setText("Add New Station");
        addStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStationActionPerformed(evt);
            }
        });

        addNetwork.setText("Add New Network");
        addNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetworkActionPerformed(evt);
            }
        });

        addUser.setText("Add New User");
        addUser.setToolTipText("");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });

        deleteNetwork.setText("Delete Network");
        deleteNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNetworkActionPerformed(evt);
            }
        });

        deleteUser.setText("Delete User");
        deleteUser.setToolTipText("");

        deleteStation.setText("Delete Station");
        deleteStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStationActionPerformed(evt);
            }
        });

        networksList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                networksListValueChanged(evt);
            }
        });
        netWorksPane.setViewportView(networksList);

        stationsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                stationsListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(stationsList);

        jScrollPane4.setViewportView(sensorsList);

        addSensor.setText("Add New Sensor");
        addSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSensorActionPerformed(evt);
            }
        });

        deleteSensor.setText("Delete Sensor");
        deleteSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSensorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSensor)
                    .addComponent(deleteSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addSensor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteSensor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Station Sensors", jPanel1);

        addRule.setText("Add Rule");
        addRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRuleActionPerformed(evt);
            }
        });

        addActuator.setText("Add New Actuator");
        addActuator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActuatorActionPerformed(evt);
            }
        });

        deleteRule.setText("Delete Rule");
        deleteRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRuleActionPerformed(evt);
            }
        });

        deleteActuator.setText("Delete Actuator");
        deleteActuator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActuatorActionPerformed(evt);
            }
        });

        actuatorsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                actuatorsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(actuatorsList);

        jScrollPane2.setViewportView(rulesList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addActuator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(deleteActuator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(addRule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteRule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addActuator)
                    .addComponent(addRule))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteActuator)
                    .addComponent(deleteRule))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Station Actuator and Rules", jPanel2);

        showGUIData.setText("Show GUI");
        showGUIData.setToolTipText("");
        showGUIData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGUIDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(netWorksPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(addNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(deleteStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addGap(137, 137, 137)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlPanelLabel)
                        .addGap(18, 18, 18)
                        .addComponent(showGUIData)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteUser))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showGUIData)
                            .addComponent(controlPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(netWorksPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStation))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteNetwork)
                            .addComponent(deleteStation)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addUserMouseClicked

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        // TODO add your handling code here:
       //new AddUserPanel().setVisible(true);
    }//GEN-LAST:event_addUserActionPerformed

    private void addNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNetworkActionPerformed
        String Id = JOptionPane.showInputDialog("Input a name of the network");
        smartCity.addNewNetwork(Id);
        networks = smartCity.getAllNetworks();
        networksModel.addElement(""+networks[smartCity.getNetworksCount()-1].getId());
        networksList.setModel(networksModel);
  //      JOptionPane.showMessageDialog(null, "network added");
    }//GEN-LAST:event_addNetworkActionPerformed

    private void networksListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_networksListValueChanged
      
        if(networksList.getSelectedValue()!=null)
        {
            clearStationsList();
            stationsModel.removeAllElements();
            int index = networksList.getSelectedIndex();
            stations = networks[index].getAllStations();
            
            for (int i=0;i<networks[index].getStationsCount(); i++)
            {
                stationsModel.addElement(""+stations[i].getId());                  
            }
            stationsList.setModel(stationsModel);
        }
    }//GEN-LAST:event_networksListValueChanged

    private void addStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStationActionPerformed
        String Id = JOptionPane.showInputDialog("Input a name for the station");
        
        if(networksList.getSelectedValue()!=null)
        {
            int index = networksList.getSelectedIndex();
            networks[index].addNewStation(Id);
            stations = networks[index].getAllStations();
            stationsModel.addElement(""+stations[networks[index].getStationsCount()-1].getId());
            stationsList.setModel(stationsModel);            
        
       //     JOptionPane.showMessageDialog(null, "Station added");
        }
    }//GEN-LAST:event_addStationActionPerformed

    private void deleteNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNetworkActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this network?", "Delete Network", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            if(networksList.getSelectedValue()!=null)
            {
                int index = networksList.getSelectedIndex();
                smartCity.deleteNetwork(networks[index]);
                networksModel.remove(networksList.getSelectedIndex());
                networksList.setModel(networksModel);
                networks=smartCity.getAllNetworks();
                
                //update other lists
                clearStationsList();
            }
        }
    }//GEN-LAST:event_deleteNetworkActionPerformed

    private void deleteStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStationActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this station?", "Delete station", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int networkIndex=networksList.getSelectedIndex();
            if(stationsList.getSelectedValue()!=null)
            {
                int index = stationsList.getSelectedIndex();
                networks[networkIndex].deleteStation(stations[index]);
                stationsModel.remove(stationsList.getSelectedIndex());
                stationsList.setModel(stationsModel);
                
                //Update other lists 
                clearSensorsList();
                clearActuatorsList();
            }
        }
      
    }//GEN-LAST:event_deleteStationActionPerformed
   
    private void clearStationsList()
    {
        clearSensorsList();
        clearRulesList();
        clearActuatorsList();
        stationsModel.removeAllElements();
        stationsList.setModel(stationsModel);
    }
    private void clearSensorsList()
    {         
        sensorsModel.removeAllElements();
        sensorsList.setModel(sensorsModel);
    }
    private void clearActuatorsList()
    {
        clearRulesList();
        actuatorsModel.removeAllElements();
        actuatorsList.setModel(rulesModel);
    }
    
    private void clearRulesList()
    {
       rulesModel.removeAllElements();;
       rulesList.setModel(rulesModel);
               
    }
    private void addSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSensorActionPerformed

        String location = JOptionPane.showInputDialog("Input a location for the sensor");
        String Id = JOptionPane.showInputDialog("Input a Id for the sensor");
  
        Sensor sensor =new Sensor(location);
        SensorHandler sensorHandler=new SensorHandler(sensor, Id);
        
         if(stationsList.getSelectedValue()!=null)
        {
            int index = stationsList.getSelectedIndex();
            stations[index].addNewSensor(sensorHandler);
            sensors = stations[index].getAllSensors();
           
            sensorsModel.addElement(sensorHandler.getId()+"");
            sensorsList.setModel(sensorsModel);//update list            
        }
        
    }//GEN-LAST:event_addSensorActionPerformed

    private void deleteSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSensorActionPerformed
        
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this sensor?", "Delete sensor", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int stationIndex=stationsList.getSelectedIndex();
            if(sensorsList.getSelectedValue()!=null)
            {
                int index = sensorsList.getSelectedIndex();
                stations[stationIndex].deleteSensor(sensors[index]);
                sensorsModel.remove(sensorsList.getSelectedIndex());
                sensorsList.setModel(sensorsModel);
            }
        }

    }//GEN-LAST:event_deleteSensorActionPerformed

    private void stationsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_stationsListValueChanged
  
        if(stationsList.getSelectedValue()!=null)
        {
            sensorsModel.removeAllElements();
            actuatorsModel.removeAllElements();
            rulesModel.removeAllElements();
            
            int stationIndex = stationsList.getSelectedIndex();
            sensors = stations[stationIndex].getAllSensors();
            actuators=stations[stationIndex].getAllActuators();
            
            
            for (int i=0;i<stations[stationIndex].getSensorCount(); i++)
            {
                sensorsModel.addElement(""+sensors[i].getId());                  
            }
            for (int i=0;i<stations[stationIndex].getActuatorsCount(); i++)
            {
                actuatorsModel.addElement(""+actuators[i].getId());                  
            }
              
            sensorsList.setModel(sensorsModel);
            actuatorsList.setModel(actuatorsModel);
            rulesList.setModel(rulesModel);
        }
      
    }//GEN-LAST:event_stationsListValueChanged

    private void addActuatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActuatorActionPerformed
        String Id = JOptionPane.showInputDialog("Input a Id for the actuator");
        ActuatorHandler actuatorHandler=new ActuatorHandler(Id);
        
         if(stationsList.getSelectedValue()!=null)
        {
            int index = stationsList.getSelectedIndex();
            stations[index].addNewActuator(actuatorHandler);
            actuators = stations[index].getAllActuators();
           
            actuatorsModel.addElement(actuatorHandler.getId()+"");
            actuatorsList.setModel(actuatorsModel);//update list            
        }
    }//GEN-LAST:event_addActuatorActionPerformed

    private void deleteActuatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActuatorActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this actuator?", "Delete Actuator", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int stationIndex=stationsList.getSelectedIndex();
            if(actuatorsList.getSelectedValue()!=null)
            {
                int index = actuatorsList.getSelectedIndex();
                stations[stationIndex].deleteActuator(actuators[index]);
                actuatorsModel.remove(actuatorsList.getSelectedIndex());
                actuatorsList.setModel(actuatorsModel);
                
                rulesModel.removeAllElements();
                rulesList.setModel(rulesModel);
            }
        }
    }//GEN-LAST:event_deleteActuatorActionPerformed

    private void addRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleActionPerformed
        float min = parseFloat(JOptionPane.showInputDialog("Input a min for the rule"));
        float max = parseFloat(JOptionPane.showInputDialog("Input a max for the rule"));
        String metric = JOptionPane.showInputDialog("Input a metric for the rule");
        Rule rule=new Rule(min,max,metric);
        
        if(actuatorsList.getSelectedValue()!=null)
        {
            int index = actuatorsList.getSelectedIndex();
            actuators[index].addNewRule(rule);
            rules = actuators[index].getAllRules();
            rulesModel.addElement(rule.getRuleData());
            rulesList.setModel(rulesModel);//update list            
        }
    }//GEN-LAST:event_addRuleActionPerformed

    private void deleteRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRuleActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this rule?", "Delete rule", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            int actuatorsIndex=actuatorsList.getSelectedIndex();
            int stationIndex=stationsList.getSelectedIndex();
            if(rulesList.getSelectedValue()!=null)
            {
                int index = rulesList.getSelectedIndex();
                actuators[actuatorsIndex].deleteRule(rules[index], stations[stationIndex]);
                rulesModel.remove(rulesList.getSelectedIndex());
                rulesList.setModel(rulesModel);
            }
        }
    }//GEN-LAST:event_deleteRuleActionPerformed

    private void actuatorsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_actuatorsListValueChanged
       if(actuatorsList.getSelectedValue()!=null)
        {
            rulesModel.removeAllElements();
            int index = actuatorsList.getSelectedIndex();
            rules = actuators[index].getAllRules();
            for (int i=0;i<actuators[index].getRuleCount(); i++)
            {
                rulesModel.addElement(""+rules[i].getRuleData());                  
            }
            rulesList.setModel(rulesModel);
        }
    }//GEN-LAST:event_actuatorsListValueChanged

    private void showGUIDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGUIDataActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        GUIData gui= new GUIData();
        gui.setSmartCity(this.smartCity);
        gui.setVisible(true);
    }//GEN-LAST:event_showGUIDataActionPerformed

    public void addExistingNetworks()
    {
        //demo networks to add them initially
        smartCity.addNewNetwork("Temp network 1");
        smartCity.addNewNetwork("Temp network 2");
        networks = smartCity.getAllNetworks();
        for (int i =0; i<smartCity.getNetworksCount();  i++)
        {
            networksModel.addElement(""+networks[i].getId());
        }
        networksList.setModel(networksModel);
    }
    
    public SmartCity getSmartCity (){
            return smartCity;
    }
    /**
     * @param args the command line arguments
     */
//    public void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//            
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ControlPanel cp= new ControlPanel();
//                cp.addExistingNetworks();
//                cp.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> actuatorsList;
    private javax.swing.JButton addActuator;
    private javax.swing.JButton addNetwork;
    private javax.swing.JButton addRule;
    private javax.swing.JButton addSensor;
    private javax.swing.JButton addStation;
    private javax.swing.JButton addUser;
    private javax.swing.JLabel controlPanelLabel;
    private javax.swing.JButton deleteActuator;
    private javax.swing.JButton deleteNetwork;
    private javax.swing.JButton deleteRule;
    private javax.swing.JButton deleteSensor;
    private javax.swing.JButton deleteStation;
    private javax.swing.JButton deleteUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane netWorksPane;
    private javax.swing.JList<String> networksList;
    private javax.swing.JList<String> rulesList;
    private javax.swing.JList<String> sensorsList;
    private javax.swing.JButton showGUIData;
    private javax.swing.JList<String> stationsList;
    // End of variables declaration//GEN-END:variables
}
