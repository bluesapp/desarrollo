/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.PacienteDao;
import co.com.medplus.Medico.entities.core.EConsultaCohorte;
import co.com.medplus.Medico.entities.core.EDemandaInducida;
import co.com.medplus.Medico.entities.core.EPaciente;
import co.com.medplus.Medico.wrapper.WCie10Wrapper;
import co.com.medplus.Medico.wrapper.WConsultCohorteWrapper;
import co.com.medplus.Medico.wrapper.WInducedDemandWrapper;
import co.com.medplus.Medico.wrapper.WPatientWrapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author MarioF
 */
@Controller
public class PatientController {
    
    private PacienteDao dao;
    
    @Autowired
    public void setDao(PacienteDao dao){
        this.dao = dao;
    }
    
    public WPatientWrapper consultaPacienteXIdentificacion(String identificacion) throws Exception {
        
        EPaciente ePaciente = new EPaciente();
        WPatientWrapper wPatient = new WPatientWrapper();
        
        ePaciente = dao.consultaPacienteXIdentificacion(identificacion);
        
        wPatient.setName(ePaciente.getNombre());
        wPatient.setIdentification(ePaciente.getIdentificacion());
        wPatient.setAge(ePaciente.getEdad());
        wPatient.setSex(ePaciente.getSexo());
        wPatient.setCity(ePaciente.getCiudad());
        wPatient.setTypeLink(ePaciente.getTipoVinculo());
        wPatient.setTypeContract(ePaciente.getTipoContrato());
        wPatient.setColectiveMatrix(ePaciente.getColectivoMatriz());
        wPatient.setEps(ePaciente.getEps());
        wPatient.setPlanMp(ePaciente.getPlanMp());
        wPatient.setValidity(ePaciente.getVigencia().substring(0, 10));
        wPatient.setAntiquity(ePaciente.getAntiguedad());
        
        return wPatient;
    }
    
    public List<WInducedDemandWrapper> consultaDemandaInducida(WConsultCohorteWrapper consultCohorte) throws Exception {
        
        List<WInducedDemandWrapper> lsw = new ArrayList<WInducedDemandWrapper>();

        EConsultaCohorte consultaCohorte = new EConsultaCohorte();
        
        consultaCohorte.setIdCohorte(consultCohorte.getIdCohorte());
        
        String listaCie10 = "";
        for(WCie10Wrapper item : consultCohorte.getLsCie10()){
        
            listaCie10 += item.getCode() + ",";
        }        
        
        consultaCohorte.setLsCie10(listaCie10);
        
        consultaCohorte.setFechaInicial(consultCohorte.getFechaInicial());
        consultaCohorte.setFechaFinal(consultCohorte.getFechaFinal());
        consultaCohorte.setCiudad(consultCohorte.getCiudad());
        consultaCohorte.setLaboratorio(consultCohorte.getLaboratorio());
        consultaCohorte.setIdGrupoQuinquenal(consultCohorte.getIdGrupoQuinquenal());
        consultaCohorte.setTipoUsuario(consultCohorte.getTipoUsuario());
        consultaCohorte.setGenero(consultCohorte.getGenero());
        consultaCohorte.setIdTipoContrato(consultCohorte.getIdTipoContrato());
        consultaCohorte.setMatrizAlianza(consultCohorte.getMatrizAlianza());
        consultaCohorte.setIdColectivoAlianza(consultCohorte.getIdColectivoAlianza());
        
        List<EDemandaInducida> ls =  dao.consultaDemandaInducida(consultaCohorte);
                
        for(EDemandaInducida item : ls){
                WInducedDemandWrapper lw = new WInducedDemandWrapper();

                //*** Cohorte o sub-cohorte	Cohorte o sub-cohorte para la que se está generando la demanda inducida
                lw.setCohorte(item.getCohorte());
                //*** Tipo Identificación	Tipo de identificación del usuario con riesgo detectado
                lw.setIdentificationType(item.getTipoIdentificacion());
                //*** Identificación	Número de identificación del usuario con posible riesgo detectado 
                lw.setIdentification(item.getIdentificacion());
                //*** Nombres y apellidos 	Nombres y apellidos del usuario con posible riesgo detectado 
                lw.setFullName(item.getNombreCompleto());
                //*** Estado	Estado del usuario, no incluir usuarios inactivos por fallecimiento (base mortalidad audita y cancelaciones)
                lw.setState(item.getEstado());
                //*** Fecha de Nacimiento	Fecha de nacimiento del usuario
                lw.setBornDate(item.getFechaNacimiento());
                //*** Edad	Edad del usuario
                lw.setAge(item.getEdad());
                //*** Sexo	Sexo del usuario F Femenino o M Masculino
                lw.setSex(item.getSexo());
                //*** Grupo Quinquenal	Grupo quinquenal al que pertenezca 
                lw.setQuinquenialGroup(item.getGrupoQuinquenal());
                //*** Ciudad	Ciudad del contrato 
                lw.setCity(item.getCiudad());
                //*** Contrato	Número del contrato
                lw.setContractNumber(item.getNumeroContrato());
                //*** Tipo Contrato C Colectivo  F Familiar  A Alianza
                lw.setContractType(item.getTipoContrato());
                //*** Tipo Usuario	Tipo usuario Contratante o Beneficiario
                lw.setUserType(item.getTipoUsuario());
                //*** Matriz	Código de la matriz o alianza
                lw.setMatrizCode(item.getCodigoMatrizAlianza());
                //*** Nombre	Nombre de la matriz o alianza 
                lw.setMatrizName(item.getNombreMatrizAlianza());
                //*** Nombre Plan	Nombre del plan
                lw.setPlanName(item.getNombrePlan());
                //*** Teléfono	Número de teléfono fijo
                lw.setPhoneNumber(item.getTelefono());
                //*** Celular	Número de teléfono celular 
                lw.setMobile(item.getCelular());
                //*** EPS	Nombre de la Eps del usuario
                lw.setEpsName(item.getNombreEps());
                //Periodo	Periodo en le que se genera el reporte 
                lw.setPeriod(consultCohorte.getPeriod());
                //CodDI	Si se generó para demanda inducida el código con cual se generó la demanda anexo 
                lw.setInducedDemandCode(consultCohorte.getInducedDemandCode());

                lsw.add(lw);
        }

        return lsw;
    }
}
