/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Album {
    
    String name;
    ArrayList<Album> albums = new ArrayList<>();
    ArrayList<Image> images = new ArrayList<>();
    
    public Album(String str)
    {
        name = str;
    }

    
    
    public String getName() {
        return name;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
    
    
    public void setName(String str)
    {
        name = str;
    }
    
    
    public void addAlbum(String str)
    {
        albums.add(new Album(str));
    }
    
    public void addAlbum(Album a)
    {
        albums.add(a);
    }
    
    public void addImage(String str, File f)
    {
        images.add(new Image(str, f));
    }
    
    public void addAlbum(Image i)
    {
        images.add(i);
    }
}
