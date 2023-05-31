package modelAuditoria.bc.modulo;


import java.util.ArrayList;
import java.util.List;

import model.utilidades.Atributos;

import modelAuditoria.bc.AuditoriaModuloImpl;
import modelAuditoria.bc.entidad.AuditoriaEventoImpl;
import modelAuditoria.bc.entidad.AuditoriaImpl;
import modelAuditoria.bc.entidad.AuditoriaParametroImpl;
import modelAuditoria.bc.modulo.estructura.Parametro;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.commons.lang3.StringUtils;


/**
 * @author omargo33@hotmail.com
 *
 * Objeto crear elementos de auditoria base para proyectos genericos.
 *
 */
public class Auditoria {
    public static final String TIPO_EVENTO_INFORMACION="I";
    public static final String TIPO_EVENTO_CUIDADO="C";
    public static final String TIPO_EVENTO_ERROR="E";
    public static final String TIPO_EVENTO_SEGURIDAD="S";

    /**
     * Metodo para crear una auditoria a procesos.
     *
     * @param nombre
     * @param elemento
     * @param contenidoExtra
     * @param usuarioPrograma
     *
     * @return
     *
     */
    public static int crearAuditoria(AuditoriaModuloImpl moduloAplicacion,String nombre, String elemento, String contenidoExtra, String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;
        ViewObject vo = moduloAplicacion.getAuditoria_AuditoriaView1();
        Row row = vo.createRow();

        row.setAttribute(AuditoriaImpl.IDAUDITORIA, codigo);
        row.setAttribute(AuditoriaImpl.NOMBRE, Atributos.stringLargo(nombre, Atributos.NO_APLICA, 128));
        row.setAttribute(AuditoriaImpl.VALOR01, Atributos.stringLargo(contenidoExtra, Atributos.NO_APLICA, 256));
        row.setAttribute(AuditoriaImpl.VALOR02, StringUtils.substring(contenidoExtra, 256, 512));
        //TODO
        row.setAttribute(AuditoriaImpl.USUARIO, "TODO");
        row.setAttribute(AuditoriaImpl.USUARIOFECHA, Atributos.sysTime());
        row.setAttribute(AuditoriaImpl.USUARIOPROGRAMA,
                         Atributos.stringLargo(usuarioPrograma, Atributos.NO_APLICA, 256));
        row.setAttribute(AuditoriaImpl.ELEMENTO, Atributos.stringLargo(elemento, Atributos.NO_APLICA, 64));
        row.validate();
        vo.insertRow(row);

        estado = moduloAplicacion.commitRollback(nombre, "crearParametrosAuditoria");

        if (estado) {
            codigo = ((Integer) row.getAttribute(AuditoriaImpl.IDAUDITORIA));
        } else {
            codigo = -1;
        }
        return codigo;
    }

    /**
     * Metodo para crear los parametros de la auditoria.
     *
     * @param parametro
     * @return
     */
    public static boolean crearAuditoriaParametros(AuditoriaModuloImpl moduloAplicacion, int idAuditoria, List<Parametro> parametro) {
        int codigo = 0;
        boolean estado = true;
        ViewObject vo = moduloAplicacion.getAuditoria_AuditoriaParametroView1();

        for (Parametro p : parametro) {
            Row row = vo.createRow();
            row.setAttribute(AuditoriaParametroImpl.IDAUDITORIAPARAMETRO, codigo);
            row.setAttribute(AuditoriaParametroImpl.IDAUDITORIA, idAuditoria);
            row.setAttribute(AuditoriaParametroImpl.NOMBRE, Atributos.stringLargo(p.getNombre(), Atributos.NO_APLICA, 128));
            row.setAttribute(AuditoriaParametroImpl.DIRECCION,
                             Atributos.stringLargo(p.getDireccion(), Atributos.NO_APLICA, 8));
            row.setAttribute(AuditoriaParametroImpl.VALOR,
                             Atributos.stringLargo(p.getValor(), Atributos.NO_APLICA, 256));
            row.validate();
            vo.insertRow(row);
            estado = moduloAplicacion.commitRollback(idAuditoria, "crearParametrosAuditoria");
        }
        return estado;
    }

    /**
     * Metodo para crear eventos de la auditoria.
     *
     * @param idAuditoria
     * @param descripcion
     * @param tipo
     * @param orden
     * @return
     */
    public static  boolean crearAuditoriaEvento(AuditoriaModuloImpl moduloAplicacion, int idAuditoria, String descripcion, String tipo, int orden) {
        int codigo = 0;
        int i = 0;
        boolean estado = true;
        String tipoComprimido = Atributos.stringLargo(tipo, Atributos.NO_APLICA, 8);
        ViewObject vo = moduloAplicacion.getAuditoria_AuditoriaEventoView1();
        List<String> listaDescripciones = splitLongitud(descripcion, 512);

        for (String descripcionParte : listaDescripciones) {
            Row row = vo.createRow();
            row.setAttribute(AuditoriaEventoImpl.IDAUDITORIAEVENTO, codigo);
            row.setAttribute(AuditoriaEventoImpl.IDAUDITORIA, idAuditoria);
            row.setAttribute(AuditoriaEventoImpl.DESCRIPCION, descripcionParte);
            row.setAttribute(AuditoriaEventoImpl.TIPO, tipoComprimido);
            row.setAttribute(AuditoriaEventoImpl.ORDEN, orden);
            row.setAttribute(AuditoriaEventoImpl.PARTE, i++);
            row.setAttribute(AuditoriaEventoImpl.USUARIOFECHA, Atributos.sysTime());
            row.validate();
            vo.insertRow(row);
            estado = moduloAplicacion.commitRollback(idAuditoria, "crearParametrosAuditoria");
        }
        return estado;
    }

    /**
     * Metodo para hacer un split de un texto en base a su largo.
     *
     * @param text
     * @param largo
     * @return
     */
    private static List<String> splitLongitud(String text, int largo) {        
        text=Atributos.stringNoNull(text,"");        
        List<String> lista = new ArrayList<String>((text.length() + largo - 1) / largo);
        for (int inicio = 0; inicio < text.length(); inicio += largo) {
            lista.add(text.substring(inicio, Math.min(text.length(), inicio + largo)));
        }
        return lista;
    }

}
