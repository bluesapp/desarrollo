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
public class WInducedDemandWrapper {
    
    //*** Cohorte o sub-cohorte	Cohorte o sub-cohorte para la que se está generando la demanda inducida
    private String cohorte;
    //*** Tipo Identificación	Tipo de identificación del usuario con riesgo detectado
    private String identificationType;
    //*** Identificación	Número de identificación del usuario con posible riesgo detectado 
    private String identification;
    //*** Nombres y apellidos 	Nombres y apellidos del usuario con posible riesgo detectado 
    private String fullName;
    //*** Estado	Estado del usuario, no incluir usuarios inactivos por fallecimiento (base mortalidad audita y cancelaciones)
    private String state;
    //*** Fecha de Nacimiento	Fecha de nacimiento del usuario
    private String bornDate;
    //*** Edad	Edad del usuario
    private String age;
    //*** Sexo	Sexo del usuario F Femenino o M Masculino
    private String sex;
    //*** Grupo Quinquenal	Grupo quinquenal al que pertenezca 
    private String quinquenialGroup;
    //*** Ciudad	Ciudad del contrato 
    private String city;
    //*** Contrato	Número del contrato
    private String contractNumber;
    //*** Tipo Contrato C Colectivo  F Familiar  A Alianza
    private String contractType;
    //*** Tipo Usuario	Tipo usuario Contratante o Beneficiario
    private String userType;
    //*** Matriz	Código de la matriz o alianza
    private String matrizCode;
    //*** Nombre	Nombre de la matriz o alianza 
    private String matrizName;
    //*** Nombre Plan	Nombre del plan
    private String planName;
    //*** Teléfono	Número de teléfono fijo
    private String phoneNumber;
    //*** Celular	Número de teléfono celular 
    private String mobile;
    //*** EPS	Nombre de la Eps del usuario
    private String epsName;
    //Periodo	Periodo en le que se genera el reporte 
    private String period;
    //CodDI	Si se generó para demanda inducida el código con cual se generó la demanda anexo 
    private String inducedDemandCode;
    /**
     * @return the cohorte
     */
    public String getCohorte() {
        return cohorte;
    }

    /**
     * @param cohorte the cohorte to set
     */
    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    /**
     * @return the identificationType
     */
    public String getIdentificationType() {
        return identificationType;
    }

    /**
     * @param identificationType the identificationType to set
     */
    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

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
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the bornDate
     */
    public String getBornDate() {
        return bornDate;
    }

    /**
     * @param bornDate the bornDate to set
     */
    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the quinquenialGroup
     */
    public String getQuinquenialGroup() {
        return quinquenialGroup;
    }

    /**
     * @param quinquenialGroup the quinquenialGroup to set
     */
    public void setQuinquenialGroup(String quinquenialGroup) {
        this.quinquenialGroup = quinquenialGroup;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * @return the contractType
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * @param contractType the contractType to set
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the matrizCode
     */
    public String getMatrizCode() {
        return matrizCode;
    }

    /**
     * @param matrizCode the matrizCode to set
     */
    public void setMatrizCode(String matrizCode) {
        this.matrizCode = matrizCode;
    }

    /**
     * @return the matrizName
     */
    public String getMatrizName() {
        return matrizName;
    }

    /**
     * @param matrizName the matrizName to set
     */
    public void setMatrizName(String matrizName) {
        this.matrizName = matrizName;
    }

    /**
     * @return the planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the epsName
     */
    public String getEpsName() {
        return epsName;
    }

    /**
     * @param epsName the epsName to set
     */
    public void setEpsName(String epsName) {
        this.epsName = epsName;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * @return the inducedDemandCode
     */
    public String getInducedDemandCode() {
        return inducedDemandCode;
    }

    /**
     * @param inducedDemandCode the inducedDemandCode to set
     */
    public void setInducedDemandCode(String inducedDemandCode) {
        this.inducedDemandCode = inducedDemandCode;
    }

}
