/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CustomImage implements Serializable{
    
    private int rating;
    private String name;
    
    private ImageIcon image;
    private ImageIcon thumbnail;
    
    private ArrayList<String> tagsList;
    
    /**
     * Creates a new CustomImage.
     * @param pic The ImageIcon used to create the thumbnail and resized image.
     * @param tags The ArrayList of strings used to filter and search for like CustomImages.
     * @param title The string used to denote this CustomImage.
     * @param rate The integer rating value from one to five. Five being good, and one being less so.
     */
    public CustomImage(ImageIcon pic, ArrayList<String> tags, String title, int rate)
    {
        setImage(pic);
        setName(title);
        setRating(rate);
        setThumbnail(pic);
        
        tagsList = new ArrayList<>();
        
        for(String tag : tags)
        {
            addTag(tag);
        }
        
    }
    
    /**
     * Returns the rating of this CustomImage.
     * @return rating of this CustomImage.
     */
    public final int getRating() 
    {
        return rating;
    }

    /**
     * Returns the name of this CustomImage
     * @return name of this CustomImage
     */
    public final String getName() 
    {
        return name;
    }

    /**
     * Returns the 500x500 pixel image stored in this CustomImage.
     * @return the 500x500 image stored in this CustomImage
     */
    public final ImageIcon getImage() 
    {
        return image;
    }
    
    /**
     * Returns the 100x100 pixel image stored in this CustomImage.
     * @return the 100x100 image stored in this CustomImage
     */
    public final ImageIcon getThumbnail()
    {
        return thumbnail;
    }
    
    /**
     * Returns the ArrayList of Strings that function as the tags for this CustomImage.
     * @return list of strings used for sorting and filtering
     */
    public final ArrayList<String> getTags()
    {
        return tagsList;
    }

    /**
     * Sets the rating for this CustomImage.
     * @param rating for this CustomImage.
     */
    public final void setRating(int rating) 
    {
        this.rating = rating;
    }

    /**
     * Sets the name for this CustomImage.
     * @param name for this CustomImage
     */
    public final void setName(String name) 
    {
        this.name = name;
    }
    
    //Creates the 500x500 ImageIcon stored in image.
    private void setImage(ImageIcon img)
    {
        BufferedImage resizedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getImage(), 0, 0, 500, 500, null);
        g.dispose();
        
        
        image = new ImageIcon(resizedImage);
    }
    
    //Creates the 100x100 ImageIcon stored in thumbnail.
    private void setThumbnail(ImageIcon  img)
    {
        BufferedImage resizedThumbnail = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedThumbnail.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getImage(), 0, 0, 100, 100, null);
        g.dispose();
        
        thumbnail = new ImageIcon(resizedThumbnail);
    }
    
    /**
     * Adds the given string, if there is not already an identical string, to the ArrayList of strings functioning as tags.
     * @param str the string to be added to the ArrayList of strings functioning as tags.
     */
    public final void addTag(String str)
    {
        if(!getTags().contains(str))
        {
            tagsList.add(str);
        }
    }
    
    /**
     * Removes the given string from the list of strings functioning as tags. If the given string is not in the list, this does nothing.
     * @param str the string to be removed from the list.
     */
    public final void removeTag(String str)
    {
        tagsList.remove(str);
    }
    
    /**
     * Returns a boolean that is true if the given String tag is contained within the ArrayList of strings.
     * @param tag the string tested to be within the ArrayList of strings.
     * @return the boolean whether tag is contained within the ArrayList of Strings.
     */
    public boolean containsTag(String tag)
    {
        return tagsList.contains(tag);
    }
    
    //This was used for testing purposes. Returns the name, rating, and list of tags.
    @Override
    public String toString()
    {
        String str = "My name is: " + getName() + "\n" +
                    "My Rating is: " + getRating() + "\n" +
                    "My Tags are: " + getTags();
        
        return str;
    }
}
