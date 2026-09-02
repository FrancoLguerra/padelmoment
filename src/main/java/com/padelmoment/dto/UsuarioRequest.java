package com.padelmoment.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UsuarioRequest {
@NotBlank(message = "El nombre es obligatorio")
private String nombre;
@NotBlank(message = "El apellido es obligatorio")
private String apellido;
@NotBlank(message = "El mail es obligatorio")
@Email(message = "El formato del mail no es válido")
private String mail;
@NotBlank(message = "La contraseña es obligatoria")
private String password;
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


}
