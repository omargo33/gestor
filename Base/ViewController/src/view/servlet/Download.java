package view.servlet;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.io.OutputStream;import java.util.logging.Level;import java.util.logging.Logger;import javax.servlet.ServletConfig;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import model.bc.ModuloImpl;import oracle.jbo.ApplicationModule;import oracle.jbo.Key;import oracle.jbo.Row;import oracle.jbo.common.Configuration;@WebServlet(name = "Download", urlPatterns = { "/faces/Download" })public class Download extends HttpServlet {    @SuppressWarnings({ "compatibility:-7139755288764057068", "oracle.jdeveloper.java.serialversionuid-stale" })    private static final long serialVersionUID = 1L;    private final static int PDF_SIZE = 4096;    private static String IMPLEMENTACION = "model.bc.ModuleImpl";    private static String CONFIG = "ModuloWeb";    @Override    public void init(ServletConfig config) throws ServletException {        super.init(config);    }    @Override    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        String user = String.valueOf(request.getParameter("nameUser"));        String idArchivo = String.valueOf(request.getParameter("idArchivo"));        int idArchivoInt = Integer.parseInt(idArchivo);        descargarArchivo(idArchivoInt, user, response);    }    @Override    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        String user = String.valueOf(request.getParameter("nameUser"));        String idArchivo = String.valueOf(request.getParameter("idArchivo"));        int idArchivoInt = Integer.parseInt(idArchivo);        descargarArchivo(idArchivoInt, user, response);    }    /**     * Metodo para evento de descarga.     *     *     * @param idArchivo     * @param user     * @param response     * @return     */    private void descargarArchivo(int idArchivo, String user, HttpServletResponse response) {        ModuloImpl moduloImpl = null;        Archivo archivo = new Archivo();                try {            ApplicationModule am = Configuration.createRootApplicationModule(IMPLEMENTACION, CONFIG);            moduloImpl = (ModuloImpl) am;            archivo = buscarInformacionArchivo(idArchivo, moduloImpl);            escribirArchivo(archivo, response);            escribirEventoDescarga(idArchivo, user, moduloImpl);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());        } finally {            try {                Configuration.releaseRootApplicationModule(moduloImpl, true);            } catch (Exception e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());            }        }    }    /**     * Metodo para descargar un archivo.     *     * A partir de un path inicializa el archivo. De no tener mimeType agrega uno     * por default. Establece el encabezado de descarga.     *     * Escribe la salida stream output estandar.     *     *     * @param archivo     * @param response     */    private void escribirArchivo(Archivo archivo, HttpServletResponse response) throws IOException {        File downloadFile = new File(archivo.getFullpath());        String mimeType = archivo.getExtension();        String headerKey = "Content-Disposition";        String headerValue = String.format("attachment; filename=\"%s\"", archivo.getNombreArchivo());        response.setContentLength((int) downloadFile.length());        response.setContentType(mimeType);        response.setHeader(headerKey, headerValue);        OutputStream outStream = response.getOutputStream();        leerEscribir(downloadFile, outStream);    }    /**     * Escribe el evento de guardado.     *     * @param idArchivo     * @param user     * @param moduloImpl     */    private void escribirEventoDescarga(int idArchivo, String user, ModuloImpl moduloImpl) {        moduloImpl.base_archivoCrearEvento(idArchivo, model.bc                                                           .modulo                                                           .Archivo                                                           .EVENTO_DESCARGAR, "Descarga de elemento", user,                                           "/faces/Download");    }    /**     * Busca informacion del archivo solicitado para ser descargado.     *     * @param idArchivo     * @param moduloImpl     * @return     */    private Archivo buscarInformacionArchivo(int idArchivo, ModuloImpl moduloImpl) {        Archivo archivo = new Archivo();        Key key = new Key(new Object[] { idArchivo });        Row[] rows = moduloImpl.getBase_ArchivoView1().findByKey(key, -1);        if (rows.length > 0) {            archivo.setExtension(String.valueOf(rows[0].getAttribute("Extension")));            archivo.setNombreArchivo(String.valueOf(rows[0].getAttribute("Nombre")));            archivo.setPathRelativo(String.valueOf(rows[0].getAttribute("PathRelativo")));            archivo.setPathBase(moduloImpl.base_obtenerParametroTexto01("200"));        }        return archivo;    }    /**     * Metodo para escribir la salida Stream PDF.     *     * @param downloadFile     * @param outputStream     */    private void leerEscribir(File downloadFile, OutputStream outputStream) {        FileInputStream fileInputStream = null;        try {            fileInputStream = new FileInputStream(downloadFile);            byte[] buffer = createNewPDFMemory();            int bytesRead = -1;            bytesRead = fileInputStream.read(buffer);            while (bytesRead != -1) {                outputStream.write(buffer, 0, bytesRead);                bytesRead = fileInputStream.read(buffer);            }        } catch (IOException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, ".leerEscribirPDF() 0 " + e.toString());        } finally {            try {                fileInputStream.close();            } catch (IOException e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, ".leerEscribirPDF() 1 " + e.toString());            }            try {                outputStream.close();            } catch (IOException e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, ".leerEscribirPDF() 2 " + e.toString());            }        }    }    /**     * Metodo para crear espacio de memoria.     *     * @return     */    private static byte[] createNewPDFMemory() {        byte[] estatus = new byte[0];        try {            estatus = new byte[PDF_SIZE];        } catch (OutOfMemoryError e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, e.toString());        }        return estatus;    }    /**     * Metodo para tener estructura de archivo de descarga.     *     * @author omargo33@hotmail.com     */    public class Archivo {        private String pathRelativo;        private String pathBase;        private String extension;        private String nombreArchivo;        /**         * Metodo para crear objeto.         */        public Archivo() {            this.pathRelativo = "";            this.pathBase = "";            this.extension = "";            this.nombreArchivo = "";        }        /**         * Metodo para crear el objeto.         *         * @param pathRelativo         * @param pathBase         * @param extension         * @param nombreArchivo         */        public Archivo(String pathRelativo, String pathBase, String extension, String nombreArchivo) {            this.pathRelativo = pathRelativo;            this.pathBase = pathBase;            this.extension = extension;            this.nombreArchivo = nombreArchivo;        }        //Propiedades        public void setPathRelativo(String pathRelativo) {            this.pathRelativo = pathRelativo;        }        public String getPathRelativo() {            return pathRelativo;        }        public void setPathBase(String pathBase) {            this.pathBase = pathBase;        }        public String getPathBase() {            return pathBase;        }        public void setExtension(String extension) {            this.extension = extension;        }        public String getExtension() {            return extension;        }        public void setNombreArchivo(String nombreArchivo) {            this.nombreArchivo = nombreArchivo;        }        public String getNombreArchivo() {            return nombreArchivo;        }        public String getFullpath() {            return (String.valueOf(getPathBase()) + String.valueOf(getPathRelativo())).trim();        }    }}