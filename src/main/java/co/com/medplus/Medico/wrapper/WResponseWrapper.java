/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

/**
 *
 * @author jorgelp
 */
public class WResponseWrapper {
	
        private String id;
	private String type;
        private String message;
        //@JsonIgnore
	private boolean confirma;
        private String mensaje;
	
	public boolean isConfirma() {
		return confirma;
	}
	public void setConfirma(boolean confirma) {
		this.confirma = confirma;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
        public String getMensaje() {
                return mensaje;
        }
        public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
        }
	

}
