package model.utilidades.estructuras;import java.io.StringReader;import java.io.StringWriter;import java.util.Base64;import java.util.logging.Level;import java.util.logging.Logger;import javax.xml.bind.JAXBContext;import javax.xml.bind.JAXBException;import javax.xml.bind.Marshaller;import javax.xml.bind.Unmarshaller;import model.utilidades.GeneradorEncripcion;import model.utilidades.estructuras.acceso.Acceso;/** * Objeto para optener informacion de usuario del un token. * * @author omargo33@hotmail.com */public class AccesoXML extends Acceso {    public AccesoXML() {        super();        setEncriptado(false);    }    /**     * Optiene el XML del objeto.     *     * @return     */    private String getXML() {        String respuesta = "";        try {            JAXBContext context = JAXBContext.newInstance(Acceso.class);            Marshaller mar = context.createMarshaller();            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);            StringWriter sw = new StringWriter();            mar.marshal(this, sw);            respuesta = sw.toString();        } catch (JAXBException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());            respuesta = "";        }        return respuesta;    }    /**     * Carga un XML para ser leido.     *     * @param xml     *     */    private boolean cargarXML(String xml) {        boolean estado = true;        try {            JAXBContext jaxbContext = JAXBContext.newInstance(Acceso.class);            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();            StringReader reader = new StringReader(xml);            Acceso accesoPivote = (Acceso) unmarshaller.unmarshal(reader);            this.setFechaEmision(accesoPivote.getFechaEmision());            this.setFechaValido(accesoPivote.getFechaValido());            this.setSemilla(accesoPivote.getSemilla());            this.setPassword(accesoPivote.getPassword());            this.setUsuario(accesoPivote.getUsuario());            this.setEncriptado(accesoPivote.isEncriptado());        } catch (JAXBException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());            estado = false;        }        return estado;    }    /**     * Metodo para cifrar el token     *     */    private void cifrar() {        if (!this.isEncriptado()) {            this.setPassword(GeneradorEncripcion.cifrar(this.getSemilla(), this.getPassword()));            this.setUsuario(GeneradorEncripcion.cifrar(this.getSemilla(), this.getUsuario()));            this.setEncriptado(true);        }    }    /**     * Metodo para descifrar el token.     */    private void decifrar() {        if (this.isEncriptado()) {            this.setPassword(GeneradorEncripcion.decifrar(this.getSemilla(), this.getPassword()));            this.setUsuario(GeneradorEncripcion.decifrar(this.getSemilla(), this.getUsuario()));            this.setEncriptado(false);        }    }    /**     * Metodo para codificar un xml en base64.     *     * @return     */    public String code() {        cifrar();        byte[] encodedBytes = Base64.getUrlEncoder().encode(getXML().getBytes());        return new String(encodedBytes);    }    /**     * Metodo para decodificar una base 64.     *     */    public void decode(String base64) {        byte[] decodedBytes = Base64.getUrlDecoder().decode(base64);        if (cargarXML(new String(decodedBytes))) {            decifrar();        } else {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "000005");        }    }}