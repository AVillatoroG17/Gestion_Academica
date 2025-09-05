package com.gestionacademica.api_gestion_academica.controller;
import com.gestionacademica.api_gestion_academica.entity.Curso;
import com.gestionacademica.api_gestion_academica.dto.CursoDTO;
import com.gestionacademica.api_gestion_academica.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crear(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerTodos(
            @RequestParam(required = false) Integer horasSemanales) {
        List<CursoDTO> cursos = cursoService.obtenerTodos(horasSemanales);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerPorId(@PathVariable Integer id) {
        return cursoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizar(id, curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (cursoService.eliminar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}