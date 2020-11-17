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
public class EPoblacionObjeto {
 
    private int IdPoblacionObjeto;
    private String Codigo;
    private String Descripcion;
    private int IdTipoRiesgo;
    private String TipoRiesgo;
    private int IdViaComunicacion;
    private String ViaComunicacion;
    private int IdAreaResponsable;
    private String AreaResponsable;
    private String Estado;
    private boolean Activo;

    /**
     * @return the IdPoblacionObjeto
     */
    public int getIdPoblacionObjeto() {
        return IdPoblacionObjeto;
    }

    /**
     * @param IdPoblacionObjeto the IdPoblacionObjeto to set
     */
    public void setIdPoblacionObjeto(int IdPoblacionObjeto) {
        this.IdPoblacionObjeto = IdPoblacionObjeto;
    }

    /**
     * @return the Codigo
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * @param Codigo the Codigo to set
     */
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the IdTipoRiesgo
     */
    public int getIdTipoRiesgo() {
        return IdTipoRiesgo;
    }

    /**
     * @param IdTipoRiesgo the IdTipoRiesgo to set
     */
    public void setIdTipoRiesgo(int IdTipoRiesgo) {
        this.IdTipoRiesgo = IdTipoRiesgo;
    }

    /**
     * @return the TipoRiesgo
     */
    public String getTipoRiesgo() {
        return TipoRiesgo;
    }

    /**
     * @param TipoRiesgo the TipoRiesgo to set
     */
    public void setTipoRiesgo(String TipoRiesgo) {
        this.TipoRiesgo = TipoRiesgo;
    }

    /**
     * @return the IdViaComunicacion
     */
    public int getIdViaComunicacion() {
        return IdViaComunicacion;
    }

    /**
     * @param IdViaComunicacion the IdViaComunicacion to set
     */
    public void setIdViaComunicacion(int IdViaComunicacion) {
        this.IdViaComunicacion = IdViaComunicacion;
    }

    /**
     * @return the ViaComunicacion
     */
    public String getViaComunicacion() {
        return ViaComunicacion;
    }

    /**
     * @param ViaComunicacion the ViaComunicacion to set
     */
    public void setViaComunicacion(String ViaComunicacion) {
        this.ViaComunicacion = ViaComunicacion;
    }

    /**
     * @return the IdAreaResponsable
     */
    public int getIdAreaResponsable() {
        return IdAreaResponsable;
    }

    /**
     * @param IdAreaResponsable the IdAreaResponsable to set
     */
    public void setIdAreaResponsable(int IdAreaResponsable) {
        this.IdAreaResponsable = IdAreaResponsable;
    }

    /**
     * @return the AreaResponsable
     */
    public String getAreaResponsable() {
        return AreaResponsable;
    }

    /**
     * @param AreaResponsable the AreaResponsable to set
     */
    public void setAreaResponsable(String AreaResponsable) {
        this.AreaResponsable = AreaResponsable;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Activo
     */
    public boolean isActivo() {
        return Activo;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }
    
    
}
