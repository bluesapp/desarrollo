/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.Cie10Dao;
import co.com.medplus.Medico.entities.core.ECie10;
import co.com.medplus.Medico.entities.core.EListas;
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
public class Cie10DaoJdbc implements Cie10Dao {
    
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    
    @Override
    public List<ECie10> consultaCie10(int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<ECie10> ls = new ArrayList<ECie10>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCie10(?)}");
                        cstm.setInt(1, idClasificacion);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {

				ECie10 li = new ECie10();

				li.setIdCie10(rs.getInt("IdCie10"));
				li.setDescripcion(rs.getString("Descripcion"));
				li.setCodigo(rs.getString("Codigo"));
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
    public List<EListas> consultaClasificaciones() throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EListas> ls = new ArrayList<EListas>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCie10Clasificaciones()}");

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
    public List<ECie10> consultaCie10XClasificacion(int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<ECie10> ls = new ArrayList<ECie10>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaCie10XClasificacion(?)}");
                        cstm.setInt(1, idClasificacion);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {

				ECie10 li = new ECie10();

				li.setIdCie10(rs.getInt("IdCie10"));
				li.setDescripcion(rs.getString("Descripcion"));
				li.setCodigo(rs.getString("Codigo"));
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
    public boolean adicionarCie10Clasificacion(ECie10 eCie10, String idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spAdicionarCie10Clasificacion(?,?)}");
			cstm.setString(1, eCie10.getCodigo());
                        cstm.setString(2, idClasificacion);
		
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
    
    
    @Override
    public boolean eliminarCie10Clasificacion(String codigo, int idClasificacion) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spEliminarCie10Clasificacion(?,?)}");
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
