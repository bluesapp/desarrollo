/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.DemandaInducidaController;
import co.com.medplus.Medico.wrapper.DatoDemandaInducida;
import co.com.medplus.Medico.wrapper.DemandainducidaResponseWrapper;
import co.com.medplus.Medico.wrapper.WDemandaInducidaExportLoad;
import java.util.List;
import javax.validation.Valid;
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
 * @author JorgeLP
 */
@RestController
@RequestMapping("/demandaInducida")
public class DemandaInducidaResource {
    
    @Autowired
    private DemandaInducidaController demandaInducidaController;
    
    @RequestMapping(value = {"/list/save"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DemandainducidaResponseWrapper>> savelist (@Valid @RequestBody List<WDemandaInducidaExportLoad> demandas) throws Exception{
        
        
        if(demandas.isEmpty()){
            throw new Exception("Lista del post vacia");
        }
        
        List<DemandainducidaResponseWrapper> demandaReturn = this.demandaInducidaController.saveList(demandas);
        
        if(demandaReturn.isEmpty()){
            throw new Exception("no se obtuvo respuesta de la consulta");
        }
        
        return new ResponseEntity<>(demandaReturn,HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/datoDemanda/{identificacion}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DatoDemandaInducida> getDato (@Valid @PathVariable String identificacion) throws Exception{
        
       DatoDemandaInducida dato = this.demandaInducidaController.getDatos(identificacion);
       
       return new ResponseEntity<>(dato,HttpStatus.OK);
        
    }
    
}
