package com.padelmoment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padelmoment.dto.UsuarioRequest;
import com.padelmoment.entity.Usuario;
import com.padelmoment.exception.UsuarioNotFoundException;
import com.padelmoment.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(()->
				new UsuarioNotFoundException("Usuario no encontrado con el id: " + id));
	}
	
	public Usuario crear(UsuarioRequest request) {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getNombre());
		usuario.setApellido(request.getApellido());
		usuario.setMail(request.getMail());
		usuario.setPassword(request.getPassword());		
		usuario.setRol("CLIENTE");
		return usuarioRepository.save(usuario);
	}

	public Usuario actualizar(Long id, UsuarioRequest request) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()->
				new UsuarioNotFoundException("Usuario no encontrado con el id: " + id));
		
		usuario.setNombre(request.getNombre());
		usuario.setApellido(request.getApellido());
		usuario.setMail(request.getMail());
		usuario.setPassword(request.getPassword());
		return usuarioRepository.save(usuario);
	}
	
	public Usuario actualizarRol(Long id, String rol) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()->
				new UsuarioNotFoundException("Usuario no encontrado con el id: " + id));
		usuario.setRol(rol);
		
		return usuarioRepository.save(usuario);
	}
	
	public void eliminar(Long id) {
		if(! usuarioRepository.existsById(id)) {
			throw new UsuarioNotFoundException("Usuario no encontrado con el id: " + id);
		}
		usuarioRepository.deleteById(id);
	}

}
