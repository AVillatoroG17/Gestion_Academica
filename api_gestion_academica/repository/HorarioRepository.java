package com.gestionacademica.api_gestion_academica.repository;

import com.gestionacademica.api_gestion_academica.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
}