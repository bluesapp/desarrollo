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
public class EGrupoRiesgo {
    
    private int idGrupoRiesgo;
    private String descripcion;
    private String posible;
    private String confirmado;
    private String codigoFecha;
    private String prestador;

    /**
     * @return the idGrupoRiesgo
     */
    public int getIdGrupoRiesgo() {
        return idGrupoRiesgo;
    }

    /**
     * @param idGrupoRiesgo the idGrupoRiesgo to set
     */
    public void setIdGrupoRiesgo(int idGrupoRiesgo) {
        this.idGrupoRiesgo = idGrupoRiesgo;
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
     * @return the posible
     */
    public String getPosible() {
        return posible;
    }

    /**
     * @param posible the posible to set
     */
    public void setPosible(String posible) {
        this.posible = posible;
    }

    /**
     * @return the confirmado
     */
    public String getConfirmado() {
        return confirmado;
    }

    /**
     * @param confirmado the confirmado to set
     */
    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * @return the codigoFecha
     */
    public String getCodigoFecha() {
        return codigoFecha;
    }

    /**
     * @param codigoFecha the codigoFecha to set
     */
    public void setCodigoFecha(String codigoFecha) {
        this.codigoFecha = codigoFecha;
    }

    /**
     * @return the prestador
     */
    public String getPrestador() {
        return prestador;
    }

    /**
     * @param prestador the prestador to set
     */
    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }
    
    
}
