/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickablethumbnail;

/**
 *
 * @author william
 */

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class DynamicGrid {

    /**
     * @param args the command line arguments
     */
    
    public DynamicGrid() {
        initComponents();
    }
    
    private void initComponents() {
        labels = new ArrayList<Thumbnail>();
        
        frame = new JFrame("Grid Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        
        buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        addButton = new JButton ("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        removeButton = new JButton("remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        
        panel = new JPanel();
        scroll = new JScrollPane(panel);
        scroll.setBounds(100,100,300,400);
        scroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        panelLayout = new GridLayout(0,3,5,5);
        panel.setLayout(panelLayout);
        
        labels.add(new Thumbnail());
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.add(scroll, BorderLayout.CENTER);
        buttons.add(addButton);
        buttons.add(removeButton);
        frame.add(buttons, BorderLayout.SOUTH);
        
        update();
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt){
        thumbCount++;
        labels.add(new Thumbnail("I am number " + thumbCount));
        update();
    }
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt){
        if(thumbCount >= 1){
            thumbCount--;
            Thumbnail del = labels.get(labels.size()-1);
            labels.remove(del);
        }
        update();
    }
    
    private void update() {
        panel.removeAll();
        labels.forEach((n)->{
            panel.add(n);
        });
        
        panel.revalidate();
        panel.repaint();
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
    private JPanel buttons;
    private JScrollPane scroll;
    private GridLayout panelLayout;
    private JButton addButton;
    private JButton removeButton;
    private ArrayList<Thumbnail> labels; 
    private int thumbCount = 0;
    
}
