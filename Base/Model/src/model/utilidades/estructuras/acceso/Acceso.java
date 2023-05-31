package model.utilidades.estructuras.acceso;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "semilla", "usuario", "password", "fechaEmision", "fechaValido", "encriptado" })
@XmlRootElement(name = "acceso")
public class Acceso {
    @XmlElement(required = true)
    protected String semilla;
    @XmlElement(required = true)
    protected String usuario;
    @XmlElement(required = true)
    protected String password;
    protected long fechaEmision;
    protected long fechaValido;
    protected boolean encriptado;

    public String getSemilla() {
        return this.semilla;
    }


    public void setSemilla(String value) {
        this.semilla = value;
    }


    public String getUsuario() {
        if (validarTimeOutXML()) {
            return this.usuario;
        }
        return "******";
    }


    public void setUsuario(String value) {
        this.usuario = value;
    }


    public String getPassword() {
        if (validarTimeOutXML()) {
            return this.password;
        }
        return "******";
    }


    public void setPassword(String value) {
        this.password = value;
    }


    public long getFechaEmision() {
        return this.fechaEmision;
    }


    public void setFechaEmision(long value) {
        this.fechaEmision = value;
    }


    public long getFechaValido() {
        return this.fechaValido;
    }


    public void setFechaValido(long value) {
        this.fechaValido = value;
    }


    public void setEncriptado(boolean encriptado) {
        this.encriptado = encriptado;
    }


    public boolean isEncriptado() {
        return this.encriptado;
    }


    private boolean validarTimeOutXML() {
        boolean estado = true;
        Long fechaActual = Long.valueOf((new Date()).getTime());
        if (getFechaValido() < fechaActual.longValue()) {
            Logger.getLogger("global").log(Level.SEVERE, "000006");
            estado = false;
        }
        return estado;
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/estructuras/acceso/Acceso.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */