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
public class LaboratorioLoad {
    
    private String examen;
    private String identificacion;
    private String resultado;
    private String fechaHoraIngreso;
    private String nota;

    public LaboratorioLoad() {
    }

    public LaboratorioLoad(String examen, String identificacion, String resultado, String fechaHoraIngreso) {
        this.examen = examen;
        this.identificacion = identificacion;
        this.resultado = resultado;
        this.fechaHoraIngreso = fechaHoraIngreso;
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
        return resultado.replace(">","").replace("<","").replace("=","").replace("==","").replace(" ","");
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

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
}
