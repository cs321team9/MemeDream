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
import javax.swing.JPopupMenu;

public class Thumbnail extends javax.swing.JLabel {
    
    private CustomImage thisImage;
    
    private javax.swing.JMenuItem deleteImageMenuItem;
    private javax.swing.JPopupMenu iconClickedPopupMenu;
    private javax.swing.JMenuItem viewImageMenuItem;
    
    // creates a new label that has no image. the mouse clicked event is different for this than for a label
    // with an image
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
    
    // created a new Thumbnail image that has stores an instance of an image
    public Thumbnail(CustomImage image) {
        thisImage = image;
        ImageIcon icon = image.getThumbnail();
        this.setIcon(icon);
        this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                iconClicked(e);
            }
        });
        this.setPreferredSize(new Dimension(100,100)); // 100pX100p
        this.setBorder(border); // makes sure the images have a black border around them
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        
        iconClickedPopupMenu = new javax.swing.JPopupMenu();
        viewImageMenuItem = new javax.swing.JMenuItem();
        deleteImageMenuItem = new javax.swing.JMenuItem();
        
        viewImageMenuItem.setText("View image");
        deleteImageMenuItem.setText("Delete image");

        viewImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewImageMenuItemActionPerformed(evt);
            }
        });
        
        deleteImageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                deleteImageMenuItemActionPerformed(evt);
            }
        });
        
        iconClickedPopupMenu.add(viewImageMenuItem);
        iconClickedPopupMenu.add(deleteImageMenuItem);
    }
    
    // creates a new label that has no image. the mouse clicked event is different for this than for a label
    // with an image
    // this is used for the "add image" label
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
    
    // opens the addimage dialog when a Thumbnail with no image is clicked (should only be "add image")
    private void clicked(MouseEvent e) {
        ((UserInterface)getTopLevelAncestor()).openAddImageDialogue();
    }
    
    // opens the image view of the image inn this thumbnail when clicked
    private void iconClicked(MouseEvent e) {
        if(e.getButton() == 1)
        {
            ((UserInterface)getTopLevelAncestor()).goToImageView(thisImage);
        }
        else if(e.getButton() == 3)
        {
            iconClickedPopupMenu.show(this, e.getX(), e.getY());
        }
    }
    
    private void viewImageMenuItemActionPerformed(ActionEvent e)
    {
        ((UserInterface)getTopLevelAncestor()).goToImageView(thisImage);
    }
    
    private void deleteImageMenuItemActionPerformed(ActionEvent e)
    {
        ((UserInterface)getTopLevelAncestor()).model.removeImage(thisImage);
    }
    
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 1); 
    
    // returns the image that is stored in this thumbnail
    public CustomImage getImage() {
        return thisImage;
    }
}
