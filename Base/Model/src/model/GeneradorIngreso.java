package model;

import java.util.Calendar;
import java.util.Date;

import model.utilidades.GeneradorClaves;
import model.utilidades.estructuras.AccesoXML;


public class GeneradorIngreso {
    
    private static String URL="http://%s/%s/faces/LOG001?server=%s&token=%s";
    public static void main(String[] args) {
        GeneradorIngreso.administradorWeblogic("aerocivil", "admin1admin", "Manifiesto-001", "localhost:7101");
        GeneradorIngreso.administradorWeblogic("admin", "admin1admin", "Administrativo-001", "localhost:7101");
        /*   
        GeneradorIngreso.administradorGlassfish("adim", "admin1admin", "Manifiesto-001", "localhost:28083");
        GeneradorIngreso.administradorGlassfish("adim", "admin1admin", "Administrativo-001", "localhost:28083");
        */
    }

    /**
     * Metodo para sacar fecha de terminacion de sesion.
     *
     * @param fecha
     * @param minutos
     * @return
     */
    private static Date addMinutosToDate(Date fecha, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }

    private static void administradorWeblogic(String usuario, String clave, String aplicacion, String hostoPuerto) {
        String data = String.format(URL,hostoPuerto,aplicacion, "WLS12", GeneradorIngreso.generaXML(usuario, clave));
        System.out.println("Weblogic:" + aplicacion + "\n" + data + "\n");
    }

    private static void administradorGlassfish(String usuario, String clave, String aplicacion, String hostoPuerto) {
        String data = String.format(URL,hostoPuerto,aplicacion, "GF5", GeneradorIngreso.generaXML(usuario, clave));        
        System.out.println("Glassfish:" + aplicacion + "\n" + data + "\n");
    }

    private static String generaXML(String usuario, String clave) {
        String semilla = GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 32);
        Date fechaInicio = new Date();
        Date fechaFin = addMinutosToDate(fechaInicio, 20);

        AccesoXML accesoXML = new AccesoXML();
        accesoXML.setFechaEmision(fechaInicio.getTime());
        accesoXML.setFechaValido(fechaFin.getTime());
        accesoXML.setSemilla(semilla);
        accesoXML.setUsuario(usuario);
        accesoXML.setPassword(clave);
        return accesoXML.code();
    }
}


