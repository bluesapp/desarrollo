package co.com.medplus.Medico.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	public String getJWTString(int IdUser, String DocumentId, String Email, String MatrizNumber, int ContractNumber, String user, Date expires, Key key) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        if (DocumentId == null) {
            throw new NullPointerException("null document is illegal");
        }
        /*if (MatrizNumber == null) {
            throw new NullPointerException("null matriz are illegal");
        }*/
        if (expires == null) {
            throw new NullPointerException("null expires is illegal");
        }
        if (key == null) {
            throw new NullPointerException("null key is illegal");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        String jwtString = Jwts
                .builder()
                .claim("IdLogin", IdUser)
                .claim("Document", DocumentId)
                .claim("Email", Email)
                .claim("ContractNumber", ContractNumber)
                .claim("MatrizNumber", MatrizNumber)               
                .setSubject(user)
                .setAudience(MatrizNumber)
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

    public String getName(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getSubject();
        }
        return null;
    }

    public String getGrupo(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getAudience();
        }
        return null;
    }

    public int getIdLogin(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return Integer.parseInt(claimsJws.getBody().get("IdLogin").toString());
        }
        return 0;
    }
    
    public String getDocument(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return claimsJws.getBody().get("Document").toString();
        }
        return null;
    }
    
    public String getEmail(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return claimsJws.getBody().get("Email").toString();
        }
        return null;
    }
    
    public String getContractNumber(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return claimsJws.getBody().get("ContractNumber").toString();
        }
        return null;
    }
    
    public String getMatrizNumber(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);          
            return claimsJws.getBody().get("MatrizNumber").toString();
        }
        return null;
    }


}
