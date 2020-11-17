/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EParametrosPassword;

/**
 *
 * @author JeisonI
 */
public interface AuthenticateDao {
    
    public EParametrosPassword passwordValidate(String correo) throws Exception;
    public void estadoSession(String user, int tipoSolicitud) throws Exception;
}
