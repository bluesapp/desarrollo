/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.RiskScaleController;
import co.com.medplus.Medico.wrapper.WRiskScaleWrapper;
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
@RequestMapping("/riskscale")
public class RiskScaleResource {
    
    private RiskScaleController controller;
    
    @Autowired
    public void setCotroller(RiskScaleController controller){
        this.controller = controller;
    }
    
    @RequestMapping(value= {"/{identification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConsultaEscalaRiesgoXIdentificacion(@PathVariable String identification) throws Exception {
        
        try {
            
            List<WRiskScaleWrapper> ls = controller.consultaEscalaRiesgoXIdentificacion(identification);
            
            return new ResponseEntity(ls, HttpStatus.OK);
        } catch (Exception ex){
            
            throw ex;
        }
    }
}
