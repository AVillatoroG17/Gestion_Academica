package com.gestionacademica.api_gestion_academica.repository;

import com.gestionacademica.api_gestion_academica.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    List<Profesor> findByApellidoContainingIgnoreCase(String apellido);
}