package com.gestionacademica.api_gestion_academica.service;

import com.gestionacademica.api_gestion_academica.dto.*;
import com.gestionacademica.api_gestion_academica.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<CursosPorProfesorDTO> obtenerCursosPorProfesor() {
        return reporteRepository.obtenerCursosPorProfesor();
    }

    public List<NotaPromedioPorCursoDTO> obtenerNotaPromedioPorCurso() {
        return reporteRepository.obtenerNotaPromedioPorCurso();
    }

    public List<EstudiantesPorCicloDTO> obtenerEstudiantesPorCiclo() {
        return reporteRepository.obtenerEstudiantesPorCiclo();
    }

    public List<TopCursosDTO> obtenerTop3CursosPorNota() {
        List<TopCursosDTO> resultados = reporteRepository.obtenerTopCursosPorNota();
        return resultados.size() > 3 ? resultados.subList(0, 3) : resultados;
    }
}