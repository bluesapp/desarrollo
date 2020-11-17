/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

/**
 *
 * @author JorgeLP
 */
public class WGestanteWrapper {
  
    private Integer id;
    private String nombre;
    private String documento_madre;
    private String tipo_documento;
    private Integer semana;
    private String sexo;
    private String fecha_creado;
    private String fecha_actualizado;
    private Boolean nacido_vivo;
    private Boolean gestante;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento_madre() {
        return documento_madre;
    }

    public void setDocumento_madre(String documento_madre) {
        this.documento_madre = documento_madre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_creado() {
        return fecha_creado;
    }

    public void setFecha_creado(String fecha_creado) {
        this.fecha_creado = fecha_creado;
    }

    public String getFecha_actualizado() {
        return fecha_actualizado;
    }

    public void setFecha_actualizado(String fecha_actualizado) {
        this.fecha_actualizado = fecha_actualizado;
    }

    public Boolean getNacido_vivo() {
        return nacido_vivo;
    }

    public void setNacido_vivo(Boolean nacido_vivo) {
        this.nacido_vivo = nacido_vivo;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
