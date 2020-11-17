/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.CohorteStateController;
import co.com.medplus.Medico.wrapper.WListasWrapper;
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
@RequestMapping("/cohortestate")
public class CohorteStateResource {
    
        private CohorteStateController listController;
        
        @Autowired
        public void setController(CohorteStateController controller){
            this.listController = controller;
        }
        
  
        @RequestMapping(value = {"/riskgroup/{idgruporiesgo}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaEstadoCohorteXIdGrupoRiesgo(@PathVariable int idgruporiesgo) throws Exception {
		
		try{
			
			List<WListasWrapper> ls = listController.consultaEstadoCohorteXIdGrupoRiesgo(idgruporiesgo);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
