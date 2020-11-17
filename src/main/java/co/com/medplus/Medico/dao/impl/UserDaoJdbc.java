package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.UserDao;
import co.com.medplus.Medico.entities.core.EUser;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoJdbc implements UserDao {

    private DataSource dataSource;

	@Autowired
	@Qualifier("dsAthenea")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
    }

    @Override
    public List<EUser> dataUser(String email) throws Exception {

        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EUser> lu = new ArrayList<EUser>();

        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spWebBuscaUserConfirm(?,?)}");
            cstm.setString(1, email);
            cstm.setInt(2, 6);

            rs = cstm.executeQuery();

            while (rs.next()) {

                EUser u = new EUser();

                u.setIdUsuario(1);
                u.setNombre(rs.getString("nombre"));
                u.setNumeroContrato(rs.getInt("numcontrato"));
                u.setCedula(rs.getString("cedula"));
                u.setUsuario(rs.getString("usuario"));
                u.setEstado(rs.getString("estado"));
                u.setIntentos(rs.getInt("intentos"));
                u.setFechaNacimiento(rs.getString("FechaNacimiento"));
                u.setEdad(rs.getInt("Edad"));
                u.setEmail(rs.getString("Email"));
                u.setTelefonoResidencia(rs.getString("TelefonoCorrespondencia"));
                u.setCelular(rs.getString("mpTelefonoCelular"));
                u.setSexo(rs.getString("Sexo"));
                u.setCiudadResidencia(rs.getString("Ciudad"));
                u.setDireccionResidencia(rs.getString("DireccionCorrespondencia"));
                u.setTipoUsuario(rs.getString("tipoUsuario"));
                u.setTipoDocumento(rs.getString("TipoIdentificacion"));

                lu.add(u);
            }

            return lu;

        } catch (Exception ex) {
            System.out.println("------------------"+ex);
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

}
