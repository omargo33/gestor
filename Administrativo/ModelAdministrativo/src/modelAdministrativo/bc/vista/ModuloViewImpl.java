  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelAdministrativo.bc.vista.ModuloViewImpl;
  import modelAdministrativo.bc.vista.common.ModuloView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class ModuloViewImpl
    extends VistaObjeto
    implements ModuloView
  {
    public void ejecutarIdEntidad(Integer id) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("ModuloViewCriteriaRecargarDetalle");
      
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idModulo", id);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/ModuloViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */