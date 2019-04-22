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
    // creates new tagButton using a tag object
    public TagButton(Tag tag){
        this.setText(tag.getTagName());
        thisTag = tag;
    }
    
    // gets the name of the tag this button represents
    @Override
    public String getName()
    {
        return thisTag.getTagName();
    }
    // gets the tag object this button represents
    public Tag getTag(){
        return thisTag;
    }
}
