/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EGrupoRiesgoCohorte;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface GrupoRiesgoCohorteDao {
    
    public List<EGrupoRiesgoCohorte> consultaValidacionManualXGrupoRiesgo(String identificacion, int idGrupoRiesgo, String fechaInicial, String fechaFinal) throws Exception;
    
    public boolean adicionarIdentificacionGrupoRiesgoCohorte(EGrupoRiesgoCohorte eGrupoRiesgoCohorte) throws Exception;
}
