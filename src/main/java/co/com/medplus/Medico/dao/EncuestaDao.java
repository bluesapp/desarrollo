package co.com.medplus.Medico.dao;

import co.com.medplus.Medico.entities.core.EncuestaLoad;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import java.sql.SQLException;

/**
 *
 * @author JorgeLP
 */
public interface EncuestaDao {
    
    public ResponseCargueSp saveEncuesta(EncuestaLoad load,String idEncuesta) throws SQLException;
    
}
