package model.sql;


import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.jbo.server.DBTransaction;


public class DML {
    private static String[] PALABRAS_RESERVADAS_INYECCION_SQL = new String[] {
        "SELECT", "FROM", "WHERE", "INSERT", "INTO", "IN TO", "UPDATE", "DELETE", "FROM", "/*", "--", "*/",
        "CA_USUARIOS", "CLIENTES", "SOCIOS"
    };


    private Object respuestaConsultaUnico = null;
    private String mensaje = null;
    private String mensajeErrorDepuracion = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet cursor = null;


    private int size;

    private SobrecargaAcciones sobrecargaAcciones;


    public void finalize() throws Throwable {
        closePreparedStatement();
        getCursor().close();
    }


    public synchronized ResultSet ejecutaConsulta(String sqlConsulta, Object... parametros) {
        int i = 1;
        this.mensaje = null;

        try {
            this.


                preparedStatement = getDBTransaction().createStatement(-1)
                                                      .getConnection()
                                                      .prepareStatement(sqlConsulta, 1004, 1007);

            for (Object o : parametros) {
                insercionTipoDatoPreparedStatemet(i++, o);
            }

            this.cursor = this.preparedStatement.executeQuery();
            getCursor().last();
            this.size = getCursor().getRow();
            getCursor().beforeFirst();
            return getCursor();
        } catch (SQLException e) {
            this.mensaje = getClass().getName() + ".each() " + e.toString();
            Logger.getLogger("global").log(Level.WARNING, e.toString());

            return null;
        }
    }


    private void closePreparedStatement() {
        if (this.preparedStatement != null) {
            try {
                this.preparedStatement.close();
            } catch (SQLException e) {
                Logger.getLogger("global").log(Level.WARNING, e.toString());
            }
        }
    }


    public void addEach(SobrecargaAcciones documentTemp) {
        this.sobrecargaAcciones = documentTemp;
    }


    public void addEach(String mensajeError, SobrecargaAcciones documentTemp) {
        this.sobrecargaAcciones = documentTemp;
        this.mensajeErrorDepuracion = mensajeError;
    }


    public void each() {
        this.mensaje = null;
        try {
            while (getCursor().next())
                this.sobrecargaAcciones.eachWorkResultSet();
        } catch (Exception e) {
            this.mensaje = this.mensajeErrorDepuracion + getClass().getName() + ".each() " + e.toString();
            Logger.getLogger("global").log(Level.WARNING, e.toString());
        }
        if (this.preparedStatement != null) {
            try {
                this.preparedStatement.close();
            } catch (SQLException e) {
                Logger.getLogger("global").log(Level.WARNING, e.toString());
            }
        }

        if (getCursor() != null) {
            try {
                getCursor().close();
            } catch (SQLException e) {
                Logger.getLogger("global").log(Level.WARNING, e.toString());
            }
        }
    }


    public Object ejecutaConsultaUnicoDato(String sqlConsulta, Object... parametros) {
        this.respuestaConsultaUnico = null;

        ejecutaConsulta(sqlConsulta, parametros);

        if (getMensaje() == null) {
            addEach(getClass().getName() + ")){ ejecutaConsultaUnicoDato() ", new SobrecargaAcciones() {
                private static final long serialVersionUID = 5949132316168921138L;

                public void eachWorkResultSet() throws SQLException {
                    DML.this.respuestaConsultaUnico = DML.this.getCursor().getObject(1);
                }
            });
            each();
        }
        return this.respuestaConsultaUnico;
    }


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
                    Logger.getLogger("global").log(Level.WARNING, e.toString());
                }
            }
        } catch (Exception e1) {
            this.mensaje = getClass().getName() + ".each() " + e1.toString();
            Logger.getLogger("global").log(Level.WARNING, e1.toString());
        }
    }


    private void insercionTipoDatoPreparedStatemet(int posicion, Object dataIsert) throws SQLException {
        String nombreObjeto = dataIsert.getClass().getName();


        if (nombreObjeto.equalsIgnoreCase("java.lang.Double")) {
            this.preparedStatement.setDouble(posicion, ((Double) dataIsert).doubleValue());
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.String")) {
            this.preparedStatement.setString(posicion, controlInyeccionSQL(String.valueOf(dataIsert)).trim());
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.Integer")) {
            if (dataIsert.toString().length() == 0)
                this.preparedStatement.setInt(posicion, 0);
            this.preparedStatement.setDouble(posicion, (new Double(((Integer) dataIsert).doubleValue())).doubleValue());
        }

        if (nombreObjeto.equalsIgnoreCase("java.math.BigDecimal")) {
            if (String.valueOf(dataIsert).length() == 0)
                dataIsert = "0";
            this.preparedStatement.setBigDecimal(posicion, new BigDecimal(String.valueOf(dataIsert)));
        }

        if (nombreObjeto.equalsIgnoreCase("java.lang.Float")) {
            if (String.valueOf(dataIsert).length() == 0)
                dataIsert = "0";
            this.preparedStatement.setFloat(posicion, (new Float(String.valueOf(dataIsert))).floatValue());
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


    private String controlInyeccionSQL(String parametro) {
        for (int i = 0; i < PALABRAS_RESERVADAS_INYECCION_SQL.length; i++) {
            if (parametro.toUpperCase().indexOf(PALABRAS_RESERVADAS_INYECCION_SQL[i]) >= 0) {
                Logger.getLogger("global").log(Level.WARNING, PALABRAS_RESERVADAS_INYECCION_SQL[i] + " " + parametro);
                return "";
            }
        }
        return parametro;
    }


    public void commit() {
        getDBTransaction().commit();
    }


    public void rollback() {
        getDBTransaction().rollback();
    }


    public boolean isClosed() {
        try {
            return getDBTransaction().createStatement(0)
                                     .getConnection()
                                     .isClosed();
        } catch (SQLException e) {
            this.mensaje = getClass().getName() + ".cerrar() " + e.toString();
            Logger.getLogger("global").log(Level.WARNING, e.toString());

            return false;
        }
    }


    public ResultSet getCursor() {
        return this.cursor;
    }


    public int size() {
        return this.size;
    }


    public String getMensaje() {
        return this.mensaje;
    }


    public DBTransaction getDBTransaction() {
        return null;
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/sql/DML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */