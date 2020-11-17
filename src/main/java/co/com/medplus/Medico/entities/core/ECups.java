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
public class ECups {

    private int idCups;
    private String codigo;
    private String descripcion;
    private short oxigenoRequiriente;
    private short hospitalizacion;
    private String estado;

    /**
     * @return the idCups
     */
    public int getIdCups() {
        return idCups;
    }

    /**
     * @param idCups the idCups to set
     */
    public void setIdCups(int idCups) {
        this.idCups = idCups;
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
     * @return the oxigenoRequiriente
     */
    public short getOxigenoRequiriente() {
        return oxigenoRequiriente;
    }

    /**
     * @param oxigenoRequiriente the oxigenoRequiriente to set
     */
    public void setOxigenoRequiriente(short oxigenoRequiriente) {
        this.oxigenoRequiriente = oxigenoRequiriente;
    }

    /**
     * @return the hospitalizacion
     */
    public short getHospitalizacion() {
        return hospitalizacion;
    }

    /**
     * @param hospitalizacion the hospitalizacion to set
     */
    public void setHospitalizacion(short hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
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
