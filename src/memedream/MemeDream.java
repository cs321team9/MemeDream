/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        Model model;
        
        
        //Deserialization or create new model instance
        try
        {
            FileInputStream fileInputStream = new FileInputStream("data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            model = (Model) objectInputStream.readObject();            
        }
        catch(Exception e)
        {
            model = new Model();
        }
        
        
        //Make sure this comes after the declaration of the model
        Window window = new Window(model);
        
        model.addObserver(window);
        model.notifyObservers();
        
        
        //Show the window
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                window.setVisible(true);
            }
        });

        
        
        
        
        
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
        model.addImage(egg, eggTitle, eggTags, eggRating);
        
        //model.filter(filterTags, "g");
        
        for(CustomImage img : window.imagesToDraw)
        {
            System.out.println(img);
        }
        
        
        //Serialization
        try 
        {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(model);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MemeDream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
