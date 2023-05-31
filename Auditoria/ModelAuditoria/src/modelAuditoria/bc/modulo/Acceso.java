package modelAuditoria.bc.modulo;

import model.utilidades.Atributos;

import modelAuditoria.bc.AuditoriaModuloImpl;
import modelAuditoria.bc.entidad.AccesoImpl;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;


/**
 * @author omargo33@hotmail.com
 *
 * Objeto para crear acceso.
 *
 */
public class Acceso {

    /**
     * Metodo para crear aceso.
     *
     * @param nombre nick ingresado para consultar
     * @param token clave del usuario
     * @param tokenApi informacion de token user-agent etc
     * @param usuarioPrograma programa ingresado
     *
     * @return
     */
    public static int crearAcceso(AuditoriaModuloImpl moduloAplicacion, String nombre, String token, String tokenApi,
                                  String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;

        ViewObject vo = moduloAplicacion.getAuditoria_AccesoView1();
        Row row = vo.createRow();

        row.setAttribute(AccesoImpl.IDACCESO, codigo);
        row.setAttribute(AccesoImpl.NOMBRE, Atributos.stringLargo(nombre, Atributos.NO_APLICA, 256));
        row.setAttribute(AccesoImpl.TOKEN, Atributos.stringLargo(token, Atributos.NO_APLICA, 256));
        row.setAttribute(AccesoImpl.TOKENAPI, Atributos.stringLargo(tokenApi, Atributos.NO_APLICA, 2048));
        row.setAttribute(AccesoImpl.USUARIOFECHA, Atributos.sysTime());
        row.setAttribute(AccesoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, Atributos.NO_APLICA, 256));
        row.validate();
        vo.insertRow(row);

        estado = moduloAplicacion.commitRollback(nombre, "crearAcceso()");

        if (estado) {
            codigo = ((Integer) row.getAttribute(AccesoImpl.IDACCESO));
        } else {
            codigo = -1;
            throw new JboException(moduloAplicacion.getBundle("000002", nombre));
        }
        return codigo;
    }
}
