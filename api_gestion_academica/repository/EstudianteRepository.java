package com.gestionacademica.api_gestion_academica.repository;

import com.gestionacademica.api_gestion_academica.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByCarreraContainingIgnoreCase(String carrera);
}