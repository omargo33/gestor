package model.utilidades;

import com.aplicaciones13.reporte.worksheet.worksheet.HojaCalculoEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.Sheet;

/**
 * Objeto para generar archivos.
 *
 * @author omargo33@hotmail.com
 *
 */
public class GeneradorFile {

    /**
     * Grabar archivo.
     *
     * @param inputStream
     * @param pathFull
     * @param largoBytes
     * @return
     */
    public static boolean grabarArchivo(InputStream inputStream, String pathFull, int largoBytes) {
        boolean estado = true;
        try {
            FileOutputStream out = new FileOutputStream(pathFull);
            byte[] buffer = new byte[largoBytes];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer, 0, largoBytes)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            estado = false;
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                Logger.getLogger("global").log(Level.SEVERE, e.toString());
                estado = false;
            }
        }
        return estado;
    }

    /**
     * Copoiar archivos.
     *
     * @param archivoOrigen
     * @param archivoDestino
     */
    public static void copiarArchivo(String archivoOrigen, String archivoDestino) {
        File origen = new File(archivoOrigen);
        File destino = new File(archivoDestino);
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(origen);
            os = new FileOutputStream(destino);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception e) {
                Logger.getLogger("global").log(Level.SEVERE, e.toString());
            }
        }
    }

    /**
     * Metodo para crear un documento excel directo desde una consulta.
     *
     * @param resultSet
     * @param nombrePagina
     * @param pathFile
     * @return
     */
    public static boolean crearExcelFromResultSet(ResultSet resultSet, String nombrePagina, String pathFile) {
        boolean estado = true;
        HojaCalculoEngine hce;
        int linea = 0;
        try {
            File file = new File(pathFile);
            FileOutputStream outputStream = new FileOutputStream(file);
            hce = new HojaCalculoEngine(outputStream);
            hce.addSheet(nombrePagina);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cantidadColumnas = resultSetMetaData.getColumnCount();

            for (int i = 0; i < cantidadColumnas; i++) {
                hce.addValorCelda(i,linea, resultSetMetaData.getColumnLabel(i + 1), HojaCalculoEngine.P_STRONG);
            }
            while (resultSet.next()) {
                linea++;
                for (int i = 0; i < cantidadColumnas; i++) {
                    hce.addValorCelda(i, linea, resultSet.getString(i + 1), HojaCalculoEngine.P);
                }
            }

            hce.cerrarLibro();
        } catch (Exception e) {
            estado = false;
            Logger.getLogger("global").log(Level.SEVERE, e.toString());
        }
        return estado;
    }

    /**
     * Metodo para borrar archivos.
     *
     * @param archivo
     * @return
     */
    public static boolean borrarArchivo(String archivo) {
        File file = new File(archivo);
        return file.delete();
    }
}
