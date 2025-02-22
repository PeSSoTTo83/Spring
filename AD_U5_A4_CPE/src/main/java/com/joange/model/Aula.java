package com.joange.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AULA")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaula")
    private Long idAula;

    // Mapea la columna "nombreaula"
    @Column(name = "nombreaula")
    private String nombreAula;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    // La columna "capacidad" es DECIMAL(3); usaremos Integer
    @Column(name = "capacidad")
    private Integer capacidad;

    // Las columnas TINYINT(1) las mapeamos a Boolean
    @Column(name = "proyector")
    private Boolean proyector;

    @Column(name = "smarttv")
    private Boolean smartTv;

    @Column(name = "hdmi")
    private Boolean hdmi;

    // En la tabla la columna se llama "appletv"
    @Column(name = "appletv")
    private Boolean applet;

    @Column(name = "aireacondicionado")
    private Boolean aireAcondicionado;

    // La columna "nenchufes" la mapeamos a Double
    @Column(name = "nenchufes")
    private Double enchufes;

    @Column(name = "activo")
    private Boolean activo;

    // Relación con TipoAula (columna TIPOAULAidtipo)
    @ManyToOne
    @JoinColumn(name = "TIPOAULAidtipo")
    private TipoAula tipoAula;

    // Relación con Planta (columna PLANTAidplanta)
    @ManyToOne
    @JoinColumn(name = "PLANTAidplanta", nullable = false)
    private Planta planta;

    // Getters y Setters

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Boolean getProyector() {
        return proyector;
    }

    public void setProyector(Boolean proyector) {
        this.proyector = proyector;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getHdmi() {
        return hdmi;
    }

    public void setHdmi(Boolean hdmi) {
        this.hdmi = hdmi;
    }

    public Boolean getApplet() {
        return applet;
    }

    public void setApplet(Boolean applet) {
        this.applet = applet;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Double getEnchufes() {
        return enchufes;
    }

    public void setEnchufes(Double enchufes) {
        this.enchufes = enchufes;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
