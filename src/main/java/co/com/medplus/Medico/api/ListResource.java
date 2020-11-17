/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.ListController;
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
@RequestMapping("/list")
public class ListResource {
    
        private ListController listController;
        
        @Autowired
        public void setController(ListController controller){
            this.listController = controller;
        }
        
  
        @RequestMapping(value = {"/{nombretabla}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaTablaLista(@PathVariable String nombretabla) throws Exception {
		
		try{
			
			List<WListasWrapper> ls = listController.consultaTablaLista(nombretabla);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
         @RequestMapping(value = {"/{idTipoContrato}/alianzaMatriz"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaTablaLista(@PathVariable Integer idTipoContrato) throws Exception {
		
		try{
			
			List<WListasWrapper> ls = listController.consultaTablaListaAlizaMatriz(idTipoContrato);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        
}
