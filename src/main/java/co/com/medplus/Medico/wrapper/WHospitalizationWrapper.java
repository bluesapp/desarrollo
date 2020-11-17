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
public class WHospitalizationWrapper {
    
    private String identification;
    private String description;
    private int income;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the income
     */
    public int getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(int income) {
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
