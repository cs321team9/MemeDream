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
public class Tag {
    private String name;
    private ArrayList<CustomImage> imageList;
    
    public Tag(String str, ArrayList<CustomImage> list)
    {
        setTagName(str);
        imageList = new ArrayList<>();
        
        for(CustomImage img : list)
        {
            imageList.add(img);
        }
    }
    
    public Tag(String str, CustomImage img)
    {
        setTagName(str);
        imageList = new ArrayList<>();
        
        imageList.add(img);
    }
    
    public void addImage(CustomImage img)
    {
        if(!imageList.contains(img))
        {
            imageList.add(img);
        }
    }
    
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
    
    public String getTagName()
    {
        return name;
    }
    
    private void setTagName(String str)
    {
        name = str;
    }
    
    public boolean containsImage(CustomImage img)
    {
        return imageList.contains(img);
    }
    
    
}
