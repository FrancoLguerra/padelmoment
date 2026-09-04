package com.padelmoment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padelmoment.dto.UsuarioRequest;
import com.padelmoment.dto.UsuarioResponse;
import com.padelmoment.entity.Usuario;
import com.padelmoment.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	public List<UsuarioResponse> listarUsuarios(){
		return usuarioService.listarUsuarios();
	}
	
	@GetMapping("/{id}")
	public UsuarioResponse findById(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping
	public UsuarioResponse crear(@Valid @RequestBody UsuarioRequest request) {
		return usuarioService.crear(request);
	}
	
	@PutMapping("/{id}")
	public UsuarioResponse actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequest request) {
		return usuarioService.actualizar(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		usuarioService.eliminar(id);
	}
	
}
