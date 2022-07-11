package model.sql;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.jbo.server.DBTransaction;

/**
 * Metodo para ejecutar eventos SQL
 *
 * Permite conexiones BC (modulo de aplicacion)
 * Permite conexiones BC (entidad)
 * Ejecutar consultas SQL
 * Ejecutar consultas SQL de dato unico
 * Ejecutar comandos DML.
 *
 * @author omargo33@hotmail.com
 *
 */
public class DML {
    private static String PALABRAS_RESERVADAS_INYECCION_SQL[] = {
        "SELECT", "FROM", "WHERE", "INSERT", "INTO", "IN TO", "UPDATE", "DELETE", "FROM", "/*", "--", "*/",
        "CA_USUARIOS", "CLIENTES", "SOCIOS"
    };

    private int size;
    private String mensaje;
    private String mensajeErrorDepuracion;
    private Object respuestaConsultaUnico;
    private SobrecargaAcciones sobrecargaAcciones;
    private ResultSet cursor;
    private PreparedStatement preparedStatement;

    /**
     * Metodo para crear el SQL.
     */
    public DML() {
        this.respuestaConsultaUnico = null;
        this.mensaje = null;
        this.mensajeErrorDepuracion = null;
        this.preparedStatement = null;
        this.cursor = null;
    }

    /**Metodo para eliminar las conexiones y los cursores a la base de datos.
     *
     * @throws Throwable
     *
     */
    public void finalize() throws Throwable {
        closePreparedStatement();
        getCursor().close();
    }

