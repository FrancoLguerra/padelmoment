package com.padelmoment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.padelmoment.dto.CanchaRequest;
import com.padelmoment.dto.CanchaResponse;
import com.padelmoment.entity.Cancha;
import com.padelmoment.exception.CanchaNotFoundException;
import com.padelmoment.repository.CanchaRepository;

@Service
public class CanchaService {
	private final CanchaRepository canchaRepository;
	
	public CanchaService(CanchaRepository canchaRepository) {
		this.canchaRepository = canchaRepository;
	}
	
	public List<CanchaResponse> listarCanchas(){
		return canchaRepository.findAll()
				.stream()
				.map(this::convertirADto)
				.toList();
	}
	
	public CanchaResponse buscarPorId(Long id){
		Cancha cancha = canchaRepository.findById(id)
				.orElseThrow(()-> new CanchaNotFoundException("Cancha no encontrada con id: " + id));
		return convertirADto(cancha);
		
	}
	
	public CanchaResponse crear(CanchaRequest request) {
		 Cancha cancha = new Cancha();
		 cancha.setNombre(request.getNombre());
		 cancha.setActiva(request.getActiva());
		 cancha.setTipo(request.getTipo());
		 
		 Cancha canchaGuardada = canchaRepository.save(cancha);
		 return convertirADto(canchaGuardada);
	}
	
	
	public CanchaResponse actualizar(Long id, CanchaRequest request) {
		Cancha cancha = canchaRepository.findById(id)
				.orElseThrow(()-> new CanchaNotFoundException("Cancha no encontrada con id: " + id));
		
		cancha.setNombre(request.getNombre());
		cancha.setTipo(request.getTipo());
		cancha.setActiva(request.getActiva());
		
		Cancha canchaActualizada = canchaRepository.save(cancha);
		 return convertirADto(canchaActualizada);
	}
	
	public void eliminar(Long id) {
		if(!canchaRepository.existsById(id)) {
			throw new CanchaNotFoundException("Cancha no encontrada con id: " + id);
		}
		
		canchaRepository.deleteById(id);
	}
	
	public CanchaResponse convertirADto(Cancha cancha) {
		return new CanchaResponse(cancha.getId(), cancha.getNombre());
	}

}
