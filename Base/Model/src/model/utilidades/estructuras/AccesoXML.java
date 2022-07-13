package model.utilidades.estructuras;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.utilidades.GeneradorEncripcion;
import model.utilidades.estructuras.acceso.Acceso;










public class AccesoXML
  extends Acceso
{
    public AccesoXML() { setEncriptado(false); }






  
  private String getXML() {
      String respuesta = "";
    try {
        JAXBContext context = JAXBContext.newInstance(new Class[] { Acceso.class });
        Marshaller mar = context.createMarshaller();
        mar.setProperty("jaxb.formatted.output", Boolean.TRUE);
        StringWriter sw = new StringWriter();
        mar.marshal(this, sw);
        respuesta = sw.toString();
      } catch (JAXBException e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        respuesta = "";
    } 
      return respuesta;
  }






  
  private boolean cargarXML(String xml) {
      boolean estado = true;
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] { Acceso.class });
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      
        StringReader reader = new StringReader(xml);
        Acceso accesoPivote = (Acceso)unmarshaller.unmarshal(reader);
        setFechaEmision(accesoPivote.getFechaEmision());
        setFechaValido(accesoPivote.getFechaValido());
        setSemilla(accesoPivote.getSemilla());
        setPassword(accesoPivote.getPassword());
        setUsuario(accesoPivote.getUsuario());
        setEncriptado(accesoPivote.isEncriptado());
      } catch (JAXBException e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        estado = false;
    } 
    
      return estado;
  }




  
  private void cifrar() {
      if (!isEncriptado()) {
        setPassword(GeneradorEncripcion.cifrar(getSemilla(), getPassword()));
        setUsuario(GeneradorEncripcion.cifrar(getSemilla(), getUsuario()));
        setEncriptado(true);
    } 
  }




  
  private void decifrar() {
      if (isEncriptado()) {
        setPassword(GeneradorEncripcion.decifrar(getSemilla(), getPassword()));
        setUsuario(GeneradorEncripcion.decifrar(getSemilla(), getUsuario()));
        setEncriptado(false);
    } 
  }





  
  public String code() {
      cifrar();
      byte[] encodedBytes = Base64.getUrlEncoder().encode(getXML().getBytes());
      return new String(encodedBytes);
  }




  
  public void decode(String base64) {
      byte[] decodedBytes = Base64.getUrlDecoder().decode(base64);
      if (cargarXML(new String(decodedBytes))) {
        decifrar();
    } else {
        Logger.getLogger("global").log(Level.SEVERE, "000005");
    } 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/estructuras/AccesoXML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */