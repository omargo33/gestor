package modelAdministrativo.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon May 17 18:18:26 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RolUsuarioImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdRolUsuario,
        IdRol,
        IdUsuario,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma,
        Rol2,
        Usuario1;
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


    public static final int IDROLUSUARIO = AttributesEnum.IdRolUsuario.index();
    public static final int IDROL = AttributesEnum.IdRol.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ROL2 = AttributesEnum.Rol2.index();
    public static final int USUARIO1 = AttributesEnum.Usuario1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public RolUsuarioImpl() {
        super();
    }

    /**
     * @param idRolUsuario key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idRolUsuario) {
        return new Key(new Object[] { idRolUsuario });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.RolUsuario");
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
            setAttribute(IDROLUSUARIO, getUltimoId());
    }
}

