/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import java.awt.event.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
/**
 *
 * @author b4014007
 */
public class GUIData extends javax.swing.JFrame {
     
    private SmartCity smartCity;
    private SensorNetwork assignedNetwork;
    private SensorStation assignedStation;
    
    // Sets the station combo box data when the network changes.
    private void setStationData() {
        SensorStation[] stations = assignedNetwork.getAllStations();
        String[] stationIds = new String[assignedNetwork.getStationsCount() + 1];
        stationIds[0] = "Select";
        for(int i = 1; i < assignedNetwork.getStationsCount() + 1; ++i) {
            stationIds[i] = stations[i - 1].getId(); 
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(stationIds);
        station.setModel(model);
    }
    
    private void resetStationData() {
        String[] select = new String[1];
        select[0] = "Select";
        station.setModel(new DefaultComboBoxModel(select));
    }
    
    void refreshGui() {
        if(assignedNetwork != null) {
            setStationData();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(SensorNetwork sn : smartCity.getAllNetworks()) {
            model.addElement(sn.getId());
        }
        network.setModel(model);
    }
    
    private void setInitialValues() {
        SensorNetwork[] networks = smartCity.getAllNetworks();
        String[] networkIds = new String[networks.length + 1];
        networkIds[0] = "Select";
        for(int i = 1; i < networkIds.length; ++i) {
            if(networks[i - 1] != null) {
                networkIds[i] = networks[i - 1].getId();
            }
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(networkIds);
        network.setModel(model);
    }
    
    // Sets all the data fields in the main panel.
    private void setData() {
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        sensors.setVisible(true);
        metrics.setVisible(true);
        values.setVisible(true);
        averages.setVisible(true);
        
        StyledDocument sdoc = sensors.getStyledDocument();
        StyledDocument mdoc = metrics.getStyledDocument();
        StyledDocument vdoc = values.getStyledDocument();
        StyledDocument adoc = averages.getStyledDocument();
        
        Reading[] readings = assignedStation.collectIndividualSensorData();
        AverageReading[] averages = assignedStation.getAllAverageData();
        SensorHandler[] shs = assignedStation.getAllSensors();
        
        try {
            for(int i = 0; i < assignedStation.getSensorCount(); ++i) {
                sdoc.insertString(sdoc.getLength(), shs[i].getId() + "\n", null);
                mdoc.insertString(mdoc.getLength(), readings[i].getMetrics() + "\n", null);
                String strValue = Double.toString(readings[i].getValue());
                strValue = strValue.substring(0, strValue.indexOf('.') + 2);
                vdoc.insertString(vdoc.getLength(), strValue + "\n", null);
                for(int j = 0; j < averages.length; ++j) {
                    if(averages[j].getMetric().compareTo(readings[i].getMetrics()) == 0) {
                        String strAvg = Double.toString(averages[j].getValue());
                        strAvg = strAvg.substring(0, strAvg.indexOf('.' + 2));
                        adoc.insertString(adoc.getLength(), strAvg + "\n", null);
                        break;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Sets the main data display panel to a string saying please select a station.
    private void resetData() {
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        sensors.setVisible(false);
        metrics.setVisible(false);
        values.setVisible(false);
        averages.setVisible(false);
    }
    
    private void clearFields() {
        sensors.setText("");
        metrics.setText("");
        values.setText("");
        averages.setText("");
    }
    
    private void setListeners() {
        network.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String n = (String)e.getItem();
                if(n.compareTo("Select") != 0) {
                    for(SensorNetwork sn : smartCity.getAllNetworks()) {
                        if(sn.getId().compareTo(n) == 0) {
                            assignedNetwork = sn;
                            assignedStation = null;
                            clearFields();
                            setStationData();
                            break;
                        }
                    }
                }
                else {
                    assignedNetwork = null;
                    resetData();
                    resetStationData();
                    clearFields();
                }
            }
        });
        station.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String n = (String)e.getItem();
                if(assignedNetwork != null) {
                    if(n.compareTo("Select") != 0) {
                        for(SensorStation ss : assignedNetwork.getAllStations()) {
                            if(ss.getId().compareTo(n) == 0) {
                                assignedStation = ss;
                                break;
                            }
                        }
                        clearFields();
                        setData();
                    }
                    else {
                        clearFields();
                        resetData();
                    }
                }
            }
        });
    }
    /**
     * Creates new form GUIData
     * @param smartCity The smart city object for the GUI to get its data from.
     */
    public GUIData(SmartCity smartCity) {
        this.smartCity = smartCity;
        initComponents();
        setListeners();
        setInitialValues();
        ((JLabel)network.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)station.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        resetData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        network = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        station = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        sensors = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        metrics = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        values = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        averages = new javax.swing.JTextPane();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Network");

        network.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        network.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Station");

        station.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        station.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sensor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Metric");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Value");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Average");

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        sensors.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane5.setViewportView(sensors);

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        metrics.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane6.setViewportView(metrics);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        values.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane7.setViewportView(values);

        jScrollPane8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        averages.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane8.setViewportView(averages);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(network, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(station, 0, 222, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(network, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(station, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane averages;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextPane metrics;
    private javax.swing.JComboBox<String> network;
    private javax.swing.JTextPane sensors;
    private javax.swing.JComboBox<String> station;
    private javax.swing.JTextPane values;
    // End of variables declaration//GEN-END:variables
}
