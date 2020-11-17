/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ETamizaje;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface TamizajeDao {

    public List<ETamizaje> consultaTamizajeXIdentificacion(String identificacion) throws Exception;
    
}
