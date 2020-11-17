/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.GrupoRiesgoCohorteDao;
import co.com.medplus.Medico.entities.core.EGrupoRiesgoCohorte;
import co.com.medplus.Medico.wrapper.WRiskGroupCohorteWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class RiskGroupCohorteController {
  
        private GrupoRiesgoCohorteDao dao;

	@Autowired
	public void setDao(GrupoRiesgoCohorteDao dao) {
		this.dao = dao;
	}
        
        public List<WRiskGroupCohorteWrapper> consultaValidacionManualXGrupoRiesgo(String identification, int idriskgroup, String initialdate, String finaldate) throws Exception {
            
            List<WRiskGroupCohorteWrapper> lsw = new ArrayList<WRiskGroupCohorteWrapper>();
                
            List<EGrupoRiesgoCohorte> ls =  dao.consultaValidacionManualXGrupoRiesgo(identification, idriskgroup, initialdate, finaldate);
                
		for(EGrupoRiesgoCohorte item : ls){
			WRiskGroupCohorteWrapper lw = new WRiskGroupCohorteWrapper();
			
                        lw.setIdRiskCohorte(item.getIdriesgocohorte());
			lw.setIdRiskGroup(item.getIdGrupoRiesgo());
                        lw.setIdentification(item.getIdentificacion());
			lw.setName(item.getNombre());
                        lw.setRiskGroup(item.getGrupoRiesgo());
                        lw.setDiagnostic(item.getDiagnostico());
                        lw.setPossible(item.getPosible());
                        lw.setConfirmed(item.getConfirmado());
                        lw.setIdmentalrisk(item.getIdriesgomental());
                        lw.setSegment(item.getSegmento());
                        lw.setDemandingOxygen(item.getOxigenoRequirente());
                        lw.setDomiciliaryChronic(item.getCronicoDomiciliario());
			
			lsw.add(lw);
		}
		
		return lsw;
        }
        
        public boolean adicionarIdentificacionGrupoRiesgoCohorte(WRiskGroupCohorteWrapper wRiskGroupCohorte) throws Exception {
            
            EGrupoRiesgoCohorte eGrupoRiesgoCohorte = new EGrupoRiesgoCohorte();
            
            eGrupoRiesgoCohorte.setIdentificacion(wRiskGroupCohorte.getIdentification());
            eGrupoRiesgoCohorte.setIdGrupoRiesgo(wRiskGroupCohorte.getIdRiskGroup());
            eGrupoRiesgoCohorte.setIdEstadoCohorte(wRiskGroupCohorte.getIdCohorteState());
            eGrupoRiesgoCohorte.setEstadoCohorte(wRiskGroupCohorte.getCohorteState());
            eGrupoRiesgoCohorte.setPosible(wRiskGroupCohorte.getPossible());
            eGrupoRiesgoCohorte.setConfirmado(wRiskGroupCohorte.getConfirmed());
            eGrupoRiesgoCohorte.setObservaciones(wRiskGroupCohorte.getObservations());
            eGrupoRiesgoCohorte.setDiagnostico(wRiskGroupCohorte.getDiagnostic());
            
            return dao.adicionarIdentificacionGrupoRiesgoCohorte(eGrupoRiesgoCohorte);
            
        }
        
}
