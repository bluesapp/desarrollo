/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.TargetPoblationController;
import co.com.medplus.Medico.wrapper.WTargetPoblationWrapper;
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
@RequestMapping("/targetpoblation")
public class TargetPoblationResource {
  
    	private TargetPoblationController controller;
	
	@Autowired
	public void setController(TargetPoblationController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{idtiporiesgo}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaPoblacionObjetoXTipoRiesgo(@PathVariable int idtiporiesgo) throws Exception {
		
		try{
			
			List<WTargetPoblationWrapper> ls = controller.consultaPoblacionObjetoXTipoRiesgo(idtiporiesgo);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postAdicionarTargetPoblation(@RequestBody WTargetPoblationWrapper wTargetPoblation) throws Exception {
		
		try{
			
			boolean ls = controller.adicionarTargetPoblation(wTargetPoblation);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/"}, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putEditarTargetPoblation(@RequestBody WTargetPoblationWrapper wTargetPoblation) throws Exception {
		
		try{
			
			boolean ls = controller.editarTargetPoblation(wTargetPoblation);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
}
