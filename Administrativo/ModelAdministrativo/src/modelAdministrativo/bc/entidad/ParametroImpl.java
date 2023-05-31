package modelAdministrativo.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon May 17 18:17:58 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ParametroImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdParametro,
        IdModulo,
        Indice,
        Clave,
        Nombre,
        Descripcion,
        ValorTexto01,
        ValorTexto02,
        ValorNumero01,
        ValorNumero02,
        DefaultTexto01,
        DefaultTexto02,
        DefaultNumero01,
        DefaultNumero02,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma,
        Modulo1;
        private static AttributesEnum[] vals = null;
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


    public static final int IDPARAMETRO = AttributesEnum.IdParametro.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int CLAVE = AttributesEnum.Clave.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int VALORTEXTO01 = AttributesEnum.ValorTexto01.index();
    public static final int VALORTEXTO02 = AttributesEnum.ValorTexto02.index();
    public static final int VALORNUMERO01 = AttributesEnum.ValorNumero01.index();
    public static final int VALORNUMERO02 = AttributesEnum.ValorNumero02.index();
    public static final int DEFAULTTEXTO01 = AttributesEnum.DefaultTexto01.index();
    public static final int DEFAULTTEXTO02 = AttributesEnum.DefaultTexto02.index();
    public static final int DEFAULTNUMERO01 = AttributesEnum.DefaultNumero01.index();
    public static final int DEFAULTNUMERO02 = AttributesEnum.DefaultNumero02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int MODULO1 = AttributesEnum.Modulo1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ParametroImpl() {
        super();
    }

    /**
     * @param idParametro key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idParametro) {
        return new Key(new Object[] { idParametro });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Parametro");
    }


    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
        //Id refresh
        if (operation == DML_INSERT)
            setAttribute(IDPARAMETRO, getUltimoId());
    }
}

