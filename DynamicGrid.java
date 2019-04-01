/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicgrid;

/**
 *
 * @author william
 */

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DynamicGrid {

    /**
     * @param args the command line arguments
     */
    
    public DynamicGrid() {
        initComponents();
    }
    
    private void initComponents() {
        labels = new ArrayList<JLabel>();
        
        frame = new JFrame("Grid Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);
        frame.setLayout(new GridLayout(0,1,5,5));
        
        updateButton = new JButton("update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        addButton = new JButton ("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        
        
        panel = new JPanel();
        scroll = new JScrollPane(panel);
        panelLayout = new GridLayout(0,3,5,5);
        panel.setLayout(panelLayout);
        
        labels.add(new JLabel("Hello"));
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(scroll);
        frame.add(addButton);
        frame.add(updateButton);
        
        update();
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt){
        update();
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
        labels.add(new JLabel("Hello"));
    }
    
    private void update() {
        panel.revalidate();
        labels.forEach((n)->panel.add(n));
        panel.revalidate();
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DynamicGrid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            DynamicGrid dynamicGrid = new DynamicGrid();
            dynamicGrid.frame.setVisible(true);
        });
    }
    
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scroll;
    private GridLayout panelLayout;
    private JButton updateButton;
    private JButton addButton;
    private ArrayList<JLabel> labels; 
    
}
