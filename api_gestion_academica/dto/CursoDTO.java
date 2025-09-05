package com.gestionacademica.api_gestion_academica.dto;

public class CursoDTO {
    private Long id;
    private String codigoCurso;
    private String nombre;
    private Integer creditos;
    private Integer horasSemanales;
    private String descripcion;
    private ProfesorDTO profesorAsignado; 

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }
    public Integer getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(Integer horasSemanales) { this.horasSemanales = horasSemanales; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public ProfesorDTO getProfesorAsignado() { return profesorAsignado; }
    public void setProfesorAsignado(ProfesorDTO profesorAsignado) { this.profesorAsignado = profesorAsignado; }
}