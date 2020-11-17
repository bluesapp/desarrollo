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
public class TipoLaboratorio {
    
    private Integer id;
    private String nombre;
    private String condicional;
    private String valorCondion;
    private String condicionalEntera;

    public TipoLaboratorio() {
    }

    public TipoLaboratorio(Integer id, String nombre, String condicional, String valorCondion, String condicionalEntera) {
        this.id = id;
        this.nombre = nombre;
        this.condicional = condicional;
        this.valorCondion = valorCondion;
        this.condicionalEntera = condicionalEntera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondicional() {
        return condicional;
    }

    public void setCondicional(String condicional) {
        this.condicional = condicional;
    }

    public String getValorCondion() {
        return valorCondion;
    }

    public void setValorCondion(String valorCondion) {
        this.valorCondion = valorCondion;
    }

    public String getCondicionalEntera() {
        return condicionalEntera;
    }

    public void setCondicionalEntera(String condicionalEntera) {
        this.condicionalEntera = condicionalEntera;
    }
   
    
}
