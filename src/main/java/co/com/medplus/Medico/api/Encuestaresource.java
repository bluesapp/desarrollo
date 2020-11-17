package co.com.medplus.Medico.api;


import co.com.medplus.Medico.controller.EncuestaController;
import co.com.medplus.Medico.wrapper.EncuestaResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.medplus.Medico.entities.core.EncuestaLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author JorgeLP 
 */
@RestController
@RequestMapping("/encuesta")
public class Encuestaresource {
    
    @Autowired
    private EncuestaController encuestaController;
    
    
    @RequestMapping(value = {"/load/list/{idEncuesta}"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EncuestaResponse>> loadEncuesta(@Valid @RequestBody List<EncuestaLoad> encuestas, @Valid @PathVariable String idEncuesta) throws Exception{
        
        if(encuestas.isEmpty()){
            throw new Exception("Lista de Encuestas Vacias");
        }
        
        List<EncuestaResponse> encuestaResponses = this.encuestaController.cargueEncuesta(encuestas,idEncuesta);
        
        if(encuestaResponses.isEmpty()){
            throw new Exception("No se obtuvieron resultados");
        }
        
        return new ResponseEntity<>(encuestaResponses,HttpStatus.OK);
    }
	
    
}
