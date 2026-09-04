package com.padelmoment.dto;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String rol;

    public UsuarioResponse() {
    }
    public UsuarioResponse(Long id, String nombre, String apellido, String mail, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.rol = rol;
    }
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getMail() {
		return mail;
	}
	public String getRol() {
		return rol;
	}

    

}
