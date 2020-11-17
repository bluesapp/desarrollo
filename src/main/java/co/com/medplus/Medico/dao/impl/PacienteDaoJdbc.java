/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.PacienteDao;
import co.com.medplus.Medico.entities.core.EConsultaCohorte;
import co.com.medplus.Medico.entities.core.EDemandaInducida;
import co.com.medplus.Medico.entities.core.EPaciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MarioF
 */
@Repository
public class PacienteDaoJdbc implements PacienteDao {
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;
        
    @Override
    public EPaciente consultaPacienteXIdentificacion(String identificacion) throws Exception {
    
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

            EPaciente li = new EPaciente();
            
		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaPacienteXIdentificacion(?)}");
                        cstm.setString(1, identificacion);
			//cstm.setString(2, consultaListaW.getDato());
			rs = cstm.executeQuery();

			while (rs.next()) {


				li.setNombre(rs.getString("NombreCompleto"));
				li.setIdentificacion(rs.getString("Identificacion"));
				li.setEdad(rs.getString("EdadTexto"));
                                li.setSexo(rs.getString("Sexo"));
                                li.setCiudad(rs.getString("Ciudad"));
                                li.setTipoVinculo(rs.getString("TipoVinculo"));
                                li.setTipoContrato(rs.getString("CodTipoContrato"));
                                li.setColectivoMatriz(rs.getString("ColectivoMatriz"));
                                li.setEps(rs.getString("NombreEPS"));
                                li.setPlanMp(rs.getString("PlanMp"));
                                li.setVigencia(rs.getString("FechaIniVigencia"));
                                li.setAntiguedad(rs.getString("Antiguedad"));
			}

