package view.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bc.ModuloImpl;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.common.Configuration;


@WebServlet(name = "Download", urlPatterns = { "/faces/Download" })
public class Download extends HttpServlet {
    @SuppressWarnings("compatibility:601844940500337986")
    private static final long serialVersionUID = 1L;
    private static String IMPLEMENTACION = "model.bc.ModuleImpl";
    private static String CONFIG = "ModuloWeb";


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = String.valueOf(request.getParameter("nameUser"));
        String idArchivo = String.valueOf(request.getParameter("idArchivo"));
        int idArchivoInt = Integer.parseInt(idArchivo);
        descargarArchivo(idArchivoInt, user, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = String.valueOf(request.getParameter("nameUser"));
        String idArchivo = String.valueOf(request.getParameter("idArchivo"));
        int idArchivoInt = Integer.parseInt(idArchivo);
        descargarArchivo(idArchivoInt, user, response);
    }


    private void descargarArchivo(int idArchivo, String user, HttpServletResponse response) {
        ApplicationModule am = null;
        Archivo archivo = new Archivo();

        try {
            am = Configuration.createRootApplicationModule(IMPLEMENTACION, CONFIG);
            ModuloImpl moduloImpl= (ModuloImpl) am;
            archivo = buscarInformacionArchivo(idArchivo, moduloImpl);
            escribirArchivo(archivo, response);
            escribirEventoDescarga(idArchivo, user, moduloImpl);
        } catch (Exception e) {
            Logger.getLogger("global").log(Level.WARNING, e.toString());
        } finally {
            try {
                Configuration.releaseRootApplicationModule(am, true);
            } catch (Exception e) {
                Logger.getLogger("global").log(Level.WARNING, e.toString());
            }
        }
    }


    private void escribirArchivo(Archivo archivo, HttpServletResponse response) throws IOException {
        File downloadFile = new File(archivo.getFullpath());
        String mimeType = archivo.getExtension();
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", new Object[] { archivo.getNombreArchivo() });

        response.setContentLength((int) downloadFile.length());
        response.setContentType(mimeType);
        response.setHeader(headerKey, headerValue);
        ServletOutputStream servletOutputStream = response.getOutputStream();
        leerEscribir(downloadFile, (OutputStream) servletOutputStream);
    }


    private void escribirEventoDescarga(int idArchivo, String user, ModuloImpl moduloImpl) {
        moduloImpl.base_archivoCrearEvento(idArchivo, "D", "Descarga de elemento", user, "/faces/Download");
    }


    private Archivo buscarInformacionArchivo(int idArchivo, ModuloImpl moduloImpl) {
        Archivo archivo = new Archivo();
        Key key = new Key(new Object[] { Integer.valueOf(idArchivo) });
        Row[] rows = moduloImpl.getBase_ArchivoView1().findByKey(key, -1);

        if (rows.length > 0) {
            archivo.setExtension(String.valueOf(rows[0].getAttribute("Extension")));
            archivo.setNombreArchivo(String.valueOf(rows[0].getAttribute("Nombre")));
            archivo.setPathRelativo(String.valueOf(rows[0].getAttribute("PathRelativo")));
            archivo.setPathBase(moduloImpl.base_obtenerParametroTexto01("200"));
        }
        return archivo;
    }


    private void leerEscribir(File downloadFile, OutputStream outputStream) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(downloadFile);
            byte[] buffer = createNewPDFMemory();
            int bytesRead = -1;
            bytesRead = fileInputStream.read(buffer);

            while (bytesRead != -1) {
                outputStream.write(buffer, 0, bytesRead);
                bytesRead = fileInputStream.read(buffer);
            }
        } catch (IOException e) {
            Logger.getLogger("global").log(Level.WARNING, ".leerEscribirPDF() 0 " + e.toString());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                Logger.getLogger("global").log(Level.WARNING, ".leerEscribirPDF() 1 " + e.toString());
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                Logger.getLogger("global").log(Level.WARNING, ".leerEscribirPDF() 2 " + e.toString());
            }
        }
    }


    private static byte[] createNewPDFMemory() {
        byte[] estatus = new byte[0];
        try {
            estatus = new byte[4096];
        } catch (OutOfMemoryError e) {
            Logger.getLogger("global").log(Level.WARNING, e.toString());
        }
        return estatus;
    }


    public class Archivo {
        private String pathRelativo;


        private String pathBase;


        private String extension;

        private String nombreArchivo;


        public Archivo() {
            this.pathRelativo = "";
            this.pathBase = "";
            this.extension = "";
            this.nombreArchivo = "";
        }


        public Archivo(String pathRelativo, String pathBase, String extension, String nombreArchivo) {
            this.pathRelativo = pathRelativo;
            this.pathBase = pathBase;
            this.extension = extension;
            this.nombreArchivo = nombreArchivo;
        }


        public void setPathRelativo(String pathRelativo) {
            this.pathRelativo = pathRelativo;
        }


        public String getPathRelativo() {
            return this.pathRelativo;
        }


        public void setPathBase(String pathBase) {
            this.pathBase = pathBase;
        }


        public String getPathBase() {
            return this.pathBase;
        }


        public void setExtension(String extension) {
            this.extension = extension;
        }


        public String getExtension() {
            return this.extension;
        }


        public void setNombreArchivo(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
        }


        public String getNombreArchivo() {
            return this.nombreArchivo;
        }


        public String getFullpath() {
            return (String.valueOf(getPathBase()) + String.valueOf(getPathRelativo())).trim();
        }
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseViewADFLib-01.jar!/view/servlet/Download.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */