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
public class EIndicadores {
    
    private String indicador;
    private String resultadoPanacea;
    private String resultadoManual;

    /**
     * @return the indicador
     */
    public String getIndicador() {
        return indicador;
    }

    /**
     * @param indicador the indicador to set
     */
    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    /**
     * @return the resultadoPanacea
     */
    public String getResultadoPanacea() {
        return resultadoPanacea;
    }

    /**
     * @param resultadoPanacea the resultadoPanacea to set
     */
    public void setResultadoPanacea(String resultadoPanacea) {
        this.resultadoPanacea = resultadoPanacea;
    }

    /**
     * @return the resultadoManual
     */
    public String getResultadoManual() {
        return resultadoManual;
    }

    /**
     * @param resultadoManual the resultadoManual to set
     */
    public void setResultadoManual(String resultadoManual) {
        this.resultadoManual = resultadoManual;
    }
    
}
