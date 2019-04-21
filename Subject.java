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
public interface Subject {
    
    /**
     *
     * @param o
     */
    public void addObserver(Observer o);

    /**
     *
     * @param o
     */
    public void removeObserver(Observer o);
    
    /**
     *
     */
    public void notifyObservers();
}
