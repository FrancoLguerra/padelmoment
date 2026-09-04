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
import com.padelmoment.dto.TurnoRequest;
import com.padelmoment.dto.TurnoResponse;
import com.padelmoment.service.TurnoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
	
	private final TurnoService turnoService;
	
	public TurnoController(TurnoService turnoService) {
		this.turnoService = turnoService;
	}
	
	@GetMapping
	public List<TurnoResponse> listarTurnos(){
		return turnoService.listarTurnos();
	}
	
	@GetMapping("/{id}")
	public TurnoResponse buscarPorId(@PathVariable Long id) {
		return turnoService.buscarPorId(id);
	}
	
	@PostMapping
	public TurnoResponse crear(@Valid @RequestBody TurnoRequest request) {
		return turnoService.crear(request);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		turnoService.eliminar(id);
	}
	
	@PutMapping("/{id}")
	public TurnoResponse actualizar(@PathVariable Long id,@Valid @RequestBody TurnoRequest request  ) {
		
		return turnoService.actualizar(id, request);
	}
	
}
