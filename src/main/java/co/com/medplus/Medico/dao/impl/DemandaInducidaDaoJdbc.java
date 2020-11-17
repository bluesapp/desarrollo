/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.DemandainducidaDao;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.DatoDemandaInducida;
import co.com.medplus.Medico.wrapper.DemandainducidaResponseWrapper;
import co.com.medplus.Medico.wrapper.WDemandaInducidaExportLoad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLP
 */
@Repository
public class DemandaInducidaDaoJdbc implements DemandainducidaDao{
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public ResponseCargueSp save(WDemandaInducidaExportLoad demanda) throws SQLException{
    
        Connection conn = null;
        CallableStatement cstm = null;
        ResponseCargueSp respo = new ResponseCargueSp();
        
        try{
           conn = this.dataSource.getConnection();
           cstm = conn.prepareCall("{call spInsertarContactoDemandaInducida (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
           
           cstm.setString("cohorte",              demanda.getCohorte());
           cstm.setString("tipoDeIdentificacion", demanda.getTipoDeIdentificacion());
           cstm.setString("identificacion",       demanda.getIdentificacion());
           cstm.setString("nombreCompleto",       demanda.getNombreCompleto());
           cstm.setString("estado",               demanda.getEstado());
           cstm.setString("fechaDeNacimiento",    demanda.getFechaDeNacimiento());
           cstm.setString("edad",                 demanda.getEdad());
           cstm.setString("sexo",                 demanda.getSexo());
           cstm.setString("grupoQuinquenial",     demanda.getGrupoQuinquenial());
           cstm.setString("ciudad",               demanda.getCiudad());
           cstm.setString("numeroDeContrato",     demanda.getNumeroDeContrato());
           cstm.setString("tipoDeContratp",       demanda.getTipoDeContratp());
           cstm.setString("tipoDeUsuario",        demanda.getTipoDeUsuario());
           cstm.setString("numeroDeMatriz",       demanda.getNumeroDeMatriz());
           cstm.setString("nombreMatriz",         demanda.getNombreMatriz());
           cstm.setString("pnombrePlan",           demanda.getNombrePlan());
           cstm.setString("numeroFijo",           demanda.getNumeroFijo());
           cstm.setString("celular",              demanda.getCelular());
           cstm.setString("nombreEPS",            demanda.getNombreEPS());
           cstm.setString("periodo",              demanda.getPeriodo());
           cstm.setString("codigoDemandaInducida",demanda.getCodigoDemandaInducida());
           cstm.setString("fechaGestion",         demanda.getFechaGestion());
           cstm.setString("horaGestion",          demanda.getHoraGestion());
           cstm.setString("resultado",            demanda.getResultado());
           cstm.setString("contactoConTitular",   demanda.getContactoConTitular());
           cstm.setString("fechaCitaMedGral",     demanda.getFechaCitaMedGral());
           cstm.setString("agente",              demanda.getAgente());
           cstm.setString("observaciones",       demanda.getObservaciones());
           
           cstm.registerOutParameter("estadoServer", Types.BIT);
           cstm.registerOutParameter("mensaje", Types.VARCHAR);
           
           cstm.execute();
           
           respo.setEstado(cstm.getBoolean("estadoServer"));
           respo.setMensaje(cstm.getString("mensaje"));
        
        }catch(SQLException ex){
            
             throw ex;
            
        } finally{
            if(!conn.isClosed()){
                conn.close();
            }
            if(!cstm.isClosed()){
                cstm.close();
            }
        }
        
        return respo;
    }
    
    @Override
    public DatoDemandaInducida getDatosDemanda(String identificacion) throws SQLException{
        
        Connection conn = null;
        CallableStatement cstm = null;
        DatoDemandaInducida datos = new DatoDemandaInducida();
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spConsultarDemanadaInducidaDato (? , ?, ?)}");
            
            cstm.setString("identificacion", identificacion);
            cstm.registerOutParameter("registros", Types.INTEGER);
            cstm.registerOutParameter("ultimaFecha",Types.VARCHAR);
            
            cstm.execute();
            
            datos.setRegistro(cstm.getInt("registros"));
            datos.setUltimaFecha(cstm.getString("ultimaFecha"));

            return datos;
        }catch(SQLException ex){
            throw ex;
        }finally{
            if(!conn.isClosed()){
                conn.close();
            }
            if(!cstm.isClosed()){
                cstm.close();
            }
        }
        
    }
    
}
