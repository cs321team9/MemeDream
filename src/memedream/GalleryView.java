/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static javax.swing.ScrollPaneConstants.*;

/**
 *
 * @author Willi
 */
public class GalleryView extends javax.swing.JPanel {

    /**
     * Creates new form GalleryView
     */
    public GalleryView() {
        initComponents();
        addComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GalleryScroll = new javax.swing.JScrollPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GalleryScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GalleryScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   
    // <editor-fold defaultstate="collapsed" desc="Custom 'InitComponents'">
    private void addComponents(){
        labels = new ArrayList<>();
        
        
        panel = new JPanel();
        GalleryScroll.setViewportView(panel);
        GalleryScroll.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        GalleryScroll.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        panelLayout = new GridLayout(0,3,5,5);
        panel.setLayout(panelLayout);
        
        labels.add(new Thumbnail("Add Image"));
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        update();
    }//</editor-fold>
    
    
    
    //*/
    
    ///*

    /**
     *
     */
    public void update() {
        panel.removeAll();
        labels.forEach((n)->{
            //System.out.println("adding new object");
            panel.add(n);
        });
        
        panel.revalidate();
        panel.repaint();
        panel.updateUI();
        //System.out.println("update complete");
    }
    //*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane GalleryScroll;
    // End of variables declaration//GEN-END:variables
    private JPanel panel;
    private JPanel buttons;
    private GridLayout panelLayout;
    ArrayList<Thumbnail> labels; 
    private int thumbCount = 0;
    
}
