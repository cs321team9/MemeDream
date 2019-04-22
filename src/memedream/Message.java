/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.util.ArrayList;

/**
 * The Message object is used to pass several variables into the View/Controller through the Observer interface.
 * Passes in the filtered images, the list of all tags, and the currently selected image.
 * @author Daniel
 */
public class Message {
    
    private final ArrayList<CustomImage>  filteredImages;
    private final ArrayList<Tag> allTags;
    private final CustomImage selectedImage;
    
    /**
     * Standard constructor, simply stores all  the values in member variables.
     * @param imageArr The list of filtered CustomImages to be passed into the View/Controller.
     * @param tagArr The list of all Tag objects to be passed into the View/Controller.
     * @param selected The currently selected CustomImage in the model.
     */
    public Message(ArrayList<CustomImage> imageArr, ArrayList<Tag> tagArr, CustomImage selected)
    {
        filteredImages = imageArr;
        allTags = tagArr;
        selectedImage = selected;
    }
    
    /**
     * Returns the stored filtered  images.
     * @return Returns the ArrayList of CustomImages sent from the model.
     */
    public ArrayList<CustomImage> getFilteredImages()
    {
        return filteredImages;
    }
    
    /**
     * Returns the stored ArrayList of Tag objects.
     * @return Returns the stored ArrayList of CustomImaged sent from the model.
     */
    public ArrayList<Tag> getTags()
    {
        return allTags;
    }
    
    /**
     * Returns the stored CustomImage that was selected in the model.
     * @return Returns the stored CustomImage that was selected in the model.
     */
    public CustomImage getSelectedImage()
    {
        return selectedImage;
    }
    
}
