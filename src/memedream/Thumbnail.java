/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import memedream.CustomImage;

public class Thumbnail extends javax.swing.JLabel {
    private CustomImage thisImage;
    
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
    
    public Thumbnail(CustomImage image) {
        thisImage = image;
        ImageIcon icon = image.getThumbnail();
        this.setIcon(icon);
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
        ((UserInterface)getTopLevelAncestor()).openAddImageDialogue();
    }
    
    
    private void iconClicked(MouseEvent e) {
        ((UserInterface)getTopLevelAncestor()).goToImageView(thisImage);
    }
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 1); 
    
    public CustomImage getImage() {
        return thisImage;
    }
}
