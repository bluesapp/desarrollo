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
public class WPerfilPMR {
    private List<List<WExamsCode>> listRutaPromocion;
    private List<List<WExamsForTamizaje>> listRutaTamizaje;

    public List<List<WExamsCode>> getListRutaPromocion() {
        return listRutaPromocion;
    }

    public void setListRutaPromocion(List<List<WExamsCode>> listRutaPromocion) {
        this.listRutaPromocion = listRutaPromocion;
    }

    public List<List<WExamsForTamizaje>> getListRutaTamizaje() {
        return listRutaTamizaje;
    }

    public void setListRutaTamizaje(List<List<WExamsForTamizaje>> listRutaTamizaje) {
        this.listRutaTamizaje = listRutaTamizaje;
    }
    
    
}
