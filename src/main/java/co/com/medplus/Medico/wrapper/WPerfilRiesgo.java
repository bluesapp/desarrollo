/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

import java.util.List;

/**
 *
 * @author JeisonI
 */
public class WPerfilRiesgo {
    private WSelectItem ciudad;
    private List<WSelectItem> matriz;
    private WSelectItem sexo;
    private WSelectItem tipoContrato;
    private String estado;
    private int edadMinimo;
    private int edadMaximo;

    public WSelectItem getCiudad() {
        return ciudad;
    }

    public void setCiudad(WSelectItem ciudad) {
        this.ciudad = ciudad;
    }

    public List<WSelectItem> getMatriz() {
        return matriz;
    }

    public void setMatriz(List<WSelectItem> matriz) {
        this.matriz = matriz;
    }

    public WSelectItem getSexo() {
        return sexo;
    }

    public void setSexo(WSelectItem sexo) {
        this.sexo = sexo;
    }

    public WSelectItem getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(WSelectItem tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEdadMinimo() {
        return edadMinimo;
    }

    public void setEdadMinimo(int edadMinimo) {
        this.edadMinimo = edadMinimo;
    }

    public int getEdadMaximo() {
        return edadMaximo;
    }

    public void setEdadMaximo(int edadMaximo) {
        this.edadMaximo = edadMaximo;
    }
    
    
}
