/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.ListaDao;
import co.com.medplus.Medico.entities.core.EListas;
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
public class ListController {
    
        private ListaDao dao;

	@Autowired
	public void setDao(ListaDao dao) {
		this.dao = dao;
	}
        
    	public List<WListasWrapper> consultaTablaLista(String nombreTabla) throws Exception {
		
		List<WListasWrapper> lsw = new ArrayList<WListasWrapper>();
                
                List<EListas> ls =  dao.consultaTablaLista(nombreTabla);
                
		for(EListas item : ls){
			WListasWrapper lw = new WListasWrapper();
			
			lw.setId(item.getValor());
			lw.setText(item.getTexto());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
        
        public List<WListasWrapper> consultaTablaListaAlizaMatriz(Integer idTipoContrato) throws Exception {
		
		List<WListasWrapper> lsw = new ArrayList<WListasWrapper>();
                
                List<EListas> ls =  dao.obtenerAlianzaOMatriz(idTipoContrato);
                
		for(EListas item : ls){
			WListasWrapper lw = new WListasWrapper();
			
			lw.setId(item.getValor());
			lw.setText(item.getTexto());
			
			lsw.add(lw);
		}
		
		return lsw;
	}
}
