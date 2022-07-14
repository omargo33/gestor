  package modelLogin.bc;
  
  import modelAuditoria.bc.AuditoriaModuloImpl;
  import modelLogin.bc.LoginModuloImpl;
  import modelLogin.bc.common.LoginModulo;
  import modelLogin.bc.modulo.Login;
  import modelLogin.bc.modulo.Token;
  import oracle.jbo.server.ViewObjectImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class LoginModuloImpl
    extends AuditoriaModuloImpl
    implements LoginModulo
  {
    public LoginModuloImpl() { setNombreBundle("modelLogin.ModelLoginBundle"); }
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public String validarUsuario(String nick, String password, String tokenGoogle, String ip, String userAgent, String usuarioPrograma) { return Login.validarUsuario(this, nick, password, tokenGoogle, ip, userAgent, usuarioPrograma); }
  
  
  
  
  
  
  
  
    
    public String contextoInicial(String nick) { return Login.contextoInicial(this, nick); }
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public void enviarToken(String correo, String ip, String userAgent, String usuarioPrograma) { Token.enviarToken(this, correo, ip, userAgent, usuarioPrograma); }
  
  
  
  
  
  
    
    public ViewObjectImpl getUsuarioCorreoViewNoDML1() { return (ViewObjectImpl)findViewObject("UsuarioCorreoViewNoDML1"); }
  
  
  
  
  
  
    
    public ViewObjectImpl getUsuarioView1() { return (ViewObjectImpl)findViewObject("UsuarioView1"); }
  
  
  
  
  
  
    
    public ViewObjectImpl getTokenServidorView1() { return (ViewObjectImpl)findViewObject("TokenServidorView1"); }
  
  
  
  
  
  
    
    public ViewObjectImpl getTokenView1() { return (ViewObjectImpl)findViewObject("TokenView1"); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/LoginModuloImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */