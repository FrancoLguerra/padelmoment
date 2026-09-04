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

import com.padelmoment.dto.CanchaRequest;
import com.padelmoment.dto.CanchaResponse;
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
	public List<CanchaResponse> listarCanchas(){
		return canchaService.listarCanchas();
	}
	@GetMapping("/{id}")
	public CanchaResponse buscarPorId(@PathVariable Long id){
		return canchaService.buscarPorId(id);
	}
	
	@PostMapping
	public CanchaResponse crear(@Valid @RequestBody CanchaRequest request) {
		return canchaService.crear(request);
	}
	
	@PutMapping("/{id}")
	public CanchaResponse actualizar(@PathVariable Long id,@Valid  @RequestBody CanchaRequest request) {
		return canchaService.actualizar(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		canchaService.eliminar(id);
	}

}
