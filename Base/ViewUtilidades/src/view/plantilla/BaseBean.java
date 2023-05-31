package view.plantilla;import java.io.Serializable;import java.security.Principal;import java.text.MessageFormat;import java.text.SimpleDateFormat;import java.util.Date;import java.util.ResourceBundle;import java.util.logging.Level;import java.util.logging.Logger;import javax.faces.context.ExternalContext;import javax.faces.context.FacesContext;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;import model.utilidades.estructuras.AccesoXML;import oracle.adf.model.BindingContext;import oracle.binding.BindingContainer;import view.plantilla.utilidades.Flow;import view.utilidades.ADFUtils;/** * Metodo con los objetos base de Bean Session. * * @author omargo33@hotmail.com * */public class BaseBean implements Serializable {    @SuppressWarnings("compatibility:6475934976354612577")    private static final long serialVersionUID = 1L;    public static final int TASK_FLOW_CREAR = 1;    public static final int TASK_FLOW_EDITAR = 2;    private static String ACCION_TASK_FLOW = "AccionTaskFlow";    private static String ACCION_TASK_FLOW_HIJO = "AccionTaskFlowHijo";    private static String ACCION_ESTADO_TASK_FLOW = "AccionEstadoTaskFlow";    private static String ACCION_ESTADO_TASK_FLOW_HIJO = "AccionEstadoTaskFlowHijo";    private static String NO_DEFINIDO = "1";    private HttpSession session;    private ResourceBundle resourceBundle = null;    private String urlBase;    private boolean isTokenExiste= false;    /** Metodo para crear el objeto.     *     */    public BaseBean() {        super();        setNombreBundle(Flow.BUNDLE);        setAccionTaskFlow("");        setAccionTaskFlowHijo("");        isTokenExiste = false;    }    /**     * Metodo para seteaer el usuario.     *     * @param user     */    public void setNameUser(String user) {        getSession().setAttribute("userData", user);    }    /**     * Metodo para obtener el usuario.     *     * Desde una session Http     * En caso de error se saca del contexto ADF.     *     * @return     */    public String getNameUser() {        String token = null;        String nameUser = "anonymous";        FacesContext context = FacesContext.getCurrentInstance();        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();        if (!isTokenExiste) {            try {                token = (String) ADFUtils.evaluateEL("#{param.token}");                                AccesoXML accesoXML = new AccesoXML();                accesoXML.decode(token);                nameUser = accesoXML.getUsuario();                if (accesoXML.getFechaValido() < new Date().getTime()) {                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);                }                                getSession().setAttribute("token", token);                isTokenExiste = true;            } catch (Exception e) {                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);            }        }        try {            Principal principal = request.getUserPrincipal();            nameUser = principal.getName();        } catch (Exception e) {            try {                AccesoXML accesoXML = new AccesoXML();                accesoXML.decode((String) getSession().getAttribute("token"));                nameUser = accesoXML.getUsuario();                if (accesoXML.getFechaValido() < new Date().getTime()) {                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);                }            } catch (Exception e1) {                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);            }        }        return nameUser;    }    /** Metodo para poner la accion de un task flow viene de un crear.     *     */    public void accionTaskFlowCrear() {        try {            setAccionTaskFlow(getBundle("accion_crear"));            setAccionEstadoTaskFlow(TASK_FLOW_CREAR);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /** Metodo para poner la accion de un task flow viene de un editar.     *     */    public void accionTaskFlowEditar() {        try {            setAccionTaskFlow(getBundle("accion_editar"));            setAccionEstadoTaskFlow(TASK_FLOW_EDITAR);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /** Metodo para poner la accion de un task flow viene de un crear.     *     */    public void accionTaskFlowCrearHijo() {        try {            setAccionTaskFlowHijo(getBundle("accion_crear"));            setAccionEstadoTaskFlowHijo(TASK_FLOW_CREAR);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /** Metodo para poner la accion de un task flow viene de un editar.     *     */    public void accionTaskFlowEditarHijo() {        try {            setAccionTaskFlowHijo(getBundle("accion_editar"));            setAccionEstadoTaskFlowHijo(TASK_FLOW_EDITAR);        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }    }    /**Metodo para devolver la session e informacion en la session.     *     * @return     */    public HttpSession getSession() {        try {            if (session == null) {                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();                session = (HttpSession) externalContext.getSession(false);            }        } catch (Exception e) {            session = null;        }        return session;    }    /**     * Metodo para set Session.     * @param session     */    public void setSession(HttpSession session) {        this.session = session;    }    /** Metodo para sacar los datos de la sesion por llave.     *     * @param llave     * @return     */    private String getNVLString(String llave) {        String campo = (String) getSession().getAttribute(llave);        return (campo == null) ? NO_DEFINIDO : campo;    }    /** Metodo para sacar los datos de la sesion por llave.     *     * @param llave     * @return     */    private int getNVLInt(String llave) {        try {            llave = (llave == null) ? "" : llave;            return ((Integer) getSession().getAttribute(llave)).intValue();        } catch (Exception e) {            return -1;        }    }    /** Metodo para obtener el ip del remote navegador.     *     * @return     */    public String getRemoteIp() {        try {            FacesContext fctx = FacesContext.getCurrentInstance();            ExternalContext ectx = fctx.getExternalContext();            HttpServletRequest request = (HttpServletRequest) ectx.getRequest();            return request.getRemoteAddr();        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }        return null;    }    /** Metodo para obtener el host del remote navegador.     *     * @return     */    public String getRemoteHost() {        try {            FacesContext fctx = FacesContext.getCurrentInstance();            ExternalContext ectx = fctx.getExternalContext();            HttpServletRequest request = (HttpServletRequest) ectx.getRequest();            return request.getRemoteHost();        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }        return null;    }    /** Metodo para obtener el host del remote navegador.     *     * @return     */    public String getRemoteAgent() {        try {            FacesContext fctx = FacesContext.getCurrentInstance();            ExternalContext ectx = fctx.getExternalContext();            HttpServletRequest request = (HttpServletRequest) ectx.getRequest();            return request.getHeader("User-Agent");        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }        return null;    }    /**     * @param accionTaskFlow     */    public void setAccionTaskFlow(String accionTaskFlow) {        getSession().setAttribute(ACCION_TASK_FLOW, accionTaskFlow);    }    /**     * @param accionTaskFlow     */    public void setAccionTaskFlowHijo(String accionTaskFlow) {        getSession().setAttribute(ACCION_TASK_FLOW_HIJO, accionTaskFlow);    }    /**     * @return     */    public String getAccionTaskFlow() {        return getNVLString(ACCION_TASK_FLOW);    }    /**     * @param accionEstadoTaskFlow     */    public void setAccionEstadoTaskFlow(int accionEstadoTaskFlow) {        getSession().setAttribute(ACCION_ESTADO_TASK_FLOW, accionEstadoTaskFlow);    }    /**     * @param accionEstadoTaskFlow     */    public void setAccionEstadoTaskFlowHijo(int accionEstadoTaskFlow) {        getSession().setAttribute(ACCION_ESTADO_TASK_FLOW_HIJO, accionEstadoTaskFlow);    }    /**     * @return     */    public int getAccionEstadoTaskFlow() {        return getNVLInt(ACCION_ESTADO_TASK_FLOW);    }    /**     * @return     */    public int getAccionEstadoTaskFlowHijo() {        return getNVLInt(ACCION_ESTADO_TASK_FLOW_HIJO);    }    /** Metodo para devolver el URL base actual.     *     * http://127.0.0.1:8080     * https://127.0.0.1:452     *     * @return     */    public String getUrlBase() {        urlBase = "";        try {            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();            String schema = externalContext.getRequestScheme();            String serverName = externalContext.getRequestServerName();            int port = externalContext.getRequestServerPort();            urlBase = schema + "://" + serverName + ":" + port;        } catch (Exception e) {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.WARNING, e.toString());        }        return urlBase;    }    /**     * Metodo para conocer los url.     *     * @param urlBase     */    public void setUrlBase(String urlBase) {        this.urlBase = urlBase;    }    /**     * Metodo para set nombre bundle.     *     * @param nombreBundle     */    public void setNombreBundle(String nombreBundle) {        resourceBundle = ResourceBundle.getBundle(nombreBundle);    }    /**     * Metodo para llamar una un mensaje bundle para los mensajes del sistema.     *     * @param llaveBundle     * @param parametros     * @return     */    public String getBundle(String llaveBundle, Object... parametros) {        if (resourceBundle == null)            return "<No Definido, Bundle no Instanciado>";        String mensaje = resourceBundle.getString(llaveBundle);        if (mensaje == null)            return String.format("<No Definido, %s llave no encontrada>", llaveBundle);        if (parametros == null)            return mensaje;        return MessageFormat.format(mensaje, parametros);    }    /**     * Set fecha corto.     *     * @param fecha     */    public void setFecha15DiasCorto(String fecha) {        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, fecha);    }    /**     * Metodo para get una fecha corta inicio.     *     * @return     */    public String getFecha15DiasCorto() {        Date fechaInicio = new Date(new Date().getTime() - (15 * 24 * 60 * 60 * 1000));        SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd");        return dateFormatCorta.format(fechaInicio);    }    /**     * Set fecha corto.     *     * @param fecha     */    public void setFecha30DiasCorto(String fecha) {        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, fecha);    }    /**     * Metodo para get una fecha corta inicio.     *     * @return     */    public String getFecha30DiasCorto() {        Date fechaInicio = new Date(new Date().getTime() - (30 * 24 * 60 * 60 * 1000));        SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd");        return dateFormatCorta.format(fechaInicio);    }    /**     * Metodo para set fecha de corto fin.     *     * @param fecha     */    public void setFechaHoyCort(String fecha) {        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, fecha);    }    /**     * Metodo para get fecha corta fin.     *     * @return     */    public String getFechaHoyCorto() {        Date fechaFin = new Date(new Date().getTime() + (5 * 60 * 1000));        SimpleDateFormat dateFormatCorta = new SimpleDateFormat("yyyy-MM-dd");        return dateFormatCorta.format(fechaFin);    }    /**     * Get Bindings.     *     * @return BindingContainer     */    public BindingContainer getBindings() {        return BindingContext.getCurrent().getCurrentBindingsEntry();    }}