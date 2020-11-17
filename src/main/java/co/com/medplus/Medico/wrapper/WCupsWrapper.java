/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

/**
 *
 * @author MarioF
 */
public class WCupsWrapper {
 
    private int idCups;
    private String code;
    private String description;
    private short oxygenRequired;
    private short hospitalization;
    private String state;
    private int idClasification;

    public WCupsWrapper(){
        
    }
    /**
     * @return the idCups
     */
    public int getIdCups() {
        return idCups;
    }

    /**
     * @param idCups the idCups to set
     */
    public void setIdCups(int idCups) {
        this.idCups = idCups;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the oxygenRequired
     */
    public short getOxygenRequired() {
        return oxygenRequired;
    }

    /**
     * @param oxygenRequired the oxygenRequired to set
     */
    public void setOxygenRequired(short oxygenRequired) {
        this.oxygenRequired = oxygenRequired;
    }

    /**
     * @return the hospitalization
     */
    public short getHospitalization() {
        return hospitalization;
    }

    /**
     * @param hospitalization the hospitalization to set
     */
    public void setHospitalization(short hospitalization) {
        this.hospitalization = hospitalization;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the idClasification
     */
    public int getIdClasification() {
        return idClasification;
    }

    /**
     * @param idClasification the idClasification to set
     */
    public void setIdClasification(int idClasification) {
        this.idClasification = idClasification;
    }
    
    
    
}
