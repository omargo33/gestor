package model.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import sun.misc.BASE64Encoder;

/**
 * Objeto para generar encripciones
 * 
 * @author omargo33@hotmail.com
 * 
 */
public class GeneradorEncripcion {
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
                MessageDigest.getInstance("SHA1").digest(cadena.getBytes()));
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