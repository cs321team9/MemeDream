/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Message {
    
    private final ArrayList<CustomImage>  filteredImages;
    private final ArrayList<Tag> allTags;
    private final CustomImage selectedImage;
    
    /**
     *
     * @param imageArr
     * @param tagArr
     */
    public Message(ArrayList<CustomImage> imageArr, ArrayList<Tag> tagArr, CustomImage selected)
    {
        filteredImages = imageArr;
        allTags = tagArr;
        selectedImage = selected;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<CustomImage> getFilteredImages()
    {
        return filteredImages;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Tag> getTags()
    {
        return allTags;
    }
    
    public CustomImage getSelectedImage()
    {
        return selectedImage;
    }
    
}
