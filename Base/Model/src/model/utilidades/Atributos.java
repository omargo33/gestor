package model.utilidades;


import java.sql.Timestamp;

import java.util.Date;

import oracle.jbo.Row;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase para dar atributos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Atributos {
    public static final String NO_APLICA = "<NO APLICA>";

    /**
     * String no null.
     *
     * @param valor
     * @param datoIntercambio
     * @return
     */
    public static String stringNoNull(Object valor, String datoIntercambio) {
        if (StringUtils.isBlank(String.valueOf(valor))) {
            return datoIntercambio;
        }
        return String.valueOf(valor).trim();
    }

    /**
     * Obtiente el valor int de un objeto.
     *
     * @param valor
     * @return
     */
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

    /**
     * Trunca un valor string.
     *
     * @param valor
     * @param datoIntercambio
     * @param largo
     * @return
     */
    public static String stringLargo(Object valor, String datoIntercambio, int largo) {
        String respuesta = stringNoNull(valor, datoIntercambio);
        return StringUtils.substring(respuesta, 0, largo);
    }

    /**
     * Al ser nulo pone un valor por default.
     *
     * @param row
     * @param campo
     * @param datoIntercambio
     * @return
     */
    public String nvl(Row row, int campo, String datoIntercambio) {
        return (row.getAttribute(campo) == null) ? datoIntercambio : row.getAttribute(campo).toString();
    }

    /**
     * Get metodo SysTime mas tiempo en milisegundos.
     *
     * @param milisegundos
     * @return
     */
    public static Timestamp sysTime(long milisegundos) {
        return new Timestamp((new Date()).getTime() + milisegundos);
    }

    /**
     * Systime del servidor de aplicaciones.
     *
     * @return
     */
    public static Timestamp sysTime() {
        return sysTime(0L);
    }

    /**
     * Fecha 
     *
     * @return
     */
    public static Date sysDate() {
        return sysDate(0L);
    }

    /**
     * Fecha mas milisegundos.
     *
     * @param milisegundos
     * @return
     */
    public static Date sysDate(long milisegundos) {
        Date sqlDate = new Date((new Date()).getTime() + milisegundos);
        return sqlDate;
    }
}