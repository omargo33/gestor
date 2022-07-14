  package modelLogin.bc.modulo;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.bc.modulo.Notificaciones;

import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorEncripcion;

import modelAuditoria.bc.modulo.Auditoria;
import modelAuditoria.bc.modulo.estructura.Parametro;

import modelLogin.InfoParametros;

import modelLogin.bc.LoginModuloImpl;
import modelLogin.bc.entidad.TokenImpl;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;


/**
 * Objeto para logica relacionada con los tokens.
 *
 * @author omargo33@hotmail.com
 */
public class Token {
  
    /**
     * Metodo para crear un token.
     *
     * Toma el current
     * Crea una clave parametrizada
     * Cambia el estado a C = Creado
     * Commit
     * Envia la notificacion
     *
     * @param moduloAplicacion
     * @param correo
     */
    public static void enviarToken(LoginModuloImpl moduloAplicacion, String correo, String ip, String userAgent,
                                   String usuarioPrograma) {
      String usuario = "";
      
        ViewObject vo = moduloAplicacion.getTokenView1();
        ViewCriteria vc = vo.getViewCriteriaManager().getViewCriteria("TokenViewCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_correo", correo);
        vo.applyViewCriteria(vc, false);
        vo.executeQuery();
      
        if (vo.getAllRowsInRange().length == 0) {
        auditarSolicitudesFallidos(moduloAplicacion, correo, ip, userAgent, usuarioPrograma);
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Token.enviarToken_txt1"));
      } 
      
        if (vo.getAllRowsInRange().length > 0) {
            Row row = vo.first();
        String socialNick = String.valueOf(row.getAttribute(TokenImpl.SOCIALNICK));
            String password = GeneradorClaves.getPassword(GeneradorClaves.KEY_ALFANUMERICOS, 8);
        
            String server = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_SERVER);
        row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, password));
        row.setAttribute(TokenImpl.ESTADO, "C");
        row.validate();
        
        if (!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "enviarToken()")) {
                throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Token.enviarToken_txt2"));
        }
        usuario = (String)row.getAttribute(TokenImpl.USUARIO);
            vo.resetAllViewCriteria();
        enviarNotificacion(moduloAplicacion, socialNick, password, correo, ip, userAgent, usuario, usuarioPrograma);
      } 
    }
  
    /**
     * Metodo para ensamblar la notificacion.
     *
     * (parametros) Obtiene idFormato y idServicio, url de Sitio
     * (bundle)Asunto y Cuerpo
     * Fecha envio
     * Ensamble de parametros al cuerpo en idFormato (hora e Ip)
     *
     * @param moduloAplicacion
     * @param socialNick
     * @param password
     * @param correo
     * @param ip
     * @param userAgent
     * @param usuario
     * @param usuarioPrograma
     */
    private static void enviarNotificacion(LoginModuloImpl moduloAplicacion, String socialNick, String password,
                                           String correo, String ip, String userAgent, String usuario,
                                           String usuarioPrograma) {
  
      int idFormato = moduloAplicacion.base_obtenerParametroNumerico01("300").intValue();
      int idServicio = moduloAplicacion.base_obtenerParametroNumerico02("300").intValue();
      String urlSitio = moduloAplicacion.base_obtenerParametroTexto01("50");
        String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto");
        String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo", socialNick, password, urlSitio);
      Date fechaEnvio = new Date();
      
      SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> mapaParametros = new HashMap<String, Object>();
      mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));
      mapaParametros.put("ip", ip);
      mapaParametros.put("dispositivo", userAgent);
      
        moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo,
                                                Notificaciones.NOTIFICACION_ANULAR, fechaEnvio, usuario,
                                                usuarioPrograma, (Map) mapaParametros, null);
    }
  
    /**
     * Metodo para auditar los ingresos de usuarios no reconocidos por el sistema.
     *
     * Crea una entrada de auditoria.
     * Eventos
     * Parametros de ingreso.
     *
     * @param moduloAplicacion
     * @param correo
     * @param ip
     * @param usuarioPrograma
     */
    private static void auditarSolicitudesFallidos(LoginModuloImpl moduloAplicacion, String correo, String ip,
                                                   String userAgent, String usuarioPrograma) {
        List<Parametro> parametros = new ArrayList<Parametro>();
        parametros.add(new Parametro("correo", Parametro.DIRECCION_ENTRADA, correo));
        parametros.add(new Parametro("ip", Parametro.DIRECCION_ENTRADA, ip));
        parametros.add(new Parametro("objeto", Parametro.DIRECCION_ENTRADA, usuarioPrograma));
        int idAuditoria =
            moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre"), "enviarToken()", "",
                                                      usuarioPrograma);
        moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, Auditoria.TIPO_EVENTO_SEGURIDAD, 0);
      moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);
    }
  }
