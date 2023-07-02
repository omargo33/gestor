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


public class ModuloAplicacion extends ApplicationModuleImpl implements BundleInterface {
    private DML baseDML;
    private ResourceBundle resourceBundle = null;


    public ModuloAplicacion() {
        this.baseDML = new DML() {
            public DBTransaction getDBTransaction() {
                return ModuloAplicacion.this.miThis().getDBTransaction();
            }
        };
    }


    public DML getBaseDML() {
        return this.baseDML;
    }


    public ApplicationModuleImpl miThis() {
        return this;
    }


    public ApplicationModuleImpl miHijo() {
        return this;
    }


    public void setNombreBundle(String nombreBundle) {
        this.resourceBundle = BundleFactory.getBundle(nombreBundle);
    }


    public String getBundle(String llaveBundle, Object... parametros) {
        String mensaje = "";
        if (this.resourceBundle == null) {
            return "<No Definido, Bundle no Instanciado>";
        }
        try {
            mensaje = this.resourceBundle.getString(llaveBundle);
            if (mensaje == null)
                return String.format("<No Definido, %s llave no encontrada>", new Object[] { llaveBundle });
        } catch (Exception e) {
            return String.format("<No Definido, %s llave no encontrada %s>",
                                 new Object[] { llaveBundle, this.resourceBundle.getBaseBundleName() });
        }

        if (parametros == null) {
            return mensaje;
        }
        return MessageFormat.format(mensaje, parametros);
    }


    public boolean commitRollback(Object datoControl, String metodo) {
        boolean estado = true;

        try {
            getDBTransaction().commit();
        } catch (JboException ex) {
            getDBTransaction().rollback();
            Logger.getLogger("global")
                .log(Level.WARNING,
                     getBundle("000001",
                               new Object[] { String.valueOf(datoControl), getClass().getName(), metodo, ex }));
            estado = false;
        }
        return estado;
    }


    public void refrescarVistaKeyAtribute(ViewObjectImpl vistaRefrescar) {
        try {
            if (vistaRefrescar.getCurrentRow() == null) {
                return;
            }
            Key llaveOriginal = vistaRefrescar.getCurrentRow().getKey();
            vistaRefrescar.executeQuery();
            vistaRefrescar.setCurrentRow(vistaRefrescar.findByKey(llaveOriginal, 1)[0]);
            vistaRefrescar.executeQuery();
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.WARNING, ".refrescarVistaKeyAtribute()" + e.toString());
        }
    }


    public boolean rollback(Object datoControl, String metodo) {
        boolean estado = true;

        try {
            getDBTransaction().rollback();
        } catch (JboException ex) {
            Logger.getLogger("global")
                .log(Level.WARNING,
                     getBundle("000000",
                               new Object[] { String.valueOf(datoControl), getClass().getName(), metodo, ex }));
            estado = false;
        }

        return estado;
    }


    public void errorMysql(int codigoError, String metodo) {
        if (codigoError != 0) {
            String mensajeError =
                getBundle("000004", new Object[] { metodo, "errorMysql", Integer.valueOf(codigoError) });
            Logger.getLogger("global").log(Level.WARNING, mensajeError);
            throw new JboException(getBundle("CodigoDefinidoUsuario.errorMysql", new Object[0]));
        }
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/ModuloAplicacion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */