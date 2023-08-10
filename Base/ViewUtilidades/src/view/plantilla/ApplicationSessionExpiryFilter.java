package view.plantilla;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase para salir correctamente tras un time out.
 * 
 * @author omargo33@hotmail.com
 * @since 2023-08-06
 * @see "https://adfdevelopers.blogspot.com/2009/06/detecting-and-handling-user-session.html"
 */
public class ApplicationSessionExpiryFilter implements Filter {
    private FilterConfig _filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
    }

    public void destroy() {
        _filterConfig = null;
    }

    /**
     * Metodo para filtrar perdidas de sesion.
     *
     * Si la sesion esta expirada la reenvia
     *                                     
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                                     ServletException {
        String requestedSession = ((HttpServletRequest) request).getRequestedSessionId();
        String currentWebSession = ((HttpServletRequest) request).getSession().getId();
        boolean sessionOk = currentWebSession.equalsIgnoreCase(requestedSession);
        if (!sessionOk && requestedSession != null) {
            
            ((HttpServletResponse) response).sendRedirect(_filterConfig.getInitParameter("SessionTimeoutRedirect"));
        } else {
            chain.doFilter(request, response);
        }
    }
}
