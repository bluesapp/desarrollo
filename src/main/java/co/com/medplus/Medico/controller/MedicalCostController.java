/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.CostoMedicoDao;
import co.com.medplus.Medico.entities.core.ECostoMedico;
import co.com.medplus.Medico.wrapper.WMedicalCostWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class MedicalCostController {
    
        private CostoMedicoDao dao;

	@Autowired
	public void setDao(CostoMedicoDao dao) {
		this.dao = dao;
	}
        
    	public List<WMedicalCostWrapper> consultaCostoMedicoXIdentificacion(String identificacion) throws Exception {
		
		List<WMedicalCostWrapper> lsw = new ArrayList<>();
                
                List<ECostoMedico> ls =  dao.consultaCostoMedicoXIdentificacion(identificacion);
                
                ls.stream().map((item) -> {
                    WMedicalCostWrapper lw = new WMedicalCostWrapper();
                    lw.setIdentification(item.getIdentificacion());
                    lw.setRadicado(item.getRadicado());
                    lw.setIncome(item.getValor());
                    lw.setIncomeText("$" + String.format("%,.2f", item.getValor()));
                return lw;
                }).forEach((lw) -> {
                    lsw.add(lw);
            });
		
		return lsw;
	}
}
