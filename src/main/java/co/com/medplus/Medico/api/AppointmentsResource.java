/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.AppointmentsController;
import co.com.medplus.Medico.wrapper.WAppointmentsWrapper;
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
@RequestMapping("/appointments")
public class AppointmentsResource {
    
    @Autowired
    private AppointmentsController controller;
    
    
    @RequestMapping(value = {"/{identification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConsultaEspecialidadXIdentificacion(@PathVariable String identification) throws Exception {

            try{

                    List<WAppointmentsWrapper> ls = controller.consultaEspecialidadXIdentificacion(identification);

                    return new ResponseEntity(ls, HttpStatus.OK);
            } catch (Exception ex){

                    throw ex;
            }
    }
    
    @RequestMapping(value = {"/manualvalidation/{identification}/{idgruporiesgo}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConsultaEspecialidadValidacionManualXIdentificacion(@PathVariable String identification, @PathVariable int idgruporiesgo) throws Exception {

            try{

                    List<WAppointmentsWrapper> ls = controller.consultaEspecialidadValidacionManualXIdentificacion(identification, idgruporiesgo);

                    return new ResponseEntity(ls, HttpStatus.OK);
            } catch (Exception ex){

                    throw ex;
            }
    }
}
