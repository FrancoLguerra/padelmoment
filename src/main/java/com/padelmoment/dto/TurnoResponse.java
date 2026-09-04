package com.padelmoment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.padelmoment.entity.Cancha;




public class TurnoResponse {
	private Long id;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String cliente;
	private Long canchaId;
	private String canchaNombre;
	private String estado;


	public TurnoResponse(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String cliente, Cancha cancha, String estado) {
		this.id = id;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.cliente = cliente;
		this.canchaId = cancha.getId();
		this.canchaNombre = cancha.getNombre();
		this.estado = estado;
		
	}


	public Long getId() {
		return id;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public LocalTime getHoraInicio() {
		return horaInicio;
	}


	public LocalTime getHoraFin() {
		return horaFin;
	}


	public String getCliente() {
		return cliente;
	}


	public Long getCanchaId() {
		return canchaId;
	}


	public String getCanchaNombre() {
		return canchaNombre;
	}


	public String getEstado() {
		return estado;
	}
	
}
