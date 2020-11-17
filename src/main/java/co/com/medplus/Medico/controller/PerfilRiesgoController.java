/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.PerfilRiesgoDao;
import co.com.medplus.Medico.entities.core.EPerfilRiesgo;
import co.com.medplus.Medico.entities.core.EPerfilRiesgoRPM;
import co.com.medplus.Medico.wrapper.WPerfilRiesgo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JeisonI
 */
@Controller
public class PerfilRiesgoController {

    private PerfilRiesgoDao dao;

    @Autowired
    public void setDao(PerfilRiesgoDao dao) {
        this.dao = dao;
    }
   
    public List<EPerfilRiesgo> obtenerData(WPerfilRiesgo perfilR) throws Exception {

        List<EPerfilRiesgo> listPerfil = dao.getAllDataPerfil(perfilR);

        return listPerfil;
    }
    
    public List<EPerfilRiesgoRPM> obternerDataTwo(WPerfilRiesgo perfilRiesgo) throws Exception{
        
        List<EPerfilRiesgoRPM> listPerfil = dao.getAllDataPerfilTwo(perfilRiesgo);

        
        return listPerfil;
    }
}
