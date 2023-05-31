  package modelLogin.bc.entidad;

import model.bc.Entidad;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 19 22:46:16 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TokenImpl extends Entidad {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdToken,
        IdUsuario,
        Tipo,
        SocialNick,
        Correo,
        Token,
        Validador,
        Estado,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma;
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
  
   
 
  
  
 
    public static final int IDTOKEN = AttributesEnum.IdToken.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int SOCIALNICK = AttributesEnum.SocialNick.index();
    public static final int CORREO = AttributesEnum.Correo.index();
    public static final int TOKEN = AttributesEnum.Token.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
  
    /**
     * This is the default constructor (do not remove).
     */
    public TokenImpl() {
    }
  
    /**
     * @param idToken key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer idToken) {
        return new Key(new Object[] { idToken });
    }
  
    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("modelLogin.bc.entidad.Token");
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
            setAttribute(IDTOKEN, getUltimoId());
      
    }
  }

