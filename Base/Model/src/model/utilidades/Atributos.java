package model.utilidades;


import java.sql.Timestamp;

import java.util.Date;

import oracle.jbo.Row;

import org.apache.commons.lang3.StringUtils;


public class Atributos {
    public static final String NO_APLICA = "<NO APLICA>";

    public static String stringNoNull(Object valor, String datoIntercambio) {
        if (StringUtils.isBlank(String.valueOf(valor))) {
            return datoIntercambio;
        }
        return String.valueOf(valor).trim();
    }


    public static Integer intValue(Object valor) {
        Integer respuesta = Integer.valueOf(0);
        if (valor != null)
            if (valor instanceof Integer) {
                respuesta = (Integer) valor;
            } else {

                respuesta = Integer.valueOf(-1);
            }
        return respuesta;
    }


    public static String stringLargo(Object valor, String datoIntercambio, int largo) {
        String respuesta = stringNoNull(valor, datoIntercambio);
        return StringUtils.substring(respuesta, 0, largo);
    }


    public String nvl(Row row, int campo, String datoIntercambio) {
        return (row.getAttribute(campo) == null) ? datoIntercambio : row.getAttribute(campo).toString();
    }


    public static Timestamp sysTime(long milisegundos) {
        return new Timestamp((new Date()).getTime() + milisegundos);
    }


    public static Timestamp sysTime() {
        return sysTime(0L);
    }


    public static Date sysDate() {
        return sysDate(0L);
    }


    public static Date sysDate(long milisegundos) {
        Date sqlDate = new Date((new Date()).getTime() + milisegundos);
        return sqlDate;
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/Atributos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */