/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.EscalaRiesgoDao;
import co.com.medplus.Medico.dao.IndicadoresDao;
import co.com.medplus.Medico.entities.core.EEscalaRiesgo;
import co.com.medplus.Medico.entities.core.EIndicadores;
import co.com.medplus.Medico.wrapper.WRiskScaleWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class RiskScaleController {
    
    private EscalaRiesgoDao dao;
    private IndicadoresDao indicadoresDao;
    
    @Autowired
    public void setController(EscalaRiesgoDao dao) {
     this.dao = dao;   
    }
    
    @Autowired
    public void setIndicadoresController(IndicadoresDao indicadoresDao){
        this.indicadoresDao = indicadoresDao;
    }
    
    public List<WRiskScaleWrapper> consultaEscalaRiesgoXIdentificacion(String identificacion) throws Exception {
        
        	List<WRiskScaleWrapper> lsw = new ArrayList<WRiskScaleWrapper>();
                
                List<EEscalaRiesgo> ls =  dao.consultaEscalaRiesgoXIdentificacion(identificacion);
                
		for(EEscalaRiesgo item : ls){
			WRiskScaleWrapper lw = new WRiskScaleWrapper();
			
			lw.setRiskScale(item.getEscalaRiesgo());
                        lw.setResultPanacea(item.getResultadoPanacea());
			lw.setResultManual(item.getResultadoManual());
			
			lsw.add(lw);
		}
                
                List<EIndicadores> lsi = indicadoresDao.consultaIndicadoresXIdentificacion(identificacion);
                
                for(EIndicadores item : lsi){
                    WRiskScaleWrapper lw = new WRiskScaleWrapper();
                    
                    lw.setRiskScale(item.getIndicador());
                    lw.setResultPanacea(item.getResultadoPanacea());
                    lw.setResultManual(item.getResultadoManual());
                    
                    lsw.add(lw);
                }
		
		return lsw;
    }
}
