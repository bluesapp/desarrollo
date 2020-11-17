package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.CupsDao;
import co.com.medplus.Medico.entities.core.ECups;
import co.com.medplus.Medico.entities.core.EListas;
import co.com.medplus.Medico.wrapper.WCupsClasificationWrapper;
import co.com.medplus.Medico.wrapper.WCupsWrapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import co.com.medplus.Medico.wrapper.WListasWrapper;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CupsController {

    	private CupsDao dao;

	@Autowired
	public void setDao(CupsDao dao) {
		this.dao = dao;
	}
        
        public List<WCupsWrapper> consultaCups(int idClasificacion) throws Exception{
            
            List<WCupsWrapper> lsw = new ArrayList<>();
                
                List<ECups> ls =  dao.consultaCups(idClasificacion);
		
                ls.stream().map((item) -> {
                    WCupsWrapper lw = new WCupsWrapper();
                    lw.setIdCups(item.getIdCups());
                    lw.setDescription(item.getDescripcion());
                    lw.setCode(item.getCodigo());
                    return lw;
                }).forEach((lw) -> {
                    lsw.add(lw);
                });
		
		return lsw;
        }
        
	public List<WListasWrapper> consultaClasificaciones() throws Exception {
		
		List<WListasWrapper> lsw = new ArrayList<>();
                
                List<EListas> ls =  dao.consultaClasificaciones();
		
                ls.stream().map((item) -> {
                    WListasWrapper lw = new WListasWrapper();
                    lw.setId(item.getValor());
                    lw.setText(item.getTexto());
                    return lw;
                }).forEach((lw) -> {
                    lsw.add(lw);
                });
		
		return lsw;
	}
        
        public List<WCupsWrapper> consultaCupsXClasificacion(int idClasificacion) throws Exception{
            
            List<WCupsWrapper> lsw = new ArrayList<>();
                
                List<ECups> ls =  dao.consultaCupsXClasificacion(idClasificacion);
		
                ls.stream().map((item) -> {
                    WCupsWrapper lw = new WCupsWrapper();
                    lw.setIdCups(item.getIdCups());
                    lw.setDescription(item.getDescripcion());
                    lw.setCode(item.getCodigo());
                    return lw;
                }).forEach((lw) -> {
                    lsw.add(lw);
                });
		
		return lsw;
        }
        
        public boolean adicionarCupsClasificacion(WCupsClasificationWrapper wCupsClasification) throws Exception {
            
            boolean bRespuesta = true;
            
            for(WCupsWrapper wCups : wCupsClasification.getLsCups()){
                
                ECups eCups = new ECups();
                eCups.setCodigo(wCups.getCode());
                
                if(bRespuesta){
                    bRespuesta = dao.adicionarCupsClasificacion(eCups, wCupsClasification.getId());
                }                
            }
            
            return bRespuesta;
        }
        
        public boolean eliminarCupsClasificacion(WCupsWrapper wCups) throws Exception {
            
            boolean bRespuesta ;
            
            bRespuesta = dao.eliminarCupsClasificacion(wCups.getCode(), wCups.getIdClasification());
            
            return bRespuesta;
        }
        
}
