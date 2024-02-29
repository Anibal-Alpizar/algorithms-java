/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.algorithms.UI;

import com.mycompany.algorithms.Layers.BLL.BLLEvent;
import com.mycompany.algorithms.Layers.Entities.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author anibal
 */
public class frmCreateEvent extends javax.swing.JFrame {

    private Event event;

    public frmCreateEvent() {
        initComponents();
        fillMonths();
        fillDays();
        fillHours();
        fillSports();

        txtYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                validateYear();
            }
        });
    }

    public frmCreateEvent(Event event) {
        this();

        this.event = event;

        fillFormWithEventData();
    }

    private void fillFormWithEventData() {

        if (event != null) {
            txtYear.setText(String.valueOf(event.getYear()));
            drpMonth.setSelectedIndex(event.getMonth() - 1);
            drpDay.setSelectedItem(String.valueOf(event.getDay()));
            txtTeamA.setText(event.getTeamA());
            txtTeamB.setText(event.getTeamB());
            drpSport.setSelectedItem(event.getSport());
            txtCompetitionName.setText(event.getCompetitionName());
            txtCompetitionCountry.setText(event.getCompetitionCountry());
            drpHour.setSelectedItem(event.getHour());

        } else {
            System.out.println("Event is null. Cannot fill form data.");
        }
    }

    // english
    private void fillMonths() {
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            if (!month.isEmpty()) {
                drpMonth.addItem(month);
            }
        }
    }

    // spanish
