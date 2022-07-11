
package model.utilidades.estructuras.acceso;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="semilla" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="fechaValido" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="encriptado" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
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

    /**
     * Gets the value of the semilla property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSemilla() {
        return semilla;
    }

    /**
     * Sets the value of the semilla property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSemilla(String value) {
        this.semilla = value;
    }

    /**
     * Gets the value of the usuario property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsuario() {
        if (validarTimeOutXML()) {
            return usuario;
        }
        return "******";
    }

    /**
     * Sets the value of the usuario property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPassword() {

        if (validarTimeOutXML()) {
            return password;
        } else
            return "******";
    }

    /**
     * Sets the value of the password property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the fechaEmision property.
     *
     */
    public long getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Sets the value of the fechaEmision property.
     *
     */
    public void setFechaEmision(long value) {
        this.fechaEmision = value;
    }

    /**
     * Gets the value of the fechaValido property.
     *
     */
    public long getFechaValido() {
        return fechaValido;
    }

    /**
     * Sets the value of the fechaValido property.
     *
     */
    public void setFechaValido(long value) {
        this.fechaValido = value;
    }

    public void setEncriptado(boolean encriptado) {
        this.encriptado = encriptado;
    }

    public boolean isEncriptado() {
        return this.encriptado;
    }


    /**
     * Valida que la fecha de validez sea superior a la fecha de ingreso.
     *
     * @return
     */
    private boolean validarTimeOutXML() {
        boolean estado = true;
        Long fechaActual = new Date().getTime();
        if (this.getFechaValido() < fechaActual) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "000006");
            estado = false;
        }
        return estado;
    }
}
