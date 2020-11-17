/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.AuthenticateDao;
import co.com.medplus.Medico.entities.core.EAuthenticateLdap;
import co.com.medplus.Medico.entities.core.EParametrosPassword;
import co.com.medplus.Medico.exception.NotAuthorizeException;
import co.com.medplus.Medico.wrapper.WAuthenticate;
import co.com.medplus.Medico.wrapper.WUserLdap;
import java.util.List;

import co.com.medplus.Medico.service.AuthenticateLdapService;
import org.springframework.stereotype.Controller;
import co.com.medplus.Medico.enumeration.Rol;
import co.com.medplus.Medico.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MarioF
 */
@Controller
public class AuthenticateController {

    @Autowired
    private AuthenticateLdapService authLdapService;

    private AuthenticateDao dao;

    @Autowired
    public void setDao(AuthenticateDao dao) {
        this.dao = dao;
    }

    private AuthenticationService authService;

    @Autowired
    public void setAuthenticationService(AuthenticationService authService) {
        this.authService = authService;
    }

    public WUserLdap authenticateLdap(WAuthenticate authenticate) throws Exception {

        EAuthenticateLdap auth = authLdapService.authenticate(authenticate);
        boolean isRol = false;

        List<String> roles = auth.getRoles();
        
        for (String r : roles) {
            if (r.equals(Rol.MANAGEMENT.getValue())) {
                isRol = true;
                break;
            }
        }
        
        String rolesConcat = "";
        for(int i = 0; i < roles.size(); i++){
                
             rolesConcat = rolesConcat + roles.get(i)+(i == (roles.size()-1) ? "" : ";");
        }
        
        if (!isRol) {
            throw new NotAuthorizeException(4, "El usuario no está autorizado para usar esta aplicación");
        }

        return new WUserLdap(
                auth.getUsername(),
                auth.getDisplayName(),
                auth.getEmail(),
                auth.getPhone(),
                null,
                rolesConcat
        );

    }

    public boolean passwordValidate(String correo, String password) throws Exception {

        EParametrosPassword p = dao.passwordValidate(correo);

        if (p == null) {
            throw new NotAuthorizeException(4, "usuario no existe");
        }

        // concatena lod datos recibidos
        String passwordAndSalt = password + p.getSalt();
        Boolean autenticated;

        //genera el hash
        String hashedPasswordAndSalt = authService.CreatePasswordHash(passwordAndSalt);
        hashedPasswordAndSalt = hashedPasswordAndSalt.toUpperCase();

        //Verifica
        autenticated = hashedPasswordAndSalt.equals(p.getDbPasswordHash());

        return autenticated;

    }
    
    public void estadoSession(String user, int tipoSolicitud) throws Exception{
		
		dao.estadoSession(user, tipoSolicitud);
    }
}
