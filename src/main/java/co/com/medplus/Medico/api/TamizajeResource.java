/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.TamizajeController;
import co.com.medplus.Medico.wrapper.WTamizajeWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarioF
 */
@RestController
@RequestMapping("/tamizaje")
public class TamizajeResource {
    
    	private TamizajeController controller;
	
	@Autowired
	public void setController(TamizajeController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{identification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaTamizajeXIdentificacion(@PathVariable String identification) throws Exception {
		
		try{
			
			List<WTamizajeWrapper> ls = controller.consultaTamizajeXIdentificacion(identification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
