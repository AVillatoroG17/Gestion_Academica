package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Estudiante;
import com.gestionacademica.api_gestion_academica.repository.EstudianteRepository;
import com.gestionacademica.api_gestion_academica.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<EstudianteDTO> obtenerTodos(String carrera) {
        List<Estudiante> estudiantes;
        if (carrera != null && !carrera.isEmpty()) {
            estudiantes = estudianteRepository.findByCarreraContainingIgnoreCase(carrera);
        } else {
            estudiantes = estudianteRepository.findAll();
        }
        return estudiantes.stream()
                .map(this::convertirAEstudianteDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> obtenerPorId(Integer id) {
        return estudianteRepository.findById(id)
                .map(this::convertirAEstudianteDTO);
    }

    public Estudiante crear(Estudiante estudiante) {
        estudiante.setFechaRegistro(LocalDateTime.now());
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizar(Integer id, Estudiante estudianteActualizado) {
        return estudianteRepository.findById(id)
            .map(estudiante -> {
                estudiante.setCodigoEstudiante(estudianteActualizado.getCodigoEstudiante());
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setApellido(estudianteActualizado.getApellido());
                estudiante.setEmail(estudianteActualizado.getEmail());
                estudiante.setTelefono(estudianteActualizado.getTelefono());
                estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());
                estudiante.setCarrera(estudianteActualizado.getCarrera());
                estudiante.setEstado(estudianteActualizado.getEstado());
                return estudianteRepository.save(estudiante);
            }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        if (estudianteRepository.existsById(id)) {
            estudianteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(Long.valueOf(estudiante.getId()));
        dto.setNombreCompleto(estudiante.getNombre() + " " + estudiante.getApellido());
        dto.setEmail(estudiante.getEmail());
        if (estudiante.getFechaNacimiento() != null) {
            int edad = Period.between(estudiante.getFechaNacimiento(), LocalDate.now()).getYears();
            dto.setEdad(edad);
        }
        dto.setCarrera(estudiante.getCarrera());
        dto.setEstado(estudiante.getEstado().name());
        return dto;
    }
}