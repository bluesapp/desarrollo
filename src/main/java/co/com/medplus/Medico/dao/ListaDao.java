/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EListas;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface ListaDao {
    
    public List<EListas> consultaTablaLista(String nombreTabla) throws Exception;
    
    public List<EListas> obtenerAlianzaOMatriz(Integer idTipoContrato) throws Exception;
    
}
