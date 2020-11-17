/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.PerfilRiesgoDao;
import co.com.medplus.Medico.entities.core.EPerfilRiesgo;
import co.com.medplus.Medico.entities.core.EPerfilRiesgoRPM;
import co.com.medplus.Medico.wrapper.WPerfilRiesgo;
import co.com.medplus.Medico.wrapper.WSelectItem;
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
public class PerfilRiesgoDaoJdbc implements PerfilRiesgoDao {

    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;

    @Override
    public List<EPerfilRiesgo> getAllDataPerfil(WPerfilRiesgo perfilRiesgo) throws Exception {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EPerfilRiesgo> listE = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGetPerfilRiesgoPart1(?, ?, ?, ?, ?, ?)}");

            String NumAlianza = null;

            for (WSelectItem matriz : perfilRiesgo.getMatriz()) {
                if (matriz.getId().equals("-1")) {
                    NumAlianza = null;
                } else {
                    NumAlianza = matriz.getId();
                }
            }

            cstm.setString(1, ("-1".equals(perfilRiesgo.getCiudad().getName()) ? null : perfilRiesgo.getCiudad().getName()));
            cstm.setInt(2, perfilRiesgo.getEdadMinimo());
            cstm.setInt(3, perfilRiesgo.getEdadMaximo());
            cstm.setString(4, ("-1".equals(perfilRiesgo.getTipoContrato().getId()) ? null : perfilRiesgo.getTipoContrato().getName().substring(0,0)));
            cstm.setString(5, NumAlianza);
            cstm.setString(6, ("-1".equals(perfilRiesgo.getSexo().getId()) ? null : perfilRiesgo.getSexo().getName()));
            
            //System.out.println(perfilRiesgo.getTipoContrato().getName().substring(0,1));
            
            rs = cstm.executeQuery();
            
            
            
            while (rs.next()) {
                EPerfilRiesgo perfil = new EPerfilRiesgo();

                perfil.setDescripcion(rs.getString("Descripcion"));
                perfil.setConteo(rs.getInt("conteo"));

                listE.add(perfil);
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
    public List<EPerfilRiesgoRPM> getAllDataPerfilTwo(WPerfilRiesgo perfilRiesgo) throws Exception {
       Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;

        List<EPerfilRiesgoRPM> listE = new ArrayList<>();
        try {

            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spGetPerfilRiesgoPart2(?, ?, ?, ?, ?, ?)}");

            String NumAlianza = null;

            for (WSelectItem matriz : perfilRiesgo.getMatriz()) {
                if (matriz.getId().equals("-1")) {
                    NumAlianza = null;
                } else {
                    NumAlianza = matriz.getId();
                }
            }

            cstm.setString(1, ("-1".equals(perfilRiesgo.getCiudad().getName()) ? null : perfilRiesgo.getCiudad().getName()));
            cstm.setInt(2, perfilRiesgo.getEdadMinimo());
            cstm.setInt(3, perfilRiesgo.getEdadMaximo());
            cstm.setString(4, ("-1".equals(perfilRiesgo.getTipoContrato().getId()) ? null : perfilRiesgo.getTipoContrato().getName().substring(0,0)));
            cstm.setString(5, NumAlianza);
            cstm.setString(6, ("-1".equals(perfilRiesgo.getSexo().getId()) ? null : perfilRiesgo.getSexo().getName()));
            
            //System.out.println(perfilRiesgo.getTipoContrato().getName().substring(0,1));
            
            rs = cstm.executeQuery();
            
            
            
            while (rs.next()) {
                EPerfilRiesgoRPM perfil = new EPerfilRiesgoRPM();

                perfil.setIdentificacion(rs.getString("Identificacion"));
                perfil.setIdGrupoRiesgo(rs.getString("IdGrupoRiesgo"));
                perfil.setDescripcion(rs.getString("Descripcion"));
                perfil.setEdad(rs.getString("Edad"));
                perfil.setSexo(rs.getString("Sexo"));

                listE.add(perfil);
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

}
