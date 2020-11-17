/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.ExamsDao;
import co.com.medplus.Medico.entities.core.CupRelacion;
import co.com.medplus.Medico.entities.core.EExamsAssisted;
import co.com.medplus.Medico.entities.core.EExamsCode;
import co.com.medplus.Medico.entities.core.EExamsForTamizaje;
import co.com.medplus.Medico.entities.core.TamizajeAbreviado;
import co.com.medplus.Medico.wrapper.WExamsAssisted;
import co.com.medplus.Medico.wrapper.WExamsCode;
import co.com.medplus.Medico.wrapper.WExamsForTamizaje;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JeisonI
 */
@Controller
public class ExamsController {
    
     private ExamsDao dao;
     private List<WExamsCode> examsCodeFinal;
     private List<WExamsForTamizaje> examTamizajeFinal;

    @Autowired
    public void setDao(ExamsDao dao) {
        this.dao = dao;
    }
    
    public List<WExamsCode> getAllExamsByCode(int edad, String sexo) throws SQLException{
        
        String codigo = "";

        if (edad < 10) {
            //Retorna tipo 1
            codigo = "1";
        } else if (edad >= 10 && edad < 18) {
            //Retorna tipo 2
            codigo = "2";
        } else if (edad >= 18) {
            if (null != sexo) switch (sexo) {
                case "F":
                    //Retorna tipo 3
                    codigo = "3";
                    break;
                case "M":
                    //Retorna tipo 4
                    codigo = "4";
                    break;
            }
        }
        
        List<WExamsCode> listForCodeFinal = new ArrayList<>();
        
        List<EExamsCode> listForCode = dao.examsByCode(codigo);
        
        for(EExamsCode item : listForCode){
            WExamsCode exams = new WExamsCode();
            
            exams.setCodigo(item.getCodigo());
            exams.setNombreExamen(item.getNombreExamen());
            
            listForCodeFinal.add(exams);
        }
        
        return listForCodeFinal;
    }
    
    public List<WExamsAssisted> getAllExamsAssisted(String numDocumento)throws SQLException{
        
        List<WExamsAssisted> examsAssisted = new ArrayList<>();
        
        List<EExamsAssisted> exams = dao.examsAssisted(numDocumento);
        
        for(EExamsAssisted item : exams){
            WExamsAssisted examAssis = new WExamsAssisted();
            
            examAssis.setCodigo(item.getCodigo());
            examAssis.setNombreExamen(item.getNombreExamen());
            examAssis.setFecha(item.getFecha());
            
            examsAssisted.add(examAssis);
        }
        
        return examsAssisted;
    }
    
    public List<WExamsForTamizaje> getTamizaje(int edad, String sexo) throws SQLException{
        
        String codigo = "";
        
        if (edad > 18) {
            
            if (edad < 50 && ("F".equals(sexo) || "f".equals(sexo))) {
                codigo = "1";
            }

            if (edad >= 50) {

                if (edad >= 55) {
                    if ("M".equals(sexo) || "m".equals(sexo)) {
                        codigo = "4";
                    }
                }
                
                if ("F".equals(sexo) || "f".equals(sexo)) {
                    codigo = "3";
                }
            }
        }
        
        
        List<WExamsForTamizaje> examsFinal = new ArrayList<>();
        
        List<EExamsForTamizaje> exams = dao.examsTamizaje(codigo);
        
        for(EExamsForTamizaje item : exams){
            WExamsForTamizaje examsTami =  new WExamsForTamizaje();
            
            examsTami.setCodigo(item.getCodigo());
            examsTami.setNombreExamen(item.getNombreExamen());
           
            examsFinal.add(examsTami);
        }
                
        return examsFinal;
    }
    
