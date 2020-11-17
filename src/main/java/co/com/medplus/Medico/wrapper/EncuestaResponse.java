/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;
import co.com.medplus.Medico.entities.core.EncuestaLoad;
/**
 *
 * @author JorgeLP
 */
public class EncuestaResponse {
    
    private String fechaDeAplicacion;
    private String identificacion;
    private String interpretacion;
    private String nombreDeLaEncuesta;
    private String resultado;
    private String mensaje;
    private Boolean estado;
    private String sexo;

    public EncuestaResponse(String fechaDeAplicacion, String identificacion, String interpretacion, String nombreDeLaEncuesta, String resultado, String mensaje, Boolean estado, String sexo) {
        this.fechaDeAplicacion = fechaDeAplicacion;
        this.identificacion = identificacion;
        this.interpretacion = interpretacion;
        this.nombreDeLaEncuesta = nombreDeLaEncuesta;
        this.resultado = resultado;
        this.mensaje = mensaje;
        this.estado = estado;
        this.sexo = sexo;
    }
    
    public EncuestaResponse(EncuestaLoad load) {
        this.fechaDeAplicacion = load.getFechaDeAplicacion();
        this.identificacion = load.getIdentificacion();
        this.interpretacion = load.getInterpretacion();
        this.nombreDeLaEncuesta = load.getNombreDeLaEncuesta();
        this.resultado = load.getResultado();
        this.sexo = load.getSexo();
       
    }
    
    public String getFechaAplicacion() {
        return fechaDeAplicacion;
    }

    public void setFechaAplicacion(String fechaDeAplicacion) {
        this.fechaDeAplicacion = fechaDeAplicacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    public String getNombreDeLaEncuesta() {
        return nombreDeLaEncuesta;
    }

    public void setNombreDeLaEncuesta(String nombreDeLaEncuesta) {
        this.nombreDeLaEncuesta = nombreDeLaEncuesta;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFechaDeAplicacion() {
        return fechaDeAplicacion;
    }

    public void setFechaDeAplicacion(String fechaDeAplicacion) {
        this.fechaDeAplicacion = fechaDeAplicacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
