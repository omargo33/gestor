  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelAdministrativo.bc.vista.RolViewImpl;
  import modelAdministrativo.bc.vista.common.RolView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class RolViewImpl
    extends VistaObjeto
    implements RolView
  {
    public void ejecutarIdEntidad(Integer id) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("RolViewCriteriaRecargarDetalle");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idRol", id);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/RolViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */