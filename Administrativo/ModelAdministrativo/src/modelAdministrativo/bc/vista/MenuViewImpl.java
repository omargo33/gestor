  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelAdministrativo.bc.AdministrativoModuloImpl;
  import modelAdministrativo.bc.modulo.Menu;
  import modelAdministrativo.bc.vista.MenuViewImpl;
  import modelAdministrativo.bc.vista.MenuViewRowImpl;
  import modelAdministrativo.bc.vista.common.MenuView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class MenuViewImpl
    extends VistaObjeto
    implements MenuView
  {
    public void ejecutarIdEntidad(Integer id) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("MenuViewCriteriaRecargarDetalle");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idMenu", id);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
    
    public void cduArriba() {
      Menu.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((MenuViewRowImpl)
          getCurrentRow())
          .getIdMenu().intValue(), true);
      executeQuery();
    }
  
  
  
  
    
    public void cduAbajo() {
      Menu.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((MenuViewRowImpl)
          getCurrentRow())
          .getIdMenu().intValue(), false);
      executeQuery();
    }
  
  
  
  
    
    public void cduPrimero() {
      Menu.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((MenuViewRowImpl)
          getCurrentRow()).getIdMenu().intValue(), -1);
      
      executeQuery();
    }
  
  
  
  
    
    public void cduUltimo() {
      Menu.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((MenuViewRowImpl)
          getCurrentRow()).getIdMenu().intValue(), 1000);
      
      executeQuery();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/MenuViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */