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
    
    private ArrayList<CustomImage>  filteredImages;
    private ArrayList<Tag> allTags;
    
    public Message(ArrayList<CustomImage> imageArr, ArrayList<Tag> tagArr)
    {
        filteredImages = imageArr;
        allTags = tagArr;
    }
    
    public ArrayList<CustomImage> getFilteredImages()
    {
        return filteredImages;
    }
    
    public ArrayList<Tag> getTags()
    {
        return allTags;
    }
    
}
