/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.service;

import co.com.medplus.Medico.entities.core.EAuthenticateLdap;
import co.com.medplus.Medico.exception.NotAuthorizeException;
import co.com.medplus.Medico.wrapper.WAuthenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author MarioF
 */
@Service
public class AuthenticateLdapService {
    
    	//@Value("${path.authenticate_ldap}")
	//private String path = "http://web.medplus.net.co:8284";
        private String path = "http://172.21.3.32:8284";

	@Autowired
	private RestTemplate restTemplate;

	public EAuthenticateLdap authenticate(WAuthenticate _obj) throws Exception {
		try {
			EAuthenticateLdap obj = restTemplate.postForObject(path + "/auth", _obj, EAuthenticateLdap.class);
			return obj;
		} catch (HttpClientErrorException e) {
			if(e.getStatusCode()==HttpStatus.UNAUTHORIZED) {
				throw new NotAuthorizeException(4, "Usuario o contraseña incorrecta");
			}else {
				throw new Exception("Ha ocurrido un error en autenticar al usuario");
			}
		}
	}

}
