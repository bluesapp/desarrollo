/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JorgeLP
 */
public class WLaboratoryConsult {
    
    private String documento;
    private List<DatoGenerico> datos;
    
    public WLaboratoryConsult(){
        this.datos = new ArrayList<DatoGenerico>();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<DatoGenerico> getDatos() {
        return datos;
    }

    public void setDatos(List<DatoGenerico> datos) {
        this.datos = datos;
    }
    
    
    
}
