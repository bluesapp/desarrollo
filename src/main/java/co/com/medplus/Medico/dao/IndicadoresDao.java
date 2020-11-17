/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EIndicadores;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface IndicadoresDao {

    public List<EIndicadores> consultaIndicadoresXIdentificacion(String identificacion) throws Exception;
}
