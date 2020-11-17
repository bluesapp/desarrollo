/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.entities.core;

/**
 *
 * @author JeisonI
 */
public class EUser {
    
    private int idUsuario;
	private String nombre;
	private String apellido;
	private int idCiudadResidencia;
	private String ciudadResidencia;
	private int numeroContrato;
	private String cedula;
	private String usuario;
	private String estado;
	private int intentos;
	private boolean autenticado;
	private String tipoUsuario;
	private String tipoDocumento;
	private String tipoContrato;
	private String nombreTipoContrato;
	private String direccionResidencia;
	private String telefonoResidencia;
	private String email;
	private String nombreMatriz;
	private String numeroMatriz;
	private String plan;
	private String celular;
	private int digito;
	private String novedades;
	private String estadoRegistro;
	private String codDeptoMunicipioResidencia;
	private String direccionOficina;
	private String telefonoOficina;
	private String codDeptoOficina;
	private String ciudadOficina;
	private String envioCorrespondencia;
	private String carne;
	private String numBeneficiario;
	private String fechaNacimiento;
	private int edad;
	private String feautorization;	
        private String sexo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdCiudadResidencia() {
        return idCiudadResidencia;
    }

    public void setIdCiudadResidencia(int idCiudadResidencia) {
        this.idCiudadResidencia = idCiudadResidencia;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public void setNombreTipoContrato(String nombreTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreMatriz() {
        return nombreMatriz;
    }

    public void setNombreMatriz(String nombreMatriz) {
        this.nombreMatriz = nombreMatriz;
    }

    public String getNumeroMatriz() {
        return numeroMatriz;
    }

    public void setNumeroMatriz(String numeroMatriz) {
        this.numeroMatriz = numeroMatriz;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getCodDeptoMunicipioResidencia() {
        return codDeptoMunicipioResidencia;
    }

    public void setCodDeptoMunicipioResidencia(String codDeptoMunicipioResidencia) {
        this.codDeptoMunicipioResidencia = codDeptoMunicipioResidencia;
    }

    public String getDireccionOficina() {
        return direccionOficina;
    }

    public void setDireccionOficina(String direccionOficina) {
        this.direccionOficina = direccionOficina;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getCodDeptoOficina() {
        return codDeptoOficina;
    }

    public void setCodDeptoOficina(String codDeptoOficina) {
        this.codDeptoOficina = codDeptoOficina;
    }

    public String getCiudadOficina() {
        return ciudadOficina;
    }

    public void setCiudadOficina(String ciudadOficina) {
        this.ciudadOficina = ciudadOficina;
    }

    public String getEnvioCorrespondencia() {
        return envioCorrespondencia;
    }

    public void setEnvioCorrespondencia(String envioCorrespondencia) {
        this.envioCorrespondencia = envioCorrespondencia;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNumBeneficiario() {
        return numBeneficiario;
    }

    public void setNumBeneficiario(String numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFeautorization() {
        return feautorization;
    }

    public void setFeautorization(String feautorization) {
        this.feautorization = feautorization;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
        
        
}
