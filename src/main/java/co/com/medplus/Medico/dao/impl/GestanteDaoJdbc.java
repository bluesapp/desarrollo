/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.GestanteDao;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.wrapper.WGestanteWrapper;
import co.com.medplus.Medico.wrapper.WGestateCreadorWrapper;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLP
 */
@Repository
public class GestanteDaoJdbc implements GestanteDao{
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public List<WGestanteWrapper> consultarGestantes(String identificacion,String tipoDocumento)throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        try{
            
            List<WGestanteWrapper> gestantes = new ArrayList<>();
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spObtenerGestante (?, ?)}");
            
            cstm.setString("identificacion", identificacion);
            cstm.setString("tipoDocumento", tipoDocumento);
            
            rs = cstm.executeQuery();

            while(rs.next()){
                WGestanteWrapper gestante = new WGestanteWrapper();
                
                gestante.setDocumento_madre(rs.getString("documento_madre"));
                gestante.setFecha_actualizado(rs.getString("fecha_actualizado"));
                gestante.setFecha_creado(rs.getString("fecha_creado"));
                gestante.setGestante(rs.getBoolean("gestante"));
                gestante.setId(rs.getInt("id"));
                gestante.setNacido_vivo(rs.getBoolean("nacido_vivo"));
                gestante.setSemana(rs.getInt("semanas"));
                gestante.setSexo(rs.getString("sexo"));
                gestante.setTipo_documento(rs.getString("tipo_documento"));
                gestante.setNombre(rs.getString("nombre"));
                
                
                gestantes.add(gestante);
            }
         return gestantes;   
            
        }catch(SQLException ex){
            
            throw ex;
            
        } finally {
            if (conn != null) {
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
            if (cstm != null) {
                if (!cstm.isClosed()) {
                    cstm.close();
                }
            }
            if (rs != null) {
                if (!rs.isClosed()) {
                    rs.close();
                }
            }

        }
        
        
    }
    
    @Override
    public Boolean ingresarGestante(WGestateCreadorWrapper creadorWrapper) throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        
        try{
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertGestante (?, ?, ?, ?, ?)}");
            
            cstm.setString("documento_madre", creadorWrapper.getDocumento());
            cstm.setString("tipo_documento", creadorWrapper.getTipoDocumento());
            cstm.setInt("semanas", creadorWrapper.getSemana());
            cstm.setString("sexo", creadorWrapper.getSexo());
            cstm.setString("nombre", creadorWrapper.getNombre());
            
            cstm.execute();
            
            return true;
            
        }catch(SQLException ex){
           throw ex;
        }finally{
            if (conn != null) {
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
            if (cstm != null) {
                if (!cstm.isClosed()) {
                    cstm.close();
                }
            }  
        }
        
    }
    
    @Override
    public ResponseCargueSp actualizarGestante(WGestanteActualizarWrapper wgaw)throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("spActualizarGestanta (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            cstm.setInt("id",wgaw.getId());
            cstm.setString("documento",wgaw.getDocumento());
            cstm.setString("tipoDocumento",wgaw.getTipoDocumento());
            cstm.setInt("semana",wgaw.getSemana());
            cstm.setString("sexo",wgaw.getSexo());
            cstm.setBoolean("nacido",wgaw.getNacido());
            cstm.setBoolean("gestante",wgaw.getGestante());
            cstm.setString(("nombre"),wgaw.getNombre());
            
            cstm.registerOutParameter("mensaje", Types.VARCHAR);
            cstm.registerOutParameter("error", Types.BIT);
            
            cstm.execute();
            
            ResponseCargueSp responseCargueSp = new ResponseCargueSp();
            
            responseCargueSp.setEstado(cstm.getBoolean("error"));
            responseCargueSp.setMensaje(cstm.getString("mensaje"));
            
            return responseCargueSp;
        }catch(SQLException ex){
            throw ex;
        }finally{
            if (conn != null) {
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
            if (cstm != null) {
                if (!cstm.isClosed()) {
                    cstm.close();
                }
            }
        }
        
    }
    
}
