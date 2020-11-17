/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.TamizajeDao;
import co.com.medplus.Medico.entities.core.ETamizaje;
import co.com.medplus.Medico.wrapper.WTamizajeWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class TamizajeController {
    
    private TamizajeDao dao;
    
    @Autowired
    public void setDao(TamizajeDao dao){
        this.dao = dao;
    }
    
    public List<WTamizajeWrapper> consultaTamizajeXIdentificacion(String identificacion) throws Exception {

        List<WTamizajeWrapper> lsw = new ArrayList<WTamizajeWrapper>();

        List<ETamizaje> ls =  dao.consultaTamizajeXIdentificacion(identificacion);

        for(ETamizaje item : ls){
                WTamizajeWrapper lw = new WTamizajeWrapper();

                lw.setIdentification(item.getIdentificacion());
                lw.setDescription(item.getDescripcion());
                lw.setLastTake(item.getUltimaToma());

                lsw.add(lw);
        }

        return lsw;
    }
}
