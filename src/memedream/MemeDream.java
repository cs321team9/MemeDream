/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *  The purpose of this class is solely to create the model and window, and then to link them together. It will deserialize the local data.txt file if it exists, and otherwise creates a new model.
 * @author Daniel Dyer, Franco Camarillo, Krystal Lin, Wm. Isaac Cunningham.
 */
public class MemeDream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declare the model
        Model model;
        
        
        //Deserialization or create new model instance
        try
        {
            
            FileInputStream fileInputStream = new FileInputStream("data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            model = (Model) objectInputStream.readObject();
            
            fileInputStream.close();
            objectInputStream.close();
            
        }
        catch(Exception e)
        {
            model = new Model();
        }
        
        
        
        //Create the View and Controller, while giving a reference to the model.
        UserInterface window = new UserInterface(model);
        
        //Establish the observer relationship
        model.addObserver(window);
        model.notifyObservers();
        
        
        //Show the window
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                window.setVisible(true);
            }
        });

    }
    
}
