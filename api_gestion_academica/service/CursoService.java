package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.entity.Curso;
import com.gestionacademica.api_gestion_academica.repository.CursoRepository;
import com.gestionacademica.api_gestion_academica.dto.CursoDTO;
import com.gestionacademica.api_gestion_academica.dto.ProfesorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
@Autowired  
private CursoRepository cursoRepository;
    @Autowired
    private ProfesorService profesorService;

    public List<CursoDTO> obtenerTodos(Integer horasSemanales) {
        List<Curso> cursos;
        if (horasSemanales != null) {
            cursos = cursoRepository.findByHorasSemanales(horasSemanales);
        } else {
            cursos = cursoRepository.findAll();
        }
        return cursos.stream()
                .map(this::convertirACursoDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursoDTO> obtenerPorId(Integer id) {
        return cursoRepository.findById(id)
                .map(this::convertirACursoDTO);
    }

    private CursoDTO convertirACursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(Long.valueOf(curso.getId()));
        dto.setCodigoCurso(curso.getCodigoCurso());
        dto.setNombre(curso.getNombre());
        dto.setCreditos(curso.getCreditos());
        dto.setHorasSemanales(curso.getHorasSemanales());
        dto.setDescripcion(curso.getDescripcion());
        return dto;
    }
    
    public Curso crear(Curso curso) {
        curso.setFechaRegistro(LocalDateTime.now());
        return cursoRepository.save(curso);
    }

    public Curso actualizar(Integer id, Curso cursoActualizado) {
        return cursoRepository.findById(id)
            .map(curso -> {
                curso.setCodigoCurso(cursoActualizado.getCodigoCurso());
                curso.setNombre(cursoActualizado.getNombre());
                curso.setCreditos(cursoActualizado.getCreditos());
                curso.setDescripcion(cursoActualizado.getDescripcion());
                curso.setHorasSemanales(cursoActualizado.getHorasSemanales());
                curso.setPuntuacionMinima(cursoActualizado.getPuntuacionMinima());
                curso.setActivo(cursoActualizado.getActivo());
                return cursoRepository.save(curso);
            }).orElse(null);
    }

    public boolean eliminar(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}