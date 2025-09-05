package com.gestionacademica.api_gestion_academica.controller;
import com.gestionacademica.api_gestion_academica.entity.Profesor;
import com.gestionacademica.api_gestion_academica.dto.ProfesorDTO;
import com.gestionacademica.api_gestion_academica.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.crear(profesor);
        return ResponseEntity.ok(nuevoProfesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> obtenerTodos(
            @RequestParam(required = false) String apellido) {
        List<ProfesorDTO> profesores = profesorService.obtenerTodos(apellido);
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerPorId(@PathVariable Integer id) {
        return profesorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        Profesor profesorActualizado = profesorService.actualizar(id, profesor);
        if (profesorActualizado != null) {
            return ResponseEntity.ok(profesorActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (profesorService.eliminar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}