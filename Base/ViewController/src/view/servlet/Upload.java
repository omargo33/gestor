  package view.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bc.ModuloImpl;

import model.utilidades.GeneradorClaves;
import model.utilidades.GeneradorFile;

import oracle.jbo.ApplicationModule;
import oracle.jbo.common.Configuration;


@WebServlet(name = "Upload", urlPatterns = {"/faces/Upload"})
  @MultipartConfig(location = "/tmp", 
                   fileSizeThreshold=1024*1024, 
                   maxFileSize=1024*1024*10, 
                   maxRequestSize=1024*1024*5*5)
  public class Upload
    extends HttpServlet
  {
    private static final long serialVersionUID = 1L;
    private String URL = "/faces/upLoadFile.jspx?tipo=%s&mensaje=%s";
    private static String IMPLEMENTACION = "model.bc.ModuleImpl";
    private static String CONFIG = "ModuloWeb";
    private DatosRequest datosRequest = new DatosRequest();
  
  
  
    
    public void init(ServletConfig config) throws ServletException { super.init(config); }
  
  
  
  
  
  
  
  
  
  
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String urlRespuesta = "";
      String nombreArchivo = "";
      String nombreTruncado = "";
      this.datosRequest = new DatosRequest(request);
      
      try {
        Iterator<Part> iterator = request.getParts().iterator(); if (iterator.hasNext()) { Part part = iterator.next();
          nombreArchivo = extraerNombreArchivo(part);
          nombreArchivo = (new File(nombreArchivo)).getName();
          part.write(nombreArchivo);
  
  
          
          nombreTruncado = (nombreArchivo.length() > 30) ? (nombreArchivo.substring(0, 12) + "..." + nombreArchivo.substring(nombreArchivo.length() - 11, nombreArchivo.length())) : nombreArchivo; }
  
      
      } catch (Exception e) {
        urlRespuesta = String.format(this.URL, new Object[] { "error", "Existe un error al subir el archivo" });
      } 
      if (nombreArchivo == null || nombreArchivo.compareTo("") == 0) {
        urlRespuesta = String.format(this.URL, new Object[] { "error", "No seleccionaste un archivo" });
      }
      else if (!validarArchivo(nombreArchivo, this.datosRequest)) {
        
        urlRespuesta = String.format(this.URL, new Object[] {
              "error", String.format("El archivo \"%s\" no tiene el formato adecuado", new Object[] { nombreTruncado })
            });
      } else if (subirPlataforma(this.datosRequest, nombreArchivo)) {
        
        urlRespuesta = String.format(this.URL, new Object[] {
              "info", String.format("El archivo \"%s\" ha cargado satisfactoriamente", new Object[] { nombreTruncado })
            });
      } else {
        urlRespuesta = String.format(this.URL, new Object[] {
              "error", String.format("El archivo \"%s\" No ha podido ser guardado", new Object[] { nombreTruncado })
            });
      } 
      
      enviarRedireccion(this.datosRequest, response, urlRespuesta);
    }
  
  
  
  
  
  
  
  
    
    private boolean subirPlataforma(DatosRequest datosRequest, String nombreArchivo) {
      boolean estado = true;
      int largo = 0;
      String extension = "";
      ModuloImpl moduloImpl = null;
      
      String pathBase = "";
      String fullPath = "";
      String pathRelativo = "";
      String pathOrigen = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + nombreArchivo;
  
      
      String nombreRamdon = datosRequest.getIdGrupo() + "-" + GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 12);
      
      try {
        ApplicationModule am = Configuration.createRootApplicationModule(IMPLEMENTACION, CONFIG);
        moduloImpl = (ModuloImpl)am;
        
        pathBase = moduloImpl.base_obtenerParametroTexto01("200");
        
        fullPath = GeneradorFile.creaDirectorio(pathBase, datosRequest.getAEsquema(), datosRequest.getATabla(), nombreRamdon);
        
        pathRelativo = fullPath.replaceFirst(pathBase, "");
        
        GeneradorFile.copiarArchivo(pathOrigen, fullPath);
        GeneradorFile.borrarArchivo(pathOrigen);
        
        try {
          Path source = Paths.get(fullPath, new String[0]);
          extension = Files.probeContentType(source);
        } catch (IOException e) {
          Logger.getLogger("global").log(Level.SEVERE, e.toString());
          return false;
        } 
        
        largo = (int)(new File(fullPath)).length();
        moduloImpl.base_archivoCrear(datosRequest.getIntIdGrupo(), nombreArchivo, nombreRamdon, extension, pathRelativo, largo, "Archivo Creado desde elemento base", datosRequest
            
            .getNameUser(), "/faces/Upload");
      }
      catch (Exception e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
        estado = false;
      } finally {
        try {
          Configuration.releaseRootApplicationModule((ApplicationModule)moduloImpl, true);
        } catch (Exception e) {
          Logger.getLogger("global").log(Level.SEVERE, e.toString());
          estado = false;
        } 
      } 
      
      return estado;
    }
  
  
  
  
  
  
    
    private String extraerNombreArchivo(Part part) {
      String nombreArchivo = "";
      String contentDisp = part.getHeader("content-disposition");
      String[] items = contentDisp.split(";");
      for (String s : items) {
        if (s.trim().startsWith("filename")) {
          nombreArchivo = s.substring(s.indexOf("=") + 2, s.length() - 1);
        }
      } 
      return nombreArchivo;
    }
  
  
  
  
  
  
  
    
    private static void enviarRedireccion(DatosRequest datosRequest, HttpServletResponse response, String URL) {
      response.setContentType("text/html");
      try {
        PrintWriter printWriter = response.getWriter();
        response.sendRedirect(datosRequest.getURLBase() + URL + datosRequest.getParametrosURL());
        printWriter.close();
      } catch (IOException e) {
        Logger.getLogger("global").log(Level.SEVERE, e.toString());
      } 
    }
  
  
  
  
  
  
  
  
    
    private boolean validarArchivo(String fileName, DatosRequest datosRequest) {
      boolean valido = false;
      
      String extensiones = String.valueOf(datosRequest.getAExtensiones());
      extensiones = extensiones.replaceAll("\\.", " ");
      extensiones = extensiones.replaceAll(",", " ");
      extensiones = extensiones.replaceAll("  ", " ");
      String[] arregloExtensiones = extensiones.split(" ");
      for (int i = 0; i < arregloExtensiones.length; i++) {
        if (fileName.endsWith(arregloExtensiones[i])) {
          valido = true;
        }
      } 
      return valido;
    }
  
  
  
  
  
    
    public class DatosRequest
    {
      private final String PARAMETROS_REENVIO = "&aExtensiones=%s&nameUser=%s&aEsquema=%s&aTabla=%s&idGrupo=%s";
      String aExtensiones = "";
      String nameUser = "";
      String aEsquema = "";
      String aTabla = "";
      String idGrupo = "";
      String URLBase = "";
  
  
  
      
      public DatosRequest() {
        this.aExtensiones = "";
        this.nameUser = "";
        this.aEsquema = "";
        this.aTabla = "";
        this.idGrupo = "";
        this.URLBase = "";
      }
  
  
  
  
  
      
      public DatosRequest(HttpServletRequest request) {
        this.aExtensiones = String.valueOf(request.getParameter("aExtensiones"));
        this.nameUser = String.valueOf(request.getParameter("nameUser"));
        this.aEsquema = String.valueOf(request.getParameter("aEsquema"));
        this.aTabla = String.valueOf(request.getParameter("aTabla"));
        this.idGrupo = String.valueOf(request.getParameter("idGrupo"));
        String scheme = request.getScheme();
        String host = request.getHeader("Host");
        String contextPath = request.getContextPath();
        this.URLBase = scheme + "://" + host + contextPath;
      }
  
  
      
      public String getParametrosURL() { return String.format("&aExtensiones=%s&nameUser=%s&aEsquema=%s&aTabla=%s&idGrupo=%s", new Object[] { this.aExtensiones, this.nameUser, this.aEsquema, this.aTabla, this.idGrupo }); }
  
  
      
      public String getAExtensiones() { return this.aExtensiones; }
  
  
  
      
      public String getNameUser() { return this.nameUser; }
  
  
  
      
      public String getAEsquema() { return this.aEsquema; }
  
  
  
      
      public String getATabla() { return this.aTabla; }
  
  
      
      public int getIntIdGrupo() { return Integer.parseInt(this.idGrupo); }
  
  
      
      public String getIdGrupo() { return this.idGrupo; }
  
  
      
      public String getURLBase() { return this.URLBase; }
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseViewADFLib-01.jar!/view/servlet/Upload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */