/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

import java.util.List;

/**
 *
 * @author MarioF
 */
public class WConsultCohorteWrapper {
    
    //Periodo	Periodo en le que se genera el reporte 
    private String period;
    //CodDI	Si se generó para demanda inducida el código con cual se generó la demanda anexo 
    private String inducedDemandCode;

    private String idCohorte;

    private List<WCie10Wrapper> lsCie10;

    private String fechaInicial;

    private String fechaFinal;

    private String ciudad;

    private String laboratorio;

    private String idGrupoQuinquenal;

    private String tipoUsuario;

    private String genero;

    private String idTipoContrato;

    private String matrizAlianza;

    private String idColectivoAlianza;
    
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

    /**
     * @return the idCohorte
     */
    public String getIdCohorte() {
        return idCohorte;
    }

    /**
     * @param idCohorte the idCohorte to set
     */
    public void setIdCohorte(String idCohorte) {
        this.idCohorte = idCohorte;
    }

    /**
     * @return the lsCie10
     */
    public List<WCie10Wrapper> getLsCie10() {
        return lsCie10;
    }

    /**
     * @param lsCie10 the lsCie10 to set
     */
    public void setLsCie10(List<WCie10Wrapper> lsCie10) {
        this.lsCie10 = lsCie10;
    }

    /**
     * @return the fechaInicial
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
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
     * @return the laboratorio
     */
    public String getLaboratorio() {
        return laboratorio;
    }

    /**
     * @param laboratorio the laboratorio to set
     */
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * @return the idGrupoQuinquenal
     */
    public String getIdGrupoQuinquenal() {
        return idGrupoQuinquenal;
    }

    /**
     * @param idGrupoQuinquenal the idGrupoQuinquenal to set
     */
    public void setIdGrupoQuinquenal(String idGrupoQuinquenal) {
        this.idGrupoQuinquenal = idGrupoQuinquenal;
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
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the idTipoContrato
     */
    public String getIdTipoContrato() {
        return idTipoContrato;
    }

    /**
     * @param idTipoContrato the idTipoContrato to set
     */
    public void setIdTipoContrato(String idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    /**
     * @return the matrizAlianza
     */
    public String getMatrizAlianza() {
        return matrizAlianza;
    }

    /**
     * @param matrizAlianza the matrizAlianza to set
     */
    public void setMatrizAlianza(String matrizAlianza) {
        this.matrizAlianza = matrizAlianza;
    }

    /**
     * @return the idColectivoAlianza
     */
    public String getIdColectivoAlianza() {
        return idColectivoAlianza;
    }

    /**
     * @param idColectivoAlianza the idColectivoAlianza to set
     */
    public void setIdColectivoAlianza(String idColectivoAlianza) {
        this.idColectivoAlianza = idColectivoAlianza;
    }

    
}
