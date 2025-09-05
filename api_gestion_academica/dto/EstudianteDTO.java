package com.gestionacademica.api_gestion_academica.dto;

public class EstudianteDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    private int edad;
    private String carrera;
    private String estado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}