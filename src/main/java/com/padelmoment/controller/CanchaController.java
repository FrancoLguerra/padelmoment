package com.padelmoment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padelmoment.entity.Cancha;
import com.padelmoment.service.CanchaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/canchas")
public class CanchaController {
	
	private final CanchaService canchaService;
	
	public CanchaController(CanchaService canchaService) {
		this.canchaService = canchaService;
	}
	
	@GetMapping
	public List<Cancha> listarCanchas(){
		return canchaService.listarCanchas();
	}
	@GetMapping("/{id}")
	public Cancha buscarPorId(@PathVariable Long id){
		return canchaService.buscarPorId(id);
	}
	
	@PostMapping
	public Cancha crear(@Valid @RequestBody Cancha cancha) {
		return canchaService.crear(cancha);
	}
	
	@PutMapping("/{id}")
	public Cancha actualizar(@Valid @PathVariable Long id, @RequestBody Cancha cancha) {
		return canchaService.actualizar(id, cancha);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		canchaService.eliminar(id);
	}

}
