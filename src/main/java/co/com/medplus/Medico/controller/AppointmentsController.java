/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.ConsultaMedicaDao;
import co.com.medplus.Medico.entities.core.EConsultaMedica;
import co.com.medplus.Medico.wrapper.WAppointmentsWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class AppointmentsController {
    
    private ConsultaMedicaDao dao;
    
    @Autowired
    public void setDao(ConsultaMedicaDao dao){
        this.dao = dao;
    }
    
    	public List<WAppointmentsWrapper> consultaEspecialidadXIdentificacion(String identificacion) throws Exception {
		
		List<WAppointmentsWrapper> lsw = new ArrayList<WAppointmentsWrapper>();
                
                List<EConsultaMedica> ls =  dao.consultaEspecialidadXIdentificacion(identificacion);
                
		for(EConsultaMedica item : ls){
			WAppointmentsWrapper lw = new WAppointmentsWrapper();
			
			lw.setIdentification(item.getIdentificacion());
                        lw.setSpecialty(item.getEspecialidad());
			lw.setLastConsultation(item.getUltimaConsulta());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
        
    	public List<WAppointmentsWrapper> consultaEspecialidadValidacionManualXIdentificacion(String identificacion, int idGrupoRiesgo) throws Exception {
		
		List<WAppointmentsWrapper> lsw = new ArrayList<WAppointmentsWrapper>();
                
                List<EConsultaMedica> ls =  dao.consultaEspecialidadValidacionManualXIdentificacion(identificacion, idGrupoRiesgo);
                
		for(EConsultaMedica item : ls){
			WAppointmentsWrapper lw = new WAppointmentsWrapper();
			
			lw.setIdentification(item.getIdentificacion());
                        lw.setSpecialty(item.getEspecialidad());
			lw.setLastConsultation(item.getUltimaConsulta());
                        lw.setProfessional(item.getProfesional());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
        
}
