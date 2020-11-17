/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.RiskGroupController;
import co.com.medplus.Medico.dao.impl.ConsultaSegmento;
import co.com.medplus.Medico.wrapper.WRiskGroupWrapper;
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
@RequestMapping("/riskgroup")
public class RiskGroupResource {
    
    	private RiskGroupController controller;
	
	@Autowired
	public void setController(RiskGroupController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{identification}/{idSubCohorte}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaGrupoRiesgoXIdentificacion(@PathVariable String identification, @PathVariable int idSubCohorte) throws Exception {
		
		try{
			
			List<WRiskGroupWrapper> ls = controller.consultaGrupoRiesgoXIdentificacion(identification, idSubCohorte);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/{identification}/{grupoRiesgo}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaSegmentoCancer(@PathVariable String identification, @PathVariable int grupoRiesgo) throws Exception {
		
		try{
			List<ConsultaSegmento> ls = controller.consultaSegmento(identification, grupoRiesgo);
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			throw ex;
		}
	}
        
        
        
}
