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
public enum TypeAccessApi {
  
    	ACCESO_APP(1),
        ACCESO_NORMAL(2);

	private int value;

	TypeAccessApi(int value) {

		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
