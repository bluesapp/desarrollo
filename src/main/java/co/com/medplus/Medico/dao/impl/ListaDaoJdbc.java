/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.ListaDao;
import co.com.medplus.Medico.entities.core.EListas;
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
 * @author MarioF
 */
@Repository
public class ListaDaoJdbc implements ListaDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    @Override
    public List<EListas> consultaTablaLista(String nombreTabla) throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EListas> ls = new ArrayList<EListas>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaTablasLista(?)}");
                        cstm.setString(1, nombreTabla);

			rs = cstm.executeQuery();

			while (rs.next()) {

				EListas li = new EListas();

				li.setValor(rs.getString("ValorCampo"));
				li.setTexto(rs.getString("NombreCampo"));
				
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
    public List<EListas> obtenerAlianzaOMatriz(Integer idTipoContrato) throws Exception{
        
        List<EListas> lista = new ArrayList<>();
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spConsultaAlianzaMatriz (?)}");
            cstm.setInt("idTipoContrato", idTipoContrato);
            
            rs = cstm.executeQuery();
            
            while(rs.next()){
               EListas li = new EListas();

	       li.setValor(rs.getString("ValorCampo"));
	       li.setTexto(rs.getString("NombreCampo"));
               
               lista.add(li);
            }
            return lista;
            
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
