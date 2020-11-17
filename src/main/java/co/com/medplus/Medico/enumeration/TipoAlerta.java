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
public enum TipoAlerta {
    
    	SUCCESS("success"),
	INFO("info"),
	QUESTION("question"),
	WARNING("warning"),
	ERROR("error"),;
	
	private String value;
	
	TipoAlerta(String value){
		
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
