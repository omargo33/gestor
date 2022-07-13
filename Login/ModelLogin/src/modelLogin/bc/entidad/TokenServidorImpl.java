  package WEB-INF.classes.modelLogin.bc.entidad;
  
  import model.bc.Entidad;
  import modelLogin.bc.entidad.TokenServidorImpl;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class TokenServidorImpl
    extends Entidad
  {
    public static final int IDTOKENSERVIDOR = AttributesEnum.IdTokenServidor.index();
    public static final int IDTOKEN = AttributesEnum.IdToken.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int SERVIDOR = AttributesEnum.Servidor.index();
    public static final int PASSWORD = AttributesEnum.Password.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idTokenServidor) { return new Key(new Object[] { idTokenServidor }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelLogin.bc.entidad.TokenServidor"); }
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      
      if (operation == 1)
        setAttribute(IDTOKENSERVIDOR, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/entidad/TokenServidorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */