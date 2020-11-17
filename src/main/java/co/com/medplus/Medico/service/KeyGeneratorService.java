/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.service;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Service;
/**
 *
 * @author JorgeLP
 */
@Service
public class KeyGeneratorService {
	
	public Key generateKey() {
		 
	     String keyString = "_M3t4ld54_$$%017";
	     Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
	     return key;

	}

}
