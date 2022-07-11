package view.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

/**
 *
 * Clase para subir un archivo corrigiendo el error de la biblioteca de trinidad.
 *
 * @see "https://mail.codejava.net/java-ee/servlet/java-file-upload-example-with-servlet-30-api"
 *
 * @author omargo33@hotmail.com
 *
 */
@WebServlet(name = "Upload", urlPatterns = { "/faces/Upload" })
@MultipartConfig(location = "/tmp", // Carpeta temporal
                 fileSizeThreshold = 1024 * 1024 * 1, // 1MB
                 maxFileSize = 1024 * 1024 * 2, // 2MB
                 maxRequestSize = 1024 * 1024 * 3 // 3MB
                 )
public class Upload extends HttpServlet {
    @SuppressWarnings("compatibility:4306628487914120915")
    private static final long serialVersionUID = 1L;
    private String URL = "/faces/upLoadFile.jspx?tipo=%s&mensaje=%s";
    private static String IMPLEMENTACION = "model.bc.ModuleImpl";
    private static String CONFIG = "ModuloWeb";
    private DatosRequest datosRequest = new DatosRequest();


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Metodo para responder un doPost.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlRespuesta = "";
        String nombreArchivo = "";
        String nombreTruncado = "";
        datosRequest = new DatosRequest(request);

        try {
            for (Part part : request.getParts()) {
                nombreArchivo = extraerNombreArchivo(part);
                nombreArchivo = new File(nombreArchivo).getName();
                part.write(nombreArchivo);
                nombreTruncado =
                    (nombreArchivo.length() > 30) ?
                    (nombreArchivo.substring(0, 12) + "..." +
                     nombreArchivo.substring(nombreArchivo.length() - 11, nombreArchivo.length())) : nombreArchivo;
                break;
            }
        } catch (Exception e) {
            urlRespuesta = String.format(URL, "error", "Existe un error al subir el archivo");
        }
        if ((nombreArchivo == null) || (nombreArchivo.compareTo("") == 0)) {
            urlRespuesta = String.format(URL, "error", "No seleccionaste un archivo");
        } else {
            if (!validarArchivo(nombreArchivo, datosRequest)) {
                urlRespuesta =
                    String.format(URL, "error",
                                  String.format("El archivo \"%s\" no tiene el formato adecuado", nombreTruncado));
            } else {
                if (subirPlataforma(datosRequest, nombreArchivo)) {
                    urlRespuesta =
                        String.format(URL, "info",
                                      String.format("El archivo \"%s\" ha cargado satisfactoriamente", nombreTruncado));
                } else {
                    urlRespuesta =
                        String.format(URL, "error",
                                      String.format("El archivo \"%s\" No ha podido ser guardado", nombreTruncado));
                }
            }
        }
        Upload.enviarRedireccion(datosRequest, response, urlRespuesta);
    }


    /**
     * Metodo para subir el archivo a la plataforma.
     *
     * @param datosRequest
     * @param nombreArchivo
     * @return
     */
    private boolean subirPlataforma(DatosRequest datosRequest, String nombreArchivo) {
        boolean estado = true;
        int largo = 0;
        String extension = "";
        ModuloImpl moduloImpl = null;

        String pathBase = "";
        String fullPath = "";
        String pathRelativo = "";
        String pathOrigen = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + nombreArchivo;

        String nombreRamdon =
            datosRequest.getIdGrupo() + "-" + GeneradorClaves.getPassword(GeneradorClaves.KEY_ALFANUMERICOS, 12);

        try {
            ApplicationModule am = Configuration.createRootApplicationModule(IMPLEMENTACION, CONFIG);
            moduloImpl = (ModuloImpl) am;

            pathBase = moduloImpl.base_obtenerParametroTexto01("200");
            fullPath =
                GeneradorFile.creaDirectorio(pathBase, datosRequest.getAEsquema(), datosRequest.getATabla(),
                                             nombreRamdon);
            pathRelativo = fullPath.replaceFirst(pathBase, "");

            GeneradorFile.copiarArchivo(pathOrigen, fullPath);
            GeneradorFile.borrarArchivo(pathOrigen);

            try {
                Path source = Paths.get(fullPath);
                extension = Files.probeContentType(source);
            } catch (IOException e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
                return false;
            }

            largo = (int) new File(fullPath).length();
            moduloImpl.base_archivoCrear(datosRequest.getIntIdGrupo(), nombreArchivo, nombreRamdon, extension,
                                         pathRelativo, largo, "Archivo Creado desde elemento base",
                                         datosRequest.getNameUser(), "/faces/Upload");

        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
            estado = false;
        } finally {
            try {
                Configuration.releaseRootApplicationModule(moduloImpl, true);
            } catch (Exception e) {
                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
                estado = false;
            }
        }

        return estado;
    }

    /**
     * Metodo para extraer nombre del archivo.
     *
     * @param part
     * @return
     */
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

    /**
     * Metodo para reenviar con datos
     *
     * @param datosRequest
     * @param response
     * @param URL
     */
    private static void enviarRedireccion(DatosRequest datosRequest, HttpServletResponse response, String URL) {
        response.setContentType("text/html");
        try {
            PrintWriter printWriter = response.getWriter();
            response.sendRedirect(datosRequest.getURLBase() + URL + datosRequest.getParametrosURL());
            printWriter.close();
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Validar extension del archivo.
     *
     * @param fileName
     * @param datosRequest
     *
     * @return
     */
    private boolean validarArchivo(String fileName, DatosRequest datosRequest) {
        boolean valido = false;

        String extensiones = String.valueOf(datosRequest.getAExtensiones());
        extensiones = extensiones.replaceAll("\\.", " ");
        extensiones = extensiones.replaceAll(",", " ");
        extensiones = extensiones.replaceAll("  ", " ");
        String arregloExtensiones[] = extensiones.split(" ");
        for (int i = 0; i < arregloExtensiones.length; i++)
            if (fileName.endsWith(arregloExtensiones[i])) {
                valido = true;
            }

        return valido;
    }


    /**
     * Objeto para dar soporte a la data de las consultas request.
     *
     * @author omargo33@hotmail.com
     */
    public class DatosRequest {
        private final String PARAMETROS_REENVIO = "&aExtensiones=%s&nameUser=%s&aEsquema=%s&aTabla=%s&idGrupo=%s";
        String aExtensiones = "";
        String nameUser = "";
        String aEsquema = "";
        String aTabla = "";
        String idGrupo = "";
        String URLBase = "";

        /**
         * Metodo para crear el objeto.
         */
        public DatosRequest() {
            this.aExtensiones = "";
            this.nameUser = "";
            this.aEsquema = "";
            this.aTabla = "";
            this.idGrupo = "";
            this.URLBase = "";
        }

        /**
         * Metodo para crear el objeto a partir de una solicitud request.
         *
         * @param request
         */
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

        //Propiedades.
        public String getParametrosURL() {
            return String.format(PARAMETROS_REENVIO, aExtensiones, nameUser, aEsquema, aTabla, idGrupo);
        }

        public String getAExtensiones() {
            return aExtensiones;
        }


        public String getNameUser() {
            return nameUser;
        }


        public String getAEsquema() {
            return aEsquema;
        }


        public String getATabla() {
            return aTabla;
        }

        public int getIntIdGrupo() {
            return Integer.parseInt(idGrupo);
        }

        public String getIdGrupo() {
            return idGrupo;
        }

        public String getURLBase() {
            return URLBase;
        }
    }
}
