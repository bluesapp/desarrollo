package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.EncuestaDao;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import co.com.medplus.Medico.entities.core.EncuestaLoad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author JorgeLP
 */
@Repository
public class EncuestaDaoJdbc implements EncuestaDao{
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
    
    @Override
    public ResponseCargueSp saveEncuesta(EncuestaLoad load,String idEncuesta) throws SQLException{
        
        ResponseCargueSp res = new ResponseCargueSp();
        
        Connection conn = null;
        CallableStatement cstm = null;
        
        try{
            conn = this.dataSource.getConnection();
            cstm = conn.prepareCall("{call spInsertaEncuesta (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstm.setString("Origen", "MANUAL");
            cstm.setString("Identificacion", load.getIdentificacion());
            cstm.setString("FechaEncuesta", load.getFechaDeAplicacion());
            cstm.setString("IdEncuesta", idEncuesta);
            cstm.setString("Encuesta", load.getNombreDeLaEncuesta());
            cstm.setString("Interpretracion", load.getInterpretacion());
            cstm.setString("resultado", load.getResultado());
            cstm.setString("sexo", load.getSexo());
            
            cstm.registerOutParameter("estado", Types.BIT);
            cstm.registerOutParameter("mensaje", Types.VARCHAR);
            cstm.execute();
            
            res.setEstado(cstm.getBoolean("estado"));
            res.setMensaje(cstm.getString("mensaje"));
            return res;
        }catch(SQLException ex){
            throw ex;
        }finally{
            if(!conn.isClosed()){
                conn.close();
            }
            if(!cstm.isClosed()){
                cstm.close();
            }
        }
    }
}
