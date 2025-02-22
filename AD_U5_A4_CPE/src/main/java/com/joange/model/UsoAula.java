package com.joange.model;

import javax.persistence.*;

@Entity
@Table(name = "usoaula")
public class UsoAula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduso")
	private Long iduso;


    @Column(nullable = false, length = 200)
    private String descripcion;

    @Column(nullable = false, length = 1)
    private String activo;

    public UsoAula() {}

    public UsoAula(String descripcion, String activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Long getIduso() {
        return iduso;
    }

    public void setIduso(Long iduso) {
        this.iduso = iduso;
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
}
