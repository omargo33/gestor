package model.utilidades;

import java.util.Date;

import oracle.jbo.Row;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * Objeto con utilidades para laborar con los datos de Mysql y evitar problemas de convertibilidad y truncado.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Atributos {
    
    public static final String NO_APLICA = "<NO APLICA>";

    /**
     * Metodo para eviar null.
     *
     * @param valor
     * @param datoIntercambio
     * @return
     */
    public static String stringNoNull(Object valor, String datoIntercambio) {
        if (StringUtils.isBlank(String.valueOf(valor)))
            return datoIntercambio;

        return String.valueOf(valor).trim();
    }

    /** 
     * Metodo para devolver un entero.
     *
     * @param valor
     * @return
     */
    public static java.lang.Integer intValue(Object valor) {
        Integer respuesta = 0;
        if (valor != null) {
            if (valor instanceof java.lang.Integer) {
                respuesta = (Integer) valor;
            }
            else 
                respuesta = -1;
        }
        return respuesta;
    }
    
    /**
     * Metodo para evitar un campo mas largo de lo permitido.
     *
     *
     * @param valor
     * @param datoIntercambio
     * @param largo
     * @return
     */
    public static String stringLargo(Object valor, String datoIntercambio,  int largo) {        
        String respuesta = stringNoNull( valor, datoIntercambio);        
        return StringUtils.substring(respuesta,0,largo);
    }

    /**
     * Metodo para intercambio de datos.
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
     * Metodo para generar una fecha del sistema con un calculo de fechas.
     *
     * @param milisegundos
     * @return
     */
    public static java.sql.Timestamp sysTime(long milisegundos) {
        return new java.sql.Timestamp(new java.util.Date().getTime() + milisegundos);
    }

    /**
     * Metodo para obtener la fecha de el sistema.
     *
     * @return
     */
    public static java.sql.Timestamp sysTime() {
        return sysTime(0);
    }

    /**
     * Metodo para obtener la fecha de el sistema.
     *
     * @return
     */
    public static Date sysDate() {
        return sysDate(0);
    }

    /**
     * Metodo para obtener la fecha de el sistema.
     *
     * @param milisegundos
     * @return
     */
    public static Date sysDate(long milisegundos) {
        java.util.Date sqlDate = new java.sql.Date(new java.util.Date().getTime() + milisegundos);
        return sqlDate;
    }
}
