/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;

/**
 * This is the class that represents the Model portion of this project. It is in charge of storing, altering, and filtering all of the images.
 * It also needs to be serializable, so all of its fields must be serializable.
 * @author Daniel
 */
public class Model implements Serializable, Subject{
    
    //ArrayList of Observers. Made static in order to avoid serialization problems.
    private static ArrayList<Observer> observers = new ArrayList<>();
    
    //ArrayList of all of the CustomImages. The master list.
    private ArrayList<CustomImage> allImagesList;
    
    //Temporary list of images meant to filtered and sent to the view. List of all tags is sent to the view as well.
    private ArrayList<CustomImage> tempImagesList;
    private ArrayList<Tag> allTagsList;
    
    //ArrayList of Strings used to filter tempImagesList for tags. Another String is used to filter for matching names.
    private ArrayList<String> filterTags;
    private String filterName;
    
    //Variable used to store the image currently being viewed in the image view. Allows for more in depth altering and editing of the CustomImage.
    private CustomImage selectedImage;
    
    //Strings used to store the user preferences. They are stored in the model in order to utilize its in built serialization.
    //theme stores the light or dark theme preference, and sortingType store alphabetical or rating sorting preference.
    private String theme;
    private String sortingType;
    
    //These are the two comparators used to sort by the two different sorting styles. Made transient to avoid serialization.
    private static final transient Comparator alphaCompare = new Comparator() {
        
        //Changes both names to lowercase in order to keep sorting from being case sensitive
        @Override
        public int compare(Object o1, Object o2) {
            String imageOneName = ((CustomImage)o1).getName().toLowerCase();
            String imageTwoName = ((CustomImage)o2).getName().toLowerCase();
            
            return imageOneName.compareTo(imageTwoName);
        }
        
    };
    private static final transient Comparator ratingCompare = new Comparator() {
        
        //Multiplied by negative 1 in order to invert the scale. Without the -1, objects with rating 1 are considered higher than rating 5.
        @Override
        public int compare(Object o1, Object o2) {
            Integer imageOneRating = ((CustomImage)o1).getRating();
            Integer imageTwoRating = ((CustomImage)o2).getRating();
            
            return (-1*imageOneRating.compareTo(imageTwoRating));
        }
        
    };
    
    /**
     * Standard constructor for the model. Will only be called when it is not deserialized. Instantiates member variables to default values.
     */
    public Model()
    {
        sortingType = "alphabetical";
        theme = "light";
        
        allImagesList = new ArrayList<>();
        tempImagesList = new ArrayList<>();
        allTagsList = new ArrayList<>();
        selectedImage = null;
    }
    
    /**
     * Returns the current sorting type. Will either be "alphabetical" or "rating".
     * @return the current sorting type.
     */
    public String getSortingType()
    {
        return sortingType;
    }
    
    /**
     * Returns the current background theme. Will either be "light" or "dark".
     * @return 
     */
    public String getBackgroundTheme()
    {
        return theme;
    }
    
    /**
     * Sets the current sorting type to alphabetical, and then filters, sorts, and notifies observers.
     */
    public void setSortingTypeAlphabetical()
    {
        sortingType = "alphabetical";
        filter();
    }
    
    /**
     * Sets the current sorting type to rating, and then filters, sorts, and notifies observers.
     */
    public void setSortingTypeRating()
    { 
        sortingType = "rating";
        filter();
    }
    
    /**
     * Sets the current background theme to dark, and then filters, sorts, and notifies observers.
     */
    public void setBackgroundThemeDark()
    {
        theme = "dark";
        filter();
    }
    
    /**
     * Sets the current background theme to light, and then filters, sorts, and notifies observers.
     */
    public void setBackgroundThemeLight()
    {
        theme = "light";
        filter();
    }
    
    /**
     * Sets the currently selected image to the image provided, then filters, sorts, and notifies observers.
     * @param img The CustomImage that will become the selected image.
     */
    public void setSelectedImage(CustomImage img)
    {
        selectedImage = img;
        filter();
    }
    
    /**
     * Sets the currently selected image's rating to the integer provided, then filters, sorts, and notifies observers.
     * @param newRating The integer that will be the new rating.
     */
    public void setSelectedImageRating(int newRating)
    {
        selectedImage.setRating(newRating);
        filter();
    }
    
    /**
     * Parses the given string into separate strings to be turned into tags.
     * For each of those parsed strings, it calls the addTagToSelectedImage function, which controls for duplicates.
     * @param tagsToBeAdded An unformatted string that may or may not contain multiple tags that need to be split.
     */
    public void addTagsToSelectedImage(String tagsToBeAdded)
    {
        ArrayList<String> arr = parseTags(tagsToBeAdded);
        for(String str : arr)
        {
            addTagToSelectedImage(str);
        }
    }
    
    //Adds a singular tag to a selected image. Controls for duplicates, and also manages for new unique Tag objects.
    private void addTagToSelectedImage(String tagToBeAdded)
    {
        boolean tagExists = false;
        
        //If one of the tag names is equal to tagToBeAdded, then the tag already exists. Filters, sorts, and notifies obervers.
        for(Tag tag : allTagsList)
        {
            if(tag.getTagName().equals(tagToBeAdded))
            {
                tagExists = true;
                break;
            }
        }
        
        //If the tag does not already exist, create a new Tag object with that name and reference to image, then add the tag to the selected image.
        if(!tagExists)
        {
            allTagsList.add(new Tag(tagToBeAdded, selectedImage));
        }
        
        selectedImage.addTag(tagToBeAdded);
        
        filter();
    }
    
