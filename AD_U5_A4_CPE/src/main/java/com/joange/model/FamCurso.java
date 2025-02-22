package com.joange.model;

import javax.persistence.*;

@Entity
@Table(name = "famcurso")
public class FamCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfamcurso")  // Ajusta si tu PK se llama distinto
    private Long idfamcurso;

    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(nullable = false, length = 1)
    private String activo;

    /**
     * Relación ManyToOne con SubUsoAula,
     * usando la columna "SUBUSOAULAidsubuso" como FK.
     */
    @ManyToOne
    @JoinColumn(name = "SUBUSOAULAidsubuso", nullable = false)
    private SubUsoAula subUsoAula;

    public FamCurso() {
    }

    public FamCurso(String descripcion, String activo, SubUsoAula subUsoAula) {
        this.descripcion = descripcion;
        this.activo = activo;
        this.subUsoAula = subUsoAula;
    }

    public Long getIdfamcurso() {
        return idfamcurso;
    }

    public void setIdfamcurso(Long idfamcurso) {
        this.idfamcurso = idfamcurso;
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

    public SubUsoAula getSubUsoAula() {
        return subUsoAula;
    }

    public void setSubUsoAula(SubUsoAula subUsoAula) {
        this.subUsoAula = subUsoAula;
    }
}
