/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.VacunacionDao;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacion;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacionAct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JeisonI
 */
@Controller
public class VacunacionController {

    @Autowired
    VacunacionDao dao;

    public WResponseWrapper saveUserVacunacion(WUsuarioVacunacion Wuser) throws Exception {

        WResponseWrapper response = new WResponseWrapper();

        Boolean estado = dao.creaUserVacuna(Wuser);

        if (estado) {
            response.setMensaje("Usuario creado correctamente");
            response.setMessage("Usuario creado correctamente");
            response.setConfirma(estado);
        } else {
            response.setMensaje("Usuario no creado");
            response.setMessage("Usuario no creado");
            response.setConfirma(estado);
        }

        return response;
    }

    public List<WUsuarioVacunacion> getUsersVacunacion(String tipoDoc, String Docu) throws Exception {

        return this.dao.getUsers(tipoDoc, Docu);

    }
    
    public WResponseWrapper actualizaUserVacunacion(WUsuarioVacunacionAct userAct)throws Exception{
        
        WResponseWrapper response = new WResponseWrapper();
        
        Boolean indica = dao.actualizaUserVacunacion(userAct);
        
         if (indica) {
            response.setMensaje("Datos Actualizados correctamente");
            response.setMessage("Datos Actualizados correctamente");
            response.setConfirma(indica);
        } else {
            response.setMensaje("No se logro actualizar");
            response.setMessage("No se logro actualizar");
            response.setConfirma(indica);
        }
         
         return response;
    }
}
