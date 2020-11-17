/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.LaboratorioDao;
import co.com.medplus.Medico.entities.core.ELaboratorio;
import co.com.medplus.Medico.entities.core.ResponseCargueSp;
import co.com.medplus.Medico.entities.core.TipoLaboratorio;
import co.com.medplus.Medico.wrapper.DatoGenerico;
import co.com.medplus.Medico.wrapper.LaboratorioLoad;
import co.com.medplus.Medico.wrapper.LaboratorioReturn;
import co.com.medplus.Medico.wrapper.WLaboratoryConsult;
import co.com.medplus.Medico.wrapper.WLaboratoryWrapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class LaboratoryController {

    private LaboratorioDao dao;

    @Autowired
    public void setDao(LaboratorioDao dao) {
        this.dao = dao;
    }

    public List<LaboratorioReturn> saveList(List<LaboratorioLoad> laboratorios, String idLaboratorio) {
        Integer count = 0;
        ArrayList<LaboratorioReturn> labReturn = new ArrayList<>();
        try {
            TipoLaboratorio tipoLab = this.dao.obtenerVariablesalerta(idLaboratorio);
            laboratorios.forEach((LaboratorioLoad laboratorio) -> {
                LaboratorioReturn lab = new LaboratorioReturn(laboratorio.getExamen(),
                        laboratorio.getIdentificacion(),
                        laboratorio.getResultado(),
                        laboratorio.getFechaHoraIngreso(),
                        laboratorio.getNota());

                try {
                //Se obtiene los valores de las variables para iniciar la alerta

                    String alerta = "";
                    switch (tipoLab.getCondicional()) {
                        case ">":
                            Double resul = Double.parseDouble(laboratorio.getResultado());
                            Double vCondicion = Double.parseDouble(tipoLab.getValorCondion().replace(',', '.'));

                        //System.out.println("Condicional : "+resul +" > "+vCondicion);
                            if (resul > vCondicion) {
                                alerta = "S";
                            } else {
                                alerta = "N";
                            }

                            break;
                        case "<":
                            Double resul1 = Double.parseDouble(laboratorio.getResultado());
                            Double vCondicion1 = Double.parseDouble(tipoLab.getValorCondion());
                            //System.out.println("Condicional : "+resul1 +" < "+vCondicion1);
                            if (resul1 < vCondicion1) {
                                alerta = "S";
                            } else {
                                alerta = "N";
                            }
                            break;
                        case "==":
                            String[] condiciones = tipoLab.getValorCondion().split(",");
                            String datoValidar = laboratorio.getResultado().trim().toUpperCase().substring(0, 8);
                            for (String condicione : condiciones) {

                           // System.out.println("Condicional : "+datoValidar +" ==  "+condicione.toUpperCase().trim());
                                if (datoValidar.equals(condicione.toUpperCase().trim())) {
                                    alerta = "S";
                                }
                            }

                            if (alerta.equals("")) {
                                alerta = "N";
                            }
                            break;
                    }
                    //Se envia a procedimiento almacena para guardar
                    ResponseCargueSp resp = this.dao.saveLaboratio(laboratorio, alerta, Integer.parseInt(idLaboratorio));

                    lab.setEstado(resp.getEstado());
                    lab.setMensaje(resp.getMensaje());

                } catch (Exception ex) {
                    lab.setEstado(Boolean.FALSE);
                    lab.setMensaje("Erro " + ex.getMessage());
                }

                labReturn.add(lab);

            });

            return labReturn;

        } catch (Exception ex) {
            System.out.println(ex);
            return labReturn;
        }
    }

    public List<WLaboratoryWrapper> consultaLaboratorioXIdentificacion(String identificacion) throws Exception {

        List<WLaboratoryWrapper> lsw = new ArrayList<WLaboratoryWrapper>();

        List<ELaboratorio> ls = dao.consultaLaboratorioXIdentificacion(identificacion);

        for (ELaboratorio item : ls) {
            WLaboratoryWrapper lw = new WLaboratoryWrapper();

            lw.setLaboratory(item.getLaboratorio());
            lw.setAlert(item.getAlerta());
            lw.setResult(item.getResultado());
            lw.setComentary(item.getComentario());
            if (item.getFechaIngreso().length() > 10) {
                lw.setDateAdmission(item.getFechaIngreso().substring(0, 10));
            } else {
                lw.setDateAdmission(item.getFechaIngreso());
            }

            lsw.add(lw);
        }

        return lsw;

    }
    
    
    public Boolean saveExamenApp (DatoGenerico datoGenerico,String documento, String tipoDocumento,Integer tipo) throws Exception{
        
        this.dao.insertarLaboratorioApp(datoGenerico, documento, tipoDocumento, tipo);
        return true;
        
        
    }
    
    public WLaboratoryConsult consultaExamenes(String identificacion, String tipo) throws SQLException{
        
        switch(Integer.parseInt(tipo)){
            case 1:
            case 2:
            case 3:
                return this.dao.examenesXidentificacionApp(identificacion, Integer.parseInt(tipo));
            case 4:
                return this.obtenerTriglicerido(identificacion);
            default :
                return null;
             
        }
    }
    
    public WLaboratoryConsult obtenerTriglicerido(String numDocumento) throws SQLException{
        return this.dao.examenesXidentificacionApp(numDocumento);
    }
}
