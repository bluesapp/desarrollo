/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.GestanteController;
import co.com.medplus.Medico.dao.impl.WGestanteActualizarWrapper;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.WGestanteWrapper;
import co.com.medplus.Medico.wrapper.WGestateCreadorWrapper;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/gestante")
@Api(value = "Gestante", description = "control Gestantes")
public class GestanteResource {
    
    @Autowired
    private GestanteController controller;
    
    
    @ApiOperation(value = "Consulta gestante X Identificacion", produces = "application/json", notes = "Consulta gestante X Identificacion")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WGestanteWrapper.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{identification}/{tipoIdentificacion}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConsultaGestanteXIdentificacion(@Valid @PathVariable String identification,
                                                                                     @Valid @PathVariable String tipoIdentificacion) throws Exception {

        try {
            List<WGestanteWrapper> ls = controller.consultarGestante(identification, tipoIdentificacion);
            return new ResponseEntity(ls, HttpStatus.OK);
        } catch (Exception ex) {
            
            WResponseWrapper wResponseWrapper = new WResponseWrapper();
            
            wResponseWrapper.setConfirma(false);
            wResponseWrapper.setMensaje("Error "+ex);
            wResponseWrapper.setMensaje("Error "+ex);
            
            return new ResponseEntity<>(wResponseWrapper,HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @ApiOperation(value = "Ingresar gestante", produces = "application/json", notes = "Agregar Gestante")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ingreso exitoso", response = WResponseWrapper.class),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardarGestante(@Valid @RequestBody WGestateCreadorWrapper gestante) throws Exception {

        try {
            
            WResponseWrapper wResponseWrapper = new WResponseWrapper();
            
            
            wResponseWrapper.setMensaje("Gestante creado ");
            wResponseWrapper.setMensaje("Gestante creado ");
            
            Boolean flag = this.controller.crearGestante(gestante);
            wResponseWrapper.setConfirma(flag);
            
            
            return new ResponseEntity(wResponseWrapper, HttpStatus.OK);
        } catch (Exception ex) {
            
            WResponseWrapper wResponseWrapper = new WResponseWrapper();
            
            wResponseWrapper.setConfirma(false);
            wResponseWrapper.setMensaje("Error "+ex);
            wResponseWrapper.setMensaje("Error "+ex);
            
            return new ResponseEntity<>(wResponseWrapper,HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @ApiOperation(value = "Actualizar Gestante", produces = "application/json", notes = "Actualizar Gestante")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Actualización exitosa", response = WResponseWrapper.class),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarGestante(@Valid @RequestBody WGestanteActualizarWrapper wgaw) throws Exception {

        try {
            
            WResponseWrapper wResponseWrapper = new WResponseWrapper();
            
            
            ResponseCargueSp response = this.controller.actualizarGestante(wgaw);
            
            if(!response.getEstado()){
              //No genero error
              wResponseWrapper.setMensaje(response.getMensaje());
              wResponseWrapper.setMensaje(response.getMensaje());
              wResponseWrapper.setConfirma(true);
              return new ResponseEntity(wResponseWrapper, HttpStatus.OK);
            }else{
              //Genero error
                wResponseWrapper.setMensaje(response.getMensaje());
                wResponseWrapper.setMensaje(response.getMensaje());
                wResponseWrapper.setConfirma(false);
                return new ResponseEntity(wResponseWrapper, HttpStatus.BAD_REQUEST);
            }
            
        } catch (Exception ex) {
            
            WResponseWrapper wResponseWrapper = new WResponseWrapper();
            
            wResponseWrapper.setConfirma(false);
            wResponseWrapper.setMensaje("Error "+ex);
            wResponseWrapper.setMensaje("Error "+ex);
            
            return new ResponseEntity<>(wResponseWrapper,HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
}
