package modelAdministrativo.bc.modulo;

import java.sql.CallableStatement;
import java.sql.Types;

import java.util.logging.Level;
import java.util.logging.Logger;

import modelAdministrativo.bc.AdministrativoModuloImpl;

import oracle.jbo.JboException;


/**
 *
 * Clase para dar soporte al ordenamiento del datos.
 *
 * @author omargo33@hotmail.com
 */
public class Menu {
    /**
     * Metodo para subir o bajar filas una a al vez
     *
     *
     * @param moduloAplicacion
     * @param idMenu
     * @param arriba
     * @return
     */
    public static int unMovimiento(AdministrativoModuloImpl moduloAplicacion, int idMenu,
                                   boolean arriba) {
        String sql = (arriba) ? "CALL menu_subir(?,?)" : "CALL menu_bajar(?,?)";
        int respuesta = -1;
        try {
            CallableStatement st =
                moduloAplicacion.getDBTransaction()
                .createCallableStatement(sql, moduloAplicacion.getDBTransaction().DEFAULT);
            st.setInt(1, idMenu);
            st.registerOutParameter(2, Types.BIGINT);
            st.execute();
            respuesta = st.getInt(2);
            //moduloAplicacion.errorMysql(respuesta, "modelAdministrativo.bc.modulo.unMovimiento");
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.SEVERE,
                     moduloAplicacion.getBundle("000003", sql, "modelAdministrativo.bc.modulo", "unMovimiento",
                                                e.toString()));
            throw new JboException(moduloAplicacion.getBundle("CodigoDefinidoUsuario.unMovimiento"));
        }
        return respuesta;

    }

    /**
     * Metodo para ejecutar extremos.
     *
     * @param moduloAplicacion
     * @param idMenu
     * @param ubicacion
     * @return
     */
    public static int ejecutarExtremos(AdministrativoModuloImpl moduloAplicacion, int idMenu,
                                       int ubicacion) {
        String sql = "CALL menu_extremos(?,?,?)";
        int respuesta = -1;
        try {
            CallableStatement st =
                moduloAplicacion.getDBTransaction()
                .createCallableStatement(sql, moduloAplicacion.getDBTransaction().DEFAULT);
            st.setInt(1, idMenu);
            st.setInt(2, ubicacion);
            st.registerOutParameter(3, Types.BIGINT);
            st.execute();
            respuesta = st.getInt(3);
            //moduloAplicacion.errorMysql(respuesta, "modelAdministrativo.bc.modulo.ejecutarExtremos");
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.SEVERE,
                     moduloAplicacion.getBundle("000003", sql, "modelAdministrativo.bc.modulo", "ejecutarExtremos",
                                                e.toString()));
            throw new JboException(moduloAplicacion.getBundle("CodigoDefinidoUsuario.ejecutarExtremos"));
        }
        return respuesta;
    }
}