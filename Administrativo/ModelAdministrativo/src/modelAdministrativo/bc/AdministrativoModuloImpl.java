package WEB;

import modelAuditoria.bc.AuditoriaModuloImpl;

import model.bc.VistaObjeto;
import modelAdministrativo.bc.AdministrativoModuloImpl;
import modelAdministrativo.bc.common.AdministrativoModulo;
import modelAdministrativo.bc.modulo.Token;
import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioDetalleViewImpl;
import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioEncabezadoViewImpl;
import modelAdministrativo.bc.vista.MenuViewImpl;
import modelAuditoria.bc.AuditoriaModuloImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;



















public class AdministrativoModuloImpl
  extends AuditoriaModuloImpl
  implements AdministrativoModulo
{
    public AdministrativoModuloImpl() { setNombreBundle("modelAdministrativo.ModelAdministrativoBundle"); }














  
  public void cambiarClaveCompleto(String socialNick, String passwordOld, String passwordNew, String passwordConfirmar, String ip, String userAgent, String usuarioPrograma) {
      String expresionRegular = base_obtenerParametroTexto01("001");
      String mensajeExpresionRegular = base_obtenerParametroTexto02("001");
    
      Token.cambiarTokenCompleto(this, socialNick, passwordOld, passwordNew, passwordConfirmar, expresionRegular, mensajeExpresionRegular, ip, userAgent, usuarioPrograma);
  }






  
    public void administrativo_crearToken(int idToken) { Token.crearToken(this, idToken); }





  
    public ViewObjectImpl getUsuarioView1() { return (ViewObjectImpl)findViewObject("UsuarioView1"); }






  
    public ViewObjectImpl getRolView1() { return (ViewObjectImpl)findViewObject("RolView1"); }






  
    public CodigoDefinidoUsuarioEncabezadoViewImpl getCodigoDefinidoUsuarioView1() { return (CodigoDefinidoUsuarioEncabezadoViewImpl)findViewObject("CodigoDefinidoUsuarioView1"); }






  
    public ViewObjectImpl getModuloView1() { return (ViewObjectImpl)findViewObject("ModuloView1"); }






  
    public CodigoDefinidoUsuarioEncabezadoViewImpl getCodigoDefinidoUsuarioEncabezadoView1() { return (CodigoDefinidoUsuarioEncabezadoViewImpl)findViewObject("CodigoDefinidoUsuarioEncabezadoView1"); }






  
    public CodigoDefinidoUsuarioDetalleViewImpl getCodigoDefinidoUsuarioDetalleView2() { return (CodigoDefinidoUsuarioDetalleViewImpl)findViewObject("CodigoDefinidoUsuarioDetalleView2"); }






  
    public ViewLinkImpl getCodigoDefinidoUsuarioFkLink1() { return (ViewLinkImpl)findViewLink("CodigoDefinidoUsuarioFkLink1"); }






  
    public ViewObjectImpl getRolUsuarioView1() { return (ViewObjectImpl)findViewObject("RolUsuarioView1"); }






  
    public ViewLinkImpl getUsuarioRolFkLink1() { return (ViewLinkImpl)findViewLink("UsuarioRolFkLink1"); }







  
    public ViewLinkImpl getRolModuloFkLink1() { return (ViewLinkImpl)findViewLink("RolModuloFkLink1"); }






  
    public ViewLinkImpl getModuloRolFkLink1() { return (ViewLinkImpl)findViewLink("ModuloRolFkLink1"); }






  
    public ViewObjectImpl getParametroView1() { return (ViewObjectImpl)findViewObject("ParametroView1"); }






  
    public ViewLinkImpl getModuloParametroFkLink1() { return (ViewLinkImpl)findViewLink("ModuloParametroFkLink1"); }






  
    public ViewObjectImpl getInformacionView1() { return (ViewObjectImpl)findViewObject("InformacionView1"); }






  
    public ViewObjectImpl getErrorView1() { return (ViewObjectImpl)findViewObject("ErrorView1"); }






  
    public ViewObjectImpl getTokenView1() { return (ViewObjectImpl)findViewObject("TokenView1"); }






  
    public ViewLinkImpl getUsuarioTokenFkLink1() { return (ViewLinkImpl)findViewLink("UsuarioTokenFkLink1"); }






  
    public ViewObjectImpl getTokenView2() { return (ViewObjectImpl)findViewObject("TokenView2"); }






  
    public ViewObjectImpl getAccesosRedesNoDML1() { return (ViewObjectImpl)findViewObject("AccesosRedesNoDML1"); }






  
    public ViewObjectImpl getUsuariosSinCorreoNoDML1() { return (ViewObjectImpl)findViewObject("UsuariosSinCorreoNoDML1"); }






  
    public MenuViewImpl getMenuView1() { return (MenuViewImpl)findViewObject("MenuView1"); }






  
    public ViewObjectImpl getPermisoView1() { return (ViewObjectImpl)findViewObject("PermisoView1"); }






  
    public ViewLinkImpl getMenuPermisoFkLink1() { return (ViewLinkImpl)findViewLink("MenuPermisoFkLink1"); }






  
    public VistaObjeto getModuloUsuarioViewNoDML1() { return (VistaObjeto)findViewObject("ModuloUsuarioViewNoDML1"); }






  
    public ViewLinkImpl getModuloUsuarioViewLink1() { return (ViewLinkImpl)findViewLink("ModuloUsuarioViewLink1"); }






  
    public VistaObjeto getTokenView3() { return (VistaObjeto)findViewObject("TokenView3"); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/AdministrativoModuloImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */