  package WEB-INF.classes.modelAdministrativo.bc.vista;
  
  import modelAdministrativo.bc.AdministrativoModuloImpl;
  import modelAdministrativo.bc.modulo.CodigoDefinidoUsuario;
  import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioDetalleViewImpl;
  import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioDetalleViewRowImpl;
  import modelAdministrativo.bc.vista.common.CodigoDefinidoUsuarioDetalleView;
  import oracle.jbo.server.ViewObjectImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class CodigoDefinidoUsuarioDetalleViewImpl
    extends ViewObjectImpl
    implements CodigoDefinidoUsuarioDetalleView
  {
    public void cduArriba() {
      CodigoDefinidoUsuario.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioDetalleViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), true);
      executeQuery();
    }
  
  
  
  
    
    public void cduAbajo() {
      CodigoDefinidoUsuario.unMovimiento((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioDetalleViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), false);
      executeQuery();
    }
  
  
  
  
    
    public void cduPrimero() {
      CodigoDefinidoUsuario.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioDetalleViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), -1);
      executeQuery();
    }
  
  
  
  
    
    public void cduUltimo() {
      CodigoDefinidoUsuario.ejecutarExtremos((AdministrativoModuloImpl)getApplicationModule(), ((CodigoDefinidoUsuarioDetalleViewRowImpl)
          getCurrentRow())
          .getIdCodigoDefinidoUsuario().intValue(), 1000);
      executeQuery();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/CodigoDefinidoUsuarioDetalleViewImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */