/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

import java.util.List;

/**
 *
 * @author MarioF
 */
public class WCupsClasificationWrapper {
    
    private String text;
    private String id;
    private List<WCupsWrapper> lsCups;

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the lsCups
     */
    public List<WCupsWrapper> getLsCups() {
        return lsCups;
    }

    /**
     * @param lsCups the lsCups to set
     */
    public void setLsCups(List<WCupsWrapper> lsCups) {
        this.lsCups = lsCups;
    }
    
    
    
}
