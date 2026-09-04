package com.padelmoment.dto;

public class CanchaResponse {
	private Long id;
	private String nombre;

	public CanchaResponse(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
}
