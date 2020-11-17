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
public class WCie10ClasificationWrapper {
    
    private String text;
    private String id;
    private List<WCie10Wrapper> lsCie10;

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
     * @return the lsCie10
     */
    public List<WCie10Wrapper> getLsCie10() {
        return lsCie10;
    }

    /**
     * @param lsCie10 the lsCie10 to set
     */
    public void setLsCie10(List<WCie10Wrapper> lsCie10) {
        this.lsCie10 = lsCie10;
    }
}
