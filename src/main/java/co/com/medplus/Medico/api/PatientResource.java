/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.PatientController;
import co.com.medplus.Medico.wrapper.WConsultCohorteWrapper;
import co.com.medplus.Medico.wrapper.WInducedDemandWrapper;
import co.com.medplus.Medico.wrapper.WPatientWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarioF
 */
@RestController
@RequestMapping("/patient")
public class PatientResource {
    
        private PatientController controller;
	
	@Autowired
	public void setController(PatientController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{identificacion}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaPacienteXIdentificacion(@PathVariable String identificacion) throws Exception {
		
		try{
			
			WPatientWrapper ls = controller.consultaPacienteXIdentificacion(identificacion);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}

        @RequestMapping(value = {"/induceddemand"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaDemandaInducida(@RequestBody WConsultCohorteWrapper consultCohorte) throws Exception {
		
		try{
			
			List<WInducedDemandWrapper> ls = controller.consultaDemandaInducida(consultCohorte);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
