package modelAuditoria.bc.modulo;

import model.utilidades.Atributos;

import modelAuditoria.bc.AuditoriaModuloImpl;
import modelAuditoria.bc.entidad.DireccionImpl;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

/**
 * @author omargo33@hotmail.com
 *
 * Objeto para insertar direcciones completas de los dispositivos y demas elementos que han sido usuados para interactuar con el sistema.
 *
 */
public class Direccion {

    /**
     * Metdo para crear direcciones.
     *
     * @param elemento
     * @param direccion
     * @param navegadorDispositivo
     * @param usuarioPrograma
     * @return
     */
    public static int crearDireccion(AuditoriaModuloImpl moduloAplicacion,String elemento, String direccion, String navegadorDispositivo, String usuario, String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;
        ViewObject vo = moduloAplicacion.getAuditoria_DireccionView1();
        Row row = vo.createRow();

        row.setAttribute(DireccionImpl.IDDIRECCION, codigo);
        row.setAttribute(DireccionImpl.ELEMENTO, Atributos.stringLargo(elemento, Atributos.NO_APLICA, 64));
        row.setAttribute(DireccionImpl.DIRECCION, Atributos.stringLargo(direccion, Atributos.NO_APLICA, 128));
        row.setAttribute(DireccionImpl.NAVEGADORDISPOSITIVO,
                         Atributos.stringLargo(navegadorDispositivo, Atributos.NO_APLICA, 1024));        
        row.setAttribute(DireccionImpl.USUARIO, usuario);        
        row.setAttribute(DireccionImpl.USUARIOFECHA, Atributos.sysTime());
        row.setAttribute(DireccionImpl.USUARIOPROGRAMA,
                         Atributos.stringLargo(usuarioPrograma, Atributos.NO_APLICA, 256));
        row.validate();
        vo.insertRow(row);

        estado = moduloAplicacion.commitRollback(elemento, "crearDireccion");

        if (estado) {
            codigo = ((Integer) row.getAttribute(DireccionImpl.IDDIRECCION));
        } else {
            codigo = -1;
        }
        return codigo;
    }
}
