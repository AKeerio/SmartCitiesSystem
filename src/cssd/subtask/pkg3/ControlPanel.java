/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import static java.lang.Float.parseFloat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author b4014007
 */
public class ControlPanel extends javax.swing.JFrame {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    LocalDateTime now;

    private final SmartCity smartCity;
    private SensorNetwork[] networks;
    private SensorStation[] stations;
    private SensorHandler[] sensors;
    private ActuatorHandler[] actuators;
    private Rule[] rules;
    
    private SensorNetwork selectedNetwork;
    private SensorStation selectedStation;
    private SensorHandler selectedSensor;
    private ActuatorHandler selectedActuator;

    private final DefaultListModel networksModel = new DefaultListModel();
    private final DefaultListModel stationsModel = new DefaultListModel();
    private final DefaultListModel sensorsModel = new DefaultListModel();
    private final DefaultListModel actuatorsModel = new DefaultListModel();
    private final DefaultListModel rulesModel = new DefaultListModel();

    /**
     * Creates new form ControlPanel
     * @param smartCity The smart city the control panel is assigned to.
     */
    public ControlPanel(SmartCity smartCity) {
        this.smartCity = smartCity;
        initComponents();
        setNetworks();
    }
    
    // Refresh elements.
    
    private void setNetworks(){
        SensorStation temp1 = selectedStation;
        SensorNetwork temp2 = selectedNetwork;
        SensorHandler temp3 = selectedSensor;
        networksModel.clear();
        networks = smartCity.getAllNetworks();
        for (SensorNetwork nw : networks) {
            networksModel.addElement(nw.getId());
        }
        networksList.setModel(networksModel);
        selectedSensor = temp3;
        selectedNetwork = temp2;
        selectedStation = temp1;
    }
     
    private void setStations() {
        SensorStation temp1 = selectedStation;
        SensorNetwork temp2 = selectedNetwork;
        SensorHandler temp3 = selectedSensor;
        stationsModel.removeAllElements();
        if(selectedNetwork != null) {
            for(SensorStation ss : selectedNetwork.getAllStations()) {
                stationsModel.addElement(ss.getId());
            }
        }
        stationsList.setModel(stationsModel);
        selectedSensor = temp3;
        selectedNetwork = temp2;
        selectedStation = temp1;
    }
    
    private void setSensors() {
        SensorStation temp1 = selectedStation;
        SensorNetwork temp2 = selectedNetwork;
        SensorHandler temp3 = selectedSensor;
        sensorsModel.removeAllElements();
        if(selectedStation != null) {
            for(SensorHandler sh : selectedStation.getAllSensors()) {
                sensorsModel.addElement(sh.getId());
            }
        }
        sensorsList.setModel(sensorsModel);
        selectedSensor = temp3;
        selectedNetwork = temp2;
        selectedStation = temp1;
    }
    
    private void setActuators() {
        SensorStation temp1 = selectedStation;
        SensorNetwork temp2 = selectedNetwork;
        SensorHandler temp3 = selectedSensor;
        ActuatorHandler temp4 = selectedActuator;
        actuatorsModel.removeAllElements();
        if(selectedStation != null) {
            for(ActuatorHandler ah : selectedStation.getAllActuators()) {
                actuatorsModel.addElement(ah.getId());
            }
        }
        actuatorsList.setModel(actuatorsModel);
        selectedActuator = temp4;
        selectedSensor = temp3;
        selectedNetwork = temp2;
        selectedStation = temp1;
    }
    
    private void setRules() {
        SensorStation temp1 = selectedStation;
        SensorNetwork temp2 = selectedNetwork;
        SensorHandler temp3 = selectedSensor;
        ActuatorHandler temp4 = selectedActuator;
        rulesModel.removeAllElements();
        if(selectedActuator != null) {
            for(Rule r : selectedActuator.getAllRules()) {
                rulesModel.addElement(r.getRuleData());
            }
        }
        rulesList.setModel(rulesModel);
        selectedActuator = temp4;
        selectedSensor = temp3;
        selectedNetwork = temp2;
        selectedStation = temp1;
    }
    
