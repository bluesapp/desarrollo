/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.CupRelacion;
import co.com.medplus.Medico.entities.core.EExamsAssisted;
import co.com.medplus.Medico.entities.core.EExamsCode;
import co.com.medplus.Medico.entities.core.EExamsForTamizaje;
import co.com.medplus.Medico.entities.core.TamizajeAbreviado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author JeisonI
 */
public interface ExamsDao {
    
    List<EExamsCode> examsByCode(String codigo) throws SQLException;
    
    List<EExamsAssisted> examsAssisted(String numDocumento) throws SQLException;
    
    List<EExamsForTamizaje> examsTamizaje(String codigo)throws SQLException;
    
    CupRelacion getCupRelacion(String cupOriginal) throws Exception ;
    
    TamizajeAbreviado getTamizajeAbreviadoApp(String codigoTamizaje) throws Exception;
    
}
