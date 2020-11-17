package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.AuthenticateDao;
import co.com.medplus.Medico.entities.core.EParametrosPassword;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticateDaoJdbc implements AuthenticateDao {

    private DataSource dataSource;

    @Autowired
    @Qualifier("dsAthenea")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    /*@Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;*/

    @Override
    public EParametrosPassword passwordValidate(String email) throws Exception {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        EParametrosPassword p = null;

        try {

            conn = dataSource.getConnection();
            cstm = conn.prepareCall("{call spWebValidaLogin(?)}");
            cstm.setString(1, email);

            rs = cstm.executeQuery();

            while (rs.next()) {

                p = new EParametrosPassword();
                p.setDbPasswordHash(rs.getString(1));
                p.setSalt(rs.getString(2));

            }

            return p;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (cstm != null) {
                    cstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @Override
    public void estadoSession(String user, int tipoSolicitud) throws Exception {
        Connection conn = null;
        CallableStatement cstm = null;

        try {

            conn = dataSource.getConnection();
            cstm = conn.prepareCall("{call spWebEstadoSesion(?,?)}");
            cstm.setString(1, user);
            cstm.setInt(2, tipoSolicitud);

            cstm.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;

        } finally {

            try {

                if (cstm != null) {
                    cstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
