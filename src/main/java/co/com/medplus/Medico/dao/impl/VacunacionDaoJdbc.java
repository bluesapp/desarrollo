/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.VacunacionDao;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacion;
import co.com.medplus.Medico.wrapper.WUsuarioVacunacionAct;
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
public class VacunacionDaoJdbc implements VacunacionDao{
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public Boolean creaUserVacuna(WUsuarioVacunacion wUserVac) throws Exception{
        Connection conn = null;
        CallableStatement cstm = null;
        
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertUserVacunacion(?, ?, ?, ?, ?, ?, ?)}");

            cstm.setString(1, wUserVac.getNameChild());
            cstm.setString(2, wUserVac.getDocumentChild());
            cstm.setString(3, wUserVac.getTypeDocumentChild().toUpperCase());
            cstm.setString(4, wUserVac.getBirthDateChild());
            cstm.setString(5, wUserVac.getSexChild().toUpperCase());
            cstm.setString(6, wUserVac.getDocumentoResponsable());
            cstm.setString(7, wUserVac.getTipoDocumentoResponsable().toUpperCase());

            cstm.execute();

            return true;

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

    @Override
    public List<WUsuarioVacunacion> getUsers(String tipoDoc, String Docu) throws Exception {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<WUsuarioVacunacion> list = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spBusquedaUserVacunacion(?, ?)}");

            cstm.setString(1, tipoDoc);
            cstm.setString(2, Docu);

            rs = cstm.executeQuery();

            while (rs.next()) {
                WUsuarioVacunacion user = new WUsuarioVacunacion();
                
                user.setId(rs.getInt("id"));
                user.setNameChild(rs.getString("nombre_child"));
                user.setDocumentChild(rs.getString("documento_child"));
                user.setTypeDocumentChild(rs.getString("tipoDocumento_child"));
                user.setBirthDateChild(rs.getString("fechaNacimiento_child"));
                user.setSexChild(rs.getString("sexo_child"));
                user.setDocumentoResponsable(Docu);
                user.setTipoDocumentoResponsable(tipoDoc);

                list.add(user);

            }

            return list;

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
    public Boolean actualizaUserVacunacion(WUsuarioVacunacionAct WuserAct) throws Exception {
        Connection conn = null;
        CallableStatement cstm = null;
        
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spUpdateUserVacunacion(?, ?, ?, ?, ?, ?)}");

            cstm.setString(1, WuserAct.getNameChild());
            cstm.setString(2, WuserAct.getDocumentChild());
            cstm.setString(3, WuserAct.getTypeDocumentChild().toUpperCase());
            cstm.setString(4, WuserAct.getBirthDateChild());
            cstm.setString(5, WuserAct.getSexChild().toUpperCase());
            cstm.setInt(6, WuserAct.getId());
            cstm.execute();

            return true;

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
