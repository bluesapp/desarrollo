/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.enumeration;

/**
 *
 * @author MarioF
 */
public enum Rol {
    
    //MANAGEMENT("ROLE_OVAMANAGEMENT");
    MANAGEMENT("ROLE_ADMINISTRACION_CRM_MEDICO");
	
	private String value;
	
	Rol(String value){		
		this.value = value;
	}	
	
	public String getValue(){
		return value;
	}
}
