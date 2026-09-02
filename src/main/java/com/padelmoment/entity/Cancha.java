package com.padelmoment.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "canchas")
public class Cancha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name= "NOMBRE")
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@Column(name= "TIPO")
	@NotBlank(message = "El tipo es obligatorio")
	private String tipo;
	@Column(name= "ACTIVA")
	@NotNull(message = "El campo activa es obligatorio")
	private Boolean activa;
	
	
	public Cancha() {}
	
	public Cancha( String nombre, String tipo, Boolean activa) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.activa = activa;
		
		
	}

	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	
	

}
