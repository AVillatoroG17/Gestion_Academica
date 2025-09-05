package com.gestionacademica.api_gestion_academica.dto;

public class CursosPorProfesorDTO {
    private String nombreProfesor;
    private Long totalCursos;

    public CursosPorProfesorDTO(String nombreProfesor, Long totalCursos) {
        this.nombreProfesor = nombreProfesor;
        this.totalCursos = totalCursos;
    }

    public String getNombreProfesor() { return nombreProfesor; }
    public void setNombreProfesor(String nombreProfesor) { this.nombreProfesor = nombreProfesor; }
    
    public Long getTotalCursos() { return totalCursos; }
    public void setTotalCursos(Long totalCursos) { this.totalCursos = totalCursos; }
}