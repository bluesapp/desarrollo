/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.wrapper.WUsuarioVacunacion;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacionAct;
import java.util.List;

/**
 *
 * @author JeisonI
 */
public interface VacunacionDao {
    
    public Boolean creaUserVacuna(WUsuarioVacunacion wUserVac)throws Exception;
    
    public List<WUsuarioVacunacion> getUsers(String tipoDoc, String Docu)throws Exception;
    
    public Boolean actualizaUserVacunacion(WUsuarioVacunacionAct WuserAct)throws Exception;
    
}
