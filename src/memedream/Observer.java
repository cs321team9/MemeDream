/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedream;


/**
 *
 * @author Daniel
 */
public interface Observer{
    
    /**
     *
     * @param msg
     */
    public void update(Message msg);
}