			return li;
        } catch (Exception e) {
            
			e.printStackTrace();
			throw e;
        } finally {

                try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
    }
    
    
    @Override
    public List<EDemandaInducida> consultaDemandaInducida(EConsultaCohorte consultaCohorte) throws Exception {
        
        Connection conn = this.dataSource.getConnection();
        
        //Connection conn = null;
        CallableStatement cstm = null;	

        int error = 0;
        String messageError = "";
        ResultSet rs = null;

		List<EDemandaInducida> ls = new ArrayList<EDemandaInducida>();

		try {

			//conn = this.dataSource.getConnection();
			cstm = conn.prepareCall("{call spConsultaDemandaInducidaGestion(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        cstm.setString(1, consultaCohorte.getIdCohorte());
                        cstm.setString(2, consultaCohorte.getLsCie10());
                        
                        if(consultaCohorte.getFechaInicial().equals("-1")){
                            cstm.setString(3, null);    
                        } else {
                            cstm.setString(3, consultaCohorte.getFechaInicial());    
                        }
                        
                        if(consultaCohorte.getFechaFinal().equals("-1")){
                            cstm.setString(4, null);    
                        } else {
                            cstm.setString(4, consultaCohorte.getFechaFinal());
                        }
                        
                        if(consultaCohorte.getCiudad().equals("-1")){
                            cstm.setString(5, null);    
                        } else {
                            cstm.setString(5, consultaCohorte.getCiudad());    
                        }
                        
                        if(consultaCohorte.getLaboratorio().equals("-1")){
                            cstm.setString(6, null);    
                        } else {
                            cstm.setString(6, consultaCohorte.getLaboratorio());    
                        }
                        
                        if(consultaCohorte.getIdGrupoQuinquenal().equals("-1")){
                            cstm.setString(7, null);    
                        } else {
                            cstm.setString(7, consultaCohorte.getIdGrupoQuinquenal());    
                        }
                        
                        if(consultaCohorte.getTipoUsuario().equals("-1")){
                            cstm.setString(8, null);    
                        } else {
                            cstm.setString(8, consultaCohorte.getTipoUsuario());    
                        }
                        
                        if(consultaCohorte.getGenero().equals("-1")){
                            cstm.setString(9, null);    
                        } else {
                            cstm.setString(9, consultaCohorte.getGenero());    
                        }
                        
                        if(consultaCohorte.getIdTipoContrato().equals("-1")){
                            cstm.setString(10, null);    
                        } else {
                            cstm.setString(10, consultaCohorte.getIdTipoContrato());    
                        }
                        
                        if(consultaCohorte.getMatrizAlianza().equals("-1")){
                            cstm.setString(11, null);    
                        } else {
                            cstm.setString(11, consultaCohorte.getMatrizAlianza());    
                        }
                        
                        if(consultaCohorte.getIdColectivoAlianza().equals("-1")){
                            cstm.setString(12, null);    
                        } else {
                            cstm.setString(12, consultaCohorte.getIdColectivoAlianza());    
                        }
                        

			rs = cstm.executeQuery();

			while (rs.next()) {

				EDemandaInducida li = new EDemandaInducida();

                                //*** Cohorte o sub-cohorte	Cohorte o sub-cohorte para la que se está generando la demanda inducida
                                li.setCohorte(rs.getString("Cohorte"));
                                //*** Tipo Identificación	Tipo de identificación del usuario con riesgo detectado
                                li.setTipoIdentificacion(rs.getString("TipoIdentificacion"));
                                //*** Identificación	Número de identificación del usuario con posible riesgo detectado 
                                li.setIdentificacion(rs.getString("Identificacion"));
                                //*** Nombres y apellidos 	Nombres y apellidos del usuario con posible riesgo detectado 
                                li.setNombreCompleto(rs.getString("NombreCompleto"));
                                //*** Estado	Estado del usuario, no incluir usuarios inactivos por fallecimiento (base mortalidad audita y cancelaciones)
                                li.setEstado(rs.getString("EstadoCohorte"));
                                //*** Fecha de Nacimiento	Fecha de nacimiento del usuario
                                li.setFechaNacimiento(rs.getString("FechaNacimiento"));
                                //*** Edad	Edad del usuario
                                li.setEdad(rs.getString("Edad"));
                                //*** Sexo	Sexo del usuario F Femenino o M Masculino
                                li.setSexo(rs.getString("Sexo"));
                                //*** Grupo Quinquenal	Grupo quinquenal al que pertenezca 
                                li.setGrupoQuinquenal(rs.getString("GrupoQuinquenal"));
                                //*** Ciudad	Ciudad del contrato 
                                li.setCiudad(rs.getString("Ciudad"));
                                //*** Contrato	Número del contrato
                                li.setNumeroContrato(rs.getString("NumContrato"));
                                //*** Tipo Contrato C Colectivo  F Familiar  A Alianza
                                li.setTipoContrato(rs.getString("CodTipoContrato"));
                                //*** Tipo Usuario	Tipo usuario Contratante o Beneficiario
                                li.setTipoUsuario(rs.getString("TipoUsuario"));
                                //*** Matriz	Código de la matriz o alianza
                                li.setCodigoMatrizAlianza(rs.getString("CodigoMatrizAlianza"));
                                //*** Nombre	Nombre de la matriz o alianza 
                                li.setNombreMatrizAlianza(rs.getString("NombreMatrizAlianza"));
                                //*** Nombre Plan	Nombre del plan
                                li.setNombrePlan(rs.getString("NombrePlan"));
                                //*** Teléfono	Número de teléfono fijo
                                li.setTelefono(rs.getString("Ctelefonoresidencia"));
                                //*** Celular	Número de teléfono celular 
                                li.setCelular(rs.getString("CTelefonoCelular"));
                                //*** EPS	Nombre de la Eps del usuario
                                li.setNombreEps(rs.getString("NombreEPS"));
				
				ls.add(li);
			}

			return ls;
        } catch (Exception e) {
            
			e.printStackTrace();
			throw e;
        } finally {

                try {

                        if (cstm != null)
                                cstm.close();
                        if (conn != null)
                                conn.close();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
    }
    
}
