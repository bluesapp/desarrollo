/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.CupsDao;
import co.com.medplus.Medico.entities.core.ECups;
import co.com.medplus.Medico.entities.core.EListas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
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
public class CupsDaoJdbc implements CupsDao {

    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    
    @Override
    public List<ECups> consultaCups(int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs ;

		List<ECups> ls = new ArrayList<>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCups(?)}");
                        cstm.setInt(1, idClasificacion);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {

				ECups li = new ECups();

				li.setIdCups(rs.getInt("IdCups"));
				li.setDescripcion(rs.getString("Descripcion"));
				li.setCodigo(rs.getString("Codigo"));
				ls.add(li);
			}

			return ls;
        } catch (Exception e) {
            
			throw e;
        } finally {

                try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                    throw e;
                }
        }
    }
    
    @Override
    public List<EListas> consultaClasificaciones() throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs ;

		List<EListas> ls = new ArrayList<>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCupsClasificaciones()}");

			rs = cstm.executeQuery();

			while (rs.next()) {

				EListas li = new EListas();

				li.setValor(rs.getString("ValorCampo"));
				li.setTexto(rs.getString("NombreCampo"));
				
				ls.add(li);
			}

			return ls;
        } catch (Exception e) {
            
			throw e;
        } finally {

                if (cstm != null){
                     cstm.close();
                }
                if (conn != null){
                     conn.close();
                }
        }
        
    }
    
    @Override
    public List<ECups> consultaCupsXClasificacion(int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs;

		List<ECups> ls = new ArrayList<>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCupsXClasificacion(?)}");
                        cstm.setInt(1, idClasificacion);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {

				ECups li = new ECups();

				li.setIdCups(rs.getInt("IdCups"));
				li.setDescripcion(rs.getString("Descripcion"));
				li.setCodigo(rs.getString("Codigo"));
				ls.add(li);
			}

			return ls;
        } catch (Exception e) {
			throw new Exception("No se encontraron Cups para esta cohorte");
        } finally {
                if (cstm != null){
                     cstm.close();
                }
                if (conn != null){
                     conn.close();
                }
       }
    }
    
    @Override
    public boolean adicionarCupsClasificacion(ECups eCups, String idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spAdicionarCupsClasificacion(?,?)}");
			cstm.setString(1, eCups.getCodigo());
                        cstm.setString(2, idClasificacion);
		
			cstm.execute();
                        
        } catch(Exception e){
            
            bRespuesta = false;
            throw e;
            
        } finally {
            
             try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                }
        }
                
                return bRespuesta;
        
    }
    
    
    @Override
    public boolean eliminarCupsClasificacion(String codigo, int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spEliminarCupsClasificacion(?,?)}");
			cstm.setString(1, codigo);
                        cstm.setInt(2, idClasificacion);
		
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
