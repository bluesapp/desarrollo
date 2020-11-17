/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.CronicoController;
import co.com.medplus.Medico.entities.core.ECronicosLoad;
import co.com.medplus.Medico.wrapper.CronicoReturn;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jorgelp
 */
@RestController
@RequestMapping("/cronico")
public class CronicosResource {
    
    @Autowired
    private CronicoController cronicoController;
    
    @RequestMapping(value = {"/save/list"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CronicoReturn>> save(@Valid @RequestBody List<ECronicosLoad> cronicos) throws Exception{
        
        if(cronicos.isEmpty()){
          throw new Exception("Lista Vacia");
        }
        
        List<CronicoReturn> responses = this.cronicoController.saveList(cronicos);
        
        if(responses.isEmpty()){
            throw new Exception("No se obtuvieron respuestas");
        }
        
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ECronicosLoad> getCronico (){
        
        ECronicosLoad e = new ECronicosLoad("25","1", "1012417317", "Jorge Linares", "Cereza elceso", "3193226287", "Dg 74 sur # 78 i 39 bosa");
        return new ResponseEntity<>(e,HttpStatus.OK);
    }
    
}
