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
public class ECie10 {

    private int idCie10;
    private String codigo;
    private String descripcion;
    private short idGrupoRiesgo;
    private String estado;

    /**
     * @return the idCie10
     */
    public int getIdCie10() {
        return idCie10;
    }

    /**
     * @param idCie10 the idCie10 to set
     */
    public void setIdCie10(int idCie10) {
        this.idCie10 = idCie10;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
     * @return the idGrupoRiesgo
     */
    public short getIdGrupoRiesgo() {
        return idGrupoRiesgo;
    }

    /**
     * @param idGrupoRiesgo the idGrupoRiesgo to set
     */
    public void setIdGrupoRiesgo(short idGrupoRiesgo) {
        this.idGrupoRiesgo = idGrupoRiesgo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
