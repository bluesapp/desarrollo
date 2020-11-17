/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

/**
 *
 * @author jorgelp
 */
public class ECronicosLoad {
    
    
  private String Tipo; 
  private String NumeroIdentificacion;
  private String Nombre;
  private String ColectivoAlianza;
  private String Telefono;
  private String Direccion;
  private String edad;

    public ECronicosLoad(String edad,String Tipo, String NumeroIdentificacion, String Nombre, String ColectivoAlianza, String Telefono, String Direccion) {
        this.Tipo = Tipo;
        this.NumeroIdentificacion = NumeroIdentificacion;
        this.Nombre = Nombre;
        this.ColectivoAlianza = ColectivoAlianza;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.edad = edad;
    }
    
   

    public ECronicosLoad() {
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public void setNumeroIdentificacion(String NumeroIdentificacion) {
        this.NumeroIdentificacion = NumeroIdentificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getColectivoAlianza() {
        return ColectivoAlianza;
    }

    public void setColectivoAlianza(String ColectivoAlianza) {
        this.ColectivoAlianza = ColectivoAlianza;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
  
  
  
}
