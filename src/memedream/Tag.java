/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is the Tag Object class. The tag object is used to store a list of images that contain the name of this tag. 
 * @author Daniel
 */
public class Tag implements Serializable{
    private String name;
    private ArrayList<CustomImage> imageList;
    
    /**
     * The constructor for Tag Objects. Accepts a String used as the name, and an ArrayList of CustomImages used to sort and filter for the view.
     * @param str The name and identifier of the Tag.
     * @param list The list of CustomImages used for sorting and filtering.
     */
    public Tag(String str, ArrayList<CustomImage> list)
    {
        setTagName(str);
        imageList = new ArrayList<>();
        
        for(CustomImage img : list)
        {
            imageList.add(img);
        }
    }
    
    /**
     * The constructor for the Tag object. Accepts a string used as the name, and a singular CustomImage. Mostly used in the GalleryView and Model for new Tags.
     * @param str The name and identifier of the Tag.
     * @param img The singular image added onto the Tag object.
     */
    public Tag(String str, CustomImage img)
    {
        setTagName(str);
        imageList = new ArrayList<>();
        
        imageList.add(img);
    }
    
    /**
     * Adds the specified image to the ArrayList, if it does not already contain it.
     * @param img The CustomImage added to the ArrayList of CustomImages.
     */
    public void addImage(CustomImage img)
    {
        if(!imageList.contains(img))
        {
            imageList.add(img);
        }
    }
    
    /**
     * Removes the input image from the ArrayList of images. If the given image is not in the ArrayList, then it does nothing.
     * @param img The CustomImage to be removed.
     */
    public void removeImage(CustomImage img)
    {
        imageList.remove(img);
    }
    
    /**
     * Returns the ArrayList of CustomImages stored in this Tag.
     * @return the ArrayList of CustomImages stored  in this Tag.
     */
    public ArrayList<CustomImage> getImages()
    {
        return imageList;
    }
    
    /**
     *  Returns the name of this Tag.
     * @return the name of this Tag.
     */
    public String getTagName()
    {
        return name;
    }
    
    //Sets the name of this Tag.
    private void setTagName(String str)
    {
        name = str;
    }
    
    /**
     * Returns whether the selected image is contained within the CustomImage ArrayList stored in this Tag.
     * @param img The image to be checked if this Tag contains.
     * @return the boolean value of whether the input image is within this Tag.
     */
    public boolean containsImage(CustomImage img)
    {
        return imageList.contains(img);
    }
    
    //This was used for testing purposes. It merely prints out the name of the Tag.
    @Override
    public String toString()
    {
        return name;
    }
}
