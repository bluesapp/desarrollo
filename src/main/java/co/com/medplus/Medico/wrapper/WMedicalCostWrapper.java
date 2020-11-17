/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

/**
 *
 * @author MarioF
 */
public class WMedicalCostWrapper {

    private String identification;
    private String radicado;
    private double income;
    private String incomeText;

    /**
     * @return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the radicado
     */
    public String getRadicado() {
        return radicado;
    }

    /**
     * @param radicado the radicado to set
     */
    public void setRadicado(String radicado) {
        this.radicado = radicado;
    }

    /**
     * @return the income
     */
    public double getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(double income) {
        this.income = income;
    }

    /**
     * @return the incomeText
     */
    public String getIncomeText() {
        return incomeText;
    }

    /**
     * @param incomeText the incomeText to set
     */
    public void setIncomeText(String incomeText) {
        this.incomeText = incomeText;
    }
    
}