    public WExamsCode getCupRelacion(String cupOriginal)throws Exception{
        
        WExamsCode examCode = new WExamsCode();
        
        CupRelacion cup = this.dao.getCupRelacion(cupOriginal);
                
        examCode.setCodigo(cup.getCupUno());
        examCode.setEstado(Boolean.FALSE);
        examCode.setFecha("");
        examCode.setNombreExamen(cup.getDescripcion());
        
        
        return examCode;
        
    }
    
    public WExamsForTamizaje getTamizajeRelacionado(String tamizaje) throws Exception{
        
        WExamsForTamizaje forTamizaje = new WExamsForTamizaje();
        
        TamizajeAbreviado ta = this.dao.getTamizajeAbreviadoApp(tamizaje);
        
        forTamizaje.setCodigo(ta.getCodigoFinal());
        forTamizaje.setEstado(Boolean.FALSE);
        forTamizaje.setFecha("");
        forTamizaje.setNombreExamen(ta.getDescripcion());
        
        return forTamizaje;
    }
    
    public void addTamizajeFinalApp(WExamsForTamizaje tamizaje)throws Exception{
        
        //Valido si la lista tiene algun objeto
        //Si tiene objeto
        if(this.examTamizajeFinal.size()>0){
            
            //Valido que el nuevo objeto no exista en la lista
            Boolean existe = false;
            //Recorro la lista final verificando por cada objeto
            for(WExamsForTamizaje examFinal :this.examTamizajeFinal){
                
                //Pregunto si el objeto actual es el mismo que estoy intentando ingresar
                if(examFinal.getCodigo().equals(tamizaje.getCodigo())){
                    //Marco check que me notifica que ya existe en la lista
                    existe = true;
                    
                    //Como existe verifico que el estado del dato que quiero actualizar sea verdadero
                    if(tamizaje.getEstado()){
                        //si es verdadero actualizo el objeto
                        examFinal.setEstado(tamizaje.getEstado());
                        examFinal.setFecha(tamizaje.getFecha());
                    }
                    //Si el estado es falso no hace nada
                } 
            }
            
            //Valido la marcacion de que existe
            //Si no existe lo creo
            if(!existe){
                
                this.examTamizajeFinal.add(tamizaje);
            }
            
        }else{
            //No tiene objeto
            //Lo crea
            this.examTamizajeFinal.add(tamizaje);
        } 
        
    }
    
    public void addCupFinalApp(WExamsCode cup){
        //Valido si la lista tiene algun objeto
        //Si tiene objeto
        if(this.examsCodeFinal.size()>0){
            
            //Valido que el nuevo objeto no exista en la lista
            Boolean existe = false;
            //Recorro la lista final verificando por cada objeto
            for(WExamsCode examFinal :this.examsCodeFinal){
                
                //Pregunto si el objeto actual es el mismo que estoy intentando ingresar
                if(examFinal.getCodigo().equals(cup.getCodigo())){
                    //Marco check que me notifica que ya existe en la lista
                    existe = true;
                    
                    //Como existe verifico que el estado del dato que quiero actualizar sea verdadero
                    if(cup.getEstado()){
                        //si es verdadero actualizo el objeto
                        examFinal.setEstado(cup.getEstado());
                        examFinal.setFecha(cup.getFecha());
                    }
                    //Si el estado es falso no hace nada
                } 
            }
            
            //Valido la marcacion de que existe
            //Si no existe lo creo
            if(!existe){
                
                this.examsCodeFinal.add(cup);
            }
            
        }else{
            //No tiene objeto
            //Lo crea
            this.examsCodeFinal.add(cup);
        }
    }
    
    public void iniciarExamenApp(){
        this.examsCodeFinal = new ArrayList<>();
    }
    
     public void iniciarExamenTamizajeApp(){
        this.examTamizajeFinal = new ArrayList<>();
    }
    
    public List<WExamsCode> getExamsCodeFinal() {
        return examsCodeFinal;
    }

    public List<WExamsForTamizaje> getExamTamizajeFinal() {
        return examTamizajeFinal;
    }
    
    
    
     
}
