package modelLogin.bc.modulo;

import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.utilidades.Atributos;
import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorEncripcion;
import model.utilidades.estructuras.AccesoXML;

import modelAuditoria.bc.entidad.AuditoriaImpl;
import modelAuditoria.bc.modulo.Auditoria;
import modelAuditoria.bc.modulo.estructura.Parametro;

import modelLogin.InfoParametros;

import modelLogin.bc.LoginModuloImpl;
import modelLogin.bc.entidad.TokenServidorImpl;
import modelLogin.bc.vista.UsuarioViewRowImpl;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewObject;

/**
 * @author omargo33@hotmail.com
 *
 * Objeto trabajar con el login del sistema.
 *
 */
public class Login {
    private static String SQL_CONTEXTO_INICIAL =
        "select xx.contexto from (select contexto from modulo where indice not in ('LG_001_00', 'US_001_00') and id_modulo in ( select DISTINCT id_modulo from menu where id_menu in ( select DISTINCT id_menu from permiso where id_rol in ( select DISTINCT id_rol from rol_usuario where id_usuario in ( select id_usuario from usuario where nick = ? ))))order by nombre) xx limit 1";

    /**
     * Metodo para validar un usuario
     *
     * Busca usuario + token
     *
     * Si no hay datos
     *  Presnta un mensaje
     * Si ya se a intentado ingresar demasiadas veces
     *
     *
     * @param moduloAplicacion
     * @param nick
     * @param password
     * @param tokenGoogle
     * @param ip
     * @param userAgent
     * @param usuarioPrograma
     * @return
     */
    public static String validarUsuario(LoginModuloImpl moduloAplicacion, String nick, String password,
                                        String tokenGoogle, String ip, String userAgent, String usuarioPrograma) {
        String tokenApi = "";

        String SQL =
            "select * from (select u.id_usuario, u.nick, u.contador_ingreso, u.contador_fecha, tx.id_token, tx.token, tx.estado, tx.validador from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";
        String SQL_count =
            "select count(*) from (select  u.nick from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";

        String token = "";
        int contadorIngreso = 0;
        int idUsuario = 0;
        int idToken = 0;
        long contadorFecha = 0L;

        Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_count, nick);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        if (String.valueOf(respuesta).compareTo("0") == 0) {
            auditarIngresosFallidos(moduloAplicacion, nick, ip, userAgent, usuarioPrograma);
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1"));
        }


        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL, nick);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                token = resultSet.getString("token");
                contadorIngreso = resultSet.getInt("contador_ingreso");
                idUsuario = resultSet.getInt("id_usuario");
                idToken = resultSet.getInt("id_token");
                if (resultSet.getTime("contador_fecha") == null) {
                    contadorFecha = new Date().getTime();
                } else {
                    contadorFecha = resultSet.getTime("contador_fecha").getTime();
                }
            }
        } catch (Exception e) {
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1"));
        }

        String server = moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_SERVER);

        double intentos =
            moduloAplicacion.base_obtenerParametroNumerico01(InfoParametros.PARAMETRO_CONTADOR_INGRESO).doubleValue();

        Date fecha = new Date();
        if (contadorIngreso >= intentos && fecha.getTime() < contadorFecha) {
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt2"));
        }

        if (contadorIngreso >= intentos && fecha.getTime() > contadorFecha) {
            actualizarContadores(moduloAplicacion, idUsuario, 0, usuarioPrograma);
            contadorIngreso = 0;
        }

        String passwordEncript = GeneradorEncripcion.cifrarRealm(server, password);
        if (passwordEncript.compareToIgnoreCase(token) != 0) {
            actualizarContadores(moduloAplicacion, idUsuario, contadorIngreso + 1, usuarioPrograma);
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1"));
        }
        actualizarContadores(moduloAplicacion, idUsuario, 0, usuarioPrograma);
        tokenApi = solicitarToken(moduloAplicacion, idToken, nick, password, usuarioPrograma);


        return tokenApi;
    }

    /**
     *
     * @param moduloAplicacion
     * @param nick
     * @return
     */
    public static String contextoInicial(LoginModuloImpl moduloAplicacion, String nick) {

        String SQL =
            "select * from (select u.id_usuario, u.nick, u.contador_ingreso, u.contador_fecha, tx.id_token, tx.token, tx.estado, tx.validador from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";
        
        String estado="";
        String validador="";
        
        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL, nick);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                estado = resultSet.getString("estado");
                validador = resultSet.getString("validador");
            }
        } catch (Exception e) {
            throw new JboException("no de puede error 001");
        }

        if ("C".compareTo(estado) == 0) {
            return moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_CONTEXTO_USUARIO);
        }

        if (validador.compareToIgnoreCase("changeServer") == 0) {
            return moduloAplicacion.base_obtenerParametroTexto01(InfoParametros.PARAMETRO_CONTEXTO_USUARIO);
        }

        Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_CONTEXTO_INICIAL, nick);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.contextoInicial_txt1"));
        }
        return String.valueOf(respuesta);
    }

    /**
     * Metodo para solicitar la creacion del token de inicio del sistema.
     *
     * Carga los datos para crear el accesoXML
     * Crea el acceso
     * Crea la clave al servidor de aplicaciones
     *
     * @param moduloAplicacion
     * @param idToken
     * @param nick
     * @param password
     * @param usuarioPrograma
     * @return
     */
    private static String solicitarToken(LoginModuloImpl moduloAplicacion, int idToken, String nick, String password,
                                         String usuarioPrograma) {
        String semilla = GeneradorClaves.getPassword(GeneradorClaves.KEY_ALFANUMERICOS, 32);
        String base64 = "";


        Date fechaInicio = new Date();
        //Todo
        // [13a-ov] -> cambiar fecha y hora para trabajo en sesiones
        Date fechaFin = addMinutosToDate(fechaInicio, 60 * 24);

        AccesoXML accesoXML = new AccesoXML();
        accesoXML.setFechaEmision(fechaInicio.getTime());
        accesoXML.setFechaValido(fechaFin.getTime());
        accesoXML.setSemilla(semilla);
        accesoXML.setUsuario(nick);
        accesoXML.setPassword(password);

        base64 = accesoXML.code();

        moduloAplicacion.auditoria_crearAcceso("validarUsuario()", semilla, base64, usuarioPrograma);
        crearTokenServidor(moduloAplicacion, idToken, GeneradorEncripcion.SHA1Weblogic12c(password), usuarioPrograma);

        return base64;
    }

    /**
     * Metodo para crear la clave temporal del servidor de aplicaciones.
     *
     * Login al aplicativo.
     *
     * @param moduloAplicacion
     * @param idToken
     * @param token
     * @param usuarioPrograma
     * @return
     */
    private static int crearTokenServidor(LoginModuloImpl moduloAplicacion, int idToken, String token,
                                          String usuarioPrograma) {

        int codigo = 0;
        boolean estado = true;
        ViewObject vo = moduloAplicacion.getTokenServidorView1();
        Row row = vo.createRow();

        row.setAttribute(TokenServidorImpl.IDTOKENSERVIDOR, codigo);
        row.setAttribute(TokenServidorImpl.IDTOKEN, idToken);
        row.setAttribute(TokenServidorImpl.TIPO, Atributos.stringLargo("JASCRIPT", Atributos.NO_APLICA, 8));
        row.setAttribute(TokenServidorImpl.SERVIDOR, Atributos.stringLargo("WL12", Atributos.NO_APLICA, 8));
        row.setAttribute(TokenServidorImpl.PASSWORD, Atributos.stringLargo(token, Atributos.NO_APLICA, 512));
        row.setAttribute(TokenServidorImpl.USUARIOFECHA, Atributos.sysTime());
        row.setAttribute(TokenServidorImpl.USUARIOPROGRAMA,
                         Atributos.stringLargo(usuarioPrograma, Atributos.NO_APLICA, 256));

        row.validate();
        vo.insertRow(row);

        estado = moduloAplicacion.commitRollback(usuarioPrograma, "crearTokenServidor()");

        if (estado) {
            codigo = ((Integer) row.getAttribute(AuditoriaImpl.IDAUDITORIA));
        } else {
            codigo = -1;
        }
        return codigo;
    }

    /**
     * Metodo para actualizar el contador y la fecha del contador.
     *
     * Busca el registro
     * Toma la fecha actual
     * Si el contador a poner es cero
     *  la fecha se actualiza a la fecha actual
     * Caso contrario
     *  la fecha se actualiza a la fecha actual
     *
     * @param moduloAplicacion
     * @param idUsuario
     * @param contador
     * @param usuarioPrograma
     */
    private static void actualizarContadores(LoginModuloImpl moduloAplicacion, int idUsuario, int contador,
                                             String usuarioPrograma) {
        boolean estado = false;
        ViewObject vo = moduloAplicacion.getUsuarioView1();
        ViewCriteriaManager vcm = vo.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("UsuarioViewCriteria");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_idUsuario", idUsuario);
        vo.applyViewCriteria(vc, true);
        vo.executeQuery();

        while (vo.hasNext()) {
            Date date = new Date();
            if (contador > 0) {
                double horasAgragadas =
                    moduloAplicacion.base_obtenerParametroNumerico01(InfoParametros.PARAMETRO_TIEMPO_INGRESO)
                    .doubleValue();
                date = addMinutosToDate(date, (int) (horasAgragadas * 60));
            }
            Timestamp ts = new Timestamp(date.getTime());

            UsuarioViewRowImpl usuarioViewRowImpl = (UsuarioViewRowImpl) vo.next();
            usuarioViewRowImpl.setContadorFecha(ts);
            usuarioViewRowImpl.setContadorIngreso(contador);
            usuarioViewRowImpl.setUsuarioPrograma(Atributos.stringLargo(usuarioPrograma, Atributos.NO_APLICA, 256));
            estado = moduloAplicacion.commitRollback("nick", "actualizarContadores()");
            if (!estado) {
                throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.actualizarContadores_txt1"));
            }
        }
    }

    /**
     * Metodo para auditar los ingresos de usuarios no reconocidos por el sistema.
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
    private static void auditarIngresosFallidos(LoginModuloImpl moduloAplicacion, String nick, String ip,
                                                String userAgent, String usuarioPrograma) {
        List<Parametro> parametros = new ArrayList<Parametro>();
        parametros.add(new Parametro("nick", Parametro.DIRECCION_ENTRADA, nick));
        parametros.add(new Parametro("ip", Parametro.DIRECCION_ENTRADA, ip));
        parametros.add(new Parametro("objeto", Parametro.DIRECCION_ENTRADA, usuarioPrograma));
        int idAuditoria =
            moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre"), "validarUsuario()",
                                                      "", usuarioPrograma);
        moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, Auditoria.TIPO_EVENTO_SEGURIDAD, 0);
        moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);
    }

    /**
     * Metodo para sumar horas a una fecha.
     *
     * Instanciar calendario
     * Agregar los minutos.
     *
     * @param fecha
     * @param minutos
     * @return
     */
    private static Date addMinutosToDate(Date fecha, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }
}
