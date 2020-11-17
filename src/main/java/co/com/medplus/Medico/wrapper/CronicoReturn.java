/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

import co.com.medplus.Medico.entities.core.ECronicosLoad;

/**
 *
 * @author jorgelp
 */
public class CronicoReturn {
    
    
  private String tipo;
  private String numeroIdentificacion ;
  private String nombre;
  private String colectivoAlianza;
  private String telefono;
  private String direccion;
  private Boolean estado;
  private String mensaje;
  private String edad;

    public CronicoReturn() {
    }

    public CronicoReturn(String edad,String tipo, String numeroIdentificacion, String nombre, String colectivoAlianza, String telefono, String direccion, Boolean estado, String mensaje) {
        this.tipo = tipo;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.colectivoAlianza = colectivoAlianza;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.mensaje = mensaje;
        this.edad = edad;
    }
    
     public void llenarCronicoReturn(ECronicosLoad cronico){
      this.tipo = cronico.getTipo();
      this.numeroIdentificacion = cronico.getNumeroIdentificacion();
      this.nombre = cronico.getNombre();
      this.colectivoAlianza = cronico.getColectivoAlianza();
      this.telefono = cronico.getTelefono();
      this.direccion = cronico.getDireccion();
      this.edad = cronico.getEdad();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColectivoAlianza() {
        return colectivoAlianza;
    }

    public void setColectivoAlianza(String colectivoAlianza) {
        this.colectivoAlianza = colectivoAlianza;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
  
  
  
    
}
