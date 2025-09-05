package com.gestionacademica.api_gestion_academica.dto;

public class EstudiantesPorCicloDTO {
    private String cicloAcademico;
    private Long totalEstudiantes;

    public EstudiantesPorCicloDTO(String cicloAcademico, Long totalEstudiantes) {
        this.cicloAcademico = cicloAcademico;
        this.totalEstudiantes = totalEstudiantes;
    }

    public String getCicloAcademico() { return cicloAcademico; }
    public void setCicloAcademico(String cicloAcademico) { this.cicloAcademico = cicloAcademico; }
    
    public Long getTotalEstudiantes() { return totalEstudiantes; }
    public void setTotalEstudiantes(Long totalEstudiantes) { this.totalEstudiantes = totalEstudiantes; }
}