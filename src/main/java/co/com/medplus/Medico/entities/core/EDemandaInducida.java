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
public class EDemandaInducida {
    
//*** Cohorte o sub-cohorte	Cohorte o sub-cohorte para la que se está generando la demanda inducida
private String cohorte;
//*** Tipo Identificación	Tipo de identificación del usuario con riesgo detectado
private String tipoIdentificacion;
//*** Identificación	Número de identificación del usuario con posible riesgo detectado 
private String identificacion;
//*** Nombres y apellidos 	Nombres y apellidos del usuario con posible riesgo detectado 
private String nombreCompleto;
//*** Estado	Estado del usuario, no incluir usuarios inactivos por fallecimiento (base mortalidad audita y cancelaciones)
private String estado;
//*** Fecha de Nacimiento	Fecha de nacimiento del usuario
private String fechaNacimiento;
//*** Edad	Edad del usuario
private String edad;
//*** Sexo	Sexo del usuario F Femenino o M Masculino
private String sexo;
//*** Grupo Quinquenal	Grupo quinquenal al que pertenezca 
private String grupoQuinquenal;
//*** Ciudad	Ciudad del contrato 
private String ciudad;
//*** Contrato	Número del contrato
private String numeroContrato;
//*** Tipo Contrato C Colectivo  F Familiar  A Alianza
private String tipoContrato;
//*** Tipo Usuario	Tipo usuario Contratante o Beneficiario
private String tipoUsuario;
//*** Matriz	Código de la matriz o alianza
private String codigoMatrizAlianza;
//*** Nombre	Nombre de la matriz o alianza 
private String nombreMatrizAlianza;
//*** Nombre Plan	Nombre del plan
private String nombrePlan;
//*** Teléfono	Número de teléfono fijo
private String telefono;
//*** Celular	Número de teléfono celular 
private String celular;
//*** EPS	Nombre de la Eps del usuario
private String nombreEps;

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
     * @return the tipoIdentificacion
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param tipoIdentificacion the tipoIdentificacion to set
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the edad
     */
    public String getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the grupoQuinquenal
     */
    public String getGrupoQuinquenal() {
        return grupoQuinquenal;
    }

    /**
     * @param grupoQuinquenal the grupoQuinquenal to set
     */
    public void setGrupoQuinquenal(String grupoQuinquenal) {
        this.grupoQuinquenal = grupoQuinquenal;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the numeroContrato
     */
    public String getNumeroContrato() {
        return numeroContrato;
    }

    /**
     * @param numeroContrato the numeroContrato to set
     */
    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    /**
     * @return the tipoContrato
     */
    public String getTipoContrato() {
        return tipoContrato;
    }

    /**
     * @param tipoContrato the tipoContrato to set
     */
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return the codigoMatriz
     */
    public String getCodigoMatrizAlianza() {
        return codigoMatrizAlianza;
    }

    /**
     * @param codigoMatrizAlianza the codigoMatriz to set
     */
    public void setCodigoMatrizAlianza(String codigoMatrizAlianza) {
        this.codigoMatrizAlianza = codigoMatrizAlianza;
    }

    /**
     * @return the nombreMatriz
     */
    public String getNombreMatrizAlianza() {
        return nombreMatrizAlianza;
    }

    /**
     * @param nombreMatrizAlianza the nombreMatriz to set
     */
    public void setNombreMatrizAlianza(String nombreMatrizAlianza) {
        this.nombreMatrizAlianza = nombreMatrizAlianza;
    }

    /**
     * @return the nombrePlan
     */
    public String getNombrePlan() {
        return nombrePlan;
    }

    /**
     * @param nombrePlan the nombrePlan to set
     */
    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the nombreEps
     */
    public String getNombreEps() {
        return nombreEps;
    }

    /**
     * @param nombreEps the nombreEps to set
     */
    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }


}
