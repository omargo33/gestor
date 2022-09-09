package model;

import java.util.Calendar;
import java.util.Date;

import model.utilidades.GeneradorClaves;
import model.utilidades.estructuras.AccesoXML;


public class GeneradorIngreso {
    public static void main(String[] args) {
        //String usuario = "aerocivil";
        String usuario = "aerocivil";
        
        //String usuario = "joy";
        String clave = "admin1admin";
        //String aplicacion = "Manifiesto-001";
        String aplicacion = "Manifiesto-001";        
        String puertoWebLogic = "7101";
        String puertoGlass = "28082";


        String semilla = GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 32);
        Date fechaInicio = new Date();
        Date fechaFin = addMinutosToDate(fechaInicio, 20);

        AccesoXML accesoXML = new AccesoXML();
        accesoXML.setFechaEmision(fechaInicio.getTime());
        accesoXML.setFechaValido(fechaFin.getTime());
        accesoXML.setSemilla(semilla);
        accesoXML.setUsuario(usuario);
        accesoXML.setPassword(clave);


        String data =
            "http://192.168.1.7:" + puertoWebLogic + "/" + aplicacion + "/faces/LOG001?server=WLS12&token=" +
            accesoXML.code();
        System.out.println("Weblogic\n" + data + "\n");

        accesoXML = new AccesoXML();
        accesoXML.setFechaEmision(fechaInicio.getTime());
        accesoXML.setFechaValido(fechaFin.getTime());
        accesoXML.setSemilla(semilla);
        accesoXML.setUsuario(usuario);
        accesoXML.setPassword(clave);


        data =
            "http://192.168.1.7:" + puertoGlass + "/" + aplicacion + "/faces/LOG001?server=GF5&token=" +
            accesoXML.code();
        System.out.println("Glassfish\n" + data + "\n");
    }


    private static Date addMinutosToDate(Date fecha, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/GeneradorIngreso.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */