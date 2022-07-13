package WEB-INF.classes.modelAdministrativo.bc.modulo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.bc.Entidad;
import model.bc.ModuloImpl;
import model.bc.VistaObjeto;
import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorEncripcion;
import modelAdministrativo.bc.AdministrativoModuloImpl;
import modelAdministrativo.bc.entidad.TokenImpl;
import modelAdministrativo.bc.modulo.Token;
import modelAuditoria.bc.modulo.estructura.Parametro;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;


























public class Token
  extends Entidad
{
  public static void crearToken(AdministrativoModuloImpl moduloAplicacion, int id) {
      String usuario = "";
      String usuarioPrograma = "";
    
      VistaObjeto vistaObjeto = moduloAplicacion.getTokenView3();
      ViewCriteria vc = vistaObjeto.getViewCriteriaManager().getViewCriteria("TokenViewCriteriaIdToken");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idToken", Integer.valueOf(id));
      vistaObjeto.applyViewCriteria(vc, false);
      vistaObjeto.executeQuery();
    
      if ((vistaObjeto.getAllRowsInRange()).length > 0) {
        Row row = vistaObjeto.first();
        String correo = String.valueOf(row.getAttribute(TokenImpl.CORREO));
        String socialNick = String.valueOf(row.getAttribute(TokenImpl.SOCIALNICK));
        String password = GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 8);
        String server = moduloAplicacion.base_obtenerParametroTexto01("100");
        row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, password));
        row.setAttribute(TokenImpl.ESTADO, "C");
        row.validate();
      
        if (!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "crearToken()")) {
          throw new JboException(moduloAplicacion.getBundle("modelAdministrativo.bc.modulo.Token.enviarToken_txt2", new Object[0]));
      }
        usuario = (String)row.getAttribute(TokenImpl.USUARIO);
        usuarioPrograma = (String)row.getAttribute(TokenImpl.USUARIOPROGRAMA);
        vistaObjeto.resetAllViewCriteria();
      
        enviarNotificacion(moduloAplicacion, socialNick, password, correo, usuario, usuarioPrograma);
    } 
  }


















  
  private static void enviarNotificacion(AdministrativoModuloImpl moduloAplicacion, String socialNick, String password, String correo, String usuario, String usuarioPrograma) {
      int idFormato = moduloAplicacion.base_obtenerParametroNumerico01("300").intValue();
      int idServicio = moduloAplicacion.base_obtenerParametroNumerico02("300").intValue();
      String urlSitio = moduloAplicacion.base_obtenerParametroTexto01("50");
    
      String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto_01", new Object[0]);
      String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo_01", new Object[] { socialNick, password, urlSitio });
      Date fechaEnvio = new Date();
    
      SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Map<String, Object> mapaParametros = new HashMap<>();
      mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));
    
      moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo, "S", fechaEnvio, usuario, usuarioPrograma, mapaParametros, null);
  }





























  
  public static void cambiarTokenCompleto(AdministrativoModuloImpl moduloAplicacion, String socialNick, String passwordOld, String passwordNew, String passwordConfirmar, String expresionRegular, String mensajeExpresionRegular, String ip, String userAgent, String usuarioPrograma) {
      int idAuditoria = auditarCambioClave(moduloAplicacion, "cambiarTokenCompleto()", socialNick, ip, userAgent, usuarioPrograma);
    
      ViewObject vo = buscarUsuario(moduloAplicacion, socialNick);
    
      if ((vo.getAllRowsInRange()).length > 0) {
        Row row = vo.first();
        String correo = String.valueOf(row.getAttribute(TokenImpl.CORREO));
        String server = moduloAplicacion.base_obtenerParametroTexto01("100");
      
        validarOldPassword((ModuloImpl)moduloAplicacion, row, passwordOld);
        validarPassword(moduloAplicacion, passwordNew, passwordConfirmar, expresionRegular, mensajeExpresionRegular);

      
        row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, passwordNew));
        row.setAttribute(TokenImpl.ESTADO, "A");
        row.setAttribute(TokenImpl.USUARIO, socialNick);
        row.setAttribute(TokenImpl.USUARIOFECHA, new Date());
        row.setAttribute(TokenImpl.USUARIOPROGRAMA, usuarioPrograma);
      
        row.validate();
        if (!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "cambiarToken()")) {
          throw new JboException(moduloAplicacion.getBundle("modelAdministrativo.bc.modulo.Token.enviarToken_txt1", new Object[0]));
      }
      
        enviarNotificacion(moduloAplicacion, socialNick, correo, ip, userAgent, socialNick, usuarioPrograma);
      
        vo.resetAllViewCriteria();
        moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, "cambiarTokenCompleto() OK", "S", 1);
    } 
  }




















  
  private static void enviarNotificacion(AdministrativoModuloImpl moduloAplicacion, String socialNick, String correo, String ip, String userAgent, String usuario, String usuarioPrograma) {
      int idFormato = moduloAplicacion.base_obtenerParametroNumerico01("301").intValue();
      int idServicio = moduloAplicacion.base_obtenerParametroNumerico02("301").intValue();
      String urlSitio = moduloAplicacion.base_obtenerParametroTexto01("50");
      String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto_02", new Object[0]);
      String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo_02", new Object[] { socialNick, urlSitio });
      Date fechaEnvio = new Date();
    
      SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Map<String, Object> mapaParametros = new HashMap<>();
      mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));
      mapaParametros.put("ip", ip);
      mapaParametros.put("dispositivo", userAgent);
    
      moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo, "N", fechaEnvio, usuario, usuarioPrograma, mapaParametros, null);
  }









  
  private static ViewObject buscarUsuario(AdministrativoModuloImpl moduloAplicacion, String socialNick) {
      ViewObjectImpl viewObjectImpl = moduloAplicacion.getTokenView2();
      ViewCriteria vc = viewObjectImpl.getViewCriteriaManager().getViewCriteria("TokenViewCriteriaSocialNick");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_socialNick", socialNick);
      viewObjectImpl.applyViewCriteria(vc, false);
      viewObjectImpl.executeQuery();
      return (ViewObject)viewObjectImpl;
  }











  
  private static void validarPassword(AdministrativoModuloImpl moduloAplicacion, String passwordNew, String passwordConfirmar, String expresionRegular, String mensajeExpresionRegular) {
      if (passwordNew.compareTo(passwordConfirmar) != 0) {
        throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarPassword_txt1", new Object[0]));
    }

    
      Pattern pat = Pattern.compile(expresionRegular);
      Matcher mat = pat.matcher(passwordNew);
      if (!mat.matches()) {
        throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarPassword_txt2", new Object[] { mensajeExpresionRegular }));
    }
  }









  
  private static void validarOldPassword(ModuloImpl moduloAplicacion, Row row, String oldPassword) {
      String oldPasswoerdSha1 = (String)row.getAttribute(TokenImpl.TOKEN);
      String server = moduloAplicacion.base_obtenerParametroTexto01("100");
      if (GeneradorEncripcion.cifrarRealm(server, oldPassword).compareToIgnoreCase(oldPasswoerdSha1) != 0) {
        moduloAplicacion.rollback(moduloAplicacion, "validarOldPassword()");
        throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarOldPassword_txt1", new Object[0]));
    } 
  }














  
  private static int auditarCambioClave(AdministrativoModuloImpl moduloAplicacion, String nombreMetodo, String nick, String ip, String userAgent, String usuarioPrograma) {
      List<Parametro> parametros = new ArrayList<>();
      parametros.add(new Parametro("nick", "I", nick));
      parametros.add(new Parametro("ip", "I", ip));
      parametros.add(new Parametro("objeto", "I", usuarioPrograma));
    
      int idAuditoria = moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre", new Object[0]), nombreMetodo, "", usuarioPrograma);
    
      moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, "S", 0);
      moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);
    
      return idAuditoria;
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/modulo/Token.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */