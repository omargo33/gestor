package model.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;





















public class GeneradorFile
{
  public static String creaDirectorio(String pathBase, String esquema, String tabla, String nombreArchivo) {
      String separador = System.getProperty("file.separator");
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      String directorioFecha = format.format(new Date());
    
      String path = pathBase + esquema + separador + tabla + separador + directorioFecha;
      File stockDir = new File(path);
    try {
        stockDir.setWritable(true, true);
        stockDir.setReadable(true, true);
        stockDir.setExecutable(true, true);
        stockDir.mkdirs();
      } catch (SecurityException e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
    } 
      return path + separador + nombreArchivo;
  }








  
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









  
  public static boolean crearExcelFromResultSet(ResultSet resultSet, String nombrePagina, String pathFile) {
      boolean estado = true;
    
    try {
        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
        Sheet sheet = hSSFWorkbook.createSheet(nombrePagina);
      
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int cantidadColumnas = resultSetMetaData.getColumnCount();
        Row row = sheet.createRow(0);
        for (int i = 0; i < cantidadColumnas; i++) {
          Cell newpath = row.createCell(i);
          newpath.setCellValue(resultSetMetaData.getColumnLabel(i + 1));
      } 
        while (resultSet.next()) {
          Row rowData = sheet.createRow(resultSet.getRow());
          for (int i = 0; i < cantidadColumnas; i++) {
            Cell newpath = rowData.createCell(i);
            newpath.setCellValue(resultSet.getString(i + 1));
        } 
      } 
      
        FileOutputStream fileOutputStream = new FileOutputStream(new File(pathFile));
        hSSFWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }
      catch (Exception e) {
        estado = false;
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
    } 
      return estado;
  }







  
  public static boolean borrarArchivo(String archivo) {
      File file = new File(archivo);
      return file.delete();
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/GeneradorFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */