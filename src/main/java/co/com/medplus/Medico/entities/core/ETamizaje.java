/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

/**
 *
 * @author MarioF
 */
public class ETamizaje {
 
    private String identificacion;
    private String descripcion;
    private String ultimaToma;

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the ultimaToma
     */
    public String getUltimaToma() {
        return ultimaToma;
    }

    /**
     * @param ultimaToma the ultimaToma to set
     */
    public void setUltimaToma(String ultimaToma) {
        this.ultimaToma = ultimaToma;
    }
    
}