//    private void fillMonths() {
//        String[] months = new DateFormatSymbols(new Locale("es", "ES")).getMonths();
//        for (String month : months) {
//            if (!month.isEmpty()) {
//                drpMonth.addItem(month);
//            }
//        }
//    }
    private void fillDays() {
        drpDay.removeAllItems();

        int selectedMonth = drpMonth.getSelectedIndex() + 1; // Months are 1-based in Calendar

        int selectedYear;
        try {
            selectedYear = Integer.parseInt(txtYear.getText());
        } catch (NumberFormatException e) {
            return;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(selectedYear, selectedMonth - 1, 1); // Months are 0-based in Calendar
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int day = 1; day <= maxDays; day++) {
            drpDay.addItem(String.valueOf(day));
        }
    }

    private void validateYear() {
        int enteredYear;
        try {
            enteredYear = Integer.parseInt(txtYear.getText());

            if (txtYear.getText().length() != 4) {
                JOptionPane.showMessageDialog(this, "Invalid year format. Please enter a 4-digit year.", "Error", JOptionPane.ERROR_MESSAGE);

                turnOff();

                return; 
            }

            if (enteredYear <= 1900) {
                JOptionPane.showMessageDialog(this, "Invalid year. Please enter a year greater than 1900.", "Error", JOptionPane.ERROR_MESSAGE);

                turnOff();

                return; 
            }

            turnOn();

            fillDays();
        } catch (NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(this, "Invalid year format. Please enter a valid 4-digit year.", "Error", JOptionPane.ERROR_MESSAGE);

            turnOff();

        }

    }

    private void turnOff() {
        drpMonth.setEnabled(false);
        drpDay.setEnabled(false);
        drpHour.setEnabled(false);
        drpSport.setEnabled(false);
        txtCompetitionCountry.setEnabled(false);
        txtCompetitionName.setEnabled(false);
        txtTeamA.setEnabled(false);
        txtTeamB.setEnabled(false);
    }

    private void turnOn() {
        drpMonth.setEnabled(true);
        drpDay.setEnabled(true);
        drpHour.setEnabled(true);
        drpSport.setEnabled(true);
        txtCompetitionCountry.setEnabled(true);
        txtCompetitionName.setEnabled(true);
        txtTeamA.setEnabled(true);
        txtTeamB.setEnabled(true);
    }

    private void fillHours() {
        DefaultComboBoxModel<String> hourModel = new DefaultComboBoxModel<>();

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 30) {
                String formattedHour = String.format("%02d:%02d", hour, minute);
                hourModel.addElement(formattedHour);
            }
        }

        drpHour.setModel(hourModel);
    }

    private void fillSports() {
        DefaultComboBoxModel<String> sportModel = new DefaultComboBoxModel<>();

        String[] sports = {
            "Fútbol",
            "Béisbol",
            "Voleibol",
            "Básquetbol",
            "Fútbol Americano",
            "Balonmano",
            "Rugby",
            "Hockey"
        };

        for (String sport : sports) {
            sportModel.addElement(sport);
        }

        drpSport.setModel(sportModel);
    }

    /**
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblYear = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTeamB = new javax.swing.JLabel();
        lblTeamA = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        lblSport = new javax.swing.JLabel();
        lblCompetitionName = new javax.swing.JLabel();
        lblCompetitionCountry = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        txtCompetitionName = new javax.swing.JTextField();
        txtCompetitionCountry = new javax.swing.JTextField();
        txtTeamB = new javax.swing.JTextField();
        txtTeamA = new javax.swing.JTextField();
        drpDay = new javax.swing.JComboBox<>();
        drpMonth = new javax.swing.JComboBox<>();
        drpSport = new javax.swing.JComboBox<>();
        drpHour = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnGetAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblYear.setText("Year");
        getContentPane().add(lblYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 27, 48, 28));

        lblMonth.setText("Month");
        getContentPane().add(lblMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 67, 48, 24));

        jLabel1.setText("Day");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 112, -1, -1));

        lblTeamB.setText("Team B");
        getContentPane().add(lblTeamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 358, -1, -1));

        lblTeamA.setText("Team A");
        getContentPane().add(lblTeamA, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 318, -1, -1));

        lblHour.setText("Hour");
        getContentPane().add(lblHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 160, -1, -1));

        lblSport.setText("Sport");
        getContentPane().add(lblSport, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 200, -1, -1));

        lblCompetitionName.setText("Competition Name");
        getContentPane().add(lblCompetitionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 240, -1, -1));

        lblCompetitionCountry.setText("Competition Country");
        getContentPane().add(lblCompetitionCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 278, -1, -1));

        txtYear.setText("1990");
        getContentPane().add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 155, -1));
        getContentPane().add(txtCompetitionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 237, 155, -1));
        getContentPane().add(txtCompetitionCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 275, 155, -1));
        getContentPane().add(txtTeamB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 155, -1));
        getContentPane().add(txtTeamA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 155, -1));

        getContentPane().add(drpDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, -1));

        drpMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpMonthActionPerformed(evt);
            }
        });
        getContentPane().add(drpMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 150, -1));

        getContentPane().add(drpSport, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 150, -1));

        getContentPane().add(drpHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        btnGetAll.setText("Get All");
        btnGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllActionPerformed(evt);
            }
        });
        getContentPane().add(btnGetAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drpMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpMonthActionPerformed
        fillDays();
    }//GEN-LAST:event_drpMonthActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtYear.getText().isEmpty() || drpMonth.getSelectedIndex() == -1 || drpDay.getSelectedIndex() == -1
                || txtTeamA.getText().isEmpty() || txtTeamB.getText().isEmpty() || drpSport.getSelectedIndex() == -1
                || txtCompetitionName.getText().isEmpty() || txtCompetitionCountry.getText().isEmpty() || drpHour.getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios. Por favor, llénelos antes de guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        int year = Integer.parseInt(txtYear.getText());
        int month = drpMonth.getSelectedIndex() + 1;  
        int day = Integer.parseInt(drpDay.getSelectedItem().toString());
        String teamA = txtTeamA.getText();
        String teamB = txtTeamB.getText();
        String sport = drpSport.getSelectedItem().toString();
        String competitionName = txtCompetitionName.getText();
        String competitionCountry = txtCompetitionCountry.getText();
        String hour = drpHour.getSelectedItem().toString();

        Event evento;

        if (event != null && event.getId() > 0) {
            evento = new Event(event.getId(), year, month, day, teamA, teamB, sport, competitionName, competitionCountry, hour);
            if (BLLEvent.updateEvent(evento)) {
                System.out.println("Evento actualizado exitosamente.");
            } else {
                System.out.println("Error al actualizar el evento.");
            }
        } else {
            evento = new Event(year, month, day, teamA, teamB, sport, competitionName, competitionCountry, hour);
            if (BLLEvent.saveEvent(evento)) {
                System.out.println("Evento creado exitosamente.");
            } else {
                System.out.println("Error al guardar el evento.");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllActionPerformed
        frmGetEvent frmGetEvent = new frmGetEvent();
        frmGetEvent.setVisible(true);
        frmGetEvent.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnGetAllActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCreateEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> drpDay;
    private javax.swing.JComboBox<String> drpHour;
    private javax.swing.JComboBox<String> drpMonth;
    private javax.swing.JComboBox<String> drpSport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCompetitionCountry;
    private javax.swing.JLabel lblCompetitionName;
    private javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblSport;
    private javax.swing.JLabel lblTeamA;
    private javax.swing.JLabel lblTeamB;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtCompetitionCountry;
    private javax.swing.JTextField txtCompetitionName;
    private javax.swing.JTextField txtTeamA;
    private javax.swing.JTextField txtTeamB;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
