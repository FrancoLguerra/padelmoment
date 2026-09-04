package com.padelmoment.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.padelmoment.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
	 		@Query("""
		        SELECT COUNT(t) > 0
		        FROM Turno t
		        WHERE t.cancha.id = :canchaId
		        AND t.fecha = :fecha
		        AND t.horaInicio < :horaFin
		        AND t.horaFin > :horaInicio
		    """)
		    boolean existeConflicto(
		            @Param("canchaId") Long canchaId,
		            @Param("fecha") LocalDate fecha,
		            @Param("horaInicio") LocalTime horaInicio,
		            @Param("horaFin") LocalTime horaFin
		    );

		    @Query("""
		        SELECT COUNT(t) > 0
		        FROM Turno t
		        WHERE t.cancha.id = :canchaId
		        AND t.fecha = :fecha
		        AND t.horaInicio < :horaFin
		        AND t.horaFin > :horaInicio
		        AND t.id <> :id
		    """)
		    boolean existeConflictoExcepto(
		            @Param("canchaId") Long canchaId,
		            @Param("fecha") LocalDate fecha,
		            @Param("horaInicio") LocalTime horaInicio,
		            @Param("horaFin") LocalTime horaFin,
		            @Param("id") Long id
		    );
}
