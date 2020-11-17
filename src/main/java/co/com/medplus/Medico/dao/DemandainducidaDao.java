/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.DatoDemandaInducida;
import co.com.medplus.Medico.wrapper.DemandainducidaResponseWrapper;
import co.com.medplus.Medico.wrapper.WDemandaInducidaExportLoad;
import java.sql.SQLException;

/**
 *
 * @author JorgeLP
 */
public interface DemandainducidaDao {
   
    public ResponseCargueSp save(WDemandaInducidaExportLoad demanda) throws SQLException;
    public DatoDemandaInducida getDatosDemanda(String identificacion) throws SQLException;

}
