package model.bc.modulo;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.bc.ModuloImpl;

import oracle.jbo.JboException;

/**
 * Metodo para manejar informacion del rol de forma interna
 *
 * @author omargo33@hotmail.com
 *
 */
public class Rol {
    private static String SQL_ROL_ACTIVO =
        "select count(*) from GS_001_00.rol_usuario ru, GS_001_00.rol r, GS_001_00.usuario u where ru.id_rol = r.id_rol and ru.id_usuario = u.id_usuario and upper(r.tipo) = upper( ? ) and upper(u.nick) = upper( ? )";

    private static String SQL_ROLES_USUARIO =
        "select r.nombre from GS_001_00.rol r where r.estado = 'A' and r.id_rol in (select id_rol from rol_usuario ru where id_usuario = (select id_usuario from GS_001_00.usuario u  where upper(nick) = upper(?) ))";

    private static String SQL_ROLES_POR_USUARIO =
        "SELECT r.tipo from GS_001_00.usuario u, GS_001_00.rol_usuario ru, GS_001_00.rol r, GS_001_00.permiso p, GS_001_00.menu m, GS_001_00.modulo m2 where r.id_rol = ru.id_rol and ru.id_usuario = u.id_usuario and p.id_rol = r.id_rol and p.id_menu = m.id_menu and m.id_modulo = m2.id_modulo and upper(u.nick) = upper(?) and upper(m2.indice) = upper(?) GROUP by r.tipo";


    /**
     * Metodo para validar si una persona tiene un rol en particular
     *
     * @param moduloAplicacion
     * @param nick
     * @param role
     * @return
     */
    public static boolean validarRol(ModuloImpl moduloAplicacion, String nick, String role) {
        int respuestaInt = 0;

        Object respuesta =
            moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_ROL_ACTIVO, new Object[] { role, nick });
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            Logger.getLogger("global").log(Level.WARNING, "error " + moduloAplicacion.getBaseDML().getMensaje());

            throw new JboException("no consulta SQL 001");
        }
        try {
            respuestaInt = ((Long) respuesta).intValue();
        } catch (Exception e) {
            throw new JboException("no convertie");
        }

        return (respuestaInt > 0);
    }

    /**
     * Metodo para validar los roles activos.
     *
     * @param moduloAplicacion
     * @param nick
     * @return
     */
    public static String rolesActivosPorUsuario(ModuloImpl moduloAplicacion, String nick) {
        String respuesta = "";
        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL_ROLES_USUARIO, new Object[] { nick });
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                respuesta = respuesta + " " + resultSet.getString(1);
            }
        } catch (Exception e) {
            throw new JboException("no legible");
        }
        return respuesta.trim();
    }

    /**
     * Metodo para validar que un usuario tenga un unico rol para un modulo especifico.
     *
     * @param moduloAplicacion
     * @param indiceModulo
     * @param nick
     * @return
     */
    public static boolean validarRolPorModulo(ModuloImpl moduloAplicacion, String indiceModulo, String rol,
                                              String nick) {        
        List<String> listaRespuestas = new ArrayList<String>();
        ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL_ROLES_POR_USUARIO, nick, indiceModulo);
        if (moduloAplicacion.getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }

        try {
            while (resultSet.next()) {
                listaRespuestas.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            throw new JboException("no legible");
        }

        if (listaRespuestas.size() == 1) {
            if (listaRespuestas.get(0).compareToIgnoreCase(rol) == 0) {                
                return true;
            }
        }        
        return false;
    }
}


