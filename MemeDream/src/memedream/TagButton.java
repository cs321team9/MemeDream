/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;

/**
 *
 * @author Willi
 */
public class TagButton extends javax.swing.JToggleButton {
    private Tag thisTag;
    public TagButton(Tag tag){
        this.setText(tag.getTagName());
        thisTag = tag;
    }
    
    public Tag getTag(){
        return thisTag;
    }
}
