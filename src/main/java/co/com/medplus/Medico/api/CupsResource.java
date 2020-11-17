package co.com.medplus.Medico.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.medplus.Medico.controller.CupsController;
import co.com.medplus.Medico.wrapper.WCupsClasificationWrapper;
import co.com.medplus.Medico.wrapper.WCupsWrapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/cups")
public class CupsResource {
	
	private CupsController controller;
	
	@Autowired
	public void setController(CupsController controller){
		this.controller = controller;
	}
        
        @RequestMapping(value = {"/{idclasification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaCups(@PathVariable int idclasification) throws Exception {
		
		try{
			
			List<WCupsWrapper> ls = controller.consultaCups(idclasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}

       
        @RequestMapping(value = {"/classification/{idclasification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getConsultaCupsXClasificacion(@PathVariable int idclasification) throws Exception {
		
		try{
			
			List<WCupsWrapper> ls = controller.consultaCupsXClasificacion(idclasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/classification/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAdicionarCupsClasificacion(@RequestBody WCupsClasificationWrapper wCupsClasification) throws Exception {
		
		try{
			
			boolean ls = controller.adicionarCupsClasificacion(wCupsClasification);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
        
        @RequestMapping(value = {"/classification/"}, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> putEliminarCupsClasificacion(@RequestBody WCupsWrapper wCups) throws Exception {
		
		try{
			
			boolean ls = controller.eliminarCupsClasificacion(wCups);
			
			return new ResponseEntity(ls, HttpStatus.OK);
		} catch (Exception ex){
			
			throw ex;
		}
	}
}
