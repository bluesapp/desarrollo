/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.LaboratorioDao;
import co.com.medplus.Medico.entities.core.ELaboratorio;
import co.com.medplus.Medico.entities.core.ELaboratoryResult;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.entities.core.TipoLaboratorio;
import co.com.medplus.Medico.wrapper.DatoGenerico;
import co.com.medplus.Medico.wrapper.LaboratorioLoad;
import co.com.medplus.Medico.wrapper.WLaboratoryConsult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class LaboratorioDaoJdbc implements LaboratorioDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    
    
    
    @Override
    public ResponseCargueSp saveLaboratio(LaboratorioLoad laboratorio,String alerta, Integer idLaboratorio) throws SQLException{
    
        Connection conn = null;
        CallableStatement cstm = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertarLaboratorio (?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            
            cstm.setString("identificacion", laboratorio.getIdentificacion());
            cstm.setInt("idLaboratorio",idLaboratorio);
            cstm.setString("laboratorio", laboratorio.getExamen());
            cstm.setString("resultado", laboratorio.getResultado());
            cstm.setString("fechaIngreso", laboratorio.getFechaHoraIngreso());
            cstm.setString("comentario", laboratorio.getNota());
            cstm.setString("alerta",alerta);
            
            cstm.registerOutParameter("mensajeRetorno", Types.VARCHAR);
            cstm.registerOutParameter("estado", Types.BIT);
            
            cstm.execute();
            
            ResponseCargueSp res = new ResponseCargueSp();
            res.setEstado(cstm.getBoolean("estado"));
            res.setMensaje(cstm.getString("mensajeRetorno"));
            
            return res;
            
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
            
        }
        
    }
    @Override
    public TipoLaboratorio obtenerVariablesalerta(String idLaboratorio) throws SQLException{
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        TipoLaboratorio tipoLaboratorio = null;
        try{
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spConsultarVariableAlertaLaboratorio (?)}");
            
            cstm.setInt("idTipoLaboratorio", Integer.parseInt(idLaboratorio));
            
            rs = cstm.executeQuery();
            
            while(rs.next()){
                tipoLaboratorio = new TipoLaboratorio();
                
                tipoLaboratorio.setCondicional(rs.getString("condicional"));
                tipoLaboratorio.setCondicionalEntera(rs.getString("condicionalEntera"));
                tipoLaboratorio.setId(rs.getInt("id"));
                tipoLaboratorio.setNombre(rs.getString("nombre"));
                tipoLaboratorio.setValorCondion(rs.getString("valorCondicion"));
            }
            
            return tipoLaboratorio;
            
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
    
    
    
    @Override
    public List<ELaboratorio> consultaLaboratorioXIdentificacion(String identificacion) throws Exception {
        
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<ELaboratorio> ls = new ArrayList<ELaboratorio>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaLaboratorioXIdentificacion(?)}");
                        cstm.setString(1, identificacion);

			rs = cstm.executeQuery();

			while (rs.next()) {

				ELaboratorio li = new ELaboratorio();

				li.setLaboratorio(rs.getString("Laboratorio"));
				li.setAlerta(rs.getString("Alerta"));
                                li.setResultado(rs.getString("Resultado"));
                                li.setComentario(rs.getString("Comentario"));
                                if (rs.getString("FechaIngreso")== null)
                                {
                                li.setFechaIngreso("");
                                }
                                else {
                                    li.setFechaIngreso(rs.getString("FechaIngreso"));
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
    public WLaboratoryConsult examenesXidentificacionApp(String numDocumento,Integer tipo) throws SQLException {
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
       WLaboratoryConsult consult = new WLaboratoryConsult();
       consult.setDocumento(numDocumento);
        try{
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spObtenerExamenApp (?, ?)}");
            
            cstm.setString("identificacion", numDocumento);
            cstm.setInt("tipoLaboratorio", tipo);
            
            rs = cstm.executeQuery();
            
            while(rs.next()){
                DatoGenerico dato = new DatoGenerico();
                
                dato.setFecha(rs.getString("fecha_creado"));
                dato.setCampoA(rs.getString("campoA"));
                dato.setCampoB(rs.getString("campoB"));
                dato.setCampoC(rs.getString("campoC"));
                
                consult.getDatos().add(dato);
            }
            
            return consult;            
            
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

    @Override
    public WLaboratoryConsult examenesXidentificacionApp(String numDocumento) throws SQLException {
        
        Connection conn = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        
       WLaboratoryConsult consult = new WLaboratoryConsult();
       consult.setDocumento(numDocumento);
        try{
            
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spConsultaLaboratorioXidentificacionApp (?)}");
            
            cstm.setString(1, numDocumento);
            
            rs = cstm.executeQuery();
            
            while(rs.next()){
                DatoGenerico dato = new DatoGenerico();
                
                dato.setFecha(rs.getString("fechaingreso"));
                dato.setCampoA(rs.getString("campo1"));
                dato.setCampoB(rs.getString("campo2"));
                dato.setCampoC(rs.getString("campo3"));
                
                consult.getDatos().add(dato);
            }
            
            return consult;            
            
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
    
    @Override
    public Boolean insertarLaboratorioApp(DatoGenerico datoGenerico,String identificacion,String tipoDocumento,Integer idLaboratorio) throws Exception{
        
        Connection conn = null;
        CallableStatement cstm = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertarLaboratorioConsultaApp (?, ?, ?, ?, ?)}");
            
            cstm.setString("identificacion", identificacion);
            cstm.setInt("idLaboratorio",idLaboratorio);
            cstm.setString("campoA", datoGenerico.getCampoA());
            cstm.setString("campoB", datoGenerico.getCampoB());
            cstm.setString("campoC", datoGenerico.getCampoC());
            
            cstm.execute();
            return true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            if(conn != null){
                if(!conn.isClosed()){
                    conn.close();
                }
                if(cstm != null){
                    if(!cstm.isClosed()){
                        cstm.close();
                    }
                }
            }
        }
        
    }
    
  
}
