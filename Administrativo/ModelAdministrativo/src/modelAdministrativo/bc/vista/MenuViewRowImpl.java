package WEB-INF.classes.modelAdministrativo.bc.vista;

import java.sql.Timestamp;
import modelAdministrativo.bc.entidad.MenuImpl;
import modelAdministrativo.bc.vista.MenuViewRowImpl;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;















































public class MenuViewRowImpl
  extends ViewRowImpl
{
  public static final int ENTITY_MENU = 0;
    public static final int IDMENU = AttributesEnum.IdMenu.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int TASKFLOW = AttributesEnum.TaskFlow.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int ORDEN = AttributesEnum.Orden.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int PERMISOVIEW = AttributesEnum.PermisoView.index();
    public static final int CODIGODEFINIDOUSUARIOVIEWLOV1 = AttributesEnum.CodigoDefinidoUsuarioViewLOV1.index();
    public static final int CODIGODEFINIDOUSUARIOVIEWLOV2 = AttributesEnum.CodigoDefinidoUsuarioViewLOV2.index();
    public static final int MODULOVIEW1 = AttributesEnum.ModuloView1.index();











  
    public MenuImpl getMenu() { return (MenuImpl)getEntity(0); }






  
    public Integer getIdMenu() { return (Integer)getAttributeInternal(IDMENU); }






  
    public void setIdMenu(Integer value) { setAttributeInternal(IDMENU, value); }






  
    public Integer getIdModulo() { return (Integer)getAttributeInternal(IDMODULO); }






  
    public void setIdModulo(Integer value) { setAttributeInternal(IDMODULO, value); }






  
    public String getTipo() { return (String)getAttributeInternal(TIPO); }






  
    public void setTipo(String value) { setAttributeInternal(TIPO, value); }






  
    public String getIndice() { return (String)getAttributeInternal(INDICE); }






  
    public void setIndice(String value) { setAttributeInternal(INDICE, value); }






  
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }






  
    public void setNombre(String value) { setAttributeInternal(NOMBRE, value); }






  
    public String getTaskFlow() { return (String)getAttributeInternal(TASKFLOW); }






  
    public void setTaskFlow(String value) { setAttributeInternal(TASKFLOW, value); }






  
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }






  
    public void setEstado(String value) { setAttributeInternal(ESTADO, value); }






  
    public Integer getOrden() { return (Integer)getAttributeInternal(ORDEN); }






  
    public void setOrden(Integer value) { setAttributeInternal(ORDEN, value); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public void setUsuario(String value) { setAttributeInternal(USUARIO, value); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public void setUsuarioFecha(Timestamp value) { setAttributeInternal(USUARIOFECHA, value); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }






  
    public void setUsuarioPrograma(String value) { setAttributeInternal(USUARIOPROGRAMA, value); }





  
    public RowIterator getPermisoView() { return (RowIterator)getAttributeInternal(PERMISOVIEW); }





  
    public RowSet getCodigoDefinidoUsuarioViewLOV1() { return (RowSet)getAttributeInternal(CODIGODEFINIDOUSUARIOVIEWLOV1); }





  
    public RowSet getCodigoDefinidoUsuarioViewLOV2() { return (RowSet)getAttributeInternal(CODIGODEFINIDOUSUARIOVIEWLOV2); }





  
    public RowSet getModuloView1() { return (RowSet)getAttributeInternal(MODULOVIEW1); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/MenuViewRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */