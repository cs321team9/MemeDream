/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

import memedream.Tag;

/**
 *
 * @author Willi
 */
public class TagButton extends javax.swing.JToggleButton {
    private Tag thisTag;

    /**
     * creates a new TagButton using the information from a Tag object
     * @param tag
     */
    public TagButton(Tag tag){
        this.setText(tag.getTagName());
        thisTag = tag;
    }
    
    @Override
    public String getName()
    {
        return thisTag.getTagName();
    }

    /**
     * returns the tag object that this button represents
     * @return
     */
    public Tag getTag(){
        return thisTag;
    }
}
