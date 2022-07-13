  package view.archivo;
  
  import javax.faces.component.UIComponent;
  import oracle.adf.view.rich.component.rich.RichPopup;
  import oracle.adf.view.rich.component.rich.data.RichTable;
  import oracle.adf.view.rich.component.rich.output.RichInlineFrame;
  import view.plantilla.BasePPR;
  import view.utilidades.ADFUtils;
  
  
  
  
  
  
  
  public class PPRListaFrg
    extends BasePPR
  {
    private static final long serialVersionUID = 1L;
    private RichInlineFrame if1;
    private RichPopup p1Arch;
    private RichTable t1;
    
    public PPRListaFrg() {
      init();
      iniciarDatosFormularios();
    }
  
    
    private void init() { setIf1(new RichInlineFrame()); }
  
  
  
  
  
    
    private void iniciarDatosFormularios() {
      String url = "/faces/upLoadFile.jspx?nameUser=%s&idGrupo=%s&aTabla=%s&aEsquema=%s&aExtensiones=%s";
      String nameUser = String.valueOf(ADFUtils.evaluateEL("#{BaseBean.nameUser}"));
      String idGrupo = String.valueOf(ADFUtils.evaluateEL("#{sessionScope.idGrupo}"));
      String atabla = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aTabla}"));
      String aEsquema = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aEsquema}"));
      String aExtensiones = String.valueOf(ADFUtils.evaluateEL("#{pageFlowScope.aExtensiones}"));
      getIf1().setSource(String.format(url, new Object[] { nameUser, idGrupo, atabla, aEsquema, aExtensiones }));
    }
  
    
    public void setIf1(RichInlineFrame if1) { this.if1 = if1; }
  
  
    
    public RichInlineFrame getIf1() { return this.if1; }
  
    
    public String refrescar() {
      getP1Arch().hide();
      doPartialRefresh((UIComponent)getP1Arch());
      doPartialRefresh((UIComponent)getT1());
      return "Inicio";
    }
  
    
    public void setP1Arch(RichPopup p1) { this.p1Arch = p1; }
  
  
    
    public RichPopup getP1Arch() { return this.p1Arch; }
  
  
    
    public void setT1(RichTable t1) { this.t1 = t1; }
  
  
    
    public RichTable getT1() { return this.t1; }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseViewADFLib-01.jar!/view/archivo/PPRListaFrg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */