package com.gestionacademica.api_gestion_academica.controller;

import com.gestionacademica.api_gestion_academica.dto.*;
import com.gestionacademica.api_gestion_academica.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<List<CursosPorProfesorDTO>> obtenerCursosPorProfesor() {
        List<CursosPorProfesorDTO> resultado = reporteService.obtenerCursosPorProfesor();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/nota-promedio-por-curso")
    public ResponseEntity<List<NotaPromedioPorCursoDTO>> obtenerNotaPromedioPorCurso() {
        List<NotaPromedioPorCursoDTO> resultado = reporteService.obtenerNotaPromedioPorCurso();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/estudiantes-por-ciclo")
    public ResponseEntity<List<EstudiantesPorCicloDTO>> obtenerEstudiantesPorCiclo() {
        List<EstudiantesPorCicloDTO> resultado = reporteService.obtenerEstudiantesPorCiclo();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/top-cursos")
    public ResponseEntity<List<TopCursosDTO>> obtenerTop3CursosPorNota() {
        List<TopCursosDTO> resultado = reporteService.obtenerTop3CursosPorNota();
        return ResponseEntity.ok(resultado);
    }
}