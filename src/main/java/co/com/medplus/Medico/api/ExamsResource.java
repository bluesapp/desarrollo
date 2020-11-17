/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.ExamsController;
import co.com.medplus.Medico.entities.core.CupRelacion;
import co.com.medplus.Medico.entities.core.TamizajeAbreviado;
import co.com.medplus.Medico.enumeration.TipoAlerta;
import co.com.medplus.Medico.wrapper.WExamsAssisted;
import co.com.medplus.Medico.wrapper.WExamsCode;
import co.com.medplus.Medico.wrapper.WExamsForTamizaje;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
 * @author JeisonI
 */
@RestController
@RequestMapping(value = "/exams")
@Api(value = "", description = "Validacion Examenes")
public class ExamsResource {
    
    @Autowired
    private ExamsController controller;
    
    @ApiOperation(value = "Examenes Pendientes", produces = "application/json", notes = "Examenes Pendientes")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta Exitosa", response = WExamsCode.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{numDocumento}/{edad}/{sexo}/{numContrato}/list"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getValidaExamenes(@Valid @PathVariable String numDocumento,
                                                @Valid @PathVariable int edad,
                                                @Valid @PathVariable String sexo){
        
        try {
            //Listado de examenes según categoria
            List<WExamsCode> examsCode = this.controller.getAllExamsByCode(edad, sexo);
            
            //Listado de examenes asistidos
            List<WExamsAssisted> examsAssist = this.controller.getAllExamsAssisted(numDocumento);
                       
            examsAssist.stream().forEach((assisted) -> { 
                examsCode.stream().filter((examsCode1) -> (assisted.getCodigo().trim().equals(examsCode1.getCodigo().trim()))).map((examsCode1) -> {
                    examsCode1.setEstado(Boolean.TRUE);
                    return examsCode1;
                }).forEach((examsCode1) -> {
                    examsCode1.setFecha(assisted.getFecha());
                });
            });
            
            //Inicializo el objeto final
            this.controller.iniciarExamenApp();
            //Recorreo los examenes que tiene dicho usuario
            for(WExamsCode exam : examsCode) {
                //consulto con cual cup tiene relacion para mostrar en la APP
                WExamsCode cup = this.controller.getCupRelacion(exam.getCodigo());
                
                //Valido que el dato que retorna pertenezca a un 
                //Valido el estado de la consulta para saber si ya asistio a dicho evento
                if(exam.getEstado()){
                    cup.setEstado(Boolean.TRUE);
                    cup.setFecha(exam.getFecha());
                }             
                
                //Envio para agregar en la lista final
                this.controller.addCupFinalApp(cup);
            }
            
            return new ResponseEntity<>(this.controller.getExamsCodeFinal(),HttpStatus.OK);
                
        } catch (Exception e) {
            
             WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        
    }
    
    
    @ApiOperation(value = "Examenes Pendientes", produces = "application/json", notes = "Examenes Pendientes")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta Exitosa", response = WExamsCode.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{numDocumento}/{edad}/{sexo}/{numContrato}/list/integra"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getValidaExamenesIntegra(@Valid @PathVariable String numDocumento,
                                                @Valid @PathVariable int edad,
                                                @Valid @PathVariable String sexo){
        
        try {
            //Listado de examenes según categoria
            List<WExamsCode> examsCode = this.controller.getAllExamsByCode(edad, sexo);
            
            //Listado de examenes asistidos
            List<WExamsAssisted> examsAssist = this.controller.getAllExamsAssisted(numDocumento);
                       
            examsAssist.stream().forEach((assisted) -> { 
                examsCode.stream().filter((examsCode1) -> (assisted.getCodigo().trim().equals(examsCode1.getCodigo().trim()))).map((examsCode1) -> {
                    examsCode1.setEstado(Boolean.TRUE);
                    return examsCode1;
                }).forEach((examsCode1) -> {
                    examsCode1.setFecha(assisted.getFecha());
                });
            });
            
            
            
            return new ResponseEntity<>(examsCode,HttpStatus.OK);
                
        } catch (Exception e) {
            
             WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        
    }
    
    @ApiOperation(value = "Examenes pendientes por tamizaje", produces = "application/json", notes = "Examenes pendientes por tamizaje")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WExamsForTamizaje.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{edad}/{sexo}/{numDocumento}/tamizaje/integra"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getExamsTamizaje(@Valid @PathVariable int edad,
                                              @Valid @PathVariable String sexo,
                                              @Valid @PathVariable String numDocumento){
    
        try {
            List<WExamsForTamizaje> examsTamizaje = controller.getTamizaje(edad, sexo);
            
             List<WExamsAssisted> examsAssist = this.controller.getAllExamsAssisted(numDocumento);
                       
             examsAssist.stream().forEach((WExamsAssisted assisted) -> {
                 examsTamizaje.stream().filter((examsTamizaje1) -> (assisted.getCodigo().trim().equals(examsTamizaje1.getCodigo().trim()))).map((examsTamizaje1) -> {
                     examsTamizaje1.setEstado(Boolean.TRUE);
                    return examsTamizaje1;
                }).forEach((examsTamizaje1) -> {
                    examsTamizaje1.setFecha(assisted.getFecha());
                });
            });
            
            return new ResponseEntity<>(examsTamizaje,HttpStatus.OK);
            
        } catch (Exception e) {
            WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);             
        }
    }
    
    @ApiOperation(value = "Examenes pendientes por tamizaje", produces = "application/json", notes = "Examenes pendientes por tamizaje")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WExamsForTamizaje.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{edad}/{sexo}/{numDocumento}/tamizaje"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getExamsTamizajeApp(@Valid @PathVariable int edad,
                                              @Valid @PathVariable String sexo,
                                              @Valid @PathVariable String numDocumento){
    
        try {
            List<WExamsForTamizaje> examsTamizaje = controller.getTamizaje(edad, sexo);
            
             List<WExamsAssisted> examsAssist = this.controller.getAllExamsAssisted(numDocumento);
                       
             examsAssist.stream().forEach((WExamsAssisted assisted) -> {
                 examsTamizaje.stream().filter((examsTamizaje1) -> (assisted.getCodigo().trim().equals(examsTamizaje1.getCodigo().trim()))).map((examsTamizaje1) -> {
                     examsTamizaje1.setEstado(Boolean.TRUE);
                    return examsTamizaje1;
                }).forEach((examsTamizaje1) -> {
                    examsTamizaje1.setFecha(assisted.getFecha());
                });
            });
             
            //Inicializa el objeto final
             this.controller.iniciarExamenTamizajeApp();
             
             for(WExamsForTamizaje tamizaje : examsTamizaje){
               
                 //Consulto el tamizaje abreviado con el que tiene realacion
                 WExamsForTamizaje ta = this.controller.getTamizajeRelacionado(tamizaje.getCodigo());
                 
                 if(tamizaje.getEstado()){
                     ta.setEstado(tamizaje.getEstado());
                     ta.setFecha(tamizaje.getFecha());
                 }
                 
                 //Agrego el tamizaje a la lista final
                 this.controller.addTamizajeFinalApp(ta);
                 
                 
             }
             
             
            return new ResponseEntity<>(this.controller.getExamTamizajeFinal(),HttpStatus.OK);
            
        } catch (Exception e) {
            WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);             
        }
    }
}
