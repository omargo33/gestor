  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import model.bc.VistaObjeto;
  import modelAdministrativo.bc.AdministrativoModuloImpl;
  import modelAdministrativo.bc.modulo.CodigoDefinidoUsuario;
  import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioEncabezadoViewImpl;
  import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioEncabezadoViewRowImpl;
  import modelAdministrativo.bc.vista.common.CodigoDefinidoUsuarioEncabezadoView;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class CodigoDefinidoUsuarioEncabezadoViewImpl
    extends VistaObjeto
    implements CodigoDefinidoUsuarioEncabezadoView
  {
    public void ejecutarIdEntidad(Integer id) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("CodigoDefinidoUsuarioEncabezadoViewCriteriaRecargarDetalle");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idCodigoDefinidoUsuario", id);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
    
    public void cduArriba() {
      CodigoDefinidoUsuario.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioEncabezadoViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), true);
      executeQuery();
    }
  
  
  
  
    
    public void cduAbajo() {
      CodigoDefinidoUsuario.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioEncabezadoViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), false);
      executeQuery();
    }
  
  
  
  
    
    public void cduPrimero() {
      CodigoDefinidoUsuario.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioEncabezadoViewRowImpl)
          getCurrentRow()).getIdCodigoDefinidoUsuario().intValue(), -1);
      
      executeQuery();
    }
  
  
  
  
    
    public void cduUltimo() {
      CodigoDefinidoUsuario.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioEncabezadoViewRowImpl)
          getCurrentRow()).getIdCodigoDefinidoUsuario().intValue(), 1000);
      
      executeQuery();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/CodigoDefinidoUsuarioEncabezadoViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */