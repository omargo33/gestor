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
@Table(name = "formato")
public class Formato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_formato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormato;
    @Column(length = 32)
    private String indice;
    @Column(length = 128)
    private String nombre;
    @Column(name="formato_html",length = 4096)
    private String formatoHtml;    
    @Column(length = 128)
    private String usuario;
    @Column(name = "usuario_fecha", columnDefinition = "DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date usuarioFecha;
    @Column(name = "usuario_programa", length = 128)
    private String usuarioPrograma;

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormatoHtml() {
        return formatoHtml;
    }

    public void setFormatoHtml(String formatoHtml) {
        this.formatoHtml = formatoHtml;
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
        hash += (idFormato != null ? idFormato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formato)) {
            return false;
        }
        Formato other = (Formato) object;
        if ((this.idFormato == null && other.idFormato != null) || (this.idFormato != null && !this.idFormato.equals(other.idFormato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Formato{idFormato=").append(idFormato);
        sb.append(", indice=").append(indice);
        sb.append(", nombre=").append(nombre);
        sb.append(", formato_html=").append(formatoHtml);
        sb.append(", usuario=").append(usuario);
        sb.append(", usuarioFecha=").append(usuarioFecha);
        sb.append(", usuarioPrograma=").append(usuarioPrograma);
        sb.append('}');
        return sb.toString();
    }
}
