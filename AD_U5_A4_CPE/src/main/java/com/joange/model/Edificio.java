package com.joange.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Edificio")
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdificio;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int nAulas;

    @Column(nullable = false)
    private int nPuertasAcceso;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private boolean activo;

    // Constructor vacío
    public Edificio() {}

    // Constructor con parámetros
    public Edificio(Long idEdificio, String descripcion, int nAulas, int nPuertasAcceso, String ubicacion, boolean activo) {
        this.idEdificio = idEdificio;
        this.descripcion = descripcion;
        this.nAulas = nAulas;
        this.nPuertasAcceso = nPuertasAcceso;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNAulas() {
        return nAulas;
    }

    public void setNAulas(int nAulas) {
        this.nAulas = nAulas;
    }

    public int getNPuertasAcceso() {
        return nPuertasAcceso;
    }

    public void setNPuertasAcceso(int nPuertasAcceso) {
        this.nPuertasAcceso = nPuertasAcceso;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
