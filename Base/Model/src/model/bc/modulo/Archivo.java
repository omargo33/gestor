package model.bc.modulo;

import model.bc.ModuloImpl;
import model.bc.VistaObjeto;
import model.bc.entidad.ArchivoEventoImpl;
import model.bc.entidad.ArchivoImpl;
import model.bc.vista.ArchivoViewImpl;

import model.utilidades.Atributos;

import oracle.jbo.Key;
import oracle.jbo.Row;

/**
 * Objeto para crear entradas de archivos a los grupos de recursos del sistema.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Archivo {
    public static final String EVENTO_CARGAR = "C";
    public static final String EVENTO_DESCARGAR = "D";
    public static final String EVENTO_ELIMINAR = "X";

    /**
     * Metod para crear el evento del archivo.
     *
     * @param moduloAplicacion
     * @param idArchivo
     * @param informacion
     * @param tipo
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static int crearEventeoArchivo(ModuloImpl moduloAplicacion, int idArchivo, String informacion, String tipo,
                                          String usuario, String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;

        VistaObjeto vistaObjeto = moduloAplicacion.getBase_ArchivoEventoView1();
        Row row = vistaObjeto.createRow();
        row.setAttribute(ArchivoEventoImpl.IDARCHIVO, Integer.valueOf(idArchivo));
        row.setAttribute(ArchivoEventoImpl.INFORMACION, Atributos.stringLargo(informacion, "<NO APLICA>", 512));
        row.setAttribute(ArchivoEventoImpl.TIPO, Atributos.stringLargo(tipo, "<NO APLICA>", 8));
        row.setAttribute(ArchivoEventoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
        row.setAttribute(ArchivoEventoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        row.validate();
        vistaObjeto.insertRow(row);
        estado = moduloAplicacion.commitRollback(Integer.valueOf(idArchivo), "crearEventeoArchivo");
        if (estado) {
            codigo = ((Integer) row.getAttribute(ArchivoEventoImpl.IDARCHIVOEVENTO)).intValue();
        } else {
            codigo = -1;
        }
        return codigo;
    }

    /**
     * Metodo para crear la entrada de un archivo, con sus diversas opciones de configuracion.
     *
     * @param moduloAplicacion
     * @param idGrupo
     * @param nombre
     * @param nombreRamdon
     * @param extension
     * @param pathRelativo
     * @param largo
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static int crearArchivo(ModuloImpl moduloAplicacion, int idGrupo, String nombre, String nombreRamdon,
                                   String extension, String pathRelativo, int largo, String usuario,
                                   String usuarioPrograma) {
        int codigo = 0;
        boolean estado = true;

        ArchivoViewImpl archivoViewImpl = moduloAplicacion.getBase_ArchivoView1();
        Row row = archivoViewImpl.createRow();
        row.setAttribute(ArchivoImpl.IDGRUPO, Integer.valueOf(idGrupo));
        row.setAttribute(ArchivoImpl.NOMBRERAMDON, Atributos.stringLargo(nombreRamdon, "<NO APLICA>", 128));
        row.setAttribute(ArchivoImpl.NOMBRE, Atributos.stringLargo(nombre, "<NO APLICA>", 256));
        row.setAttribute(ArchivoImpl.EXTENSION, Atributos.stringLargo(extension, "<NO APLICA>", 32));
        row.setAttribute(ArchivoImpl.LARGO, Integer.valueOf(largo));
        row.setAttribute(ArchivoImpl.PATHRELATIVO, Atributos.stringLargo(pathRelativo, "<NO APLICA>", 512));
        row.setAttribute(ArchivoImpl.ESTADO, Atributos.stringLargo("A", "<NO APLICA>", 8));
        row.setAttribute(ArchivoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
        row.setAttribute(ArchivoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        row.validate();
        archivoViewImpl.insertRow(row);
        estado = moduloAplicacion.commitRollback(nombre, "crearArchivo");
        if (estado) {
            codigo = ((Integer) row.getAttribute(ArchivoImpl.IDARCHIVO)).intValue();
        } else {
            codigo = -1;
        }

        return codigo;
    }


    /**
     * Metodo para borrar el archivo, esta labor es logica, no fisica.
     *
     * @param moduloAplicacion
     * @param idArchivo
     * @param informacion
     * @param usuario
     * @param usuarioPrograma
     */
    public static void borrarArchivo(ModuloImpl moduloAplicacion, int idArchivo, String informacion, String usuario,
                                     String usuarioPrograma) {
        boolean estado = true;
        Key key = new Key(new Object[] { Integer.valueOf(idArchivo) });
        Row[] rows = moduloAplicacion.getBase_ArchivoView2().findByKey(key, 1);

        for (Row r : rows) {
            r.setAttribute(ArchivoImpl.ESTADO, "X");
            r.setAttribute(ArchivoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
            r.setAttribute(ArchivoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        }

        estado = moduloAplicacion.commitRollback(Integer.valueOf(idArchivo), "borrarArchivo");

        if (estado) {
            crearEventeoArchivo(moduloAplicacion, idArchivo, informacion, "X", usuario, usuarioPrograma);
        }
    }   
}