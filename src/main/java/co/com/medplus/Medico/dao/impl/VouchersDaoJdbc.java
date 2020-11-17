/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.VouchersDao;
import co.com.medplus.Medico.entities.core.EAutorizacion;
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
public class VouchersDaoJdbc implements VouchersDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public List<EAutorizacion> consultaAutorizacionValidacionManualXIdentificacion(String identificacion, int idGrupoRiesgo) throws Exception {
       
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EAutorizacion> ls = new ArrayList<EAutorizacion>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaAutorizacionesValidacionManualXIdentificacion(?,?)}");
                        cstm.setString(1, identificacion);
                        cstm.setInt(2, idGrupoRiesgo);

			rs = cstm.executeQuery();

			while (rs.next()) {

				EAutorizacion li = new EAutorizacion();

				li.setIdentificacion(rs.getString("Identificacion"));
				li.setEspecialidad(rs.getString("Especialidad"));
                                li.setProfesional(rs.getString("Profesional"));
                                li.setUltimaConsulta(rs.getString("UltimaConsulta"));
				
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
}
