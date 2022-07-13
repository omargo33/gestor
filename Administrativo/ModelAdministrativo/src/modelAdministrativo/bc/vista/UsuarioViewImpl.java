  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelAdministrativo.bc.vista.UsuarioViewImpl;
  import modelAdministrativo.bc.vista.common.UsuarioView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class UsuarioViewImpl
    extends VistaObjeto
    implements UsuarioView
  {
    public void ejecutarIdEntidad(Integer id) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("UsuarioViewCriteriaRecargarDetalle");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idUsuario", id);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/UsuarioViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */