package com.padelmoment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "El nombre es obligatorio")
	@Column(name = "NOMBRE")
	private String nombre;
	@NotBlank(message = "El apellido es obligatorio")
	@Column(name = "APELLIDO")
	private String apellido;
	@NotBlank(message = "El mail es obligatorio")
	@Column(name = "MAIL", unique = true)
	@Email(message = "El formato del mail no es válido")
	private String mail;
	@NotBlank(message = "La contraseña es obligatoria")
	@Column(name = "PASSWORD")
	private String password;
	@NotBlank(message = "El rol es obligatorio")
	@Column(name = "ROL")
	private String rol;
		
	
	public Usuario(){}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public Long getId() {
		return id;
	}
	
}
