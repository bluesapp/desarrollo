/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ECie10;
import co.com.medplus.Medico.entities.core.EListas;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface Cie10Dao {
    
    public List<ECie10> consultaCie10(int idClasificacion) throws Exception;
    
    public List<EListas> consultaClasificaciones() throws Exception;
    
    public List<ECie10> consultaCie10XClasificacion(int idClasificacion) throws Exception;
    
    public boolean adicionarCie10Clasificacion(ECie10 eCie10, String idClasificacion) throws Exception;
    
    public boolean eliminarCie10Clasificacion(String codigo, int idClasificacion) throws Exception;
}
