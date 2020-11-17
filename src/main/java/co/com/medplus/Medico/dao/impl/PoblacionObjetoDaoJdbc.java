/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.PoblacionObjetoDao;
import co.com.medplus.Medico.entities.core.EPoblacionObjeto;
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
public class PoblacionObjetoDaoJdbc implements PoblacionObjetoDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    @Override
    public List<EPoblacionObjeto> consultaPoblacionObjetoXTipoRiesgo(int idTipoRiesgo) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EPoblacionObjeto> ls = new ArrayList<EPoblacionObjeto>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaPoblacionObjetoXTipoRiesgo(?)}");
                        cstm.setInt(1, idTipoRiesgo);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {

				EPoblacionObjeto li = new EPoblacionObjeto();

				li.setIdPoblacionObjeto(rs.getInt("IdPoblacionObjeto"));
				li.setCodigo(rs.getString("Codigo"));
				li.setDescripcion(rs.getString("Descripcion"));
                                li.setIdTipoRiesgo(rs.getInt("IdTipoRiesgo"));
                                li.setTipoRiesgo(rs.getString("TipoRiesgo"));
                                li.setIdViaComunicacion(rs.getInt("IdViaComunicacion"));
                                li.setViaComunicacion(rs.getString("ViaComunicacion"));
                                li.setIdAreaResponsable(rs.getInt("IdAreaResponsable"));
                                li.setAreaResponsable(rs.getString("AreaResponsable"));
                                li.setEstado(rs.getString("Estado"));
                                if (rs.getInt("Activo") == 1){
                                    li.setActivo(true);
                                }
                                else {
                                    li.setActivo(false);
                                }
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
    public boolean adicionarPoblacionObjeto(EPoblacionObjeto ePoblacionObjeto) throws Exception{
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spAdicionarPoblacionObjeto(?,?,?,?,?,?)}");
			cstm.setString(1, ePoblacionObjeto.getCodigo());
                        cstm.setString(2, ePoblacionObjeto.getDescripcion());
                        cstm.setInt(3, ePoblacionObjeto.getIdTipoRiesgo());
                        cstm.setInt(4, ePoblacionObjeto.getIdViaComunicacion());
                        cstm.setInt(5, ePoblacionObjeto.getIdAreaResponsable());
                        if (ePoblacionObjeto.isActivo()){
                            cstm.setString(6, "A");
                        }
                        else {
                            cstm.setString(6, "I");                            
                        }
                        
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
    public boolean editarPoblacionObjeto(EPoblacionObjeto ePoblacionObjeto) throws Exception{
        
        
        Connection conn = this.dataSource.getConnection();
       	boolean bRespuesta = true;
        
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spEditarPoblacionObjeto(?,?,?,?,?,?,?)}");
                        cstm.setInt(1, ePoblacionObjeto.getIdPoblacionObjeto());
			cstm.setString(2, ePoblacionObjeto.getCodigo());
                        cstm.setString(3, ePoblacionObjeto.getDescripcion());
                        cstm.setInt(4, ePoblacionObjeto.getIdTipoRiesgo());
                        cstm.setInt(5, ePoblacionObjeto.getIdViaComunicacion());
                        cstm.setInt(6, ePoblacionObjeto.getIdAreaResponsable());
                        if (ePoblacionObjeto.isActivo()){
                            cstm.setString(7, "A");
                        }
                        else {
                            cstm.setString(7, "I");                            
                        }
		
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
