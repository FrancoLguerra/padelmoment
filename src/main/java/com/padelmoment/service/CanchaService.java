package com.padelmoment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.padelmoment.entity.Cancha;
import com.padelmoment.exception.CanchaNotFoundException;
import com.padelmoment.repository.CanchaRepository;

@Service
public class CanchaService {
	private final CanchaRepository canchaRepository;
	
	public CanchaService(CanchaRepository canchaRepository) {
		this.canchaRepository = canchaRepository;
	}
	
	public List<Cancha> listarCanchas(){
		return canchaRepository.findAll();
	}
	
	public Cancha crear(Cancha cancha) {
		return canchaRepository.save(cancha);
	}
	
	public Cancha buscarPorId(Long id){
		return canchaRepository.findById(id)
				.orElseThrow(()-> new CanchaNotFoundException("Cancha no encontrada con id: " + id));
		
	}
	
	public Cancha actualizar(Long id, Cancha canchaActualizada) {
		Cancha cancha = canchaRepository.findById(id)
				.orElseThrow(()-> new CanchaNotFoundException("Cancha no encontrada con id: " + id));
		
		cancha.setNombre(canchaActualizada.getNombre());
		cancha.setTipo(canchaActualizada.getTipo());
		cancha.setActiva(canchaActualizada.getActiva());
		
		return canchaRepository.save(cancha);
	}
	
	public void eliminar(Long id) {
		if(!canchaRepository.existsById(id)) {
			new CanchaNotFoundException("Cancha no encontrada con id: " + id);
		}
		
		canchaRepository.deleteById(id);
	}

}
