/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.awt.image.BufferedImage;

/**
 *
 * @author Daniel
 */
public class PlaceholderName {
    
    String name;
    int rating;
    BufferedImage image;
    
    public PlaceholderName(String name, int rating, BufferedImage image)
    {
        this.name = name;
        this.rating = rating;
        this.image = image;
    }    

    
    
    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public BufferedImage getImage() {
        return image;
    }
    
}
