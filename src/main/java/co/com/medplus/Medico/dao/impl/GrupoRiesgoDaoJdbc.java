/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.GrupoRiesgoDao;
import co.com.medplus.Medico.entities.core.EGrupoRiesgo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author MarioF
 */
@Repository
public class GrupoRiesgoDaoJdbc implements GrupoRiesgoDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    @Override
    public List<EGrupoRiesgo> consultaGrupoRiesgoXIdentificacion(String identificacion, int idSubCohorte) throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EGrupoRiesgo> ls = new ArrayList<EGrupoRiesgo>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaGrupoRiesgoXIdentificacion(?,?)}");
                        cstm.setString(1, identificacion);
                        cstm.setInt(2, idSubCohorte);

			rs = cstm.executeQuery();

			while (rs.next()) {

				EGrupoRiesgo li = new EGrupoRiesgo();

                                li.setIdGrupoRiesgo(rs.getInt("IdGrupoRiesgo"));
				li.setDescripcion(rs.getString("GrupoRiesgo"));
				li.setPosible(rs.getString("Posible"));
                                li.setCodigoFecha(rs.getString("CodigoFecha"));
                                li.setPrestador(rs.getString("Prestador"));
				
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
    public List<ConsultaSegmento> consultarSegmentos(String identificacion, Integer grupoRiesgo) throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        try{
            List<ConsultaSegmento> segmentos = new ArrayList<>();
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{ call spCConsultarSegmento (? , ?)}");
            
            cstm.setString("identificacion", identificacion );
            cstm.setInt("grupoRiesgo", grupoRiesgo);
            
            rs = cstm.executeQuery();
            
            while(rs.next()){
               ConsultaSegmento segmento = new ConsultaSegmento();
               
               segmento.setFechaPrimeraConsulta(rs.getString("fechaPrimeraConsulta"));
               segmento.setIdentificacion(rs.getString("Identificacion"));
               segmento.setSegmento(rs.getString("segmento"));
               segmento.setTipoConsulta(rs.getString("tipoConsulta"));
               
               segmentos.add(segmento);
            }
            
            return segmentos;
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
