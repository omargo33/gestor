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

    public Entidad() {
        this.baseDML = new DML() {
            public DBTransaction getDBTransaction() {
                return Entidad.this.miThis().getDBTransaction();
            }
        };
    }

    public String getParametroTexto01(String indice) {
        String respuesta = "";
        try {
            respuesta =
                (String) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_TEXTO_01, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }

    public String getParametroTexto02(String indice) {
        String respuesta = "";
        try {
            respuesta =
                (String) getBaseDML()
                .ejecutaConsultaUnicoDato(SQL_PARAMETRO_TEXTO_02, getBundle("modulo.indice"), indice);
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        }
        return respuesta;
    }


    public Double getParametroValor01(String indice) {
        double respuesta = 0.0D;
        try {
            respuesta =
                ((Double) getBaseDML()
                 .ejecutaConsultaUnicoDato(SQL_PARAMETRO_NUMERO_01, getBundle("modulo.indice"), indice)).doubleValue();
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        }
        return Double.valueOf(respuesta);
    }

    public Double getParametroValor02(String indice) {
        double respuesta = 0.0D;
        try {
            respuesta =
                ((Double) getBaseDML()
                 .ejecutaConsultaUnicoDato(SQL_PARAMETRO_NUMERO_02, getBundle("modulo.indice"), indice)).doubleValue();
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        }
        return Double.valueOf(respuesta);
    }

    public void noBorrar(int... codigosVerificacion) {
        EntityRowSetImpl rowSet = null;
        int largo = 0;
        for (int i : codigosVerificacion) {
            try {
                rowSet = (EntityRowSetImpl) getAttribute(i);
                largo = rowSet.size();
            } catch (Exception e) {
                Logger.getLogger("global").log(Level.SEVERE, e.toString());
            }

            if (largo > 0) {
                throw new JboException("");
            }
        }
    }

    public EntityImpl miThis() {
        return this;
    }

    public int getUltimoId() {
        int codigo = 0;
        Object ultimoCodigo = this.baseDML.ejecutaConsultaUnicoDato(SQL_LAST_ID, new Object[0]);
        if (this.baseDML.getMensaje() == null) {
            try {
                codigo = (new Integer(String.valueOf(ultimoCodigo))).intValue();
            } catch (Exception e) {
                codigo = -1;
            }
        }
        return codigo;
    }


    public String getBundle(String llaveBundle, Object... parametros) {
        if (this.resourceBundle == null) {
            return "<No Definido, Bundle no Instanciado>";
        }
        String mensaje = this.resourceBundle.getString(llaveBundle);
        if (mensaje == null) {
            return String.format("<No Definido, %s llave no encontrada>", new Object[] { llaveBundle });
        }
        if (parametros == null) {
            return mensaje;
        }
        return MessageFormat.format(mensaje, parametros);
    }


    public DML getBaseDML() {
        return this.baseDML;
    }

    public void setNombreBundle(String nombreBundle) {
        this.resourceBundle = BundleFactory.getBundle(nombreBundle);
    }
}
