/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.api;

import co.com.medplus.Medico.controller.ExamsController;
import co.com.medplus.Medico.controller.PerfilRiesgoController;
import co.com.medplus.Medico.entities.core.EPerfilRiesgo;
import co.com.medplus.Medico.entities.core.EPerfilRiesgoRPM;
import co.com.medplus.Medico.enumeration.TipoAlerta;
import co.com.medplus.Medico.wrapper.WExamsAssisted;
import co.com.medplus.Medico.wrapper.WExamsCode;
import co.com.medplus.Medico.wrapper.WExamsForTamizaje;
import co.com.medplus.Medico.wrapper.WPerfilRiesgo;
import co.com.medplus.Medico.wrapper.WPerfilRiesgoRPM;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author JeisonI
 */
@RestController
@RequestMapping("/perfil")
public class PerfilRiesgoResource {

    @Autowired
    private PerfilRiesgoController controller;

    @Autowired
    private ExamsController examsController;

    @RequestMapping(value = {"/1/"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cargarDocPart1(@Valid @RequestBody WPerfilRiesgo perfil) {
        try {
            List<EPerfilRiesgo> list = this.controller.obtenerData(perfil);

            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch (Exception ex) {

            WResponseWrapper response = new WResponseWrapper();

            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/2/"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cargarDocPart2(@Valid @RequestBody WPerfilRiesgo perfil) {
        try {
            List<EPerfilRiesgoRPM> list = this.controller.obternerDataTwo(perfil);
            List<WExamsCode> examsCode = new ArrayList<>();
            List<List<WExamsCode>> examsCodes = new ArrayList<>();

            for (EPerfilRiesgoRPM listPerfil1 : list) {
                //Listado de examenes según categoria
                examsCode = this.examsController.getAllExamsByCode(Integer.parseInt(listPerfil1.getEdad()), listPerfil1.getSexo());

                //Listado de examenes asistidos
                List<WExamsAssisted> examsAssist = this.examsController.getAllExamsAssisted(listPerfil1.getIdentificacion());

                for (WExamsAssisted assisted : examsAssist) {
                    for (int i = 0; i < examsCode.size(); i++) {
                        if (assisted.getCodigo().trim().equals(examsCode.get(i).getCodigo().trim())) {
                            examsCode.get(i).setEstado(Boolean.TRUE);
                            examsCode.get(i).setFecha(assisted.getFecha());
                        }
                    }
                }

                examsCodes.add(examsCode);
            }

            return new ResponseEntity<>(examsCodes, HttpStatus.OK);

        } catch (Exception ex) {

            WResponseWrapper response = new WResponseWrapper();

            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = {"/T/"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cargarTamizaje(@Valid @RequestBody WPerfilRiesgo perfil) {
        try {
            List<EPerfilRiesgoRPM> list = this.controller.obternerDataTwo(perfil);
            List<WExamsForTamizaje> examsTamizaje = new ArrayList<>();
            List<List<WExamsForTamizaje>> examsTamizajes = new ArrayList<>();

            for (EPerfilRiesgoRPM listPerfil1 : list) {
                examsTamizaje = this.examsController.getTamizaje(Integer.parseInt(listPerfil1.getEdad()), listPerfil1.getSexo());

                List<WExamsAssisted> examsAssist = this.examsController.getAllExamsAssisted(listPerfil1.getIdentificacion());

                for (WExamsAssisted assisted : examsAssist) {
                    for (int i = 0; i < examsTamizaje.size(); i++) {
                        if (assisted.getCodigo().trim().equals(examsTamizaje.get(i).getCodigo().trim())) {
                            examsTamizaje.get(i).setEstado(Boolean.TRUE);
                            examsTamizaje.get(i).setFecha(assisted.getFecha());
                        }
                    }
                }
                
                examsTamizajes.add(examsTamizaje);
            }
            
            return new ResponseEntity<>(examsTamizajes, HttpStatus.OK);

        } catch (Exception ex) {

            WResponseWrapper response = new WResponseWrapper();

            response.setType(TipoAlerta.ERROR.getValue());
            response.setMensaje("Error interno en servidor");

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
