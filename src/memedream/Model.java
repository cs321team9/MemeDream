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
 *
 * @author Daniel
 */
public class Model implements Serializable, Subject{
    
    private String sortingType;
    
    private int id;
    
    private ArrayList<Observer> observers;
    
    private ArrayList<CustomImage> allImagesList;
    private ArrayList<CustomImage> tempImagesList;
    private ArrayList<Tag> allTagsList;
    
    private ArrayList<String> filterTags;
    private String filterName;
    
    private CustomImage selectedImage;
    
    private Comparator alphaCompare = new Comparator() {
        
        @Override
        public int compare(Object o1, Object o2) {
            String imageOneName = ((CustomImage)o1).getName().toLowerCase();
            String imageTwoName = ((CustomImage)o2).getName().toLowerCase();
            
            return imageOneName.compareTo(imageTwoName);
        }
        
    };
    private Comparator ratingCompare = new Comparator() {
        
        @Override
        public int compare(Object o1, Object o2) {
            Integer imageOneRating = ((CustomImage)o1).getRating();
            Integer imageTwoRating = ((CustomImage)o2).getRating();
            
            return -1*imageOneRating.compareTo(imageTwoRating);
        }
        
    };
    
    /**
     *
     */
    public Model()
    {
        id = 0;
        sortingType = "alphabetical";
        
        observers = new ArrayList<>();
        allImagesList = new ArrayList<>();
        tempImagesList = new ArrayList<>();
        allTagsList = new ArrayList<>();
    }
    
    /**
     *
     * @return
     */
    public String getSortingType()
    {
        return sortingType;
    }
    
    /**
     *
     * @return
     */
    public CustomImage getSelected()
    {
        return selectedImage;
    }
    
    /**
     *
     */
    public void setSortingTypeAlphabetical()
    {
        sortingType = "alphabetical";
    }
    
    /**
     *
     */
    public void setSortingTypeRating()
    {
        sortingType = "rating";
    }
    
    /**
     *
     * @param img
     */
    public void setSelected(CustomImage img)
    {
        selectedImage = img;
    }
    
    public int generateID()
    {
        return id++;
    }
    
    /**
     *
     * @param tagToBeAdded
     */
    public void addTagToSelectedImage(String tagToBeAdded)
    {
        boolean hasTag = false;
        
        for(Tag tag : allTagsList)
        {
            if(tag.getTagName().equals(tagToBeAdded))
            {
                hasTag = true;
                break;
            }
        }
        
        if(!hasTag)
        {
            allTagsList.add(new Tag(tagToBeAdded, selectedImage));
        }
        
        selectedImage.addTag(tagToBeAdded);
        
        notifyObservers();
    }
    
    /**
     *
     * @param tagToBeRemoved
     */
    public void removeTagFromSelectedImage(String tagToBeRemoved)
    {
        for(Tag tag : allTagsList)
        {
            if(tag.getTagName().equals(tagToBeRemoved))
            {
                tag.removeImage(selectedImage);
            }
        }
        
        selectedImage.getTags().remove(tagToBeRemoved);
        
        removeEmptyTags();
        
        notifyObservers();
    }
    
    /**
     *
     * @param img
     * @param name
     * @param tags
     * @param rating
     */
    public void addImage(ImageIcon img, String name, String tags, int rating)
    {
        String tempName = name;
        
        if(tempName == "" || tempName == null)
        {
            tempName = "default";
        }
        
        int tempID = generateID();
        
        ArrayList<String> temporaryTags = parseTags(tags);
        
        CustomImage newImage = new CustomImage(tempID, img, temporaryTags, name, rating);
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
        
        notifyObservers();
    }
    
    private ArrayList<String> parseTags(String tags)
    {
        //This is a big line that just turns tags into an ArrayList of tags using regex
        return new ArrayList<>(Arrays.asList(tags.split("\\W+")));
    }
    
    /**
     *
     * @param imageToBeRemoved
     */
    public void removeImage(CustomImage imageToBeRemoved)
    {
        for(Tag tag : allTagsList)
        {
            tag.removeImage(imageToBeRemoved);
        }
        
        allImagesList.remove(imageToBeRemoved);
        removeEmptyTags();
        
        notifyObservers();
    }
    
    /**
     *
     */
    private void removeEmptyTags()
    {
        for(Tag tag : allTagsList)
        {
            if(tag.getImages().isEmpty())
            {
                allTagsList.remove(tag);
            }
        }
    }
    
    /**
     *
     */
    public void sort()
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
     *
     * @param arr
     * @param name
     */
    public void filter(ArrayList<String> arr, String name)
    {
        filterTags = arr;
        filterName = name;
        
        tempImagesList.clear();
        for(CustomImage currentImage : allImagesList)
        {
            if(filterByTag(arr, currentImage) && filterByName(name, currentImage))
            {
                tempImagesList.add(currentImage);
            }
        }
        
        sort();
    }
    
    private boolean filterByTag(ArrayList<String> arr, CustomImage img)
    {
        if(arr == null)
        {
            return true;
        }
        for(String currentTag : arr)
        {
            if(!img.getTags().contains(currentTag))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean filterByName(String name, CustomImage img)
    {
        if(name == null)
        {
            return true;
        }
        if(img.getName().contains(name) && (name != ""  || name != null))
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
        filter(filterTags, filterName);
        
        Message msg = new Message(tempImagesList, allTagsList);
                
        for(Observer o: observers)
        {
            o.update(msg);
        }
    }
}
