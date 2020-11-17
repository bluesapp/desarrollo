/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.Cie10Dao;
import co.com.medplus.Medico.entities.core.ECie10;
import co.com.medplus.Medico.entities.core.EListas;
import co.com.medplus.Medico.wrapper.WCie10ClasificationWrapper;
import co.com.medplus.Medico.wrapper.WCie10Wrapper;
import co.com.medplus.Medico.wrapper.WListasWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class Cie10Controller {
  
    	private Cie10Dao dao;

	@Autowired
	public void setDao(Cie10Dao dao) {
		this.dao = dao;
	}
        
        public List<WCie10Wrapper> consultaCie10(int idClasificacion) throws Exception{
            
            List<WCie10Wrapper> lsw = new ArrayList<WCie10Wrapper>();
                
                List<ECie10> ls =  dao.consultaCie10(idClasificacion);
		
		for(ECie10 item : ls){
                    
                        WCie10Wrapper lw = new WCie10Wrapper();
			
			lw.setIdCie10(item.getIdCie10());
			lw.setDescription(item.getDescripcion());
			lw.setCode(item.getCodigo());
			lsw.add(lw);
		}
		
		return lsw;
        }
        
	public List<WListasWrapper> consultaClasificaciones() throws Exception {
		
		List<WListasWrapper> lsw = new ArrayList<WListasWrapper>();
                
                List<EListas> ls =  dao.consultaClasificaciones();
		
		for(EListas item : ls){
			WListasWrapper lw = new WListasWrapper();
			
			lw.setId(item.getValor());
			lw.setText(item.getTexto());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
        
        public List<WCie10Wrapper> consultaCie10XClasificacion(int idClasificacion) throws Exception{
            
            List<WCie10Wrapper> lsw = new ArrayList<WCie10Wrapper>();
                
                List<ECie10> ls =  dao.consultaCie10XClasificacion(idClasificacion);
		
		for(ECie10 item : ls){
                    
                        WCie10Wrapper lw = new WCie10Wrapper();
			
			lw.setIdCie10(item.getIdCie10());
			lw.setDescription(item.getDescripcion());
			lw.setCode(item.getCodigo());
			lsw.add(lw);
		}
		
		return lsw;
        }
        
        public boolean adicionarCie10Clasificacion(WCie10ClasificationWrapper wCie10Clasification) throws Exception {
            
            boolean bRespuesta = true;
            
            for(WCie10Wrapper wCie10 : wCie10Clasification.getLsCie10()){
                
                ECie10 eCie10 = new ECie10();
                eCie10.setCodigo(wCie10.getCode());
                
                if(bRespuesta){
                    bRespuesta = dao.adicionarCie10Clasificacion(eCie10, wCie10Clasification.getId());
                }                
            }
            
            return bRespuesta;
        }
        
        public boolean eliminarCie10Clasificacion(WCie10Wrapper wCie10) throws Exception {
            
            boolean bRespuesta = true;
            
            bRespuesta = dao.eliminarCie10Clasificacion(wCie10.getCode(), wCie10.getIdClasification());
            
            return bRespuesta;
        } 
}
