/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.CronicoDao;
import co.com.medplus.Medico.entities.core.ECronicosLoad;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JorgeLP
 */
@Repository
public class CronicoDaoJdbc implements CronicoDao {

    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;

    @Override
    public ResponseCargueSp saveCronico(ECronicosLoad cronico) throws SQLException {

        Connection conn = null;
        CallableStatement cstm = null;

        try {
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertarCronicoDomiciliario(?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cstm.setString("tipoIdentificacion", cronico.getTipo());
            cstm.setString("identificacion", cronico.getNumeroIdentificacion());
            cstm.setString("nombreCompleto", cronico.getNombre());
            cstm.setString("colectivoAlianza", cronico.getColectivoAlianza());
            cstm.setString("telefono", cronico.getTelefono());
            cstm.setString("direccion", cronico.getDireccion());
            cstm.setString("edad", cronico.getEdad());

            cstm.registerOutParameter("mensaje", java.sql.Types.VARCHAR);
            cstm.registerOutParameter("estado", java.sql.Types.BIT);

            cstm.execute();
            ResponseCargueSp response = new ResponseCargueSp();

            response.setMensaje(cstm.getString("mensaje"));
            response.setEstado(cstm.getBoolean("estado"));

            return response;

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

        }

    }

}
