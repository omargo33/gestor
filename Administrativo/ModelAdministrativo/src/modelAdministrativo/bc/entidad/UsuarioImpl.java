package modelAdministrativo.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon May 17 18:18:43 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UsuarioImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdUsuario,
        IdArchivo,
        Nick,
        Nombre,
        Apellido,
        Usuario,
        Validador,
        UsuarioFecha,
        UsuarioPrograma,
        Estado,
        ContadorIngreso,
        ContadorFecha,
        RolUsuario,
        Token;
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


    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDARCHIVO = AttributesEnum.IdArchivo.index();
    public static final int NICK = AttributesEnum.Nick.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int APELLIDO = AttributesEnum.Apellido.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int CONTADORINGRESO = AttributesEnum.ContadorIngreso.index();
    public static final int CONTADORFECHA = AttributesEnum.ContadorFecha.index();
    public static final int ROLUSUARIO = AttributesEnum.RolUsuario.index();
    public static final int TOKEN = AttributesEnum.Token.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UsuarioImpl() {
        super();
    }

    /**
     * @param idUsuario key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idUsuario) {
        return new Key(new Object[] { idUsuario });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Usuario");
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
        if (operation == DML_UPDATE)
            setAttribute(VALIDADOR, String.valueOf(getAttribute(NICK).hashCode()));
        
        if (operation == DML_DELETE)
            noBorrar(ROLUSUARIO, TOKEN);

        super.doDML(operation, e);
        //Id refresh
        if (operation == DML_INSERT)
            setAttribute(IDUSUARIO, getUltimoId());
    }
}

