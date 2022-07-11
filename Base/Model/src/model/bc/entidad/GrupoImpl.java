package model.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 23 18:57:46 ECT 2022
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
/**
 * @author omargo33@hotmail.com
 */
@SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
public class GrupoImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO
     * NOT MODIFY.
     * @author omargo33@hotmail.com
     */
    protected enum AttributesEnum {
        IdGrupo,
        Id,
        Esquema,
        Tabla,
        LargoMaximo,
        Extensiones,
        Ancho,
        Alto,
        MaximoArchivo,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma,
        Archivo;
        private static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int IDGRUPO = AttributesEnum.IdGrupo.index();
    public static final int ID = AttributesEnum.Id.index();
    public static final int ESQUEMA = AttributesEnum.Esquema.index();
    public static final int TABLA = AttributesEnum.Tabla.index();
    public static final int LARGOMAXIMO = AttributesEnum.LargoMaximo.index();
    public static final int EXTENSIONES = AttributesEnum.Extensiones.index();
    public static final int ANCHO = AttributesEnum.Ancho.index();
    public static final int ALTO = AttributesEnum.Alto.index();
    public static final int MAXIMOARCHIVO = AttributesEnum.MaximoArchivo.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ARCHIVO = AttributesEnum.Archivo.index();

    /**
     * This is the default constructor (do not remove).
     */
    public GrupoImpl() {
        super();
    }

    /**
     * @param idGrupo key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idGrupo) {
        return new Key(new Object[] { idGrupo });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.bc.entidad.Grupo");
    }


    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * 
     * @param operation the operation type
     * @param e         the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        if (operation == DML_DELETE) {
            noBorrar(ARCHIVO);
        }
        super.doDML(operation, e);
        if (operation == DML_INSERT) {
            setAttribute(IDGRUPO, getUltimoId());
        }
    }
}
