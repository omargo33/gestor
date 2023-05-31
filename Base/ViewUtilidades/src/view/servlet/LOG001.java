package view.servlet;import java.io.IOException;import java.io.PrintWriter;import java.util.logging.Level;import java.util.logging.Logger;import javax.servlet.ServletConfig;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;import model.utilidades.estructuras.AccesoXML;/** * Servlet para logear contra los recursos del sistema. * * ejemplo de llamdo: * * http://192.168.1.7:28081/Administrativo-001/faces/LOG001?server=GF5&amp;token={0} * * GL5=GlasFish5/Payara5 * WLS12=Weblogic12c * * @author omargo33@hotmail.com */@WebServlet(name = "LOG001", urlPatterns = "/LOG001")public class LOG001 extends HttpServlet {    @SuppressWarnings("compatibility:-2851783981679477115")    private static final long serialVersionUID = 1L;    private static String URL = "/faces/Home.jspx?token=";    //private static String URL = "/faces/Home.jspx";        public void init(ServletConfig config) throws ServletException {        super.init(config);    }    /**     * Metodo para redireccionar acciones de acuerdo a la informacion del toke.     *     * @param request     * @param response     * @throws ServletException     * @throws IOException     */    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        String token = "";        String server = "";        token = request.getParameter("token");        server = request.getParameter("server");        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, token + " " + server);        try {            if (server.compareToIgnoreCase("WLS12") == 0) {                doGetWLS12(token, request, response);            }            if (server.compareToIgnoreCase("GF5") == 0) {                doGetGF5(token, request, response);            }        } catch (NullPointerException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "nullPointerException");            response.sendError(HttpServletResponse.SC_BAD_REQUEST);        }    }    /**     * Metodo para responder las solicitudes doPost.     *     * @param request     * @param response     * @throws ServletException     * @throws IOException     */    public void doGetWLS12(String token, HttpServletRequest request,                           HttpServletResponse response) throws ServletException, IOException {        try {            if (ejecutarWLS12(request, token)) {                String scheme = request.getScheme();                String host = request.getHeader("Host");                String contextPath = request.getContextPath();                String resultPath = scheme + "://" + host + contextPath;                response.setContentType("text/html");                //response.setHeader("Authorization", "Bearer " + token);                PrintWriter pw = response.getWriter();                response.sendRedirect(resultPath + URL + token);                //response.sendRedirect(resultPath + URL);                pw.close();            } else {                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);            }        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /**     *Metodo para login interno de Glasfish 5 /Parayara5     *     * @param token     * @param request     * @param response     */    private void doGetGF5(String token, HttpServletRequest request, HttpServletResponse response) {        try {            if (ejecutarGF5(request, token)) {                String scheme = request.getScheme();                String host = request.getHeader("Host");                String contextPath = request.getContextPath();                String resultPath = scheme + "://" + host + contextPath;                response.setContentType("text/html");                //response.setHeader("Authorization", "Bearer " + token);                PrintWriter pw = response.getWriter();                response.sendRedirect(resultPath + URL + token);                //response.sendRedirect(resultPath + URL);                pw.close();            } else {                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);            }        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /**     * Metodo para ejecutar una solicitud al servlet.     *     * Logout de sesion previa.     * Decodifica el Token y login sesion.     * Obtiene el usuario remoto     * Compara el usuario remoto con el usuario loggin para evitar confusiones con las sesiones     *     * @param request     */    private boolean ejecutarGF5(HttpServletRequest request, String token) {        AccesoXML accesoXML = new AccesoXML();        String remoteUser = "";        String user = "";        String password = "";        boolean estado = false;        remoteUser = request.getRemoteUser();        if (remoteUser != null) {            try {                request.logout();            } catch (ServletException e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutarGF5 0 " + e.toString());            }        }        try {            accesoXML.decode(token);            user = accesoXML.getUsuario();            password = accesoXML.getPassword();            request.login(user, password);        } catch (ServletException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutarGF5 1 " + e.toString());            return estado;        }        try {            remoteUser = request.getRemoteUser();            estado = (accesoXML.getUsuario().compareTo(remoteUser) == 0);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutarGF5 4 " + e.toString());            return estado;        }        return estado;    }    /**     * Metodo para ejecutar una solicitud al servlet.     *     * Logout de sesion previa.     * Decodifica el Token y login sesion.     * Obtiene el usuario remoto     * Compara el usuario remoto con el usuario loggin para evitar confusiones con las sesiones     * Ingresa el token en la sesion.     *     *     * @param request     */    private boolean ejecutarWLS12(HttpServletRequest request, String token) {        AccesoXML accesoXML = new AccesoXML();        String remoteUser = "";        String user = "";        String password = "";        boolean estado = false;        remoteUser = request.getRemoteUser();        if (remoteUser != null) {            try {                request.logout();            } catch (ServletException e) {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "ejecutar 0 " + e.toString());            }        }        try {            accesoXML.decode(token);            user = accesoXML.getUsuario();            password = accesoXML.getPassword();            request.login(user, password);        } catch (ServletException e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutar 1 " + e.toString());            return estado;        }        try {            remoteUser = request.getRemoteUser();        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutar 2 " + e.toString());            return estado;        }        try {            estado = (accesoXML.getUsuario().compareTo(remoteUser) == 0);            HttpSession session = request.getSession(false);            if (session != null) {                session.setAttribute("token", token);            } else {                Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "ejecutar 3 sesion null");            }        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, "ejecutar 4 " + e.toString());            return estado;        }        return estado;    }}