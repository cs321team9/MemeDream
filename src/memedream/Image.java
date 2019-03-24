/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Daniel
 */
public class Image {
    
    int rating;
    String name;
    Date date;
    BufferedImage image;
    File file;

    
    
    public Image(String str, File f)
    {
        name = str;
        date = new Date();
        file  = f;
        
        try {
            image = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public BufferedImage getImage() {
        return image;
    }

    public File getFile() {
        return file;
    }

    
    
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
