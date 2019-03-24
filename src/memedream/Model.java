/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import java.util.Observable;

/**
 *
 * @author Daniel
 */
public class Model extends Observable{
    
    Album root;
    Album focused;
    
    public Model()
    {
        root = new Album("root");
        setFocused(root);
    }
    
    
    
    public Album getFocused()
    {
        return focused;
    }
    
    public void setFocused(Album a)
    {
        focused = a;
    }
}
