package com.padelmoment.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "turnos")
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private String cliente;
	@ManyToOne
	@JoinColumn(name = "cancha_id")
	private Cancha cancha;
	private String estado;
	
	public Turno() {}

	public Turno(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String cliente, Cancha cancha,
			String estado) {
		super();
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.cliente = cliente;
		this.cancha = cancha;
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}
	
	

}
