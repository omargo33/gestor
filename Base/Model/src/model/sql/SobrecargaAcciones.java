package model.sql;

import java.io.Serializable;

import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para poder sobrecargar la forma de actuar de los mentodos de conexion a la base de datos y a procesos en backgroud.
 *
 * @author omargo33@hotmail.com
 *
 */
public class SobrecargaAcciones implements Serializable {
    @SuppressWarnings("compatibility:6414916207457291239")

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    private String NO_DEFINIDO = "<NO-DEFINIDO>";

    /**
     * Accion a ser invocada, la misma que tendra que ser reescrita pra su funcionamiento.
     */
    public void accionExtra() {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, NO_DEFINIDO);
    }

    /**
     * Metodo para eachWorkResult.
     *
     * @throws SQLException
     * @throws Exception
     */
    @SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
    public void eachWorkResultSet() throws SQLException, java.lang.Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, NO_DEFINIDO);
    }
}
