package model.bc.modulo;

import com.aplicaciones13.reporte.pdf.ImpresionBaseIText;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.ResultSet;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.bc.ModuloImpl;
import model.bc.vistaNoDML.UsuarioViewNoDMLImpl;

import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorFile;

import com.aplicaciones13.tools.Archivo;

import java.util.Map;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;

/**
 * Objeto para dar soporte a los reportes emitidos por el sistema.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Reporte {

    /**
     * Metodo para crear reporte de Excel e ingresa los valores a la estructura de soporte de documentos del sistema.
     *
     * @param moduloAplicacion
     * @param resultSet
     * @param nombreArchivo
     * @param esquema
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static int crearReporteExcel(ModuloImpl moduloAplicacion, ResultSet resultSet, String nombreArchivo,
                                        String esquema, String tabla, String usuario, String usuarioPrograma) {
        int codigoArchivo = 0;
        int codigoUsuario = buscarUsuario(moduloAplicacion, usuario);
        int codigoGrupo = Grupo.buscarGrupo(moduloAplicacion, codigoUsuario, esquema, tabla);
        int largo = 0;

        String nombreRamdon =
            codigoGrupo + "-" +
            GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 12);
        String pathBase = moduloAplicacion.base_obtenerParametroTexto01("200");

        String fullPath = Archivo.creaDirectorio(pathBase, esquema, tabla, nombreRamdon);
        String pathRelativo = fullPath.replaceFirst(pathBase, "");
        String extension = "none";

        if (codigoGrupo == 0) {
            codigoGrupo =
                Grupo.crearGrupo(moduloAplicacion, codigoUsuario, esquema, tabla, -1, "xls, xlsx, ", 1900, 1080, -1,
                                 usuario, usuarioPrograma);
        }

        if (GeneradorFile.crearExcelFromResultSet(resultSet, tabla, fullPath)) {
            try {
                Path source = Paths.get(fullPath, new String[0]);
                extension = Files.probeContentType(source);
            } catch (IOException e) {
                Logger.getLogger("global").log(Level.SEVERE, e.toString());
            }
            largo = (int) (new File(fullPath)).length();

            codigoArchivo =
                moduloAplicacion.base_archivoCrear(codigoGrupo, nombreArchivo, nombreRamdon, extension, pathRelativo,
                                                   largo, "Archivo Generado al solicitar un reporte", usuario,
                                                   usuarioPrograma);
        } else {
            Logger.getLogger("global").log(Level.SEVERE, "No se pudo generar el repoerte " + nombreArchivo);
            throw new JboException("No se pudo generar el reporte " + nombreArchivo);
        }
        return codigoArchivo;
    }


    /**
     * Metodo para crear reporte de PDF e ingresa los valores a la estructura de soporte de documentos del sistema.
     *
     * @param moduloAplicacion
     * @param impresionBaseIText
     * @param mapa
     * @param nombreArchivo
     * @param esquema
     * @param tabla
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public static int crearReportePDF(ModuloImpl moduloAplicacion, ImpresionBaseIText impresionBaseIText,
                                      Map<String, String> mapa, String nombreArchivo, String esquema, String tabla,
                                      String usuario, String usuarioPrograma) {        
        boolean isHorizontal = false;
        int codigoArchivo = 0;
        int codigoUsuario = buscarUsuario(moduloAplicacion, usuario);
        int codigoGrupo = Grupo.buscarGrupo(moduloAplicacion, codigoUsuario, esquema, tabla);
        int largo = 0;
        String horizontal = mapa.get("horizontal");
        String nombreRamdon =
            codigoGrupo + "-" +
            GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 12);
        String pathBase = moduloAplicacion.base_obtenerParametroTexto01("200");
        
        String fullPath = Archivo.creaDirectorio(pathBase, esquema, tabla, nombreRamdon);
        String pathRelativo = fullPath.replaceFirst(pathBase, "");
        String extension = "none";
        
        //Se imprime horizontal o vertical
        if (horizontal != null && horizontal.compareToIgnoreCase("true") == 0) {
            isHorizontal = true;
        }
        
        if (codigoGrupo == 0) {
            codigoGrupo =
                Grupo.crearGrupo(moduloAplicacion, codigoUsuario, esquema, tabla, -1, "pdf, ", 1900, 1080, -1, usuario,
                                 usuarioPrograma);
        }

        mapa.put("documentoDestino", fullPath);
        if (impresionBaseIText.ejecutar(18, 36, 30, 30, isHorizontal, mapa)) {                        
            try {             
                Path source = Paths.get(fullPath, new String[0]);
                extension = Files.probeContentType(source);             
            } catch (IOException e) {
                Logger.getLogger("global").log(Level.SEVERE, e.toString());
            }

            largo = (int) (new File(fullPath)).length();

            codigoArchivo =
                moduloAplicacion.base_archivoCrear(codigoGrupo, nombreArchivo, nombreRamdon, extension, pathRelativo,
                                                   largo, "Archivo Generado al solicitar un reporte", usuario,
                                                   usuarioPrograma);            
        } else {            
            Logger.getLogger("global").log(Level.SEVERE, "No se pudo generar el reporte " + nombreArchivo);
            throw new JboException("No se pudo generar el reporte " + nombreArchivo);
        }
        return codigoArchivo;
    }

    /**
     * Metodo para buscar un usuario.
     *
     * @param moduloAplicacion
     * @param nick
     * @return
     */
    public static int buscarUsuario(ModuloImpl moduloAplicacion, String nick) {
        int codigo = 0;

        UsuarioViewNoDMLImpl usuarioViewNoDMLImpl = moduloAplicacion.getBase_UsuarioViewNoDML1();
        ViewCriteriaManager vcm = usuarioViewNoDMLImpl.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("UsuarioViewNoDMLCriteriaByNick");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_nick", nick);
        usuarioViewNoDMLImpl.applyViewCriteria(vc);
        usuarioViewNoDMLImpl.executeQuery();
        while (usuarioViewNoDMLImpl.hasNext()) {
            Row r = usuarioViewNoDMLImpl.next();
            codigo = ((Integer) r.getAttribute("IdUsuario")).intValue();
        }
        return codigo;
    }
}
