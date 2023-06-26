package modelAdministrativo.bc.modulo;

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
import model.bc.modulo.Notificaciones;

import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorEncripcion;

import modelAdministrativo.InfoParametros;

import modelAdministrativo.bc.AdministrativoModuloImpl;
import modelAdministrativo.bc.entidad.TokenImpl;

import modelAuditoria.bc.modulo.Auditoria;
import modelAuditoria.bc.modulo.estructura.Parametro;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewObject;

/**
 * Objetos para dar soporte a los
 *
 * @author omargo33@hotmail.com
 */
public class Token extends Entidad {
    public Token() {
        super();
    }

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
     */
    public static void crearToken(AdministrativoModuloImpl moduloAplicacion, int id) {
        String usuario="";
        String usuarioPrograma="";
    
        ViewObject vo = moduloAplicacion.getTokenView3();
        ViewCriteria vc = vo.getViewCriteriaManager().getViewCriteria("TokenViewCriteriaIdToken");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_idToken", id);
        vo.applyViewCriteria(vc, false);
        vo.executeQuery();

        if (vo.getAllRowsInRange().length > 0) {
            Row row = vo.first();
            String correo = String.valueOf(row.getAttribute(TokenImpl.CORREO));
            String socialNick = String.valueOf(row.getAttribute(TokenImpl.SOCIALNICK));
            String password = GeneradorClaves.getPassword(GeneradorClaves.KEY_ALFANUMERICOS, 8);
            String server = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_SERVER);
            row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, password));
            row.setAttribute(TokenImpl.ESTADO, "C");
            row.validate();
            
            if(!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "crearToken()")){
                    throw new JboException(moduloAplicacion.getBundle("modelAdministrativo.bc.modulo.Token.enviarToken_txt2"));                
                }
            usuario = (String) row.getAttribute(TokenImpl.USUARIO);
            usuarioPrograma = (String) row.getAttribute(TokenImpl.USUARIOPROGRAMA);
            vo.resetAllViewCriteria();            
            
            enviarNotificacion(moduloAplicacion, socialNick, password,correo, usuario,usuarioPrograma);
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
     * @param usuario
     * @param usuarioPrograma
     */
    private static void enviarNotificacion(AdministrativoModuloImpl moduloAplicacion, String socialNick, String password,
                                           String correo,  String usuario,
                                           String usuarioPrograma) {

        int idFormato = moduloAplicacion.base_obtenerParametroNumerico01(InfoParametros.PARAMETRO_PLANTILLA_NOTIFICACION_01).intValue();
        int idServicio = moduloAplicacion.base_obtenerParametroNumerico02(InfoParametros.PARAMETRO_PLANTILLA_NOTIFICACION_01).intValue();
        String urlSitio = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_URL_LOGOUT);
        
        String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto_01");
        String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo_01", socialNick, password, urlSitio);
        Date fechaEnvio = new Date();

        SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> mapaParametros = new HashMap<String, Object>();
        mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));

        moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo,
                                                Notificaciones.NOTIFICACION_ANULAR, fechaEnvio, usuario,
                                                usuarioPrograma, (Map) mapaParametros, null);
    }
    
    

    /**
     * Metodo para cambiar el token.
     *
     * Busca usuario definido.
     * Valida el password anterior
     * Valida el nuevo password
     * Cambia estado
     * Notifica por correo
     *
     * @param moduloAplicacion
     * @param socialNick
     * @param passwordOld
     * @param passwordNew
     * @param passwordConfirmar
     * @param expresionRegular
     * @param mensajeExpresionRegular
     * @param ip
     * @param userAgent
     * @param usuarioPrograma
     */
    public static void cambiarTokenCompleto(AdministrativoModuloImpl moduloAplicacion, String socialNick, String passwordOld,
                                            String passwordNew, String passwordConfirmar, String expresionRegular,
                                            String mensajeExpresionRegular, String ip, String userAgent,
                                            String usuarioPrograma) {

        int idAuditoria =
            auditarCambioClave(moduloAplicacion, "cambiarTokenCompleto()", socialNick, ip, userAgent, usuarioPrograma);

        ViewObject vo = buscarUsuario(moduloAplicacion, socialNick);

        if (vo.getAllRowsInRange().length > 0) {
            Row row = vo.first();
            String correo = String.valueOf(row.getAttribute(TokenImpl.CORREO));
            String server = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_SERVER);

            validarOldPassword(moduloAplicacion, row, passwordOld);
            validarPassword(moduloAplicacion, passwordNew, passwordConfirmar, expresionRegular,
                            mensajeExpresionRegular);

            row.setAttribute(TokenImpl.TOKEN, GeneradorEncripcion.cifrarRealm(server, passwordNew));
            row.setAttribute(TokenImpl.ESTADO, "A");
            row.setAttribute(TokenImpl.USUARIO, socialNick);
            row.setAttribute(TokenImpl.USUARIOFECHA, new Date());
            row.setAttribute(TokenImpl.USUARIOPROGRAMA, usuarioPrograma);

            row.validate();
            if (!moduloAplicacion.commitRollback(row.getAttribute(TokenImpl.SOCIALNICK), "cambiarToken()")) {
                throw new JboException(moduloAplicacion.getBundle("modelAdministrativo.bc.modulo.Token.enviarToken_txt1"));
            }

            enviarNotificacion(moduloAplicacion, socialNick, correo, ip, userAgent, socialNick, usuarioPrograma);

            vo.resetAllViewCriteria();
            moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, "cambiarTokenCompleto() OK",
                                                            Auditoria.TIPO_EVENTO_SEGURIDAD, 1);
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
     * @param correo
     * @param ip
     * @param userAgent
     * @param usuario
     * @param usuarioPrograma
     */
    private static void enviarNotificacion(AdministrativoModuloImpl moduloAplicacion, String socialNick, String correo,
                                           String ip, String userAgent, String usuario, String usuarioPrograma) {

        int idFormato = moduloAplicacion.base_obtenerParametroNumerico01(InfoParametros.PARAMETRO_PLANTILLA_NOTIFICACION_02).intValue();
        int idServicio = moduloAplicacion.base_obtenerParametroNumerico02(InfoParametros.PARAMETRO_PLANTILLA_NOTIFICACION_02).intValue();
        String urlSitio = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_URL_LOGOUT);
        String asunto = moduloAplicacion.getBundle("token.enviarToken.asunto_02");
        String cuerpo = moduloAplicacion.getBundle("token.enviarToken.cuerpo_02", socialNick, urlSitio);
        Date fechaEnvio = new Date();

        SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> mapaParametros = new HashMap<String, Object>();
        mapaParametros.put("hora", dateFormatCorta.format(fechaEnvio));
        mapaParametros.put("ip", ip);
        mapaParametros.put("dispositivo", userAgent);

        moduloAplicacion.base_crearNotificacion(idFormato, idServicio, asunto, cuerpo, correo,
                                                Notificaciones.NOTIFICACION_NO_ANULAR, fechaEnvio, usuario,
                                                usuarioPrograma, (Map) mapaParametros, null);
    }

    /**
     * Metodo para realizar la busqueda de socio.
     *
     * @param moduloAplicacion
     * @param socialNick
     * @return
     */
    private static ViewObject buscarUsuario(AdministrativoModuloImpl moduloAplicacion, String socialNick) {
        ViewObject vo = moduloAplicacion.getTokenView2();
        ViewCriteria vc = vo.getViewCriteriaManager().getViewCriteria("TokenViewCriteriaSocialNick");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_socialNick", socialNick);
        vo.applyViewCriteria(vc, false);
        vo.executeQuery();
        return vo;
    }

    /**
     * Metodo para validar Password.
     *
     * @param passwordNew
     * @param passwordConfirmar
     * @param expresionRegular
     * @param mensajeExpresionRegular
     */
    private static void validarPassword(AdministrativoModuloImpl moduloAplicacion, String passwordNew,
                                        String passwordConfirmar, String expresionRegular,
                                        String mensajeExpresionRegular) {

        if (passwordNew.compareTo(passwordConfirmar) != 0) {
            throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarPassword_txt1"));
        }


        Pattern pat = Pattern.compile(expresionRegular);
        Matcher mat = pat.matcher(passwordNew);
        if (!mat.matches()) {
            throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarPassword_txt2",
                                                              mensajeExpresionRegular));
        }
    }

    /**
     *
     * Validar password anterior.
     *
     * @param moduloAplicacion
     * @param row
     * @param oldPassword
     */
    private static void validarOldPassword(ModuloImpl moduloAplicacion, Row row, String oldPassword) {
        String oldPasswoerdSha1 = (String) row.getAttribute(TokenImpl.TOKEN);
        String server = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_SERVER);
        if (GeneradorEncripcion.cifrarRealm(server, oldPassword).compareToIgnoreCase(oldPasswoerdSha1) != 0) {
            moduloAplicacion.rollback(moduloAplicacion, "validarOldPassword()");
            throw new JboException(moduloAplicacion.getBundle("modelUsuario.bc.modulo.Token.validarOldPassword_txt1"));
        }
    }


    /**
     * Metodo para auditar los cambios de claves del sistema.
     *
     * Crea una entrada de auditoria.
     * Eventos
     * Parametros de ingreso.
     *
     * @param moduloAplicacion
     * @param nick
     * @param ip
     * @param usuarioPrograma
     */
    private static int auditarCambioClave(AdministrativoModuloImpl moduloAplicacion, String nombreMetodo, String nick,
                                          String ip, String userAgent, String usuarioPrograma) {
        List<Parametro> parametros = new ArrayList<Parametro>();
        parametros.add(new Parametro("nick", Parametro.DIRECCION_ENTRADA, nick));
        parametros.add(new Parametro("ip", Parametro.DIRECCION_ENTRADA, ip));
        parametros.add(new Parametro("objeto", Parametro.DIRECCION_ENTRADA, usuarioPrograma));
        int idAuditoria =
            moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre"), nombreMetodo, "",
                                                      usuarioPrograma);
        moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, Auditoria.TIPO_EVENTO_SEGURIDAD, 0);
        moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);

        return idAuditoria;
    }
}
