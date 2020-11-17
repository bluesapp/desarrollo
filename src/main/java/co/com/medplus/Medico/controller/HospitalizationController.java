/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.HospitalizacionDao;
import co.com.medplus.Medico.entities.core.EHospitalizacion;
import co.com.medplus.Medico.wrapper.WHospitalizationWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class HospitalizationController {
    
    private HospitalizacionDao dao;
    
    @Autowired
    public void setDao(HospitalizacionDao dao){
        this.dao = dao;
    }
    
    public List<WHospitalizationWrapper> consultaHospitalizacionXIdentificacion(String identificacion) throws Exception {

        List<WHospitalizationWrapper> lsw = new ArrayList<WHospitalizationWrapper>();

        List<EHospitalizacion> ls =  dao.consultaHospitalizacionXIdentificacion(identificacion);

        for(EHospitalizacion item : ls){
                WHospitalizationWrapper lw = new WHospitalizationWrapper();

                lw.setIdentification(item.getIdentificacion());
                lw.setDescription(item.getDescripcion());
                lw.setIncome(item.getIngresos());
                lw.setIncomeText(item.getIngresosTexto());

                lsw.add(lw);
        }

        return lsw;
    }
}
