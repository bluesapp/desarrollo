/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.CronicoDao;
import co.com.medplus.Medico.entities.core.ECronicosLoad;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.CronicoReturn;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jorgelp
 */
@Controller
public class CronicoController {
    
    @Autowired
    private CronicoDao cronicoDao;
    
    private List<CronicoReturn> responses;
    
    
    
    public List<CronicoReturn> saveList(List<ECronicosLoad> cronicos) throws Exception{
        
        this.responses = new ArrayList<>();
        
        cronicos.forEach((cronico) -> {
           
            //Envia cada cronico por independiente al procedimiento almacenado para ser guardado.          
            CronicoReturn response = new CronicoReturn();
            response.llenarCronicoReturn(cronico);
            try{
            //Envio a procedimiento almacenado
            ResponseCargueSp responsecargue = this.cronicoDao.saveCronico(cronico);
            response.setMensaje(responsecargue.getMensaje());
            response.setEstado(responsecargue.getEstado());
            
            this.addResponse(response);
           }catch(Exception ex){
            response.setMensaje(ex.getMessage());
            response.setEstado(Boolean.FALSE);
            this.addResponse(response);
            
           }
        });
        
       return responses;
    }
    
    public void addResponse(CronicoReturn response){
        this.responses.add(response);
    }

    public List<CronicoReturn> getResponses() {
        return responses;
    }

    public void setResponses(List<CronicoReturn> responses) {
        this.responses = responses;
    }
    
    
}
