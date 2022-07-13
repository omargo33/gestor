  package WEB-INF.classes.modelLogin.bc.modulo;
  
  import java.text.SimpleDateFormat;
  import java.util.ArrayList;
  import java.util.Date;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;
  import model.utilidades.GeneradorClaves;
  import model.utilidades.GeneradorEncripcion;
  import modelAuditoria.bc.modulo.estructura.Parametro;
  import modelLogin.bc.LoginModuloImpl;
  import modelLogin.bc.entidad.TokenImpl;
  import modelLogin.bc.modulo.Token;
  import oracle.jbo.JboException;
  import oracle.jbo.Row;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  import oracle.jbo.server.ViewObjectImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class Token
  {
    public static void enviarToken(LoginModuloImpl moduloAplicacion, String correo, String ip, String userAgent, String usuarioPrograma) {
      String usuario = "";
      
      ViewObjectImpl viewObjectImpl = moduloAplicacion.getTokenView1();
      ViewCriteria vc = viewObjectImpl.getViewCriteriaManager().getViewCriteria("TokenViewCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_correo", correo);
      viewObjectImpl.applyViewCriteria(vc, false);
      viewObjectImpl.executeQuery();
      
      if ((viewObjectImpl.getAllRowsInRange()).length == 0) {
        auditarSolicitudesFallidos(moduloAplicacion, correo, ip, userAgent, usuarioPrograma);
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Token.enviarToken_txt1", new Object[0]));
      } 
      
      if ((viewObjectImpl.getAllRowsInRange()).length > 0) {
        Row row = viewObjectImpl.first();
        String socialNick = String.valueOf(row.getAttribute(TokenImpl.SOCIALNICK));
        String password = GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 8);
        
        String server = moduloAplicacion.base_obtenerParametroTexto01("100");
        row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, password));
        row.setAttribute(TokenImpl.ESTADO, "C");
        row.validate();
        
        if (!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "enviarToken()")) {
          throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Token.enviarToken_txt2", new Object[0]));
        }
        usuario = (String)row.getAttribute(TokenImpl.USUARIO);
        viewObjectImpl.resetAllViewCriteria();
        enviarNotificacion(moduloAplicacion, socialNick, password, correo, ip, userAgent, usuario, usuarioPrograma);
      } 
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static void enviarNotificacion(LoginModuloImpl moduloAplicacion, String socialNick, String password, String correo, String ip, String userAgent, String usuario, String usuarioPrograma) {
      int idFormato = moduloAplicacion.base_obtenerParametroNumerico01("300").intValue();
      int idServicio = moduloAplicacion.base_obtenerParametroNumerico02("300").intValue();
      String urlSitio = moduloAplicacion.base_obtenerParametroTexto01("50");
      String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto", new Object[0]);
      String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo", new Object[] { socialNick, password, urlSitio });
      Date fechaEnvio = new Date();
      
      SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Map<String, Object> mapaParametros = new HashMap<>();
      mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));
      mapaParametros.put("ip", ip);
      mapaParametros.put("dispositivo", userAgent);
      
      moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo, "S", fechaEnvio, usuario, usuarioPrograma, mapaParametros, null);
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static void auditarSolicitudesFallidos(LoginModuloImpl moduloAplicacion, String correo, String ip, String userAgent, String usuarioPrograma) {
      List<Parametro> parametros = new ArrayList<>();
      parametros.add(new Parametro("correo", "I", correo));
      parametros.add(new Parametro("ip", "I", ip));
      parametros.add(new Parametro("objeto", "I", usuarioPrograma));
      
      int idAuditoria = moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre", new Object[0]), "enviarToken()", "", usuarioPrograma);
      
      moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, "S", 0);
      moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/modulo/Token.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */