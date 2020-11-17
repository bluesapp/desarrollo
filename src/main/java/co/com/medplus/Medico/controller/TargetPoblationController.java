/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.PoblacionObjetoDao;
import co.com.medplus.Medico.entities.core.EPoblacionObjeto;
import co.com.medplus.Medico.wrapper.WTargetPoblationWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class TargetPoblationController {
    
        private PoblacionObjetoDao dao;

	@Autowired
	public void setDao(PoblacionObjetoDao dao) {
		this.dao = dao;
	}
        
        public List<WTargetPoblationWrapper> consultaPoblacionObjetoXTipoRiesgo(int idTipoRiesgo) throws Exception{
            
            List<WTargetPoblationWrapper> lsw = new ArrayList<WTargetPoblationWrapper>();
                
                List<EPoblacionObjeto> ls =  dao.consultaPoblacionObjetoXTipoRiesgo(idTipoRiesgo);
		
		for(EPoblacionObjeto item : ls){
                    
                        WTargetPoblationWrapper lw = new WTargetPoblationWrapper();
			
			lw.setIdTargetPoblation(item.getIdPoblacionObjeto());
			lw.setDescription(item.getDescripcion());
			lw.setCode(item.getCodigo());
                        lw.setIdRiskType(item.getIdTipoRiesgo());
                        lw.setRiskType(item.getTipoRiesgo());
                        lw.setIdComunicationWay(item.getIdViaComunicacion());
                        lw.setComunicationWay(item.getViaComunicacion());
                        lw.setIdResponsableArea(item.getIdAreaResponsable());
                        lw.setResponsableArea(item.getAreaResponsable());
                        lw.setState(item.getEstado());
                        lw.setActive(item.isActivo());
			lsw.add(lw);
		}
		
		return lsw;
        }
        
        public boolean adicionarTargetPoblation(WTargetPoblationWrapper wTargetPoblation) throws Exception{
         
            EPoblacionObjeto ePoblacionObjeto = new EPoblacionObjeto();
            
            ePoblacionObjeto.setIdPoblacionObjeto(wTargetPoblation.getIdTargetPoblation());
            ePoblacionObjeto.setCodigo(wTargetPoblation.getCode());
            ePoblacionObjeto.setDescripcion(wTargetPoblation.getDescription());
            ePoblacionObjeto.setIdTipoRiesgo(wTargetPoblation.getIdRiskType());
            ePoblacionObjeto.setIdViaComunicacion(wTargetPoblation.getIdComunicationWay());
            ePoblacionObjeto.setIdAreaResponsable(wTargetPoblation.getIdResponsableArea());
            ePoblacionObjeto.setActivo(wTargetPoblation.isActive());
            
            return dao.adicionarPoblacionObjeto(ePoblacionObjeto);
        }
        
        public boolean editarTargetPoblation(WTargetPoblationWrapper wTargetPoblation) throws Exception{
         
            EPoblacionObjeto ePoblacionObjeto = new EPoblacionObjeto();
            
            ePoblacionObjeto.setIdPoblacionObjeto(wTargetPoblation.getIdTargetPoblation());
            ePoblacionObjeto.setCodigo(wTargetPoblation.getCode());
            ePoblacionObjeto.setDescripcion(wTargetPoblation.getDescription());
            ePoblacionObjeto.setIdTipoRiesgo(wTargetPoblation.getIdRiskType());
            ePoblacionObjeto.setIdViaComunicacion(wTargetPoblation.getIdComunicationWay());
            ePoblacionObjeto.setIdAreaResponsable(wTargetPoblation.getIdResponsableArea());
            ePoblacionObjeto.setActivo(wTargetPoblation.isActive());
            
            return dao.editarPoblacionObjeto(ePoblacionObjeto);
        }
}
