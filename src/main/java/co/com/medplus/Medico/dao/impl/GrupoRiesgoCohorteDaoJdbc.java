/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.GrupoRiesgoCohorteDao;
import co.com.medplus.Medico.entities.core.EGrupoRiesgoCohorte;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MarioF
 */
@Repository
public class GrupoRiesgoCohorteDaoJdbc implements GrupoRiesgoCohorteDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public List<EGrupoRiesgoCohorte> consultaValidacionManualXGrupoRiesgo(String identificacion, int idGrupoRiesgo, String fechaInicial, String fechaFinal) throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EGrupoRiesgoCohorte> ls = new ArrayList<EGrupoRiesgoCohorte>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaValidacionManualPosibleRiesgo(?,?,?,?)}");
                        
                        if (identificacion.equals("-1")){
                            cstm.setString(1, null);
                        }
                        else {
                            cstm.setString(1, identificacion);
                        }
                        
                        if (idGrupoRiesgo == -1){
                            cstm.setString(2, null);
                        }
                        else {
                            cstm.setInt(2, idGrupoRiesgo);
                        //System.out.println("idGrupoRiesgo -> "+idGrupoRiesgo);
                        }
                        
                        if (fechaInicial.equals("-1")){
                            cstm.setString(3, null);
                        }
                        else {
                            cstm.setString(3, fechaInicial);
                        }
                        
                        if (fechaFinal.equals("-1")){
                            cstm.setString(4, null);
                        }
                        else {
                            cstm.setString(4, fechaFinal);
                        }

                        
			rs = cstm.executeQuery();

			while (rs.next()) {

				EGrupoRiesgoCohorte li = new EGrupoRiesgoCohorte();

                                li.setIdriesgocohorte(rs.getDouble("IdUsuariosGestionRiesgoCohorte"));
                                li.setIdentificacion(rs.getString("Identificacion"));
				li.setNombre(rs.getString("NombreCompleto"));
				li.setIdGrupoRiesgo(rs.getInt("IdGrupoRiesgo"));
                                li.setGrupoRiesgo(rs.getString("GrupoRiesgo"));
                                li.setDiagnostico(rs.getString("Diagnosticos"));
                                li.setPosible(rs.getString("Posible"));
                                li.setConfirmado(rs.getString("Confirmado"));
                                li.setCronicoDomiciliario(rs.getString("CronicoDomiciliario"));
                                li.setOxigenoRequirente(rs.getString("OxigenoRequiriente"));
                                
                                if (rs.getString("IdRiesgoMental") == null) {
                
                                    li.setIdriesgomental(0);                                    
                                }
                                else {

                                    li.setIdriesgomental(rs.getInt("IdRiesgoMental"));                                    
                                }
                                
                                if (rs.getString("Segmento") == null) {
                
                                    li.setSegmento("");                                    
                                }
                                else {

                                    li.setSegmento(rs.getString("Segmento"));                                    
                                }
				
				ls.add(li);
			}

			return ls;
        } catch (Exception e) {
            
			e.printStackTrace();
			throw e;
        } finally {

                try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
    }
    
    @Override
    public boolean adicionarIdentificacionGrupoRiesgoCohorte(EGrupoRiesgoCohorte eGrupoRiesgoCohorte) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spValidaUsuarioGestionRiesgoCohorte(?,?,?,?,?,?,?,?)}");
			cstm.setString(1, eGrupoRiesgoCohorte.getIdentificacion());
                        cstm.setInt(2, eGrupoRiesgoCohorte.getIdGrupoRiesgo());
                        
                        if (eGrupoRiesgoCohorte.getIdEstadoCohorte() == -1){
                            cstm.setString(3, null);
                        }
                        else {
                            cstm.setInt(3, eGrupoRiesgoCohorte.getIdEstadoCohorte());
                        }
                        
                        if (eGrupoRiesgoCohorte.getEstadoCohorte().equals("-1")){
                            cstm.setString(4, null);
                        }
                        else {
                            cstm.setString(4, eGrupoRiesgoCohorte.getEstadoCohorte());
                        }
                        
                        cstm.setString(5, eGrupoRiesgoCohorte.getPosible());
                        cstm.setString(6, eGrupoRiesgoCohorte.getConfirmado());
                        cstm.setString(7, eGrupoRiesgoCohorte.getObservaciones());
                        
                        if (eGrupoRiesgoCohorte.getDiagnostico().equals("-1")){
                            cstm.setString(8, null);
                        }
                        else {
                            cstm.setString(8, eGrupoRiesgoCohorte.getDiagnostico());
                        }
                        
			cstm.execute();
                        
        } catch(Exception e){
            
            bRespuesta = false;
            e.printStackTrace();
            throw e;
            
        } finally {
            
             try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
                
                return bRespuesta;
    }
}
