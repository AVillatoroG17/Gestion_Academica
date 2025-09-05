package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Profesor;
import com.gestionacademica.api_gestion_academica.repository.ProfesorRepository;
import com.gestionacademica.api_gestion_academica.dto.ProfesorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<ProfesorDTO> obtenerTodos(String apellido) {
        List<Profesor> profesores;
        if (apellido != null && !apellido.isEmpty()) {
            profesores = profesorRepository.findByApellidoContainingIgnoreCase(apellido);
        } else {
            profesores = profesorRepository.findAll();
        }
        return profesores.stream()
                .map(this::convertirAProfesorDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfesorDTO> obtenerPorId(Integer id) {
        return profesorRepository.findById(id)
                .map(this::convertirAProfesorDTO);
    }
    
    public Profesor crear(Profesor profesor) {
        profesor.setFechaRegistro(LocalDateTime.now());
        return profesorRepository.save(profesor);
    }

    public Profesor actualizar(Integer id, Profesor profesorActualizado) {
        return profesorRepository.findById(id)
            .map(profesor -> {
                profesor.setCodigoProfesor(profesorActualizado.getCodigoProfesor());
                profesor.setNombre(profesorActualizado.getNombre());
                profesor.setApellido(profesorActualizado.getApellido());
                profesor.setEmail(profesorActualizado.getEmail());
                profesor.setTelefono(profesorActualizado.getTelefono());
                profesor.setEspecialidad(profesorActualizado.getEspecialidad());
                profesor.setFechaContratacion(profesorActualizado.getFechaContratacion());
                profesor.setActivo(profesorActualizado.getActivo());
                return profesorRepository.save(profesor);
            }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        if (profesorRepository.existsById(id)) {
            profesorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(Long.valueOf(profesor.getId()));
        dto.setNombreCompleto(profesor.getNombre() + " " + profesor.getApellido());
        dto.setEspecialidad(profesor.getEspecialidad());
        dto.setEmail(profesor.getEmail());
        dto.setEstado(profesor.getActivo() ? "ACTIVO" : "INACTIVO");
        return dto;
    }
}