/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.jpa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author omarv
 */
@Entity
@Table(name = "notificacion_evento")
public class NotificacionEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_notificacion_evento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacionEvento;

    @Column(name = "id_notificacion")
    private Long idNotificacion;

    @Column(length = 512)
    private String informacion;
    @Column(length = 8)
    private String tipo;

    @Column(length = 128)
    private String usuario;
    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;
    @Column(name = "usuario_programa", length = 128)
    private String usuarioPrograma;

    public Long getIdNotificacionEvento() {
        return idNotificacionEvento;
    }

    public void setIdNotificacionEvento(Long idNotificacionEvento) {
        this.idNotificacionEvento = idNotificacionEvento;
    }

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getUsuarioFecha() {
        return usuarioFecha;
    }

    public void setUsuarioFecha(Date usuarioFecha) {
        this.usuarioFecha = usuarioFecha;
    }

    public String getUsuarioPrograma() {
        return usuarioPrograma;
    }

    public void setUsuarioPrograma(String usuarioPrograma) {
        this.usuarioPrograma = usuarioPrograma;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacionEvento != null ? idNotificacionEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionEvento)) {
            return false;
        }
        NotificacionEvento other = (NotificacionEvento) object;
        if ((this.idNotificacionEvento == null && other.idNotificacionEvento != null) || (this.idNotificacionEvento != null && !this.idNotificacionEvento.equals(other.idNotificacionEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificacionEvento{idNotificacionEvento=").append(idNotificacionEvento);
        sb.append(", idNotificacion=").append(idNotificacion);
        sb.append(", informacion=").append(informacion);
        sb.append(", tipo=").append(tipo);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }

    
    

}
