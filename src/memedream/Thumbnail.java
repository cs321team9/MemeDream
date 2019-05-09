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
import java.awt.event.*;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import memedream.CustomImage;

/**
 * Stores the basic interactible object for the user interface
 * a Thumbnail object with no image has a different function than a Thumbnail object with an image
 * @author Daniel and Willi
 */
public class Thumbnail extends javax.swing.JLabel {
    
    private CustomImage thisImage;
    private javax.swing.JMenuItem deleteImageMenuItem;
    private javax.swing.JPopupMenu iconClickedPopupMenu;
    private javax.swing.JMenuItem viewImageMenuItem;
    
    
    /**
     *  The basic Thumbnail object
     * displays a thumbnail of the image that can be clicked in order to open the
     * show image card
     * @param image
     */
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
    
    /**
     * Creates an imageless "Thumbnail" object that, when clicked, opens the add image dialogue
     * @param str
     */
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
    
    /**
     *  returns the CustomImage that this Thumbnail represents
     * @return thisImage
     */
    public CustomImage getImage() {
        return thisImage;
    }
}
