/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

/**
 *
 * @author JorgeLP
 */
public class CupRelacion {
    
    private Integer id;
    private String descripcion;
    private String cupUno;
    private String cupDos;
    private Integer idArray;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCupUno() {
        return cupUno;
    }

    public void setCupUno(String cupUno) {
        this.cupUno = cupUno;
    }

    public String getCupDos() {
        return cupDos;
    }

    public void setCupDos(String cupDos) {
        this.cupDos = cupDos;
    }

    public Integer getIdArray() {
        return idArray;
    }

    public void setIdArray(Integer idArray) {
        this.idArray = idArray;
    }
    
    
    
    
   
}
