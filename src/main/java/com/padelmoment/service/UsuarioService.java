package com.padelmoment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padelmoment.dto.UsuarioRequest;
import com.padelmoment.dto.UsuarioResponse;
import com.padelmoment.entity.Usuario;
import com.padelmoment.exception.UsuarioNotFoundException;
import com.padelmoment.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioResponse> listarUsuarios(){
		return usuarioRepository.findAll()
				.stream()
				.map(this::convertirADto)
				.toList();
	}
	
	public UsuarioResponse findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()->
				new UsuarioNotFoundException("Usuario no encontrado con el id: " + id));
		return convertirADto(usuario);
	}
	
	public UsuarioResponse crear(UsuarioRequest request) {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getNombre());
		usuario.setApellido(request.getApellido());
		usuario.setMail(request.getMail());
		usuario.setPassword(request.getPassword());		
		usuario.setRol("CLIENTE");
		Usuario usuarioGuardado = usuarioRepository.save(usuario);
		return convertirADto(usuarioGuardado);
	}

	public UsuarioResponse actualizar(Long id, UsuarioRequest request) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(()->
				new UsuarioNotFoundException("Usuario no encontrado con el id: " + id));
		
		usuario.setNombre(request.getNombre());
		usuario.setApellido(request.getApellido());
		usuario.setMail(request.getMail());
		usuario.setPassword(request.getPassword());
		Usuario usuarioActualizado = usuarioRepository.save(usuario);
		return convertirADto(usuarioActualizado);
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
	
	private UsuarioResponse convertirADto(Usuario usuario) {
		return new UsuarioResponse(
				usuario.getId(),
				usuario.getNombre(),
				usuario.getApellido(),
				usuario.getMail(),
				usuario.getRol()
				);
	
	}

}
