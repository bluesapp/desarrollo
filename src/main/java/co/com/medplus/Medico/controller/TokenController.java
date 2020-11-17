/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.enumeration.TypeAccessApi;
import co.com.medplus.Medico.service.KeyGeneratorService;
import co.com.medplus.Medico.service.TokenManagementService;
import co.com.medplus.Medico.service.TokenService;
import co.com.medplus.Medico.wrapper.WUserWrapper;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class TokenController {

    //@Value("${jwt.expire_management}")
    private final String _expire = "14400";

    @Autowired
    private KeyGeneratorService key;

    @Autowired
    private TokenManagementService tokenManagementService;
    
    @Autowired
    private TokenService tokenService;
	
   public String getToken(WUserWrapper u){
		
		Date expiry = getExpiryDate(Integer.parseInt(_expire));
		Key _key = key.generateKey();	
			
		return tokenService.getJWTString(u.getIdHistoryLogin(), u.getDocumentId(), u.getEmail(), u.getMatrizNumber(), u.getContractNumber(),u.getUser(), 
					expiry, _key);		
		
	}
   
   public String getTokenManagement(int idLogin, String userLdap, String ip) {
		
		Date expiry = getExpiryDate(Integer.parseInt(_expire));
		Key _key = key.generateKey();	
			
		return tokenManagementService.getJWTString(idLogin, userLdap, ip, TypeAccessApi.ACCESO_NORMAL.getValue(), expiry, _key);
	}


    private Date getExpiryDate(int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, segundos);
        return calendar.getTime();
    }

}
