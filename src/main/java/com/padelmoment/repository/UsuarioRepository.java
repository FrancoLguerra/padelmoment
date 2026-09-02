package com.padelmoment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padelmoment.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
