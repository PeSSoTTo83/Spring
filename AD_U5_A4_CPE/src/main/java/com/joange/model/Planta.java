package com.joange.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Planta")
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanta;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int nAulasDocentes;

    @Column(nullable = false)
    private int nAulaAuxiliares;


    @Column(nullable = false)
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "EDIFICIOidedificio", nullable = false)
    private Edificio edificio;

    public Planta() {}

    public Planta(String descripcion, int nAulasDocentes, int nAulaAuxiliares, boolean activo, Edificio edificio) {
        this.descripcion = descripcion;
        this.nAulasDocentes = nAulasDocentes;
        this.nAulaAuxiliares = nAulaAuxiliares;
        this.activo = activo;
        this.edificio = edificio;
    }

	public Long getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(Long idPlanta) {
		this.idPlanta = idPlanta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getnAulasDocentes() {
		return nAulasDocentes;
	}

	public void setnAulasDocentes(int nAulasDocentes) {
		this.nAulasDocentes = nAulasDocentes;
	}

	public int getnAulaAuxiliares() {
		return nAulaAuxiliares;
	}

	public void setnAulaAuxiliares(int naAulaAuxiliares) {
		this.nAulaAuxiliares = nAulaAuxiliares;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
