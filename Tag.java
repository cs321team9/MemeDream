/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Tag implements Serializable{
    private String name;
    private ArrayList<CustomImage> imageList;
    
    /**
     *
     * @param str
     * @param list
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
     *
     * @param str
     * @param img
     */
    public Tag(String str, CustomImage img)
    {
        setTagName(str);
        imageList = new ArrayList<>();
        
        imageList.add(img);
    }
    
    /**
     *
     * @param img
     */
    public void addImage(CustomImage img)
    {
        if(!imageList.contains(img))
        {
            imageList.add(img);
        }
    }
    
    /**
     *
     * @param img
     */
    public void removeImage(CustomImage img)
    {
        imageList.remove(img);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<CustomImage> getImages()
    {
        return imageList;
    }
    
    /**
     *
     * @return
     */
    public String getTagName()
    {
        return name;
    }
    
    private void setTagName(String str)
    {
        name = str;
    }
    
    /**
     *
     * @param img
     * @return
     */
    public boolean containsImage(CustomImage img)
    {
        return imageList.contains(img);
    }
}
