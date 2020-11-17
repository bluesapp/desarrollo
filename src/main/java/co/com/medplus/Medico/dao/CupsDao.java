/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ECups;
import co.com.medplus.Medico.entities.core.EListas;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface CupsDao {
    
    public List<ECups> consultaCups(int idClasificacion) throws Exception;
    
    public List<EListas> consultaClasificaciones() throws Exception;
    
    public List<ECups> consultaCupsXClasificacion(int idClasificacion) throws Exception;
    
    public boolean adicionarCupsClasificacion(ECups eCups, String idClasificacion) throws Exception;
    
    public boolean eliminarCupsClasificacion(String codigo, int idClasificacion) throws Exception;
}
