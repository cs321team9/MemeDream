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
    
    private int idNumber;
    private int rating;
    private String name;
    
    private ImageIcon image;
    private ImageIcon thumbnail;
    
    private ArrayList<String> tagsList;
    
    /**
     *
     * @param id
     * @param pic
     * @param tags
     * @param title
     * @param rate
     */
    public CustomImage(int id, ImageIcon pic, ArrayList<String> tags, String title, int rate)
    {
        
        
        
        
        setIDNumber(id);
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
     *
     * @return
     */
    public final int getRating() 
    {
        return rating;
    }

    /**
     *
     * @return
     */
    public final String getName() 
    {
        return name;
    }

    /**
     *
     * @return
     */
    public final ImageIcon getImage() 
    {
        return image;
    }
    
    /**
     *
     * @return
     */
    public final ImageIcon getThumbnail()
    {
        return thumbnail;
    }
    
    /**
     *
     * @return
     */
    public final ArrayList<String> getTags()
    {
        return tagsList;
    }

    /**
     *
     * @param rating
     */
    public final void setRating(int rating) 
    {
        this.rating = rating;
    }

    /**
     *
     * @param name
     */
    public final void setName(String name) 
    {
        this.name = name;
    }
    
    private void setImage(ImageIcon img)
    {
        BufferedImage resizedImage = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getImage(), 0, 0, img.getIconWidth(), img.getIconHeight(), null);
        g.dispose();
        
        
        image = new ImageIcon(resizedImage);
    }
    
    private void setThumbnail(ImageIcon  img)
    {
        BufferedImage resizedThumbnail = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedThumbnail.createGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img.getImage(), 0, 0, 700, 700, null);
        g.dispose();
        
        thumbnail = new ImageIcon(resizedThumbnail);
    }
    
    private void setIDNumber(int id)
    {
        idNumber = id;
    }
    
    /**
     *
     * @param str
     */
    public final void addTag(String str)
    {
        if(!getTags().contains(str))
        {
            tagsList.add(str);
        }
    }
    
    /**
     *
     * @param str
     */
    public final void removeTag(String str)
    {
        tagsList.remove(str);
    }
    
    /**
     *
     * @param tag
     * @return
     */
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
