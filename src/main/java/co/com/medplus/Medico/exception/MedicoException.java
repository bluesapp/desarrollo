package co.com.medplus.Medico.exception;

import org.springframework.http.HttpStatus;

public class MedicoException extends Exception{
	
	private static final long serialVersionUID = 1L;	
	
	private String requestBody;
	private Exception sourceException;
	private Object objectResponse;
	private HttpStatus statusResponse;
	
	public MedicoException(Object objectResponse, HttpStatus statusResponse, String requestBody, Exception sourceException){		
		
		this.objectResponse = objectResponse;
		this.statusResponse = statusResponse;
		this.requestBody = requestBody;
		this.sourceException = sourceException;
			
	}

	public String getRequestBody() {
		return requestBody;
	}

	public Exception getSourceException() {
		return sourceException;
	}

	public Object getObjectResponse() {
		return objectResponse;
	}

	public HttpStatus getStatusResponse() {
		return statusResponse;
	}
	
	
	
		
}
