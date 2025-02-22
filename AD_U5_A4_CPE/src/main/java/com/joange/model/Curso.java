package com.joange.model;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")
    private Long idcurso;

    @Column(nullable = false, length = 200)
    private String descripcion;

    // Asumimos que tu columna "activo" es un TINYINT(1) o CHAR(1)
    @Column(nullable = false, length = 1)
    private String activo;

    /**
     * Campo para guardar el ID de la tabla famcurso
     * (columna "FAMCURSOidfamcurso" en la BD).
     */
    @Column(name = "FAMCURSOfamcurso", nullable = false)
    private Long famcurso;

    public Curso() {
    }

    public Curso(String descripcion, String activo, Long famcurso) {
        this.descripcion = descripcion;
        this.activo = activo;
        this.famcurso = famcurso;
    }

    public Long getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Long idcurso) {
        this.idcurso = idcurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getFamcurso() {
        return famcurso;
    }

    public void setFamcurso(Long famcurso) {
        this.famcurso = famcurso;
    }
}
