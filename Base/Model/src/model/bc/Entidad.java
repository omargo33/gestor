package model.bc;

import java.text.MessageFormat;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.sql.DML;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.JboException;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.EntityRowSetImpl;

/**
 * Objeto para dar soporte a tablas en base de datos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Entidad extends EntityImpl implements BundleInterface {
    private static String SQL_LAST_ID = "SELECT last_insert_id()";

    private static String SQL_PARAMETRO_TEXTO_01 =
        "SELECT p.valor_texto_01 FROM GS_001_00.parametro p, GS_001_00.modulo m WHERE p.id_modulo = m.id_modulo and m.indice = ? and p.indice = ?";
    private static String SQL_PARAMETRO_TEXTO_02 =
        "SELECT p.valor_texto_02 FROM GS_001_00.parametro p, GS_001_00.modulo m WHERE p.id_modulo = m.id_modulo and m.indice = ? and p.indice = ?";
    private static String SQL_PARAMETRO_NUMERO_01 =
        "SELECT p.valor_numero_01 FROM GS_001_00.parametro p, GS_001_00.modulo m WHERE p.id_modulo = m.id_modulo and m.indice = ? and p.indice = ?";
    private static String SQL_PARAMETRO_NUMERO_02 =
        "SELECT p.valor_numero_02 FROM GS_001_00.parametro p, GS_001_00.modulo m WHERE p.id_modulo = m.id_modulo and m.indice = ? and p.indice = ?";

    private DML baseDML;
    private ResourceBundle resourceBundle = null;

    /**
     * Metodo para crear el objeto de entidad.
     *
     */
    public Entidad() {
        super();
        baseDML = new DML() {
            @Override
            public DBTransaction getDBTransaction() {
                return miThis().getDBTransaction();
            }
        };
    }

    /**
     * Metodo para conocer un parametro de texto 01
     *
     * @param indice
     * @return
     */
    public String getParametroTexto01(String indice) {
        String respuesta = "";
        try {
            respuesta =
                (String) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_TEXTO_01, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }
    
    /**
     * Metodo para conocer un parametro de texto 01
     *
     * @param indice
     * @return
     */
    public String getParametroTexto02(String indice) {
        String respuesta = "";
        try {
            respuesta =
                (String) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_TEXTO_02, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }
    
    /**
     * Metodo para conocer un parametro de Valor 01
     *
     * @param indice
     * @return
     */
    public Double getParametroValor01(String indice) {
        double respuesta = 0f;
        try {
            respuesta =
                (Double) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_NUMERO_01, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }
    
    /**
     * Metodo para conocer un parametro de Valor 02
     *
     * @param indice
     * @return
     */
    public Double getParametroValor02(String indice) {
        double respuesta = 0f;
        try {
            respuesta =
                (Double) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_NUMERO_02, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }




    /**
     * Metodo para validar si se borra o no un registro.
     *
     * @param codigosVerificacion
     */
    public void noBorrar(int... codigosVerificacion) {
        EntityRowSetImpl rowSet = null;
        int largo = 0;
        for (int i : codigosVerificacion) {
            try {
                rowSet = (EntityRowSetImpl) getAttribute(i);
                largo = rowSet.size();
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            }

            if (largo > 0) {
                throw new JboException("");
            }
        }
    }

    /**
     * Pivote para encapsular este objeto.
     *
     * @return
     */
    public EntityImpl miThis() {
        return this;
    }

    /**
     * Metodo para obtener el ultimo codigo insertado.
     *
     * @return
     */
    public int getUltimoId() {
        int codigo = 0;
        Object ultimoCodigo = baseDML.ejecutaConsultaUnicoDato(SQL_LAST_ID);
        if (baseDML.getMensaje() == null) {
            try {
                codigo = new Integer(String.valueOf(ultimoCodigo)).intValue();
            } catch (Exception e) {
                codigo = -1;
            }
        }
        return codigo;
    }

    /**
     * Metodo para llamar una un mensaje bundle para los mensajes del sistema.
     *
     * @param llaveBundle
     * @param parametros
     * @return
     */
    public String getBundle(String llaveBundle, Object... parametros) {
        if (resourceBundle == null)
            return "<No Definido, Bundle no Instanciado>";

        String mensaje = resourceBundle.getString(llaveBundle);
        if (mensaje == null)
            return String.format("<No Definido, %s llave no encontrada>", llaveBundle);

        if (parametros == null)
            return mensaje;

        return MessageFormat.format(mensaje, parametros);
    }

    /**
     * Metodo base de uso de conexiones a base de datos.
     *
     * @return
     */
    public DML getBaseDML() {
        return this.baseDML;
    }

    /**
     * Metodo para set nombre bundle.
     *
     * @param nombreBundle
     */
    public void setNombreBundle(String nombreBundle) {
        resourceBundle = BundleFactory.getBundle(nombreBundle);
    }
}
