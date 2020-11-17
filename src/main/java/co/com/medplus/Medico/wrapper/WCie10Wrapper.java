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
public class WCie10Wrapper {
         
    private int idCie10;
    private String code;
    private String description;
    private short idRiskGroup;
    private String state;
    private int idClasification;

    /**
     * @return the idCie10
     */
    public int getIdCie10() {
        return idCie10;
    }

    /**
     * @param idCie10 the idCie10 to set
     */
    public void setIdCie10(int idCie10) {
        this.idCie10 = idCie10;
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
     * @return the idRiskGroup
     */
    public short getIdRiskGroup() {
        return idRiskGroup;
    }

    /**
     * @param idRiskGroup the idRiskGroup to set
     */
    public void setIdRiskGroup(short idRiskGroup) {
        this.idRiskGroup = idRiskGroup;
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