    // End of refresh elements.
        
    
    // Updates all list boxes and ensures they contain relevant networks.
    public void refreshGui() {
        setNetworks();
        setStations();
        setSensors();
        setActuators();
        setRules();
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
        addUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        showGUIData = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        netWorksPane = new javax.swing.JScrollPane();
        networksList = new javax.swing.JList<>();
        addNetwork = new javax.swing.JButton();
        deleteNetwork = new javax.swing.JButton();
        deleteStation = new javax.swing.JButton();
        addStation = new javax.swing.JButton();
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
        alert = new javax.swing.JButton();

        controlPanelLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        controlPanelLabel.setText("Control  Panel");

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

        deleteUser.setText("Delete User");
        deleteUser.setToolTipText("");

        showGUIData.setText("Show GUI");
        showGUIData.setToolTipText("");
        showGUIData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGUIDataActionPerformed(evt);
            }
        });

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane5.setViewportView(logArea);

        jLabel1.setText("Mesage log");

        networksList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                networksListValueChanged(evt);
            }
        });
        netWorksPane.setViewportView(networksList);

        addNetwork.setText("Add New Network");
        addNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetworkActionPerformed(evt);
            }
        });

        deleteNetwork.setText("Delete Network");
        deleteNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNetworkActionPerformed(evt);
            }
        });

        deleteStation.setText("Delete Station");
        deleteStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStationActionPerformed(evt);
            }
        });

        addStation.setText("Add New Station");
        addStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStationActionPerformed(evt);
            }
        });

        stationsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                stationsListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(stationsList);

        sensorsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                sensorsListValueChanged(evt);
            }
        });
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(deleteSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(deleteActuator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(addActuator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(deleteNetwork, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(netWorksPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(addNetwork, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deleteStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addStation, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(netWorksPane))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStation))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteNetwork)
                    .addComponent(deleteStation))
                .addContainerGap())
        );

        alert.setText("Alerts");
        alert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addComponent(controlPanelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showGUIData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(controlPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alert))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showGUIData)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteUser)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        String id = JOptionPane.showInputDialog("Input a name of the network");
        if(id != null)
        {
            smartCity.addNewNetwork(id);
            smartCity.notifyRefresh();
        }
    }//GEN-LAST:event_addNetworkActionPerformed

    private void networksListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_networksListValueChanged
        String networkId = networksList.getSelectedValue();
        if(networkId != null) {
            for(SensorNetwork sn : smartCity.getAllNetworks()) {
                if(sn.getId().compareTo(networkId) == 0) {
                    selectedNetwork = sn;
                    break;
                }
            }
        } else {
            selectedNetwork = null;
        }
        setStations();
    }//GEN-LAST:event_networksListValueChanged
