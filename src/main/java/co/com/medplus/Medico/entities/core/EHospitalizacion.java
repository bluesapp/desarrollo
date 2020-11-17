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
public class EHospitalizacion {
    
    private String identificacion;
    private String descripcion;
    private int ingresos;
    private String ingresosTexto;
    
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
     * @return the ingresos
     */
    public int getIngresos() {
        return ingresos;
    }

    /**
     * @param ingresos the ingresos to set
     */
    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    /**
     * @return the ingresosTexto
     */
    public String getIngresosTexto() {
        return ingresosTexto;
    }

    /**
     * @param ingresosTexto the ingresosTexto to set
     */
    public void setIngresosTexto(String ingresosTexto) {
        this.ingresosTexto = ingresosTexto;
    }

    
}
