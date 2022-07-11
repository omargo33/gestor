package model.bc.modulo;import java.util.logging.Level;import java.util.logging.Logger;import model.bc.ModuloImpl;import oracle.jbo.JboException;/** * Metodo para ejecutar * * @author omargo33@hotmail.com */public class Rol {    private static String SQL_ROL_ACTIVO =        "select count(*) from GS_001_00.rol_usuario ru, GS_001_00.rol r, GS_001_00.usuario u where ru.id_rol = r.id_rol and ru.id_usuario = u.id_usuario and upper(r.tipo) = upper( ? ) and upper(u.nick) = upper( ? )";    /**     * Metodo para conocer si un usuario pertenece a un rol consultado.     *     * @param moduloAplicacion     * @param nick     * @param role     * @return     */    public static boolean validarRol(ModuloImpl moduloAplicacion, String nick, String role) {        int respuestaInt = 0;                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "nick="+nick);        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "role="+role);                Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_ROL_ACTIVO, role, nick);        if (moduloAplicacion.getBaseDML().getMensaje() != null) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "error " + moduloAplicacion.getBaseDML().getMensaje());                            throw new JboException("no consulta SQL 001");        }        try {                        respuestaInt = ((Long)respuesta).intValue();                    } catch (Exception e) {            throw new JboException("no convertie");        }        return (respuestaInt > 0);    }}