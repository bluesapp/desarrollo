/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EConsultaCohorte;
import co.com.medplus.Medico.entities.core.EDemandaInducida;
import co.com.medplus.Medico.entities.core.EPaciente;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface PacienteDao {
    
    public EPaciente consultaPacienteXIdentificacion(String identificacion) throws Exception;
    
    public List<EDemandaInducida> consultaDemandaInducida(EConsultaCohorte consultaCohorte) throws Exception;
}
