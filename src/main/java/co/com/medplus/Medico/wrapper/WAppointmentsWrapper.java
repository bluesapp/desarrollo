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
public class WAppointmentsWrapper {
    
    private String identification;
    private String specialty;
    private String lastConsultation;
    private String professional;

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
     * @return the specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * @param specialty the specialty to set
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * @return the lastConsultation
     */
    public String getLastConsultation() {
        return lastConsultation;
    }

    /**
     * @param lastConsultation the lastConsultation to set
     */
    public void setLastConsultation(String lastConsultation) {
        this.lastConsultation = lastConsultation;
    }

    /**
     * @return the professional
     */
    public String getProfessional() {
        return professional;
    }

    /**
     * @param professional the professional to set
     */
    public void setProfessional(String professional) {
        this.professional = professional;
    }
    
    
}
