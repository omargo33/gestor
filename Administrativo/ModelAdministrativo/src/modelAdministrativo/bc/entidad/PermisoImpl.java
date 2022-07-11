package modelAdministrativo.bc.entidad;import model.bc.Entidad;import oracle.jbo.Key;import oracle.jbo.server.EntityDefImpl;import oracle.jbo.server.TransactionEvent;// ---------------------------------------------------------------------// ---    File generated by Oracle ADF Business Components Design Time.// ---    Wed Jul 07 17:16:43 ECT 2021// ---    Custom code may be added to this class.// ---    Warning: Do not modify method signatures of generated methods.// ---------------------------------------------------------------------public class PermisoImpl extends Entidad {    /**     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.     */    protected enum AttributesEnum {        IdPermiso,        IdMenu,        IdRol,        Crear,        Actualizar,        Borrar,        VerAuditoria,        Usuario,        UsuarioFecha,        UsuarioPrograma,        Menu,        Rol;        private static AttributesEnum[] vals = null;        private static final int firstIndex = 0;        protected int index() {            return AttributesEnum.firstIndex() + ordinal();        }        protected static final int firstIndex() {            return firstIndex;        }        protected static int count() {            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;        }        protected static final AttributesEnum[] staticValues() {            if (vals == null) {                vals = AttributesEnum.values();            }            return vals;        }    }    public static final int IDPERMISO = AttributesEnum.IdPermiso.index();    public static final int IDMENU = AttributesEnum.IdMenu.index();    public static final int IDROL = AttributesEnum.IdRol.index();    public static final int CREAR = AttributesEnum.Crear.index();    public static final int ACTUALIZAR = AttributesEnum.Actualizar.index();    public static final int BORRAR = AttributesEnum.Borrar.index();    public static final int VERAUDITORIA = AttributesEnum.VerAuditoria.index();    public static final int USUARIO = AttributesEnum.Usuario.index();    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();    public static final int MENU = AttributesEnum.Menu.index();    public static final int ROL = AttributesEnum.Rol.index();    /**     * This is the default constructor (do not remove).     */    public PermisoImpl() {        super();    }    /**     * @param idPermiso key constituent     * @return a Key object based on given key constituents.     */    public static Key createPrimaryKey(Integer idPermiso) {        return new Key(new Object[] { idPermiso });    }    /**     * @return the definition object for this instance class.     */    public static synchronized EntityDefImpl getDefinitionObject() {        return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Permiso");    }    /**     * Add locking logic here.     */    public void lock() {        super.lock();    }    /**     * Custom DML update/insert/delete logic here.     * @param operation the operation type     * @param e the transaction event     */    protected void doDML(int operation, TransactionEvent e) {        super.doDML(operation, e);                //Id refresh        if (operation == DML_INSERT)            setAttribute(IDPERMISO, getUltimoId());    }}