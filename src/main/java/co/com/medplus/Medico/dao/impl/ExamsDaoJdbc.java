/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.ExamsDao;
import co.com.medplus.Medico.entities.core.CupRelacion;
import co.com.medplus.Medico.entities.core.EExamsAssisted;
import co.com.medplus.Medico.entities.core.EExamsCode;
import co.com.medplus.Medico.entities.core.EExamsForTamizaje;
import co.com.medplus.Medico.entities.core.TamizajeAbreviado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JeisonI
 */
@Repository
public class ExamsDaoJdbc implements ExamsDao {

    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;

    @Override
    public List<EExamsCode> examsByCode(String codigo) throws SQLException {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EExamsCode> listE = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGetExamsForCode(?)}");

            cstm.setString(1, codigo);

            rs = cstm.executeQuery();

            while (rs.next()) {
                EExamsCode exams = new EExamsCode();

                exams.setCodigo(rs.getString("codigo_cups"));
                exams.setNombreExamen(rs.getString("Descripcion"));

                listE.add(exams);

            }

            return listE;

        } catch (SQLException ex) {
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
    public List<EExamsAssisted> examsAssisted(String numDocumento) throws SQLException {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EExamsAssisted> listE = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGetExamsAssisted(?)}");

            cstm.setString(1, numDocumento);

            rs = cstm.executeQuery();

            while (rs.next()) {
                EExamsAssisted exams = new EExamsAssisted();

                exams.setCodigo(rs.getString("CodigoConcepto"));
                exams.setNombreExamen(rs.getString("Especialidad"));
                exams.setFecha(rs.getString("UltimaConsulta"));

                listE.add(exams);
            }

            return listE;

        } catch (SQLException ex) {
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
    public List<EExamsForTamizaje> examsTamizaje(String codigo) throws SQLException {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EExamsForTamizaje> listE = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGetExamsTamizajeForCode(?)}");

            cstm.setString(1, codigo);

            rs = cstm.executeQuery();

            while (rs.next()) {
                EExamsForTamizaje exams = new EExamsForTamizaje();

                exams.setCodigo(rs.getString("codigo_cups"));
                exams.setNombreExamen(rs.getString("Descripcion"));

                listE.add(exams);
            }

            return listE;

        } catch (SQLException ex) {
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
    public CupRelacion getCupRelacion(String cupOriginal) throws Exception {
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGrConsultaRelacionApp (?)}");
            cstm.setString("cupOriginal", cupOriginal);
            
            rs = cstm.executeQuery();
            
            CupRelacion cup = new CupRelacion();
            
            while(rs.next()){
                cup.setCupDos(rs.getString("id_cup_dos"));
                cup.setCupUno(rs.getString("id_cup_uno"));
                cup.setDescripcion(rs.getString("descripcion"));
                cup.setId(rs.getInt("id"));
            }
            
            return cup;
            
        }catch(SQLException ex){
            throw ex;
        }finally{
            if(conn != null){
                if(!conn.isClosed()){
                    conn.close();
                }
            }
            
            if(cstm != null){
                if(!cstm.isClosed()){
                    cstm.close();
                }
            }
            
            if(rs != null){
                if(!rs.isClosed()){
                    rs.close();
                }
            }
        }
                
    }
    
    @Override
    public TamizajeAbreviado getTamizajeAbreviadoApp(String codigoTamizaje) throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
       try{
           conn = this.dataSource.getConnection();
           cstm = conn.prepareCall("{call spGrObtenerTamizajeAbreviado (?)}");
           cstm.setString("codigoTamizaje", codigoTamizaje);
           
           rs = cstm.executeQuery();
           
           TamizajeAbreviado ta = new TamizajeAbreviado();
           
           while(rs.next()){
               ta.setCodigoFinal(rs.getString("codigoFinal"));
               ta.setDescripcion(rs.getString("descripcion"));
               ta.setEstado(rs.getString("estado"));
               ta.setId(rs.getInt("id"));
           }
           
           return ta;
       }catch(SQLException ex){
           throw ex;
       }finally{
           if(conn != null){
               if(!conn.isClosed()){
                   conn.close();
               }
           }
           
           if(cstm != null){
               if(!cstm.isClosed()){
                   cstm.close();
               }
           }
           
           if(rs != null){
               if(!rs.isClosed()){
                   rs.close();
               }
           }
       }
              
    }

}
