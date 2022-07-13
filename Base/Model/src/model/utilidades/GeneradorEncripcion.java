package model.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import sun.misc.BASE64Encoder;
















public class GeneradorEncripcion
{
  public static final String REALM_WEBLOGIC_12 = "WLS12";
  public static final String REALM_GLASSFISH_5 = "GF5";
  
  public static String cifrar(String semilla, String cadena) {
      if (cadena == null)
        return cadena; 
    try {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(semilla);
        return standardPBEStringEncryptor.encrypt(cadena);
      } catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        return null;
    } 
  }






  
  public static String decifrar(String semilla, String cadena) {
      if (cadena == null)
        return cadena; 
    try {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(semilla);
        return standardPBEStringEncryptor.decrypt(cadena);
      } catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        return cadena;
    } 
  }








  
  public static String SHA1Weblogic12c(String cadena) {
      String respuesta = "";
    try {
        respuesta = "{SHA-1}" + (new BASE64Encoder()).encode(
          
            MessageDigest.getInstance("SHA1")
            .digest(cadena.getBytes()));
      } catch (NoSuchAlgorithmException e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
    } 
      return respuesta;
  }







  
  public static String SHA256Glassfish5(String cadena) {
      String respuesta = null;
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(cadena.getBytes("UTF-8"));
        respuesta = DatatypeConverter.printHexBinary(hash);
      } catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
    } 
      return respuesta;
  }








  
  public static String cifrarRealm(String servidor, String cadena) {
      if (servidor.compareTo("WLS12") == 0) {
        return SHA1Weblogic12c(cadena);
    }
      if (servidor.compareTo("GF5") == 0) {
        return SHA256Glassfish5(cadena);
    }
    
      return "";
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/GeneradorEncripcion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */