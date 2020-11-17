/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.GestanteDao;
import co.com.medplus.Medico.dao.impl.WGestanteActualizarWrapper;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.WGestanteWrapper;
import co.com.medplus.Medico.wrapper.WGestateCreadorWrapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JorgeLP
 */
@Controller
public class GestanteController {
    
    @Autowired
    private GestanteDao gestanteDao;
    
    
    
    public List<WGestanteWrapper> consultarGestante(String identificacion,String tipoDocumento) throws Exception{
        return this.gestanteDao.consultarGestantes(identificacion, tipoDocumento);
    }
    
    public Boolean crearGestante(WGestateCreadorWrapper creadorWrapper) throws Exception{
        return this.gestanteDao.ingresarGestante(creadorWrapper);
    }
    
    public ResponseCargueSp actualizarGestante(WGestanteActualizarWrapper wgaw)throws Exception{
        return this.gestanteDao.actualizarGestante(wgaw);
    }
}
