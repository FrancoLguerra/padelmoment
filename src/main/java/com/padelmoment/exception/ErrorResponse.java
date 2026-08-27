package com.padelmoment.exception;

public class ErrorResponse {

	private int status;
	private String error;
	private String mensaje;
	
	public ErrorResponse() {}
	
	public ErrorResponse(int status, String error, String mensaje) {
		this.status = status;
		this.error = error;
		this.mensaje = mensaje;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMensaje() {
		return mensaje;
	}
	
	
}