    /**
     * Metodo para ejecutar una consulta con parametros de una vector de parametros.
     *
     * @param sqlConsulta
     * @param parametros
     * @return
     */
    public synchronized ResultSet ejecutaConsulta(String sqlConsulta, Object... parametros) {
        int i = 1;
        mensaje = null;

        try {
            this.preparedStatement =
                getDBTransaction().createStatement(DBTransaction.DEFAULT)
                                                       .getConnection()
                                                       .prepareStatement(sqlConsulta, ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                         ResultSet.CONCUR_READ_ONLY);
            for (Object o : parametros) {
                insercionTipoDatoPreparedStatemet(i++, o);
            }

            this.cursor = this.preparedStatement.executeQuery();
            getCursor().last();
            size = getCursor().getRow();
            getCursor().beforeFirst();
            return getCursor();
        } catch (SQLException e) {
            this.mensaje = this.getClass().getName() + ".each() " + e.toString();
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return null;
    }

    /**
     * Metodo para cerrar un preparedStatement
     *
     * Si el preparedStatement no es null
     *  Lo cierra
     *
     * Caso contrario notifica al servidor
     *
     */
    private void closePreparedStatement() {
        if (this.preparedStatement != null) {
            try {
                this.preparedStatement.close();
            } catch (SQLException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
    }

    /**
     * Este metodo es para poner metos al recorrido de un metodo con el objeto de ampliar la funcionabilidad del los work resul set se usa eachWorkResultSet(workResultSet cursor).
     *
     *
     * @param documentTemp
     */
    public void addEach(SobrecargaAcciones documentTemp) {
        this.sobrecargaAcciones = documentTemp;
    }

    /**
     * Este metodo es para poner metos al recorrido de un metodo con el objeto de ampliar la funcionabilidad del los work resul set se usa eachWorkResultSet(workResultSet cursor) y de haber un error presenta un mensaje de error con la procedencia del mismo.
     *
     * @param mensajeError
     * @param documentTemp
     */
    public void addEach(String mensajeError, SobrecargaAcciones documentTemp) {
        this.sobrecargaAcciones = documentTemp;
        mensajeErrorDepuracion = mensajeError;
    }

    /**
     * Metodo que ejecutar metodos a cada cambio de registro
     *
     * -. capacita poner cualquier codigo a las interacciones
     * -. controla los errores
     * -. reduce las lineas de codigo en la programacion
     *
     */
    public void each() {
        this.mensaje = null;
        try {
            while (getCursor().next())
                this.sobrecargaAcciones.eachWorkResultSet();
        } catch (Exception e) {
            this.mensaje = mensajeErrorDepuracion + this.getClass().getName() + ".each() " + e.toString();
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        if (this.preparedStatement != null) {
            try {
                this.preparedStatement.close();
            } catch (SQLException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }

        if (getCursor() != null) {
            try {
                getCursor().close();
            } catch (SQLException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
            }
        }
    }

    /**
     * Metodo para ejecutar una consulta con parametros dinamicos y que devuelve un unico.
     *
     * @param sqlConsulta
     * @param parametros
     * @return
     */
    public Object ejecutaConsultaUnicoDato(String sqlConsulta, Object... parametros) {
        respuestaConsultaUnico = null;

        ejecutaConsulta(sqlConsulta, parametros);

        if (getMensaje() == null) {
            addEach(this.getClass().getName() + ")){ ejecutaConsultaUnicoDato() ", new SobrecargaAcciones() {
                @SuppressWarnings("compatibility:1018404215466113836")
                private static final long serialVersionUID = 5949132316168921138L;
                public void eachWorkResultSet() throws SQLException {
                    respuestaConsultaUnico = getCursor().getObject(1);
                }
            });
            each();
        }
        return respuestaConsultaUnico;
    }

    /**
     * Metodo para ejecutar sin importar desde un vector
     *
     * Insert
     * Delete
     * Update.
     *
     * @param sql
     * @param parametros
     *
     */
    public synchronized void ejecutaDML(String sql, Object... parametros) {
        int i = 1;
        this.mensaje = null;
        try {
            this.preparedStatement = getDBTransaction().createPreparedStatement(sql, 1);
            for (Object o : parametros) {
                insercionTipoDatoPreparedStatemet(i++, o);
            }
            this.preparedStatement.execute();
            if (this.preparedStatement != null) {
                try {
                    this.preparedStatement.close();
                } catch (SQLException e) {
                    Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
                }
            }
        } catch (Exception e1) {
            this.mensaje = this.getClass().getName() + ".each() " + e1.toString();
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e1.toString());
        }
    }

    /**
     * Metodo para hacer la conversion de datos en forma correcta para la inserciones ayuda a controlar los errores de conversion e implementa la conversion int en forma automatica, ya no es necesario enviar los campos (new Integer(9)), solo se pone (9)
     *
     * @param posicion
     * @param dataIsert
     * @throws SQLException
     */
    private void insercionTipoDatoPreparedStatemet(int posicion, Object dataIsert) throws SQLException {
        String nombreObjeto = dataIsert.getClass().getName();


        if (nombreObjeto.equalsIgnoreCase("java.lang.Double")) {
            this.preparedStatement.setDouble(posicion, ((Double) dataIsert).doubleValue());
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.String")) {
            this.preparedStatement.setString(posicion, controlInyeccionSQL(String.valueOf(dataIsert)).trim());
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.Integer")) {
            if ((dataIsert.toString().length() == 0))
                this.preparedStatement.setInt(posicion, 0);
            this.preparedStatement.setDouble(posicion, new Double(((Integer) dataIsert).doubleValue()));
        }

        if (nombreObjeto.equalsIgnoreCase("java.math.BigDecimal")) {
            if (String.valueOf(dataIsert).length() == 0)
                dataIsert = "0";
            this.preparedStatement.setBigDecimal(posicion, new BigDecimal(String.valueOf(dataIsert)));
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.Float")) {
            if (String.valueOf(dataIsert).length() == 0)
                dataIsert = "0";
            this.preparedStatement.setFloat(posicion, new Float(String.valueOf(dataIsert)).floatValue());
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.Boolean")) {
            if (String.valueOf(dataIsert)
                      .trim()
                      .toLowerCase()
                      .compareTo("true") == 0) {
                this.preparedStatement.setInt(posicion, 1);
            } else {
                this.preparedStatement.setInt(posicion, 0);
            }
        }

        if (nombreObjeto.equalsIgnoreCase("java.sql.Clob")) {
            this.preparedStatement.setClob(posicion, (java.sql.Clob) dataIsert);
        }

        if (nombreObjeto.equalsIgnoreCase("java.sql.Date")) {
            this.preparedStatement.setDate(posicion, (java.sql.Date) dataIsert);
        }

        if (nombreObjeto.equalsIgnoreCase("java.util.Date")) {
            java.sql.Date fechaTemp = new java.sql.Date(((java.util.Date) dataIsert).getTime());
            this.preparedStatement.setDate(posicion, fechaTemp);
        }
    }

    /**
     * Metodo para control de inyeccion SQL (OWASP)
     *
     * Si la palabra consultada tiene un campo que incluya codigo SQL
     *  Devuelve un campo vacio y
     *  Notifica
     *
     * @param parametro
     * @return
     */
    private String controlInyeccionSQL(String parametro) {
        for (int i = 0; i < PALABRAS_RESERVADAS_INYECCION_SQL.length; i++)
            if (parametro.toUpperCase().indexOf(PALABRAS_RESERVADAS_INYECCION_SQL[i]) >= 0) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
                    .log(Level.SEVERE, PALABRAS_RESERVADAS_INYECCION_SQL[i] +" "+ parametro);
                return "";
            }
        return parametro;
    }

    /**
     * Metodo para hacer el commit, al terminar devuelve el estado de la trasaccion a autocommits
     *
     * Necesita de usar al principio de la transacion el metodo iniciaTransaccion().
     *
     */
    public void commit() {
        getDBTransaction().commit();
    }

    /**
     * Metodo para hacer el rollback, al terminar devuelve el estado de la trasaccion a autocommit.
     *
     * Necesita de usar al principio de la transacion el metodo iniciaTransaccion().
     *
     */
    public void rollback() {
        getDBTransaction().rollback();
    }

    /**
     * Averigua si la conexion se encuentra cerrada.
     *
     * @return
     */
    public boolean isClosed() {
        try {
            return getDBTransaction().createStatement(0)
                                     .getConnection()
                                     .isClosed();
        } catch (SQLException e) {
            this.mensaje = this.getClass().getName() + ".cerrar() " + e.toString();
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());
        }
        return false;
    }

    /**
     * Metodo para obtener el cursor.
     *
     * @return
     */
    public ResultSet getCursor() {
        return this.cursor;
    }

    /**
     * Obtiene el tamano de un cursor.
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Obtiene el mensaje.
     *
     * @return
     */
    public String getMensaje() {
        return this.mensaje;
    }

    /**
     * Metodo para sobrecargar la conexion.
     *
     * @return
     */
    public DBTransaction getDBTransaction() {
        return null;
    }
}
