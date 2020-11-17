/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.HospitalizacionDao;
import co.com.medplus.Medico.entities.core.EHospitalizacion;
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
public class HospitalizacionDaoJdbc implements HospitalizacionDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    @Override
    public List<EHospitalizacion> consultaHospitalizacionXIdentificacion(String identificacion) throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EHospitalizacion> ls = new ArrayList<EHospitalizacion>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaHospitalizacionXIdentificacion(?)}");
                        cstm.setString(1, identificacion);

			rs = cstm.executeQuery();

			while (rs.next()) {

				EHospitalizacion li = new EHospitalizacion();

				li.setIdentificacion(rs.getString("Identificacion"));
				li.setDescripcion(rs.getString("Hospitalizacion"));
                                li.setIngresos(rs.getInt("Ingresos"));
                                li.setIngresosTexto(rs.getString("Meses"));
				
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
