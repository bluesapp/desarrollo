/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.GrupoRiesgoDao;
import co.com.medplus.Medico.dao.impl.ConsultaSegmento;
import co.com.medplus.Medico.entities.core.EGrupoRiesgo;
import co.com.medplus.Medico.wrapper.WRiskGroupWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class RiskGroupController {
    
        private GrupoRiesgoDao dao;

	@Autowired
	public void setDao(GrupoRiesgoDao dao) {
		this.dao = dao;
	}
        
    	public List<WRiskGroupWrapper> consultaGrupoRiesgoXIdentificacion(String identificacion, int idSubCohorte) throws Exception {
		
		List<WRiskGroupWrapper> lsw = new ArrayList<WRiskGroupWrapper>();
                
                List<EGrupoRiesgo> ls =  dao.consultaGrupoRiesgoXIdentificacion(identificacion, idSubCohorte);
                
		for(EGrupoRiesgo item : ls){
			WRiskGroupWrapper lw = new WRiskGroupWrapper();
			
			lw.setIdRiskGroup(item.getIdGrupoRiesgo());
                        lw.setDescription(item.getDescripcion());
			lw.setPosible(item.getPosible());
                        lw.setCodeDate(item.getCodigoFecha());
                        lw.setLender(item.getPrestador());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
        
        
        public List<ConsultaSegmento> consultaSegmento(String identificacion, Integer grupoRiesgo) throws Exception{
            
            List<ConsultaSegmento> segmentos = new ArrayList<>();
            
            segmentos = this.dao.consultarSegmentos(identificacion, grupoRiesgo);
            
            List<ConsultaSegmento> segmentosFinal = new ArrayList<>();
            for (ConsultaSegmento segmento : segmentos) {
                
              if(segmento.getFechaPrimeraConsulta() != null){
                  if(!segmento.getFechaPrimeraConsulta().trim().equals("")){
                      segmentosFinal.add(segmento);
                  }
              }
            }
            
            return segmentosFinal;
        }
        
}
