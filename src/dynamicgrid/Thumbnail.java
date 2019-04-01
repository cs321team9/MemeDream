/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicgrid;

/**
 *
 * @author Willi
 */

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Thumbnail extends javax.swing.JLabel {
    
    public Thumbnail() {
        this.setText("no image");
        this.setSize(100, 100);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                clicked(e);
            }
        });
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(border);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
    }
    
    public Thumbnail(Image image) {
        ImageIcon icon = new ImageIcon(image);
        this.setIcon(icon);
        this.setSize(100, 100);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                iconClicked(e);
            }
        });
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(border);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
    }
    
    public Thumbnail (String str) {
        this.setText(str);
        this.setSize(100, 100);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                clicked(e);
            }
        });
        this.setPreferredSize(new Dimension(100,100));
        this.setBorder(border);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
    }
    
    private void clicked(MouseEvent e) {
        this.setText("Clicked!");
    }
    
    private void iconClicked(MouseEvent e) {
        //Do Nothing
    }
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 1); 
}
