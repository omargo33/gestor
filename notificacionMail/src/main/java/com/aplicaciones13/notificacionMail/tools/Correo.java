package com.aplicaciones13.notificacionMail.tools;

import com.sun.mail.util.MailSSLSocketFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Objeto para enviar un correo de manera personalizada con las propiedades
 * como:
 *
 * 13a.usuario=test.portal@jardinazuayo.fin.ec
 * 13a.clave=Testportal.2022
 * 13a.instancia.servidor=false
 * 13a.acceso.ssl=true 
 * mail.smtp.host=smt
 * mail.smtp.host=172.18.34.9 
 * mail.smtp.socketFactory.port=465
 * mail.smtp.ssl.enable=true
 * mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
 * mail.smtp.auth=true 
 * mail.smtp.port=465 
 * mail.debug=false
 * mail.smtp.starttls.enable=true
 *
 * @author omargo33@hotmail.com
 *
 */
public class Correo {

    private static final Logger LOG = LoggerFactory.getLogger(Correo.class);
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private boolean accesoSSL;
    private boolean instaciaServidorAplicacion;

    private String correo;
    private String asunto;
    private String cuerpo;
    private String userName;
    private String clave;
    private String descripcionEstado;

    private Date fechaInicio;
    private Date fechaFin;

    private Properties propiedades;

    private List<String> adjuntos;
    private List<String> adjuntosRespuesta;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Correo() {
        super();
        limpiar();
    }

    /**
     * Metodo para limpiar los datos del proceso de envio del correo.
     *
     */
    private void limpiar() {
        this.accesoSSL = false;
        this.instaciaServidorAplicacion = false;
        this.clave = "";
        this.userName = "";
        setAsunto("");
        setCorreo("");
        setCuerpo("");
        this.descripcionEstado = "";
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.propiedades = new Properties();
        setAdjuntos(new ArrayList<>());
        this.adjuntosRespuesta = new ArrayList<>();
    }

    /**
     * Metodo para enviar el correo con utilizacion de exception para facilitar
     * el uso.
     *
     * @return
     */
    public boolean enviarCorreo() {
        boolean estado = false;
        
        if (validarCorreo()) {
            try {
                enviarMail();
                estado = true;
            } catch (Exception e) {
                LOG.error("Correo {} no se pudo enviar por {}", this.correo, e.toString());
                descripcionEstado = "Tiene el siguiente error:" + e.toString();
            }
        } else {
            LOG.error("Correo {} no tiene el formato correcto", this.correo);
            descripcionEstado = "Correo invalido";
        }
        return estado;
    }

    /**
     * Metodo para enviar un correo.
     *
     * Valida que el correo este con el formato adecuado Genera la autorizacion
     * del servidor de correo. Toma los datos de la session. Inserta
     * destinatario. Inserta emisor Agrega asunto Agrega mensaje Agrega los
     * adjuntos y corrige el mensaje en cuerpos multipart De ser necesario hace
     * cambios en los documentos electronicos en los nombres de los documentos
     * Envia el mail.
     *
     * @throws AddressException
     * @throws MessagingException
     * @throws IOException
     */
    private void enviarMail() throws AddressException, MessagingException, IOException, Exception {
        Authenticator autentificacion = new SMTPAuthenticator();

        if (accesoSSL) {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            this.propiedades.put("mail.smtp.ssl.socketFactory", sf);
        }

        Session session = Session.getDefaultInstance(this.propiedades, autentificacion);
        if (!instaciaServidorAplicacion) {
            session = Session.getInstance(this.propiedades, autentificacion);
        }

        MimeMessage message = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(this.userName);
        message.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[1];
        addressTo[0] = new InternetAddress(this.correo);
        message.setRecipients(Message.RecipientType.TO, addressTo);

        message.setSubject(this.asunto);
        message.setContent(this.cuerpo, "text/html; charset=utf-8");

        if (this.adjuntos.size() > 0) {
            MimeMultipart multipart = new MimeMultipart();

            BodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(this.cuerpo, "text/html; charset=utf-8");

            if (this.adjuntos.size() > 0) {
                validaAdjuntos();
                for (String a : this.adjuntos) {
                    if (a != null) {
                        try {
                            MimeBodyPart messageBodyPart = new MimeBodyPart();
                            messageBodyPart.attachFile(a);
                            messageBodyPart.setFileName(messageBodyPart.getFileName());
                            multipart.addBodyPart(messageBodyPart);
                        } catch (IOException | MessagingException e) {
                            this.adjuntosRespuesta.add(a + " " + e.toString());
                            LOG.error("enviarMail() - add attachment {}", e.toString());
                        }
                    }
                }
            }

            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);
        }

