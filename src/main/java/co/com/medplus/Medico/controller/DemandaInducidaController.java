/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.DemandainducidaDao;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.DatoDemandaInducida;
import co.com.medplus.Medico.wrapper.DemandainducidaResponseWrapper;
import co.com.medplus.Medico.wrapper.WDemandaInducidaExportLoad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JorgeLP
 */
@Controller
public class DemandaInducidaController {
    
    @Autowired
    private DemandainducidaDao dao;
    
    public List<DemandainducidaResponseWrapper> saveList(List<WDemandaInducidaExportLoad> demandas){
        
        List<DemandainducidaResponseWrapper> respuesta = new ArrayList<>();
        
        demandas.forEach((demanda) ->{
           DemandainducidaResponseWrapper demaLoad = new DemandainducidaResponseWrapper();
           demaLoad.cargardata(demanda);
           
           try{
               ResponseCargueSp tmpResp = this.dao.save(demanda);
               demaLoad.setEstadoServer(tmpResp.getEstado());
               demaLoad.setMensaje(tmpResp.getMensaje());
               
           }catch(Exception ex){
               demaLoad.setEstadoServer(Boolean.FALSE);
               demaLoad.setMensaje(ex.getMessage());
           }
            
           respuesta.add(demaLoad);
        });
        
        return respuesta;
        
    }
    
    public DatoDemandaInducida getDatos(String identificacion) throws SQLException{
        try {
            return this.dao.getDatosDemanda(identificacion);
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
