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
public class LaboratorioReturn {
    
    
    private String examen;
    private String identificacion;
    private String resultado;
    private String fechaHoraIngreso;
    private String nota;
    private Boolean estado;
    private String mensaje;

    public LaboratorioReturn() {
    }

    public LaboratorioReturn(String examen, String identificacion, String resultado, String fechaHoraIngreso, Boolean estado, String mensaje) {
        this.examen = examen;
        this.identificacion = identificacion;
        this.resultado = resultado;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public LaboratorioReturn(String examen, String identificacion, String resultado, String fechaHoraIngreso, String nota) {
        this.examen = examen;
        this.identificacion = identificacion;
        this.resultado = resultado;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.nota = nota;
    }
    
    
    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(String fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
    
    
}
