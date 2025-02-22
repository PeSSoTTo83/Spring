package com.joange.model;

import javax.persistence.*;

@Entity
@Table(name = "subusoaula")
public class SubUsoAula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubuso") // Asegúrate de que el nombre coincide con el de la tabla
    private Long idsubuso;  // Clave primaria actualizada

    @Column(nullable = false, length = 200)
    private String descripcion;

 // Este campo hace referencia a la columna "iduso" (FK a usoA ula, si así lo deseas)
    @Column(name = "USOAULAiduso", nullable = false)
    private Long iduso;

    // Campo activo de 1 caracter (1 ó 0, o S ó N, según tu preferencia)
    @Column(nullable = false, length = 1)
    private String activo;

    public SubUsoAula() {
    }

    public SubUsoAula(String descripcion, Long iduso, String activo) {
        this.descripcion = descripcion;
        this.iduso = iduso;
        this.activo = activo;
    }

    public Long getIdsubuso() {
        return idsubuso;
    }

    public void setIdsubuso(Long idsubuso) {
        this.idsubuso = idsubuso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIduso() {
        return iduso;
    }

    public void setIduso(Long iduso) {
        this.iduso = iduso;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
