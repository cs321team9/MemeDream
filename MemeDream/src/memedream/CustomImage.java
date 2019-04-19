/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Daniel
 */
public class CustomImage {
    
    private int idNumber;
    private int rating;
    private String name;
    
    private ImageIcon image;
    
    private ArrayList<String> tagsList;
    
    public CustomImage(int id, ImageIcon pic, ArrayList<String> tags, String title, int rate)
    {
        setIDNumber(id);
        setImage(pic);
        setName(title);
        setRating(rate);
        
        
        tagsList = new ArrayList<>();
        
        for(String tag : tags)
        {
            addTag(tag);
        }
        
    }
    
    
    
    public final int getRating() 
    {
        return rating;
    }

    public final String getName() 
    {
        return name;
    }

    public final ImageIcon getImage() 
    {
        return image;
    }
    
    public final ArrayList<String> getTags()
    {
        return tagsList;
    }

    
    
    public final void setRating(int rating) 
    {
        this.rating = rating;
    }

    public final void setName(String name) 
    {
        this.name = name;
    }
    
    private final void setImage(ImageIcon img)
    {
        image = img;
    }
    
    private final void setIDNumber(int id)
    {
        idNumber = id;
    }
    
    
    
    
    public final void addTag(String str)
    {
        if(!getTags().contains(str))
        {
            tagsList.add(str);
        }
    }
    
    public final void removeTag(String str)
    {
        tagsList.remove(str);
    }
    
    public boolean containsTag(String tag)
    {
        return tagsList.contains(tag);
    }
    
    @Override
    public String toString()
    {
        String str = "My name is: " + getName() + "\n" +
                    "My Rating is: " + getRating() + "\n" +
                    "My Tags are: " + getTags();
        /*
        for(String strong : getTags())
        {
            str += strong + " ";
        }
*/
        return str;
    }
}
