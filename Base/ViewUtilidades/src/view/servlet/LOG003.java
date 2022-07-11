package view.servlet;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Metodo para hacer logout del sistema.
 *
 * @author omargo33@hotmail.com
 */
@WebServlet(name = "LOG003", urlPatterns =  "/LOG003")
public class LOG003 extends HttpServlet {
    @SuppressWarnings("compatibility:6390922385331371617")
    private static final long serialVersionUID = 1L;
    //    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Metodo para salir por solicitud Get.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ejecutar(request)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    /**
     * Metodo para salir por solicitud PUT.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (ejecutar(request)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }


    /**
     *
     * Metodo para ejecutar el logout.
     *
     * @param request
     * @return
     */
    private boolean ejecutar(HttpServletRequest request) {
        boolean estado = false;
        try {
            HttpSession session = request.getSession(true);
            session.invalidate();
        } catch (Exception e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, e.toString());
        }
        try {
            request.logout();
            estado = true;
        } catch (ServletException e) {
            estado = false;
        }
        return estado;
    }
}
