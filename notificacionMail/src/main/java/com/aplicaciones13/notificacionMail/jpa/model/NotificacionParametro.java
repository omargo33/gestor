/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones13.notificacionMail.jpa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author omarv
 */
@Entity
@Table(name = "notificacion_parametro")
public class NotificacionParametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_notificacion_parametro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacionParametro;

    @Column(name = "id_notificacion")
    private Long idNotificacion;
    @Column(length = 64)
    private String llave;
    @Column(length = 512)
    private String valor;
    @Column(length = 8)
    private String tipo;

    public Long getIdNotificacionParametro() {
        return idNotificacionParametro;
    }

    public void setIdNotificacionParametro(Long idNotificacionParametro) {
        this.idNotificacionParametro = idNotificacionParametro;
    }

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacion != null ? idNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificacionParametro)) {
            return false;
        }
        NotificacionParametro other = (NotificacionParametro) object;
        if ((this.idNotificacion == null && other.idNotificacion != null) || (this.idNotificacion != null && !this.idNotificacion.equals(other.idNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificacionParametro{idNotificacionParametro=").append(idNotificacionParametro);
        sb.append(", idNotificacion=").append(idNotificacion);
        sb.append(", llave=").append(llave);
        sb.append(", valor=").append(valor);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

}
