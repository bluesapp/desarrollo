/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EAutorizacion;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface VouchersDao {

    public List<EAutorizacion> consultaAutorizacionValidacionManualXIdentificacion(String identificacion, int idGrupoRiesgo) throws Exception;
    
}
