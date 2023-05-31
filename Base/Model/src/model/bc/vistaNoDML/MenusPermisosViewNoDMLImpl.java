  package model.bc.vistaNoDML;
  
  import java.util.ArrayList;
  import java.util.List;
  import model.bc.VistaObjeto;
  import model.bc.vistaNoDML.common.MenusPermisosViewNoDML;
  import model.utilidades.estructuras.Menu;
  import oracle.adf.share.ADFContext;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class MenusPermisosViewNoDMLImpl
    extends VistaObjeto
    implements MenusPermisosViewNoDML
  {
    public void ejecutarMenusPermisos(String nick) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("MenusPermisosViewNoDMLCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      
      vvm.setVariableValue("v_nick", nick);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
      List<Menu> listaMenus = new ArrayList<>();
      while (hasNext()) {
        MenusPermisosViewNoDMLRowImpl row = (MenusPermisosViewNoDMLRowImpl)next();
  
  
  
  
        
        Menu menu = new Menu(row.getIdMenusPermisos().intValue(), row.getOrden().intValue(), row.getNick(), row.getIndiceModulo(), row.getNombreModulo(), row.getContexto(), row.getIdMenu().intValue(), row.getTipo(), row.getIndiceMenu(), row.getNombreMenu(), row.getTaskFlow(), row.getTaskFlowInformacion(), (row.getCrear().compareTo("1") == 0), (row.getActualizar().compareTo("1") == 0), (row.getBorrar().compareTo("1") == 0), (row.getVerAuditoria().compareTo("1") == 0));
        listaMenus.add(menu);
      } 
      ADFContext.getCurrent()
        .getSessionScope()
        .put("menu", listaMenus);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/MenusPermisosViewNoDMLImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */