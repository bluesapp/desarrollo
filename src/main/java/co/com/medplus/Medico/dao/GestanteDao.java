/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.dao.impl.WGestanteActualizarWrapper;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.WGestanteWrapper;
import co.com.medplus.Medico.wrapper.WGestateCreadorWrapper;
import java.util.List;

/**
 *
 * @author JorgeLP
 */
public interface GestanteDao {
    
    public List<WGestanteWrapper> consultarGestantes(String identificacion,String tipoDocumento)throws Exception;
    
    public Boolean ingresarGestante(WGestateCreadorWrapper creadorWrapper) throws Exception;
    
    public ResponseCargueSp actualizarGestante(WGestanteActualizarWrapper wgaw)throws Exception;
    
}
