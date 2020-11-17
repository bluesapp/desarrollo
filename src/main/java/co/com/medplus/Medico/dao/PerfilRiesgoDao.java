/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EPerfilRiesgo;
import co.com.medplus.Medico.entities.core.EPerfilRiesgoRPM;
import co.com.medplus.Medico.wrapper.WPerfilRiesgo;
import java.util.List;

/**
 *
 * @author JeisonI
 */
public interface PerfilRiesgoDao {
    
    List<EPerfilRiesgo> getAllDataPerfil(WPerfilRiesgo perfilRiesgo) throws Exception;
    
    List<EPerfilRiesgoRPM> getAllDataPerfilTwo(WPerfilRiesgo perfilRiesgo)throws Exception;
    
}
