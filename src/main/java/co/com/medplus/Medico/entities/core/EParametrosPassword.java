/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

/**
 *
 * @author JeisonI
 */
public class EParametrosPassword {
    private String dbPasswordHash;
    private String salt;

    public String getDbPasswordHash() {
        return dbPasswordHash;
    }

    public void setDbPasswordHash(String dbPasswordHash) {
        this.dbPasswordHash = dbPasswordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    
}