        Transport.send(message);
    }

    /**
     * Metodo para hacer una validacion de correo electronico.
     *
     * @return
     */
    private boolean validarCorreo() {
        Pattern pattern = pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(this.correo);
        return matcher.matches();
    }

    /**
     * Metodo para validar los adjuntos
     *
     */
    private void validaAdjuntos() {
        List<String> listaTemporal = new ArrayList<>();
        for (String a : this.adjuntos) {
            File fichero = new File(a);
            if (fichero.exists()) {
                listaTemporal.add(a);
            }
        }
        if (listaTemporal.isEmpty()) {
            this.descripcionEstado = String.format("Se esperaban %s adjunto(s), y se validaron %s",
                    this.adjuntos.size(),
                    listaTemporal.size());
        }
        setAdjuntos(listaTemporal);
    }

    /**
     * Metodo para cambiar de forma adecuado los ascentos latinos y la eñe
     *
     * Si se desea que el asunto tenga las eñes, varia en los navegadores y se
     * decidio quitarlas para evitar complicaciones.
     *
     * @param textoACambiar
     * @return
     */
    private String changeCharSet(String textoACambiar, boolean asunto) {
        if (textoACambiar == null) {
            return "";
        }
        if (asunto) {
            textoACambiar = textoACambiar.replaceAll("á", "a");
            textoACambiar = textoACambiar.replaceAll("é", "e");
            textoACambiar = textoACambiar.replaceAll("í", "i");
            textoACambiar = textoACambiar.replaceAll("ó", "o");
            textoACambiar = textoACambiar.replaceAll("ú", "u");
            textoACambiar = textoACambiar.replaceAll("ñ", "n");
        } else {
            textoACambiar = textoACambiar.replaceAll("á", "&aacute;");
            textoACambiar = textoACambiar.replaceAll("é", "&eacute;");
            textoACambiar = textoACambiar.replaceAll("í", "&iacute;");
            textoACambiar = textoACambiar.replaceAll("ó", "&oacute;");
            textoACambiar = textoACambiar.replaceAll("ú", "&uacute;");
            textoACambiar = textoACambiar.replaceAll("ñ", "&ntilde;");

            textoACambiar = textoACambiar.replaceAll("\\\\u00E1", "&aacute;");
            textoACambiar = textoACambiar.replaceAll("\\\\u00E9", "&eacute;");
            textoACambiar = textoACambiar.replaceAll("\\\\u00ED", "&iacute;");
            textoACambiar = textoACambiar.replaceAll("\\\\u00F3", "&oacute;");
            textoACambiar = textoACambiar.replaceAll("\\\\u00FA", "&uacute;");
            textoACambiar = textoACambiar.replaceAll("\\\\u00F1", "&ntilde;");
        }

        try {
            byte[] latin1 = textoACambiar.getBytes("utf-8");
            return new String(latin1);
        } catch (UnsupportedEncodingException e) {
            return textoACambiar;
        }
    }

    /**
     * Metodo para poner las propiedades a partir de una cadna de String
     *
     * Tomar las propiedades especificas del sistema Borrara las propiedades
     * especificas.
     *
     * @param propiedadesTexto
     */
    public void setPropiedades(String propiedadesTexto) {
        try {
            String valorTrueString = "";
            this.propiedades = new Properties();
            this.propiedades.load(new StringReader(propiedadesTexto.trim().replace(" ", "\n")));
            this.userName = this.propiedades.getProperty("13a.usuario");
            this.clave = this.propiedades.getProperty("13a.clave");

            valorTrueString = this.propiedades.getProperty("13a.instancia.servidor");
            
            this.instaciaServidorAplicacion = valorTrueString.equalsIgnoreCase("true");

            valorTrueString = this.propiedades.getProperty("13a.acceso.ssl");
            this.accesoSSL = valorTrueString.equalsIgnoreCase("true");

            this.propiedades.remove("13a.usuario");
            this.propiedades.remove("13a.clave");
            this.propiedades.remove("13a.instancia.servidor");
            this.propiedades.remove("13a.acceso.ssl");
        } catch (IOException ex) {
            LOG.error("No se puede procesar las propiedades {}", ex.toString());
        }
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAsunto(String asunto) {
        this.asunto = changeCharSet(asunto, true);
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = changeCharSet(cuerpo, false);
    }

    public void setAdjuntos(List<String> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public String getDescripcionEstado() {
        return this.descripcionEstado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public List<String> getAdjuntosRespuesta() {
        return adjuntosRespuesta;
    }

    //Propiedades para pasar datos a objeto de seguridades.
    public String getUserName() {
        return this.userName;
    }

    public String getClave() {
        return this.clave;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Correo{accesoSSL=").append(accesoSSL);
        sb.append(", instaciaServidorAplicacion=").append(instaciaServidorAplicacion);
        sb.append(", correo=").append(correo);
        sb.append(", asunto=").append(asunto);
        sb.append(", cuerpo=").append(cuerpo);
        sb.append(", userName=").append(userName);
        sb.append(", clave=").append(clave);
        sb.append(", descripcionEstado=").append(descripcionEstado);
        sb.append(", fechaInicio=").append(fechaInicio);
        sb.append(", fechaFin=").append(fechaFin);
        sb.append(", propiedades=").append(propiedades);
        sb.append(", adjuntos=").append(adjuntos);
        sb.append(", adjuntosRespuesta=").append(adjuntosRespuesta);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Objeto para redifinir al autenticacion al sito.
     *
     * @author omarv omargo33@hotmail.com
     *
     */
    private class SMTPAuthenticator extends javax.mail.Authenticator {

        /**
         * Metodo para sobrecargar la obtencion del password.
         *
         * @return
         */
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getUserName(), getClave());
        }
    }
}
