/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.VouchersDao;
import co.com.medplus.Medico.entities.core.EAutorizacion;
import co.com.medplus.Medico.wrapper.WVoucherWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class VouchersController {
    
    private VouchersDao dao;
    
    @Autowired
    public void setDao(VouchersDao dao){
        this.dao = dao;
    }
    
        public List<WVoucherWrapper> consultaAutorizacionValidacionManualXIdentificacion(String identificacion, int idGrupoRiesgo) throws Exception {

            List<WVoucherWrapper> lsw = new ArrayList<WVoucherWrapper>();

            List<EAutorizacion> ls =  dao.consultaAutorizacionValidacionManualXIdentificacion(identificacion, idGrupoRiesgo);

            for(EAutorizacion item : ls){
                    WVoucherWrapper lw = new WVoucherWrapper();

                    lw.setIdentification(item.getIdentificacion());
                    lw.setSpecialty(item.getEspecialidad());
                    lw.setLastConsultation(item.getUltimaConsulta());
                    lw.setProfessional(item.getProfesional());

                    lsw.add(lw);
            }

            return lsw;
	}
}
