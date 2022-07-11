package view.archivo;import oracle.adf.view.rich.component.rich.RichPopup;import oracle.adf.view.rich.component.rich.data.RichTable;import oracle.adf.view.rich.component.rich.output.RichInlineFrame;import view.plantilla.BasePPR;import view.utilidades.ADFUtils;/** * Objeto para dar soporte a la subida de archivos. * * @author omargo33@hotmail.com */public class PPRListaFrg extends BasePPR {    @SuppressWarnings("compatibility:6388304295982464060")    private static final long serialVersionUID = 1L;    private RichInlineFrame if1;    private RichPopup p1Arch;    private RichTable t1;    public PPRListaFrg() {        super();        init();        iniciarDatosFormularios();    }    private void init() {        setIf1(new RichInlineFrame());    }    /**     * Metodo para inicializar datos a partir de datos del Task Flow     *      */    private void iniciarDatosFormularios() {        String url = "/faces/upLoadFile.jspx?nameUser=%s&idGrupo=%s&aTabla=%s&aEsquema=%s&aExtensiones=%s";        String nameUser = String.valueOf(ADFUtils.evaluateEL("#{BaseBean.nameUser}"));        String idGrupo = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idGrupo}"));        String atabla = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aTabla}"));        String aEsquema = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aEsquema}"));        String aExtensiones = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aExtensiones}"));        getIf1().setSource(String.format(url, nameUser, idGrupo, atabla, aEsquema, aExtensiones));          }    public void setIf1(RichInlineFrame if1) {        this.if1 = if1;    }    public RichInlineFrame getIf1() {        return if1;    }    public String refrescar() {        getP1Arch().hide();        doPartialRefresh(getP1Arch());                doPartialRefresh(getT1());                return "Inicio";    }    public void setP1Arch(RichPopup p1) {        this.p1Arch = p1;    }    public RichPopup getP1Arch() {        return p1Arch;    }    public void setT1(RichTable t1) {        this.t1 = t1;    }    public RichTable getT1() {        return t1;    }}