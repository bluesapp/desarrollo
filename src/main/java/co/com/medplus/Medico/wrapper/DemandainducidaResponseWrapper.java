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
public class DemandainducidaResponseWrapper {
    
    private String cohorte;
    private String tipoDeIdentificacion;
    private String identificacion;
    private String nombreCompleto;
    private String estado;
    private String fechaDeNacimiento;
    private String edad;
    private String sexo;
    private String grupoQuinquenial;
    private String ciudad;
    private String numeroDeContrato;
    private String tipoDeContratp;
    private String tipoDeusuario;
    private String numeroDeMatriz;
    private String nombreMatriz;
    private String nombrePlan;
    private String numeroFijo;
    private String celular;
    private String nombreEPS;
    private String periodo;
    private String codigoDemandaInducida;
    private String fechaGestion;
    private String horaGestion;
    private String resultado;
    private String contactoConTitular;
    private String fechaCitaMedGral;
    private String agente;
    private String observaciones;
    
    private Boolean estadoServer;
    private String mensaje;

    public DemandainducidaResponseWrapper() {
    }
    
    public void cargardata(WDemandaInducidaExportLoad load){
        
        this.cohorte = load.getCohorte();
        this.tipoDeIdentificacion = load.getTipoDeIdentificacion();
        this.identificacion = load.getIdentificacion();
        this.nombreCompleto = load.getNombreCompleto();
        this.estado = load.getEstado();
        this.fechaDeNacimiento = load.getFechaDeNacimiento();
        this.edad = load.getEdad();
        this.sexo = load.getSexo();
        this.grupoQuinquenial = load.getGrupoQuinquenial();
        this.ciudad = load.getCiudad();
        this.numeroDeContrato = load.getNumeroDeContrato();
        this.tipoDeContratp = load.getTipoDeContratp();
        this.tipoDeusuario = load.getTipoDeUsuario();
        this.numeroDeMatriz = load.getNumeroDeMatriz();
        this.nombreMatriz = load.getNombreMatriz();
        this.nombrePlan = load.getNombrePlan();
        this.numeroFijo = load.getNumeroFijo();
        this.celular = load.getCelular();
        this.nombreEPS = load.getNombreEPS();
        this.periodo = load.getPeriodo();
        this.codigoDemandaInducida = load.getCodigoDemandaInducida();
        this.fechaGestion = load.getFechaGestion();
        this.horaGestion = load.getHoraGestion();
        this.resultado = load.getResultado();
        this.contactoConTitular = load.getContactoConTitular();
        this.fechaCitaMedGral = load.getFechaCitaMedGral();
        this.agente = load.getAgente();
        this.observaciones = load.getObservaciones();
        
        
    }
    
    public String getCohorte() {
        return cohorte;
    }

    public void setCohorte(String cohorte) {
        this.cohorte = cohorte;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrupoQuinquenial() {
        return grupoQuinquenial;
    }

    public void setGrupoQuinquenial(String grupoQuinquenial) {
        this.grupoQuinquenial = grupoQuinquenial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(String numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public String getTipoDeContratp() {
        return tipoDeContratp;
    }

    public void setTipoDeContratp(String tipoDeContratp) {
        this.tipoDeContratp = tipoDeContratp;
    }

    public String getTipoDeusuario() {
        return tipoDeusuario;
    }

    public void setTipoDeusuario(String tipoDeusuario) {
        this.tipoDeusuario = tipoDeusuario;
    }

    public String getNumeroDeMatriz() {
        return numeroDeMatriz;
    }

    public void setNumeroDeMatriz(String numeroDeMatriz) {
        this.numeroDeMatriz = numeroDeMatriz;
    }

    public String getNombreMatriz() {
        return nombreMatriz;
    }

    public void setNombreMatriz(String nombreMatriz) {
        this.nombreMatriz = nombreMatriz;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(String numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombreEPS() {
        return nombreEPS;
    }

    public void setNombreEPS(String nombreEPS) {
        this.nombreEPS = nombreEPS;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodigoDemandaInducida() {
        return codigoDemandaInducida;
    }

    public void setCodigoDemandaInducida(String codigoDemandaInducida) {
        this.codigoDemandaInducida = codigoDemandaInducida;
    }

    public String getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(String fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public String getHoraGestion() {
        return horaGestion;
    }

    public void setHoraGestion(String horaGestion) {
        this.horaGestion = horaGestion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getContactoConTitular() {
        return contactoConTitular;
    }

    public void setContactoConTitular(String contactoConTitular) {
        this.contactoConTitular = contactoConTitular;
    }

    public String getFechaCitaMedGral() {
        return fechaCitaMedGral;
    }

    public void setFechaCitaMedGral(String fechaCitaMedGral) {
        this.fechaCitaMedGral = fechaCitaMedGral;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getEstadoServer() {
        return estadoServer;
    }

    public void setEstadoServer(Boolean estadoServer) {
        this.estadoServer = estadoServer;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
