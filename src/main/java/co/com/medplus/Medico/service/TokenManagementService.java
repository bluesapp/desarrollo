/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarioF
 */
@Service
public class TokenManagementService {
    
    	public String getJWTString(int idLogin, String userLdap, String ip, int typeAccess, Date expires, Key key) {       
        if (userLdap == null) {
            throw new NullPointerException("null user is illegal");
        }       

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String jwtString = Jwts
                .builder()
                .claim("IdLogin", idLogin)
                .claim("_ip", ip)
                .claim("_typeAccess", typeAccess)
                .setSubject(userLdap)                
                .setExpiration(expires)
                .setIssuedAt(new Date())                
                .signWith(signatureAlgorithm, key)
                .compact();
        return jwtString;
    }

    public boolean isValid(String token, Key key) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
            return true;
            
            
        } /*catch(ExpiredJwtException e){
        	System.out.println("Token expirado");
        	return false;
        }*/
        catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public String getUser(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getSubject();
        }
        return null;
    }  
    
    public String getIp(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return claimsJws.getBody().get("_ip").toString();
        }
        return null;
    }
    
    public int getTypeAccess(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return Integer.parseInt(claimsJws.getBody().get("_typeAccess").toString());
        }
        return -1;
    }
    
    public int getIdLogin(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return Integer.parseInt(claimsJws.getBody().get("_idLogin").toString());
        }
        return 0;
    }
}
