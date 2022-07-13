  package WEB-INF.classes.modelLogin.bc.vistaNoDML;
  
  import java.sql.Timestamp;
  import modelLogin.bc.vistaNoDML.UsuarioCorreoViewNoDMLRowImpl;
  import oracle.jbo.server.ViewRowImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class UsuarioCorreoViewNoDMLRowImpl
    extends ViewRowImpl
  {
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int NICK = AttributesEnum.Nick.index();
    public static final int CONTADORINGRESO = AttributesEnum.ContadorIngreso.index();
    public static final int CONTADORFECHA = AttributesEnum.ContadorFecha.index();
    public static final int IDTOKEN = AttributesEnum.IdToken.index();
    public static final int TOKEN = AttributesEnum.Token.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
  
  
  
  
  
  
  
  
  
  
  
    
    public Integer getIdUsuario() { return (Integer)getAttributeInternal(IDUSUARIO); }
  
  
  
  
  
  
    
    public String getNick() { return (String)getAttributeInternal(NICK); }
  
  
  
  
  
  
    
    public Integer getContadorIngreso() { return (Integer)getAttributeInternal(CONTADORINGRESO); }
  
  
  
  
  
  
    
    public Timestamp getContadorFecha() { return (Timestamp)getAttributeInternal(CONTADORFECHA); }
  
  
  
  
  
  
    
    public Integer getIdToken() { return (Integer)getAttributeInternal(IDTOKEN); }
  
  
  
  
  
  
    
    public String getToken() { return (String)getAttributeInternal(TOKEN); }
  
  
  
  
  
  
    
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }
  
  
  
  
  
  
    
    public String getValidador() { return (String)getAttributeInternal(VALIDADOR); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/vistaNoDML/UsuarioCorreoViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */