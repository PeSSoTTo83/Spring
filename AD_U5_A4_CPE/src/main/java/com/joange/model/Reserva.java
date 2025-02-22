package com.joange.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Long idreserva;

    /**
     * Campo tipo DATE en la base de datos.
     * Usamos @Temporal(TemporalType.DATE) + @DateTimeFormat si quieres parsear "yyyy-MM-dd" del formulario.
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechadesde;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechahasta;

    /**
     * Campo tipo TIME en la base de datos.
     * Usamos @Temporal(TemporalType.TIME) + @DateTimeFormat(pattern="HH:mm") para parsear "HH:mm".
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horadesde;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date horahasta;

    /**
     * Campo para indicar si está validada (por ejemplo, "S"/"N", "1"/"0", etc.)
     */
    @Column(name = "validar", length = 1, nullable = true)
    private String validar;

    /**
     * Campo activo (también "1"/"0" o "S"/"N").
     */
    @Column(name = "activo", length = 1, nullable = true)
    private String activo;

    /**
     * Foráneas:
     * - AULAidaula
     * - USUARIOidusuario
     * - CURSOidcurso
     * Cada una mapeada como Long para almacenar el ID.
     */
    @Column(name = "AULAidaula", nullable = false)
    private Long aulaidaula;

    @Column(name = "USUARIOidusuario", nullable = false)
    private Long usuarioidusuario;

    @Column(name = "CURSOidcurso", nullable = false)
    private Long cursoidcurso;

    public Reserva() {
    }

    public Reserva(Date fechadesde, Date fechahasta, Date horadesde, Date horahasta,
                   String validar, String activo,
                   Long aulaidaula, Long usuarioidusuario, Long cursoidcurso) {
        this.fechadesde = fechadesde;
        this.fechahasta = fechahasta;
        this.horadesde = horadesde;
        this.horahasta = horahasta;
        this.validar = validar;
        this.activo = activo;
        this.aulaidaula = aulaidaula;
        this.usuarioidusuario = usuarioidusuario;
        this.cursoidcurso = cursoidcurso;
    }

    public Long getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Long idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    public Date getHoradesde() {
        return horadesde;
    }

    public void setHoradesde(Date horadesde) {
        this.horadesde = horadesde;
    }

    public Date getHorahasta() {
        return horahasta;
    }

    public void setHorahasta(Date horahasta) {
        this.horahasta = horahasta;
    }

    public String getValidar() {
        return validar;
    }

    public void setValidar(String validar) {
        this.validar = validar;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Long getAulaidaula() {
        return aulaidaula;
    }

    public void setAulaidaula(Long aulaidaula) {
        this.aulaidaula = aulaidaula;
    }

    public Long getUsuarioidusuario() {
        return usuarioidusuario;
    }

    public void setUsuarioidusuario(Long usuarioidusuario) {
        this.usuarioidusuario = usuarioidusuario;
    }

    public Long getCursoidcurso() {
        return cursoidcurso;
    }

    public void setCursoidcurso(Long cursoidcurso) {
        this.cursoidcurso = cursoidcurso;
    }
}
