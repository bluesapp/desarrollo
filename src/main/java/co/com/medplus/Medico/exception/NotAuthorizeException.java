/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.exception;

/**
 *
 * @author MarioF
 */
public class NotAuthorizeException extends Exception{
    
    private static final long serialVersionUID = 1L;
	
	private int tipoMensaje;
	
	public NotAuthorizeException(int tipoMensaje, String message){
		
		super(message);
		this.tipoMensaje = tipoMensaje;
	}

	public int getTipoMensaje() {
		return tipoMensaje;
	}
}
