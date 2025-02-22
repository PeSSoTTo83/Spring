package com.joange.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TIPOAULA")
public class TipoAula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private Long idTipo;

    @Column(name = "nombretipo", length = 20)
    private String nommbretipo;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "activo")
    private Boolean activo;

    // Getters y settersw

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    // Asegúrate de que este getter se llame exactamente getNomTipo()
    public String getNombretipo() {
        return nommbretipo;
    }

    public void setNombreTipo(String nommbretipo) {
        this.nommbretipo = nommbretipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
