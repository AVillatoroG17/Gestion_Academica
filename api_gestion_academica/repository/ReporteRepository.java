package com.gestionacademica.api_gestion_academica.repository;

import com.gestionacademica.api_gestion_academica.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<com.gestionacademica.api_gestion_academica.entity.Inscripcion, Integer> {

    @Query("SELECT NEW com.gestionacademica.api_gestion_academica.dto.CursosPorProfesorDTO(" +
           "CONCAT(p.nombre, ' ', p.apellido), " +
           "COUNT(DISTINCT s.curso.id)) " +
           "FROM Seccion s " +
           "JOIN s.profesor p " +
           "GROUP BY p.id, p.nombre, p.apellido")
    List<CursosPorProfesorDTO> obtenerCursosPorProfesor();

    @Query("SELECT NEW com.gestionacademica.api_gestion_academica.dto.NotaPromedioPorCursoDTO(" +
        "c.nombre, " +
        "CAST(AVG(i.notaFinal) as java.math.BigDecimal)) " + 
        "FROM Inscripcion i " +
        "JOIN i.seccion s " +
        "JOIN s.curso c " +
        "WHERE i.notaFinal IS NOT NULL " +
        "GROUP BY c.id, c.nombre")
List<NotaPromedioPorCursoDTO> obtenerNotaPromedioPorCurso();

    @Query("SELECT NEW com.gestionacademica.api_gestion_academica.dto.EstudiantesPorCicloDTO(" +
           "CONCAT('Ciclo ', s.ano, '-', s.semestre), " +
           "COUNT(DISTINCT i.estudiante.id)) " +
           "FROM Inscripcion i " +
           "JOIN i.seccion s " +
           "GROUP BY s.ano, s.semestre " +
           "ORDER BY s.ano DESC, s.semestre DESC")
    List<EstudiantesPorCicloDTO> obtenerEstudiantesPorCiclo();

    @Query("SELECT NEW com.gestionacademica.api_gestion_academica.dto.TopCursosDTO(" +
        "c.nombre, " +
        "CAST(AVG(i.notaFinal) as java.math.BigDecimal)) " + // <-- La corrección está aquí
        "FROM Inscripcion i " +
        "JOIN i.seccion s " +
        "JOIN s.curso c " +
        "WHERE i.notaFinal IS NOT NULL " +
        "GROUP BY c.id, c.nombre " +
        "ORDER BY AVG(i.notaFinal) DESC")
    List<TopCursosDTO> obtenerTopCursosPorNota();
}