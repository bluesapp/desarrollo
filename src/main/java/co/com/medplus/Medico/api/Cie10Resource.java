/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.Cie10Controller;
import co.com.medplus.Medico.wrapper.WCie10ClasificationWrapper;
import co.com.medplus.Medico.wrapper.WCie10Wrapper;
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
@RequestMapping("/cie10")
public class Cie10Resource {
    	
	private Cie10Controller controller;
	
	@Autowired
	public void setController(Cie10Controller controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{idclasification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaCie10(@PathVariable int idclasification) throws Exception {
		
		try{
			
			List<WCie10Wrapper> ls = controller.consultaCie10(idclasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}

       
        @RequestMapping(value = {"/classification/{idclasification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaCie10XClasificacion(@PathVariable int idclasification) throws Exception {
		
		try{
			
			List<WCie10Wrapper> ls = controller.consultaCie10XClasificacion(idclasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/classification/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAdicionarCie10Clasificacion(@RequestBody WCie10ClasificationWrapper wCie10Clasification) throws Exception {
		
		try{
			
			boolean ls = controller.adicionarCie10Clasificacion(wCie10Clasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/classification/"}, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putEliminarCie10Clasificacion(@RequestBody WCie10Wrapper wCie10) throws Exception {
		
		try{
			
			boolean ls = controller.eliminarCie10Clasificacion(wCie10);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
