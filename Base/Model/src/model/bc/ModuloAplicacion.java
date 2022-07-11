package model.bc;

import java.text.MessageFormat;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.sql.DML;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;

/**
 * Objeto para dar soporte a tablas en base de datos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class ModuloAplicacion extends ApplicationModuleImpl implements BundleInterface {

    private DML baseDML;
    private ResourceBundle resourceBundle = null;

    /**
     * Crear modulo de aplicacion.
     */
    public ModuloAplicacion() {
        super();

        baseDML = new DML() {
            @Override
            public DBTransaction getDBTransaction() {
                return miThis().getDBTransaction();
            }
        };
    }

    /**
     * Metodo base de uso de conexiones a base de datos.
     *
     * @return
     */
    public DML getBaseDML() {
        return this.baseDML;
    }

    /**Pivote para encapsular este objeto.
     *
     * @return
     */
    public ApplicationModuleImpl miThis() {
        return this;
    }

    /**Pivote para encapsular este objeto.
     *
     * @return
     */
    public ApplicationModuleImpl miHijo() {
        return this;
    }

    /**
     * Metodo para set nombre bundle.
     *
     * @param nombreBundle
     */
    public void setNombreBundle(String nombreBundle) {
        resourceBundle = BundleFactory.getBundle(nombreBundle);
    }

    /**
     * Metodo para llamar una un mensaje bundle para los mensajes del sistema.
     *
     * @param llaveBundle
     * @param parametros
     * @return
     */
    public String getBundle(String llaveBundle, Object... parametros) {
        String mensaje = "";
        if (resourceBundle == null)
            return "<No Definido, Bundle no Instanciado>";

        try {
            mensaje = resourceBundle.getString(llaveBundle);
            if (mensaje == null)
                return String.format("<No Definido, %s llave no encontrada>", llaveBundle);
        } catch (Exception e) {
            return String.format("<No Definido, %s llave no encontrada %s>", llaveBundle,
                                 resourceBundle.getBaseBundleName());
        }
        
        if (parametros == null)
            return mensaje;

        return MessageFormat.format(mensaje, parametros);
    }

    /**
     * Metodo para ejecutar un commit y rollback en caso de error y reportar el mismo.
     *
     * @param datoControl
     * @param metodo
     *
     * @return
     */
    public boolean commitRollback(Object datoControl, String metodo) {
        boolean estado = true;

        try {
            this.getDBTransaction().commit();
        } catch (JboException ex) {
            this.getDBTransaction().rollback();
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.SEVERE,
                     getBundle("000001", String.valueOf(datoControl), this.getClass().getName(), metodo, ex));
            estado = false;
        }
        return estado;
    }

    /**Metodo para refrescar una vista con Atributos llave.
     *
     * Si no tiene una fila "actual"
     *  Sale
     *
     * Toma la llave de la fila "actual"
     * Ejecuta una consulta para recargar los datos
     * Hace una busqueda con la llave original
     * Ejecuta una consulta para recargar los datos
     *
     * @param vistaRefrescar
     */
    public void refrescarVistaKeyAtribute(ViewObjectImpl vistaRefrescar) {
        try {
            if (vistaRefrescar.getCurrentRow() == null)
                return;

            Key llaveOriginal = vistaRefrescar.getCurrentRow().getKey();
            vistaRefrescar.executeQuery();
            vistaRefrescar.setCurrentRow(vistaRefrescar.findByKey(llaveOriginal, 1)[0]);
            vistaRefrescar.executeQuery();
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.SEVERE, ".refrescarVistaKeyAtribute()" + e.toString());
        }
    }


    /**
     * Metodo para ejecutar un commit y rollback en caso de error y reportar el mismo.
     *
     * @param datoControl
     * @param metodo
     *
     * @return
     */
    public boolean rollback(Object datoControl, String metodo) {
        boolean estado = true;

        try {
            this.getDBTransaction().rollback();
        } catch (JboException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                .log(Level.SEVERE,
                     getBundle("000000", String.valueOf(datoControl), this.getClass().getName(), metodo, ex));
            estado = false;

        }
        return estado;
    }

    /**
     * Metodo para reportar los errores de la Base de datos.
     *
     * @param codigoError
     * @param metodo "modelAdministrativo.bc.modulo"
     */
    public void errorMysql(int codigoError, String metodo) {
        if (codigoError != 0) {
            String mensajeError = getBundle("000004", metodo, "errorMysql", codigoError);
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, mensajeError);
            throw new JboException(getBundle("CodigoDefinidoUsuario.errorMysql"));
        }
    }
}
