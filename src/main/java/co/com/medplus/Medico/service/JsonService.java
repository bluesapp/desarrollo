/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.StringWriter;
import org.springframework.stereotype.Service;

/**
 *
 * @author MarioF
 */
@Service
public class JsonService {
    
    public String toJson(Object obj) throws Exception {

		try {
			// create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			// configure Object mapper for pretty print
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

			// writing to console, can write to any output stream such as file
			StringWriter stringEmp = new StringWriter();
			objectMapper.writeValue(stringEmp, obj);			
			//System.out.println("login JSON is\n" + stringEmp);			
			return "" + stringEmp;
			

		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}

	}
}
