package view.plantilla;import java.util.ArrayList;import java.util.Comparator;import java.util.HashMap;import java.util.List;import java.util.Map;import java.util.logging.Level;import java.util.logging.Logger;import model.utilidades.estructuras.Menu;import oracle.adf.controller.TaskFlowId;import view.utilidades.ADFUtils;import view.utilidades.JSFUtils;/** * Clase para hacer cambios en la estructura de menu y permisos. * * @author omargo33@hotmail.com */public class MenuEstructuraBean extends BaseBean {    @SuppressWarnings("compatibility:5593372073813773719")    private static final long serialVersionUID = 1L;    private List<MenuLink> listaMenu = null;    private List<MenuLink> listaModulo = null;    private String tituloModulo;    private String urlModulo;    private MenuLink menuActual;    /**     * Metodo para buscar la informacion de los menus del usuario.     *     */    private void buscarInformacionMenu() {        //int indice = 0;        listaMenu = new ArrayList<MenuLink>();        @SuppressWarnings("unchecked")        List<Menu> listaMenuBase = (List<Menu>) ADFUtils.evaluateEL("#{sessionScope.menu}");        String moduloActual = JSFUtils.resolveExpressionAsString("#{pageFlowScope.pModulo}");        for (model.utilidades.estructuras.Menu row : listaMenuBase) {            if (row.getIndiceModulo().equalsIgnoreCase(moduloActual)) {                MenuLink temporal =                    new MenuLink(row.getIdMenusPermisos(), row.getOrden(), row.getNick(), row.getIndiceModulo(),                                 row.getNombreModulo(), row.getContexto(), row.getIdMenu(), row.getTipo(),                                 row.getIndiceMenu(), row.getNombreMenu(), row.getTaskFlow(),                                 row.getTaskFlowInformacion(), row.getCrear(), row.getActualizar(), row.getBorrar(),                                 row.getVerAuditoria());                //temporal.setSeleccionado(false);                //temporal.setIndice(indice);                //temporal.setIndice(row.getOrden());                listaMenu.add(temporal);                //indice++;            }        }        listaMenu.sort(Comparator.comparing(MenuLink::getOrden));        if (listaMenu.size() > 0) {            for (int i = 0;i < listaMenu.size(); i++) {                listaMenu.get(i).setIndice(i);                listaMenu.get(i).setSeleccionado(false);            }                        tituloModulo = listaMenu.get(0).getNombreModulo();            listaMenu.get(0).setSeleccionado(true);            JSFUtils.setExpressionValue("#{MenuBean.menuActual}", getListaMenu().get(0));            JSFUtils.setExpressionValue("#{sessionScope.idSeleccionado}", 0);            setMenuActual(listaMenu.get(0));        }    }    /**     * Metodo para conocer los demas modulos del sistema.     *     */    private void buscarInformacionModulo() {        listaModulo = new ArrayList<MenuLink>();        @SuppressWarnings("unchecked")        List<Menu> listaMenuExclusion = (List<Menu>) JSFUtils.resolveExpression("#{sessionScope.menu}");        String moduloActual = JSFUtils.resolveExpressionAsString("#{pageFlowScope.pModulo}");        Map<String, MenuLink> mapaModulos = new HashMap<String, MenuLink>();        for (model.utilidades.estructuras.Menu row : listaMenuExclusion) {            if (!row.getIndiceModulo().equalsIgnoreCase(moduloActual)) {                MenuLink temporal =                    new MenuLink(row.getIdMenusPermisos(), row.getOrden(), row.getNick(), row.getIndiceModulo(),                                 row.getNombreModulo(), row.getContexto(), row.getIdMenu(), row.getTipo(),                                 row.getIndiceMenu(), row.getNombreMenu(), row.getTaskFlow(),                                 row.getTaskFlowInformacion(), row.getCrear(), row.getActualizar(), row.getBorrar(),                                 row.getVerAuditoria());                mapaModulos.put(row.getNombreModulo(), temporal);            }        }        for (Map.Entry<String, MenuLink> mapTempo : mapaModulos.entrySet()) {            listaModulo.add(mapTempo.getValue());        }    }    /**     *     * @return     */    public MenuLink getMenuActual() {        /*if (menuActual == null) {            MenuLink menuEstructura =                new MenuLink(-1, -1, "none", "BD_001_00", "empty", "/empty", 0, "P", "0", "menu",                             "/WEB-INF/vacio-task-flow.xml#vacio-task-flow", "info", false, false, false, false);            return menuEstructura;        }*/        /*if (menuActual == null) {            MenuEstructuraBean menuEstructura = new MenuEstructuraBean();            menuActual = menuEstructura.new MenuLink();        }*/        return menuActual;    }    /**     *     * @param menu     */    public void setMenuActual(MenuLink menu) {        this.menuActual = menu;    }    /**     * Metodo para listar menu     *     * @return     */    public List<MenuLink> getListaMenu() {        if (listaMenu == null) {            buscarInformacionMenu();        }        return listaMenu;    }    public int getMenuSize() {        if (listaMenu == null) {            return 0;        }        return listaMenu.size();    }    public void setMenuSize(int size) {    }    public void setListaMenu(List<MenuLink> listaMenu) {        this.listaMenu = listaMenu;    }    public List<MenuLink> getListaModulo() {        if (listaModulo == null) {            buscarInformacionModulo();        }        return listaModulo;    }    public int getModuloSize() {        if (listaModulo == null) {            return 0;        }        return listaModulo.size();    }    public void setModuloSize(int size) {    }    public void setListaModulo(List<MenuLink> listaModulo) {        this.listaModulo = listaModulo;    }    public String getTituloModulo() {        return tituloModulo;    }    public void setTituloModulo(String tituloModulo) {        this.tituloModulo = tituloModulo;    }    public void setUrlModulo(String urlModulo) {        this.urlModulo = urlModulo;    }    public String getUrlModulo() {        return this.urlModulo;    }    /**     * Clase para la informacion de la estructura.     *     * @see "https://docs.oracle.com/cd/E28280_01/web.1111/b31974/taskflows_regions.htm#ADFFD22580"     * @see "apartado 17.4.2 What Happens When You Create a Parameter Map to Specify Input Parameters"     *     * @author omargo33@hotmail.com     */    public class MenuLink extends model.utilidades.estructuras.Menu {        /**         * el campo puede ser 0 o 1. presente en maestro-base-template.xml         *         */        public static final String PARAMETRO_PACCION = "pAccion";        public static final String PARAMETRO_PERMISO_CREAR = "pPermisoCrear";        public static final String PARAMETRO_PERMISO_ACTUALIZAR = "pPermisoActualizar";        public static final String PARAMETRO_PERMISO_BORRAR = "pPermisoBorrar";        public static final String PARAMETRO_PERMISO_VER_AUDITORIA = "pPermisoVerAuditoria";        private boolean seleccionado = false;        private int indice;        private Map<String, Object> mapaParametros;        /**         * Metodo para crear sobrecargado.         *         * @param i         * @param i1         * @param string         * @param string1         * @param string2         * @param string3         * @param i2         * @param string4         * @param string5         * @param string6         * @param string7         * @param b1         * @param b2         * @param b3         * @param b4         */        public MenuLink(int i, int i1, String string, String string1, String string2, String string3, int i2,                        String string4, String string5, String string6, String string7, String string8, boolean b1,                        boolean b2, boolean b3, boolean b4) {            super(i, i1, string, string1, string2, string3, i2, string4, string5, string6, string7, string8, b1, b2, b3,                  b4);            getMapaParametros().put(PARAMETRO_PACCION, "0");            getMapaParametros().put(PARAMETRO_PERMISO_CREAR, b1);            getMapaParametros().put(PARAMETRO_PERMISO_ACTUALIZAR, b2);            getMapaParametros().put(PARAMETRO_PERMISO_BORRAR, b3);            getMapaParametros().put(PARAMETRO_PERMISO_VER_AUDITORIA, b4);        }        /**         * Metodo para ejecutar un nuevo modulo.         *         */        public String ejecutarModulo() {            String token = String.valueOf(getSession().getAttribute("token"));            //TODO            //[13a-ov] pasa a arquitectura rigida probar por payara.            //setUrlModulo(getUrlBase() + "/" + getContexto() + "?token=" + token);            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "correcion payara salida 001");            setUrlModulo(getContexto() + token);            return "irModulo";        }        /**         * Ejecutar el menu.         *         * @return         */        public String ejecutarMenu() {            int indiceSeleccionado = 0;            for (int i = 0; i < getListaMenu().size(); i++) {                getListaMenu().get(i).setSeleccionado(false);            }            setSeleccionado(true);            indiceSeleccionado = getIndice();            JSFUtils.setExpressionValue("#{MenuBean.menuActual}", getListaMenu().get(indiceSeleccionado));            JSFUtils.setExpressionValue("#{sessionScope.idSeleccionado}", indiceSeleccionado);            return "reload";        }        public boolean isSeleccionado() {            return seleccionado;        }        public void setSeleccionado(boolean seleccionado) {            this.seleccionado = seleccionado;        }        public int getIndice() {            return indice;        }        public void setIndice(int indice) {            this.indice = indice;        }        public TaskFlowId getDynamicTaskFlowId() {            String taskFlowIdString = getTaskFlow();            taskFlowIdString =                (taskFlowIdString == null) ? "/WEB-INF/vacio-task-flow.xml#vacio-task-flow" : taskFlowIdString;            return TaskFlowId.parse(taskFlowIdString);        }        public void setDynamicTaskFlowId(String taskFlowId) {            setTaskFlow(taskFlowId);        }        public TaskFlowId getDynamicTaskFlowInformacionId() {            return TaskFlowId.parse(getTaskFlow());        }        public void setDynamicTaskFlowInformacionId(String taskFlowIdInformacion) {            setTaskFlowInformacion(taskFlowIdInformacion);        }        public Map<String, Object> getMapaParametros() {            if (mapaParametros == null) {                mapaParametros = new HashMap<String, Object>();            }            return mapaParametros;        }        public void setMapaParametros(Map<String, Object> mapaParametros) {            this.mapaParametros = mapaParametros;        }        @Override        public String toString() {            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "toString solicitado" + getTaskFlow());            return getTaskFlow();        }    }}