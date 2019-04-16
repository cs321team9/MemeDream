/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public class MemeDream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        Window window = new Window(model);
        
        model.addObserver(window);
        
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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                window.setVisible(true);
            }
        });
        */
        
        
        
        ImageIcon dog = null;
        String dogTags = "dog, cool, funny";
        String dogTitle = "Funny Dogs";
        int dogRating = 5;
        
        ImageIcon pug = null;
        String pugTags = "dog, ugly, cute";
        String pugTitle = "pug";
        int pugRating = 3;
        
        ImageIcon egg = null;
        String eggTags = "egg, god";
        String eggTitle = "egg";
        int eggRating = 1;
        
        try 
        {
            dog = new ImageIcon(ImageIO.read(new File("C:/Temp/dog.jpg")));
            pug = new ImageIcon(ImageIO.read(new File("C:/Temp/pug.jpg")));
            egg = new ImageIcon(ImageIO.read(new File("C:/Temp/egg.jpg")));
        } 
        catch (IOException e) 
        {
            
        }
        
        ArrayList<String> filterTags = new ArrayList<>();
        //filterTags.add("dog");
        
        String filterName;
        
        model.addImage(dog, dogTitle, dogTags, dogRating);
        model.addImage(pug, pugTitle, pugTags, pugRating);
        model.addImage(dog, eggTitle, eggTags, eggRating);
        
        //model.filter(filterTags, "g");
        
        for(CustomImage img : window.imagesToDraw)
        {
            System.out.println(img);
        }
        
        
        
        
        
    }
    
}
