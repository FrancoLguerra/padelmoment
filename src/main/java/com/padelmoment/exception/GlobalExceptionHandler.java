package com.padelmoment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CanchaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse manejarCanchaNoEncontrada(CanchaNotFoundException ex) {
		return new ErrorResponse(404, "Not Found", ex.getMessage());
	}
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse manejarErroresValidacion(
	            MethodArgumentNotValidException ex) {

	        String mensaje = ex.getBindingResult()
	                .getFieldErrors()
	                .get(0)
	                .getDefaultMessage();

	        return new ErrorResponse(
	                400,
	                "Bad Request",
	                mensaje
	        );
	    }
	   @ExceptionHandler(IllegalArgumentException.class)
	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	   public ErrorResponse manejarErrorDeValidacion(
	           IllegalArgumentException ex) {

	       return new ErrorResponse(
	               400,
	               "Bad Request",
	               ex.getMessage()
	       );
	   }
	   
	   @ExceptionHandler(TurnoNotFoundException.class)
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	   public ErrorResponse manejarTurnoNoEncontrado(TurnoNotFoundException ex) {
	       return new ErrorResponse(
	               404,
	               "Not Found",
	               ex.getMessage()
	       );
	   }

	   @ExceptionHandler(UsuarioNotFoundException.class)
	   @ResponseStatus(HttpStatus.NOT_FOUND)
	   public ErrorResponse manejarUsuarioNoEncontrado(UsuarioNotFoundException ex) {
	       return new ErrorResponse(
	               404,
	               "Not Found",
	               ex.getMessage()
	       );
	   }
	
}
