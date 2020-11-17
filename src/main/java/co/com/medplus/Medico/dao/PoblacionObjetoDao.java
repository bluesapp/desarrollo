/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;
import java.util.List;
import co.com.medplus.Medico.entities.core.EPoblacionObjeto;

/**
 *
 * @author MarioF
 */
public interface PoblacionObjetoDao {
    
    public List<EPoblacionObjeto> consultaPoblacionObjetoXTipoRiesgo(int idTipoRiesgo) throws Exception;
    
    public boolean adicionarPoblacionObjeto(EPoblacionObjeto ePoblacionObjeto) throws Exception;
    
    public boolean editarPoblacionObjeto(EPoblacionObjeto ePoblacionObjeto) throws Exception;
}
