package com.gestionacademica.api_gestion_academica.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(name = "seccion_id")
    private Integer seccionId;

    @Column(name = "dia_semana", length = 15)
    private String diaSemana;

    @Column(name = "hora_inicio")
    private java.time.LocalTime horaInicio;

    @Column(name = "hora_fin")
    private java.time.LocalTime horaFin;

    @Column(length = 50)
    private String aula;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Horario() {}

    public Integer  getId() { return id; }
    public void setId(Integer  id) { this.id = id; }
    
    public Integer getSeccionId() { return seccionId; }
    public void setSeccionId(Integer seccionId) { this.seccionId = seccionId; }
    
    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    
    public java.time.LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(java.time.LocalTime horaInicio) { this.horaInicio = horaInicio; }
    
    public java.time.LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(java.time.LocalTime horaFin) { this.horaFin = horaFin; }
    
    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
    
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}