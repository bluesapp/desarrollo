package co.com.medplus.Medico.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String CreateSalt() throws NoSuchAlgorithmException {
     	SecureRandom random = new SecureRandom();
     	byte[] salt = new byte[10];
     	random.nextBytes(salt);
     	return Base64.getEncoder().withoutPadding().encodeToString(salt);
    }
    
    public String CreatePasswordHash(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    
}
