/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.dao.impl.ConsultaSegmento;
import co.com.medplus.Medico.entities.core.EGrupoRiesgo;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface GrupoRiesgoDao {
    
    public List<EGrupoRiesgo> consultaGrupoRiesgoXIdentificacion(String identificacion, int idSubCohorte) throws Exception;
    public List<ConsultaSegmento> consultarSegmentos(String identificacion, Integer grupoRiesgo) throws Exception;
    
}