    /**
     * Removes the input tag from the currently selected image. Removes empty Tag objects if there are any, then filters, sorts, and notifies observers.
     * If the input string is not within the currently selected image, it does nothing, but still filters, sorts, and notifies observers.
     * @param tagToBeRemoved The tag to be removed from the currently selected image.
     */
    public void removeTagFromSelectedImage(String tagToBeRemoved)
    {
        //If  the tag to be removed has the same name as a Tag object, then removed selectedImage from it's list.
        for(Tag tag : allTagsList)
        {
            if(tag.getTagName().equals(tagToBeRemoved))
            {
                tag.removeImage(selectedImage);
            }
        }
        
        //Remove the tag from the image.
        selectedImage.getTags().remove(tagToBeRemoved);
        
        removeEmptyTags();
        
        filter();
    }
    
    /**
     * Creates a new CustomImage with the given arguments, then handles tags, add the image to the list, then filter, sort, and notify observers.
     * @param img The ImageIcon to be used in generating a new CustomImage.
     * @param name The name to be used for the new CustomImage.
     * @param tags The unformatted string of tags that will be parsed and then analyzed.
     * @param rating The rating of the new CustomImage object to be created.
     */
    public void addImage(ImageIcon img, String name, String tags, int rating)
    {   
        //Just in case their is no name, it is given a default one.
        String tempName = name;
        if(tempName == "" || tempName == null)
        {
            tempName = "default";
        }
        
        //The temporary ArrayList to store tags in
        ArrayList<String> temporaryTags = new ArrayList<>();
        
        if(tags != "" && tags != null)
        {
            temporaryTags = parseTags(tags);
        }
        
        //Create the actual image and add it
        CustomImage newImage = new CustomImage(img, temporaryTags, name, rating);
        allImagesList.add(newImage);
        
        //The given for loop is meant to generate new Tags if there ain't any of the current name
        for(String temp : temporaryTags)//For all string Tags in the new Image
        {
        boolean hasTag = false;
            for(Tag tag : allTagsList)//For all tags
            {
                if(tag.getTagName().equals(temp))//If the tag has the name of the string added, set hasTag to true
                {
                    hasTag = true;
                    
                    tag.addImage(newImage);//Make sure to add images to the Tag if the string is the name of a tag.
                    break;
                }
            }

            if(!hasTag)//If the tag does not exist, make it and add the new image to it
            {
                allTagsList.add(new Tag(temp, newImage));
            }
        }
        
        filter();
    }
    
    //Used to format a string into an array of strings. Splits words between non alphabetical characters like ',' or ' '.
    private ArrayList<String> parseTags(String tags)
    {
        //This is a big line that just turns tags into an ArrayList of tags using regex
        return new ArrayList<>(Arrays.asList(tags.split("\\W+")));
    }
    
    /**
     * Removes the input image from the model, then filters, sorts, and notifies observers.
     * @param imageToBeRemoved The image to be removed.
     */
    public void removeImage(CustomImage imageToBeRemoved)
    {
        //If the Tag objects have the image to be removed, remove the image from them.
        ArrayList<Tag> tempTagsList = allTagsList;
        for(Tag tag : tempTagsList)
        {
            tag.removeImage(imageToBeRemoved);
        }
        
        //Remove the image from the master array, then remove empty tags.
        allImagesList.remove(imageToBeRemoved);
        removeEmptyTags();
        filter();
    }
    
    //Removes empty Tag objects, then filters, sorts, and notifies observers.
    private void removeEmptyTags()
    {
        ArrayList<Tag> toBeRemoved = new ArrayList<>();
        for(Tag tag : allTagsList)
        {
            if(tag.getImages().isEmpty())
            {
                toBeRemoved.add(tag);
            }
        }
        for(Tag tag : toBeRemoved)
        {
            allTagsList.remove(tag);
        }
        filter();
    }
    
    //Sorts depending on the current sorting type
    private void sort()
    {
        if("alphabetical".equals(sortingType))
        {
            Collections.sort(tempImagesList, alphaCompare);
        }
        else
        {
            Collections.sort(tempImagesList, ratingCompare);
        }
    }
    
    /**
     * Updates the filter fields to the given arguments, then filters, sorts, and notifies observers.
     * @param tagsArr The array of strings to be used in filtering by tags.
     * @param name The string that must be contained within the image title to not be filtered.
     */
    public void updateFilter(ArrayList<String> tagsArr, String name)
    {
        filterTags = tagsArr;
        filterName = name;
        
        filter();
    }
    
    //Filters allImages by whether they have the currently selected tags and string in their name, then sorts and notifies observers.
    private void filter()
    {
        
        tempImagesList.clear();
        for(CustomImage currentImage : allImagesList)
        {
            if(filterByTag(currentImage) && filterByName(currentImage))
            {
                tempImagesList.add(currentImage);
            }
        }
        
        sort();
        notifyObservers();
    }
    
    
    private boolean filterByTag(CustomImage img)
    {
        if(filterTags == null)
        {
            return true;
        }
        for(String currentTag : filterTags)
        {
            if(!img.getTags().contains(currentTag))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean filterByName(CustomImage img)
    {
        if(filterName == null)
        {
            return true;
        }
        if(img.getName().contains(filterName) && (filterName != ""  || filterName != null))
        {
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     *
     * @param o
     */
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     *
     */
    @Override
    public void notifyObservers() {
        
        Message msg = new Message(tempImagesList, allTagsList, selectedImage);
                
        for(Observer o: observers)
        {
            o.update(msg);
        }
    }
}
