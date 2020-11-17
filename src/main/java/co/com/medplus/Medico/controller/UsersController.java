/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.UserDao;
import co.com.medplus.Medico.entities.core.EUser;
import co.com.medplus.Medico.wrapper.WUserWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class UsersController {

    private UserDao dao;

    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public WUserWrapper datosUsuarioLogin(String correo) throws Exception {

        List<EUser> lu = dao.dataUser(correo);

        WUserWrapper _u = new WUserWrapper();
        _u.setName("");

        for (EUser u : lu) {

            if (u != null) {

                if (u.getEstado().equals("A")) {

                    _u.setIdHistoryLogin(u.getIdUsuario());
                    _u.setName(u.getNombre());
                    _u.setContractNumber(u.getNumeroContrato());
                    _u.setDocumentId(u.getCedula());
                    _u.setUser(u.getUsuario().trim());
                    _u.setState(u.getEstado());
                    _u.setTries(u.getIntentos());
                    _u.setResidentialCity(u.getCiudadResidencia());
                    _u.setBirthDate(u.getFechaNacimiento());
                    _u.setAge(u.getEdad());
                    _u.setEmail(u.getEmail());
                    _u.setResidentialPhone(u.getTelefonoResidencia());
                    _u.setCelphone(u.getCelular());
                    _u.setSex(u.getSexo());
                    _u.setResidentialCity(u.getCiudadResidencia());
                    _u.setResidentialAddress(u.getDireccionResidencia());
                    _u.setUserType(u.getTipoUsuario());
                    _u.setDocumentType(u.getTipoDocumento());
                }
            } else {

                if (_u.getName().equals("")) {
                    _u.setIdHistoryLogin(0);
                }
            }

        }

        return _u;

    }
}
