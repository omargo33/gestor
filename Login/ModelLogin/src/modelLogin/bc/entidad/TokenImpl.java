  package WEB-INF.classes.modelLogin.bc.entidad;
  
  import model.bc.Entidad;
  import modelLogin.bc.entidad.TokenImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class TokenImpl
    extends Entidad
  {
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
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idToken) { return new Key(new Object[] { idToken }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelLogin.bc.entidad.Token"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDTOKEN, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/entidad/TokenImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */