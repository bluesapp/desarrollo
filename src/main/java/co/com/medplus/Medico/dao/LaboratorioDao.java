/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.ELaboratorio;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.entities.core.TipoLaboratorio;
import co.com.medplus.Medico.wrapper.DatoGenerico;
import co.com.medplus.Medico.wrapper.LaboratorioLoad;
import co.com.medplus.Medico.wrapper.WLaboratoryConsult;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MarioF
 */
public interface LaboratorioDao {
    
    public List<ELaboratorio> consultaLaboratorioXIdentificacion(String identificacion) throws Exception;
    
    public TipoLaboratorio obtenerVariablesalerta(String idLaboratorio) throws SQLException;
    
    public ResponseCargueSp saveLaboratio(LaboratorioLoad laboratorio,String alerta,Integer idLaboratirio) throws SQLException;
    
    public WLaboratoryConsult examenesXidentificacionApp(String numDocumento)throws SQLException;
    
    public WLaboratoryConsult examenesXidentificacionApp(String numDocumento,Integer tipo) throws SQLException;
    
    public Boolean insertarLaboratorioApp(DatoGenerico datoGenerico,String identificacion,String tipoDocumento,Integer idLaboratorio) throws Exception;
}
