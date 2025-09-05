package com.gestionacademica.api_gestion_academica.controller;
import com.gestionacademica.api_gestion_academica.entity.Estudiante;
import com.gestionacademica.api_gestion_academica.dto.EstudianteDTO;
import com.gestionacademica.api_gestion_academica.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crear(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodos(
            @RequestParam(required = false) String carrera) {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodos(carrera);
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable Integer id) {
        return estudianteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.actualizar(id, estudiante);
        if (estudianteActualizado != null) {
            return ResponseEntity.ok(estudianteActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (estudianteService.eliminar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}