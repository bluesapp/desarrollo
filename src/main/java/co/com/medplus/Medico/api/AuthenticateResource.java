/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.LoggController;
import co.com.medplus.Medico.controller.AuthenticateController;
import co.com.medplus.Medico.controller.TokenController;
import co.com.medplus.Medico.controller.UsersController;
import co.com.medplus.Medico.entities.core.ELogin;
import co.com.medplus.Medico.enumeration.TipoAlerta;

import co.com.medplus.Medico.enumeration.TypeAccessApi;
import co.com.medplus.Medico.exception.MedicoException;
import co.com.medplus.Medico.wrapper.WAuthenticate;
import co.com.medplus.Medico.exception.NotAuthorizeException;
import co.com.medplus.Medico.exception.NotResultException;
import java.net.InetAddress;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.medplus.Medico.service.JsonService;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import co.com.medplus.Medico.wrapper.WUserLdap;
import co.com.medplus.Medico.wrapper.WUserWrapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MarioF
 */
@RestController
@RequestMapping("/auth")
public class AuthenticateResource {

    private UsersController controller;
    private AuthenticateController controllerLogin;
    private TokenController tokenController;
    private LoggController loggController;
    private JsonService jsonService;

    //Value("${virtual_office.login_crm_md}")
    private final String urlVirtualOfficeLoginCrmMd = "http://localhost:4200/auth/mp_access";
    //private String urlVirtualOfficeLoginCrmMd = "http://localhost:4200/";

    @Autowired
    public void setController(UsersController controller) {
        this.controller = controller;
    }

    @Autowired
    public void setControllerLogin(AuthenticateController controllerLogin) {
        this.controllerLogin = controllerLogin;
    }

    @Autowired
    public void setTokenController(TokenController tokenController) {
        this.tokenController = tokenController;
    }

    @Autowired
    public void setLoggController(LoggController loggController) {
        this.loggController = loggController;
    }

    @Autowired
    public void setJsonService(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @Autowired
    private Environment environment;

    @ApiOperation(value = "Login CRM", produces = "application/json", notes = "Login CRM")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Login Exitoso", response = WUserWrapper.class)
        ,
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class)
        ,
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postDatosUsuario(@RequestBody ELogin login, @RequestParam(value = "type", required = true) String typeAccess, HttpServletRequest request) throws Exception {

        try {
            boolean autenticated = false;
            boolean _validateCredentials = true;
            boolean _accesoNormal = false;
            boolean _accesoApp = false;
            String _user = null;

            String ip = request.getRemoteAddr();
            if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
                InetAddress inetAddress = InetAddress.getLocalHost();
                String ipAddress = inetAddress.getHostAddress();
                ip = ipAddress;
            }

            if (typeAccess != null) {
                try {

                    int _type = Integer.parseInt(typeAccess);

                    if (_type == TypeAccessApi.ACCESO_APP.getValue()) {
                        _user = login.getUser().trim();
                        _accesoApp = true;
                    } else if (_type == TypeAccessApi.ACCESO_NORMAL.getValue()) {
                        _user = login.getUser().trim();
                        _accesoNormal = true;
                    } else {
                        throw new NotAuthorizeException(4, "Lo sentimos, la petición esta mal generada.");
                    }

                } catch (NumberFormatException e) {
                    throw new NotAuthorizeException(4, "Lo sentimos, la petición esta mal generada.");
                }

            } else {
                throw new NotAuthorizeException(4, "Petición rechazada.");
            }

            if (_accesoApp) {
                WUserWrapper u = controller.datosUsuarioLogin(_user);

                if (u.getIdHistoryLogin() == 0) {
                    throw new NotResultException("Usuario no registrado, o sin contratos activos.");
                }

                if (!(u.getIdHistoryLogin() != 0 && u.getState().equals("A"))) {
                    throw new NotAuthorizeException(4, "Usuario no activo.");
                }

                if (!(u.getTries() < 5)) {
                    throw new NotAuthorizeException(4, "Usuario bloqueado por intentos de ingreso.");
                }

                if (_validateCredentials) {

                    if (environment.getActiveProfiles()[0].equals("dev")) {

                        autenticated = true;
                    } else {

                        autenticated = controllerLogin.passwordValidate(login.getUser().trim(), login.getPass().trim());
                    }
                }

                u.setAutenticated(autenticated);

                if (autenticated) {
                    controllerLogin.estadoSession(login.getUser(), 2);
                } else {
                    controllerLogin.estadoSession(login.getUser(), 1);
                    throw new NotAuthorizeException(4, "Usuario o contraseña incorrecta.");
                }

                int _idHistoryLogin = loggController.setLoginHistory(_user, ip, TypeAccessApi.ACCESO_APP.getValue());
                u.setIdHistoryLogin(_idHistoryLogin);

                String jwtString = tokenController.getToken(u);

                u.setToken(jwtString);

                return new ResponseEntity<>(u, HttpStatus.OK);
            } else if (_accesoNormal) {

                WAuthenticate wLogin = new WAuthenticate();

                wLogin.setUsername(login.getUser());
                wLogin.setPassword(login.getPass());

                WUserLdap user = controllerLogin.authenticateLdap(wLogin);

                int _idHistoryLogin = loggController.setLoginHistory(wLogin.getUsername(), ip, TypeAccessApi.ACCESO_NORMAL.getValue());

                user.setToken(tokenController.getTokenManagement(_idHistoryLogin, user.getUsername(), ip));

                return new ResponseEntity<>(user, HttpStatus.OK);
            }

        } catch (NotResultException e) {

            WResponseWrapper response = new WResponseWrapper();

            response.setType(TipoAlerta.WARNING.getValue());
            response.setMessage(e.getMessage());
            response.setMensaje(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (NotAuthorizeException e) {

            WResponseWrapper response = new WResponseWrapper();
            response.setType(TipoAlerta.WARNING.getValue());
            response.setMessage(e.getMessage());
            response.setMensaje(e.getMessage());

            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

        } catch (Exception e) {

            login.setPass("***");

            String _json = jsonService.toJson(login);

            WResponseWrapper response = new WResponseWrapper();

            response.setType(TipoAlerta.ERROR.getValue());
            response.setMessage("Error interno en servidor");
            response.setMensaje("Error interno en servidor");

            throw new MedicoException(response, HttpStatus.INTERNAL_SERVER_ERROR, _json, e);

        }
        return null;

    }
}
