/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ECronicosLoad;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import java.sql.SQLException;

/**
 *
 * @author JorgeLP
 */
public interface CronicoDao {
    
    public ResponseCargueSp saveCronico(ECronicosLoad cronico) throws SQLException;
}
