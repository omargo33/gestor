package model.bc.modulo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.bc.ModuloImpl;
import model.bc.VistaObjeto;
import model.bc.entidad.ArchivoImpl;
import model.bc.entidad.GrupoImpl;

import model.utilidades.Atributos;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;

/**
 * Objeto para tener soporte a grupos de archivos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Grupo {

    /**
     * Metodo para crear un grupo.
     *
     * @param moduloAplicacion
     * @param id
     * @param esquema
     * @param tabla
     * @param largoMaximo
     * @param extensiones
     * @param ancho
     * @param alto
     * @param maximoArchivo
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static int crearGrupo(ModuloImpl moduloAplicacion, int id, String esquema, String tabla, int largoMaximo,
                                 String extensiones, int ancho, int alto, int maximoArchivo, String usuario,
                                 String usuarioPrograma) {
        boolean estado = true;
        int codigo = buscarGrupo(moduloAplicacion, id, esquema, tabla);

        if (codigo > 0) {
            return codigo;
        }        

        VistaObjeto vistaObjeto = moduloAplicacion.getBase_GrupoView1();
        Row row = vistaObjeto.createRow();
        row.setAttribute(GrupoImpl.ID, Integer.valueOf(id));
        row.setAttribute(GrupoImpl.ESQUEMA, Atributos.stringLargo(esquema, "<NO APLICA>", 16));
        row.setAttribute(GrupoImpl.TABLA, Atributos.stringLargo(tabla, "<NO APLICA>", 32));
        row.setAttribute(GrupoImpl.LARGOMAXIMO, Integer.valueOf(largoMaximo * 1024));
        row.setAttribute(GrupoImpl.EXTENSIONES, Atributos.stringLargo(extensiones, "<NO APLICA>", 128));
        row.setAttribute(GrupoImpl.ANCHO, Integer.valueOf(ancho));
        row.setAttribute(GrupoImpl.ALTO, Integer.valueOf(alto));
        row.setAttribute(GrupoImpl.MAXIMOARCHIVO, Integer.valueOf(maximoArchivo));
        row.setAttribute(GrupoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
        row.setAttribute(GrupoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        row.validate();
        vistaObjeto.insertRow(row);
        estado = moduloAplicacion.commitRollback(tabla, "crearGrupo");
        if (estado) {
            codigo = ((Integer) row.getAttribute(GrupoImpl.IDGRUPO)).intValue();
        } else {
            codigo = -1;
        }
        return codigo;
    }

    /**
     * Metodo para borrar todos los archivos de un grupo.
     */

    /**
     * Metodo para buscar el id de grupo.
     *
     * @param moduloAplicacion
     * @param id
     * @param esquema
     * @param tabla
     * @return
     */
    public static int buscarGrupo(ModuloImpl moduloAplicacion, int id, String esquema, String tabla) {
        int codigo = 0;

        VistaObjeto vistaObjeto = moduloAplicacion.getBase_GrupoView1();
        ViewCriteriaManager vcm = vistaObjeto.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("GrupoViewCriteria");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_Id", Integer.valueOf(id));
        vvm.setVariableValue("v_Esquema", esquema);
        vvm.setVariableValue("v_Tabla", tabla);
        vistaObjeto.applyViewCriteria(vc);
        vistaObjeto.executeQuery();
        while (vistaObjeto.hasNext()) {
            Row r = vistaObjeto.next();
            codigo = ((Integer) r.getAttribute(GrupoImpl.IDGRUPO)).intValue();
        }
        return codigo;
    }

    /**
     * Metodo para conocer los Paths activos de un grupo.
     *
     * @param moduloAplicacion
     * @return
     */
    public static Map<String, String> buscarPathArchivosByGrupo(ModuloImpl moduloAplicacion, int idGrupo) {
        Map<String, String> mapaArchivos = new HashMap<>();

        String pathBase = moduloAplicacion.base_obtenerParametroTexto01("200");

        VistaObjeto vistaObjeto = moduloAplicacion.getBase_ArchivoView2();
        ViewCriteriaManager vcm = vistaObjeto.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("ArchivoViewCriteria");

        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_idGrupo", idGrupo);

        vistaObjeto.applyViewCriteria(vc);
        vistaObjeto.executeQuery();
        while (vistaObjeto.hasNext()) {
            Row r = vistaObjeto.next();
            mapaArchivos.put(String.valueOf(r.getAttribute(ArchivoImpl.IDARCHIVO)),
                             pathBase + String.valueOf(r.getAttribute(ArchivoImpl.PATHRELATIVO)));
        }
        return mapaArchivos;
    }

    /**
     * Metodo para borrar todos los archivos de un grupo.
     *
     * @param moduloAplicacion
     * @param idGrupo
     * @param informacion
     * @param usuario
     * @param usuarioPrograma
     */
    public static void borrarArchivosByGrupos(ModuloImpl moduloAplicacion, int idGrupo, String informacion,
                                              String usuario, String usuarioPrograma) {

        Map<String, String> mapaBorrar = buscarPathArchivosByGrupo(moduloAplicacion, idGrupo);
        Iterator<String> it = mapaBorrar.keySet().iterator();

        while (it.hasNext()) {
            int idArchivo = Integer.parseInt(it.next());
            Archivo.borrarArchivo(moduloAplicacion, idArchivo, informacion, usuario, usuarioPrograma);
        }

    }
}
