/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.VacunacionController;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacion;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacionAct;
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
 * @author JeisonI
 */
@RestController
@RequestMapping("/vacunacion")
@Api(value = "Vacunación", description = "control vacunación")
public class VacunacionResource {

    @Autowired
    VacunacionController controller;

    @ApiOperation(value = "Vacunacion", produces = "application/json", notes = "Registro control vacunacion")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta Exitosa", response = WResponseWrapper.class)
        ,
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class)
        ,
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postControlVacunas(@Valid @RequestBody WUsuarioVacunacion wUserVac) throws Exception {
        try {

            WResponseWrapper response = controller.saveUserVacunacion(wUserVac);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {

            WResponseWrapper wResponseWrapper = new WResponseWrapper();

            wResponseWrapper.setMensaje("Error " + e);
            wResponseWrapper.setMessage("Error " + e);
            wResponseWrapper.setConfirma(false);

            return new ResponseEntity<>(wResponseWrapper, HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(value = "userVacunacion", produces = "application/json", notes = "Obtener usuario vacunacion")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta Exitosa", response = WUsuarioVacunacion.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{tipoDocResponsable}/{docResponsable}/list"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserVacunacion(@Valid @PathVariable String tipoDocResponsable,
                                               @Valid @PathVariable String docResponsable) {
        try {

            List<WUsuarioVacunacion> list = controller.getUsersVacunacion(tipoDocResponsable, docResponsable);
            WResponseWrapper response = new WResponseWrapper();

            if (list.isEmpty()) {
                response.setConfirma(false);
                response.setMensaje("No se encontraron usuarios para esta solicitud");
                response.setMessage("No se encontraron usuarios para esta solicitud");

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
            
        } catch (Exception e) {
            WResponseWrapper wResponseWrapper = new WResponseWrapper();

            wResponseWrapper.setMensaje("Error " + e);
            wResponseWrapper.setMessage("Error " + e);
            wResponseWrapper.setConfirma(false);

            return new ResponseEntity<>(wResponseWrapper, HttpStatus.BAD_REQUEST);
        }
    }
    
    @ApiOperation(value = "Actualizacion", produces = "application/json", notes = "Actualiza datos usuario vacunacion")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WResponseWrapper.class),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
     @ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/act"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizaInfoVacunacion(@Valid @RequestBody WUsuarioVacunacionAct userAct){
            
        try {
            
            WResponseWrapper response = controller.actualizaUserVacunacion(userAct);
            
            return new ResponseEntity<>(response,HttpStatus.OK);
            
       } catch (Exception e) {
           
           WResponseWrapper wResponseWrapper = new WResponseWrapper();

            wResponseWrapper.setMensaje("Error " + e);
            wResponseWrapper.setMessage("Error " + e);
            wResponseWrapper.setConfirma(false);

            return new ResponseEntity<>(wResponseWrapper, HttpStatus.BAD_REQUEST);
            
       }
    }

}
