package com.padelmoment.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.padelmoment.dto.TurnoRequest;
import com.padelmoment.dto.TurnoResponse;
import com.padelmoment.entity.Turno;
import com.padelmoment.exception.CanchaNotFoundException;
import com.padelmoment.exception.TurnoNotFoundException;
import com.padelmoment.entity.Cancha;
import com.padelmoment.repository.CanchaRepository;
import com.padelmoment.repository.TurnoRepository;

@Service
public class TurnoService {
	
	private final TurnoRepository turnoRepository;
	private final CanchaRepository canchaRepository;
	
	public TurnoService(TurnoRepository turnoRepository, CanchaRepository canchaRepository) {
		this.turnoRepository = turnoRepository;
		this.canchaRepository = canchaRepository;
	}
	
	public List<TurnoResponse> listarTurnos(){
		return turnoRepository.findAll()
				.stream()
				.map(this::convertirADto)
				.toList();
		}
				
	
	public TurnoResponse buscarPorId(Long id) {
		 Turno turno = turnoRepository.findById(id)
				.orElseThrow(()-> 
				new TurnoNotFoundException("Turno no encontrado con el id: " + id));
		return convertirADto(turno);
	}
	
	private void validarHorario(TurnoRequest request) {

	    if (!request.getHoraInicio().isBefore(request.getHoraFin())) {
	        throw new IllegalArgumentException(
	                "La hora de inicio debe ser anterior a la hora de fin"
	        );
	    }
	}
	
	public TurnoResponse crear(TurnoRequest request) {
		validarHorario(request);
		Cancha cancha = canchaRepository.findById(request.getCanchaId())
				.orElseThrow(()->
				new CanchaNotFoundException("Cancha no encontrada con el id: " + request.getCanchaId()));
		boolean existeConflicto = turnoRepository.existeConflicto(
				request.getCanchaId(), request.getFecha(),request.getHoraInicio(),request.getHoraFin());
		if(existeConflicto) {
			throw new IllegalArgumentException(
		            "La cancha ya está reservada en ese horario"
		    );
		}
		
		Turno turno = new Turno();
		turno.setFecha(request.getFecha());
		turno.setHoraInicio(request.getHoraInicio());
		turno.setHoraFin(request.getHoraFin());
		turno.setCliente(request.getCliente());
		turno.setCancha(cancha);
		turno.setEstado("RESERVADA");
		
		Turno turnoGuardado =  turnoRepository.save(turno);
		return convertirADto(turnoGuardado);
		
	}
	
	public TurnoResponse actualizar(Long id, TurnoRequest request) {
		validarHorario(request);
		Turno turno = turnoRepository.findById(id)
				.orElseThrow(()->
				new TurnoNotFoundException("Turno no encontrado con el id: " + id));
		Cancha cancha = canchaRepository.findById(request.getCanchaId())
				.orElseThrow(()->
				new CanchaNotFoundException("Cancha no encontrada con el id: " + request.getCanchaId()));
		boolean existeConflicto = turnoRepository.existeConflictoExcepto(request.getCanchaId(), request.getFecha(),request.getHoraInicio(),request.getHoraFin(), id);
		if(existeConflicto) {
			throw new IllegalArgumentException(
		            "La cancha ya está reservada en ese horario"
		    );
		}

		turno.setCancha(cancha);
		turno.setCliente(request.getCliente());
		turno.setHoraInicio(request.getHoraInicio());
		turno.setHoraFin(request.getHoraFin());
		turno.setFecha(request.getFecha());
		
		Turno turnoActualizado =  turnoRepository.save(turno);
		return convertirADto(turnoActualizado);
	}
	
	public void eliminar(Long id) {
		if(!turnoRepository.existsById(id)) {
			throw new TurnoNotFoundException("Turno no encontrado con el id: " + id);
		}
		
		turnoRepository.deleteById(id);
	}
	
	private TurnoResponse convertirADto(Turno turno) {
		return new TurnoResponse(turno.getId(),
				turno.getFecha(),
				turno.getHoraInicio(),
				turno.getHoraFin(),
				turno.getCliente(),
				turno.getCancha(),
				turno.getEstado());
	}
}
