/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.subtask.pkg3;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Louis
 */
public class AlertWindow extends javax.swing.JFrame {

    private SmartCity sc;
    private Alert[] currentAlerts;
    private DefaultListModel alertListModel;
    private Alert selectedAlert;
    
    public AlertWindow(SmartCity sc) {
        this.sc = sc;
        alertListModel = new DefaultListModel();
        initComponents();
        setAlerts();
        setListeners();
    }
    
    private void setListeners() {
        alerts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String id = (String)alerts.getSelectedValue();
                for(Alert a : currentAlerts) {
                    if(a.getSensorId().compareTo(id) == 0) {
                        details.setText(a.getSensorId() + a.getTimestamp().toString());
                        selectedAlert = a;
                        return;
                    }
                }
            }
        });
    }
    
    // Sets the initial alerts list.
    private void setAlerts() {
        ArrayList<Alert> alertList = new ArrayList<>();
        SensorNetwork[] sn = sc.getAllNetworks();
        for(int i = 0; i < sn.length; ++i) {
            if(sn[i] != null) {
                SensorStation[] ss = sn[i].getAllStations();
                for(int j = 0; j < ss.length; ++j) {
                    if(ss[j] != null) {
                        Alert[] ssAlerts = ss[j].getAllAlerts();
                        if(ssAlerts != null) {
                            alertList.addAll(Arrays.asList(ssAlerts));
                        }
                    }
                }
            }
        }
        currentAlerts = alertList.toArray(new Alert[alertList.size()]);
        if(currentAlerts.length > 0) {
            for(int i = 0; i < currentAlerts.length; ++i) {
                alertListModel.addElement(currentAlerts[i].getSensorId());
            }
            alerts.setModel(alertListModel);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        alerts = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        alerts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(alerts);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alerts");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        details.setColumns(20);
        details.setRows(5);
        details.setText("No Alerts");
        jScrollPane2.setViewportView(details);

        jButton1.setText("Acknowledge Alert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // If someone ate the Minecraft source code and threw it up, this is
        // what it'd look like.
        String id = selectedAlert.getSensorId();
        SensorNetwork[] sn = sc.getAllNetworks();
        for(int i = 0; i < sn.length; ++i) {
            if(sn[i] != null) {
                SensorStation[] ss = sn[i].getAllStations();
                for(int j = 0; j < ss.length; ++j) {
                    if(ss[j] != null) {
                        SensorHandler[] sh = ss[j].getAllSensors();
                        for(int p = 0; p < sh.length; ++p) {
                            if(sh[p].getId().compareTo(id) == 0) {
                                sh[p].deleteAlert();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> alerts;
    private javax.swing.JTextArea details;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
