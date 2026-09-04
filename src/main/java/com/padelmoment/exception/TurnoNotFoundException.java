package com.padelmoment.exception;

public class TurnoNotFoundException extends RuntimeException{
	
	public TurnoNotFoundException(String mensaje) {
		super(mensaje);
	}
}
