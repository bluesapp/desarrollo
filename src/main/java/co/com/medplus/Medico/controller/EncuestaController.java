
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.EncuestaDao;
import co.com.medplus.Medico.wrapper.EncuestaResponse;
import java.util.List;
import co.com.medplus.Medico.entities.core.EncuestaLoad;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JorgeLP
 */
@Controller
public class EncuestaController {
    
    @Autowired
    private EncuestaDao encuestaDao;
    
    public List<EncuestaResponse> cargueEncuesta(List<EncuestaLoad> encuestas, String idEncuesta){
        
        List<EncuestaResponse> encuestasResponses = new ArrayList<>();
        
        encuestas.forEach((encuesta) ->{
          //String fechaAplicacion, String identificacion, String interpretacion, String nombreDeLaEncuesta, String resultado
            EncuestaResponse respo = new EncuestaResponse(encuesta);
            
            try{
               ResponseCargueSp resultDB = this.encuestaDao.saveEncuesta(encuesta,idEncuesta);
               respo.setMensaje(resultDB.getMensaje());
               respo.setEstado(resultDB.getEstado());
                
            }catch(Exception ex){
                respo.setMensaje(ex.getMessage());
                respo.setEstado(Boolean.FALSE);
            }
            
            encuestasResponses.add(respo);
        
        }); 
       return encuestasResponses; 
    }
    
}
