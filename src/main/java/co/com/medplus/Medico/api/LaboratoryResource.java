/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.LaboratoryController;
import co.com.medplus.Medico.enumeration.TipoAlerta;
import co.com.medplus.Medico.wrapper.DatoGenerico;
import co.com.medplus.Medico.wrapper.LaboratorioLoad;
import co.com.medplus.Medico.wrapper.LaboratorioReturn;
import co.com.medplus.Medico.wrapper.WLaboratoryConsult;
import co.com.medplus.Medico.wrapper.WLaboratoryResult;
import co.com.medplus.Medico.wrapper.WLaboratoryWrapper;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.sql.SQLException;
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
 * @author MarioF
 */
@RestController
@RequestMapping("/laboratory")
@Api(value = "", description = "Laboratorio")
public class LaboratoryResource {

    private LaboratoryController controller;

    @Autowired
    public void setController(LaboratoryController controller) {
        this.controller = controller;
    }

    @ApiOperation(value = "Consulta Laboratorio X Identificacion", produces = "application/json", notes = "Consulta Laboratorio X Identificacion", hidden = true)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WLaboratoryWrapper.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no Autorizado", response = Exception.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = Exception.class)
    })
    @RequestMapping(value = {"/{identification}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getConsultaLaboratorioXIdentificacion(@PathVariable String identification) throws Exception {

        try {

            List<WLaboratoryWrapper> ls = controller.consultaLaboratorioXIdentificacion(identification);

            return new ResponseEntity(ls, HttpStatus.OK);
        } catch (Exception ex) {

            throw ex;
        }
    }
    
    @ApiOperation(value = "Save List", produces = "application/json", notes = "Save List", hidden = true)
    @RequestMapping(value = {"/save/list/{idLaboratorio}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LaboratorioReturn>> saveList(@Valid @RequestBody List<LaboratorioLoad> laboratorios, @Valid @PathVariable String idLaboratorio) throws Exception {

        if (laboratorios.isEmpty()) {
            throw new Exception("Lista de Laboratorios vacia");
        }

        List<LaboratorioReturn> ret = this.controller.saveList(laboratorios, idLaboratorio);

        if (ret.isEmpty()) {
            throw new Exception("No existen resultados");
        }

        return new ResponseEntity<>(ret, HttpStatus.OK);

    }
    
    @ApiOperation(value = "Consulta Examenes", produces = "application/json", notes = "Consulta Examenes")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WLaboratoryConsult.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{numDocumento}/{tipoDocumento}/{tipo}/list"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(@Valid @PathVariable String numDocumento, @Valid @PathVariable String tipo,@Valid @PathVariable String tipoDocumento) throws Exception {

        try {
            WLaboratoryConsult listExam = controller.consultaExamenes(numDocumento,tipo);
            
            return new ResponseEntity<>(listExam, HttpStatus.OK);
            
        }catch  (SQLException ex){
            WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        
        } 
    }
    
     @ApiOperation(value = "Ingresar registro", produces = "application/json", notes = "Ingresar examenes")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Consulta exitosa", response = WResponseWrapper.class),
        @ApiResponse(code = 401, message = "Acceso no autorizado", response = WResponseWrapper.class),
        @ApiResponse(code = 500, message = "Error interno en servidor", response = WResponseWrapper.class)
    })
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = {"/{numDocumento}/{tipoDocumento}/{tipo}/list"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WResponseWrapper> saveLaboratorioApp(@Valid @PathVariable String numDocumento, 
                                                               @Valid @PathVariable Integer tipo,
                                                               @Valid @PathVariable String tipoDocumento,
                                                               @Valid @RequestBody DatoGenerico datoGenerico) throws Exception {

        try {
            WResponseWrapper response = new WResponseWrapper();
            
            
            Boolean estado = controller.saveExamenApp(datoGenerico, numDocumento, tipoDocumento, tipo);
            response.setConfirma(estado);
            response.setMensaje("Datos creados correctamente");
            response.setMessage("Datos creados correctamente");
            
            return new ResponseEntity<>(response, HttpStatus.OK);
            
        }catch  (SQLException ex){
            WResponseWrapper response = new WResponseWrapper();
            
            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");
            
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        
        } 
    }

}