// RIP Stephen Hawking 14/03/2018
    private void addStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStationActionPerformed
        if(selectedNetwork != null) {
            String name = JOptionPane.showInputDialog("Please enter the station name: ");
            if(name != null && !name.isEmpty()) {
                selectedNetwork.addNewStation(name);
                smartCity.notifyRefresh();
            } else {
                logArea.setText(logArea.getText() + "Error: Station name cannot be empty.\n");
            }
        }
    }//GEN-LAST:event_addStationActionPerformed

    private void deleteNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNetworkActionPerformed
        if(selectedNetwork != null) {
            int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this network?", "Warning", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION) {
                smartCity.deleteNetwork(selectedNetwork);
                smartCity.notifyRefresh();
                stationsModel.clear();
                actuatorsModel.clear();
                rulesModel.clear();
                sensorsModel.clear();
                stationsList.setModel(stationsModel);
                actuatorsList.setModel(actuatorsModel);
                rulesList.setModel(rulesModel);
                sensorsList.setModel(sensorsModel);
            }
        }
    }//GEN-LAST:event_deleteNetworkActionPerformed

    private void deleteStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStationActionPerformed
        if(selectedStation != null) {
            smartCity.deleteStation(selectedNetwork, selectedStation);
            smartCity.notifyRefresh();
        }
    }//GEN-LAST:event_deleteStationActionPerformed

    private void clearStationsList() {
        clearSensorsList();
        clearRulesList();
        clearActuatorsList();
        stationsModel.removeAllElements();
        stationsList.setModel(stationsModel);
    }

    private void clearSensorsList() {
        sensorsModel.removeAllElements();
        sensorsList.setModel(sensorsModel);
    }

    private void clearActuatorsList() {
        clearRulesList();
        actuatorsModel.removeAllElements();
        actuatorsList.setModel(rulesModel);
    }

    private void clearRulesList() {
        rulesModel.removeAllElements();;
        rulesList.setModel(rulesModel);

    }
    private void addSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSensorActionPerformed
        if(selectedStation != null) {
            JTextField locationField = new JTextField();
            JTextField idField = new JTextField();
            Object[] message = {
                "Location:", locationField,
                "ID:", idField
            };
            int result = JOptionPane.showConfirmDialog(null, message, "OK", JOptionPane.OK_CANCEL_OPTION);
            while ((locationField.getText().equals("") || idField.getText().equals("")) && result != JOptionPane.CANCEL_OPTION) {
                Object[] message2 = {
                    "<html><font color=\"red\">Invalid Location or ID</font></html>",
                    "Location:", locationField,
                    "ID:", idField
                };
                result = JOptionPane.showConfirmDialog(null, message2, "OK", JOptionPane.OK_CANCEL_OPTION);
            }
            if(result == JOptionPane.OK_OPTION) {
               Sensor sensor = new Sensor(locationField.getText());
               SensorHandler sh = new SensorHandler(sensor, idField.getText());
               sh.addListener(new SensorChangeListener(selectedStation));
               selectedStation.addNewSensor(sh);
               smartCity.notifyRefresh();
            }
        }
    }//GEN-LAST:event_addSensorActionPerformed

    private void deleteSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSensorActionPerformed
        if(selectedStation != null && selectedSensor != null) {
            int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this sensor?", "Delete sensor", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                selectedStation.deleteSensor(selectedSensor);
                smartCity.notifyRefresh();
            }
        }
    }//GEN-LAST:event_deleteSensorActionPerformed

    private void addActuatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActuatorActionPerformed

        if (stationsList.getSelectedValue() != null) {
            String id = JOptionPane.showInputDialog("Input a Id for the actuator");
            if(id!=null)
            {
                ActuatorHandler actuatorHandler = new ActuatorHandler(id);
                int index = stationsList.getSelectedIndex();
                stations[index].addNewActuator(actuatorHandler);
                actuators = stations[index].getAllActuators();

                actuatorsModel.addElement(actuatorHandler.getId() + "");
                actuatorsList.setModel(actuatorsModel);//update list 
            }
                       
        } else {
            now = LocalDateTime.now();
            logArea.append(DTF.format(now) + ":\tPlease select a station first" + "\n");
        }

    }//GEN-LAST:event_addActuatorActionPerformed

    private void deleteActuatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActuatorActionPerformed
        if (actuatorsList.getSelectedValue() != null) {
            int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this actuator?", "Delete Actuator", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                int stationIndex = stationsList.getSelectedIndex();

                int index = actuatorsList.getSelectedIndex();
                stations[stationIndex].deleteActuator(actuators[index]);
                actuatorsModel.remove(actuatorsList.getSelectedIndex());
                actuatorsList.setModel(actuatorsModel);

                rulesModel.removeAllElements();
                rulesList.setModel(rulesModel);
            }
        } else {
            now = LocalDateTime.now();
            logArea.append(DTF.format(now) + ":\tPlease select a actuator to delete" + "\n");
        }
    }//GEN-LAST:event_deleteActuatorActionPerformed

    private void addRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRuleActionPerformed
        if (actuatorsList.getSelectedValue() != null) {
            JTextField minField = new JTextField();
            JTextField maxField = new JTextField();
            JTextField metricField = new JTextField();
            Object[] message = {
                "Min:", minField,
                "Max:", maxField,
                "Metric", metricField
            };

            int result = JOptionPane.showConfirmDialog(null, message, "OK", JOptionPane.OK_CANCEL_OPTION);

            float min = 0;
            float max = 0;

            while ((minField.getText().equals("") || maxField.getText().equals("") || metricField.getText().equals("")) && result != JOptionPane.CANCEL_OPTION) {
                Object[] message2 = {
                    "<html><font color=\"red\">Please enter values in all fields</font></html>",
                    "Min:", minField,
                    "Max:", maxField,
                    "Metric", metricField
                };
                result = JOptionPane.showConfirmDialog(null, message2, "OK", JOptionPane.OK_CANCEL_OPTION);

            }

            boolean done=false;
            while(!done)
            {
                try {
                    min = parseFloat(minField.getText());
                    max = parseFloat(maxField.getText());
                    done=true;
                } catch (NumberFormatException ex) {
                    Object[] message3 = {
                        "<html><font color=\"red\">Min and Max must be numbers</font></html>",
                        "Min:", minField,
                        "Max:", maxField,
                        "Metric", metricField
                    };
                    result = JOptionPane.showConfirmDialog(null, message3, "OK", JOptionPane.OK_CANCEL_OPTION);
                }
            }
            if (result == JOptionPane.OK_OPTION) {
                String metric = metricField.getText();
                Rule rule = new Rule(min, max, metric);
                int index = actuatorsList.getSelectedIndex();
                actuators[index].addNewRule(rule);
                rules = actuators[index].getAllRules();
                rulesModel.addElement(rule.getRuleData());
                rulesList.setModel(rulesModel);//update list

            }
        } else {
            now = LocalDateTime.now();
            logArea.append(DTF.format(now) + ":\tPlease select a actuator first" + "\n");
        }
    }//GEN-LAST:event_addRuleActionPerformed

    private void deleteRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRuleActionPerformed
        if (rulesList.getSelectedValue() != null) {
            int reply = JOptionPane.showConfirmDialog(this, "Do you want to delete this rule?", "Delete rule", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                int actuatorsIndex = actuatorsList.getSelectedIndex();
                int stationIndex = stationsList.getSelectedIndex();
                int index = rulesList.getSelectedIndex();
                actuators[actuatorsIndex].deleteRule(rules[index], stations[stationIndex]);
                rulesModel.remove(rulesList.getSelectedIndex());
                rulesList.setModel(rulesModel);
            }
        } else {
            now = LocalDateTime.now();
            logArea.append(DTF.format(now) + ":\tPlease select a rule to delete" + "\n");
        }
    }//GEN-LAST:event_deleteRuleActionPerformed

    private void actuatorsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_actuatorsListValueChanged
        String actuatorId = actuatorsList.getSelectedValue();
        if(actuatorId != null) {
            if(selectedStation != null) {
                for(ActuatorHandler ah : selectedStation.getAllActuators()) {
                    if(ah.getId().compareTo(actuatorId) == 0) {
                        selectedActuator = ah;
                        break;
                    }
                }
            }
        } else {
            selectedActuator = null;
        }
    }//GEN-LAST:event_actuatorsListValueChanged

    private void showGUIDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGUIDataActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        GUIData gui = new GUIData(this.smartCity);
        smartCity.addWindow(gui);
        gui.setVisible(true);
    }//GEN-LAST:event_showGUIDataActionPerformed

    private void stationsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_stationsListValueChanged
        String stationId = stationsList.getSelectedValue();
        if(stationId != null) {
            for(SensorNetwork sn : smartCity.getAllNetworks()) {
                for(SensorStation ss : sn.getAllStations()) {
                    if(ss.getId().compareTo(stationId) == 0) {
                        selectedStation = ss;
                    }
                }
            }
        } else {
            selectedStation = null;
        }
        setSensors();
        setActuators();
    }//GEN-LAST:event_stationsListValueChanged

    private void alertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlertWindow(smartCity).setVisible(true);
            }
        });
    }//GEN-LAST:event_alertActionPerformed

    private void sensorsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_sensorsListValueChanged
        String sensorId = sensorsList.getSelectedValue();
        if(sensorId != null) {
            if(selectedStation != null) {
                for(SensorHandler sh : selectedStation.getAllSensors()) {
                    if(sh.getId().compareTo(sensorId) == 0) {
                        selectedSensor = sh;
                        break;
                    }
                }
            }
        } else {
            selectedStation = null;
        }
    }//GEN-LAST:event_sensorsListValueChanged

    public void addExistingNetworks() {
        //demo networks to add them initially
        smartCity.addNewNetwork("Temp network 1");
        smartCity.addNewNetwork("Temp network 2");
        networks = smartCity.getAllNetworks();
        for (int i = 0; i < smartCity.getNetworksCount(); i++) {
            networksModel.addElement("" + networks[i].getId());
        }
        networksList.setModel(networksModel);
    }

    public SmartCity getSmartCity() {
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
    private javax.swing.JButton alert;
    private javax.swing.JLabel controlPanelLabel;
    private javax.swing.JButton deleteActuator;
    private javax.swing.JButton deleteNetwork;
    private javax.swing.JButton deleteRule;
    private javax.swing.JButton deleteSensor;
    private javax.swing.JButton deleteStation;
    private javax.swing.JButton deleteUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JScrollPane netWorksPane;
    private javax.swing.JList<String> networksList;
    private javax.swing.JList<String> rulesList;
    private javax.swing.JList<String> sensorsList;
    private javax.swing.JButton showGUIData;
    private javax.swing.JList<String> stationsList;
    // End of variables declaration//GEN-END:variables

}
