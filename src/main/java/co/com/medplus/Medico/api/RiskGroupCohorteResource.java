/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.RiskGroupCohorteController;
import co.com.medplus.Medico.wrapper.WRiskGroupCohorteWrapper;
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
@RequestMapping("/riskgroupcohorte")
public class RiskGroupCohorteResource {
    
        private RiskGroupCohorteController controller;
	
	@Autowired
	public void setController(RiskGroupCohorteController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{identification}/{idriskgroup}/{initialdate}/{finaldate}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaValidacionManualXGrupoRiesgo(@PathVariable String identification, @PathVariable int idriskgroup,
                @PathVariable String initialdate, @PathVariable String finaldate) throws Exception {
		
		try{
			
			List<WRiskGroupCohorteWrapper> ls = controller.consultaValidacionManualXGrupoRiesgo(identification, idriskgroup, initialdate, finaldate);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postAdicionarIdentificacionGrupoRiesgoCohorte(@RequestBody WRiskGroupCohorteWrapper wRiskGroupCohorte) throws Exception {
		
		try{
			
			boolean ls = controller.adicionarIdentificacionGrupoRiesgoCohorte(wRiskGroupCohorte);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
