package WEB-INF.classes.modelAdministrativo.bc.vista;

import java.sql.Timestamp;
import modelAdministrativo.bc.entidad.CodigoDefinidoUsuarioImpl;
import modelAdministrativo.bc.vista.CodigoDefinidoUsuarioEncabezadoViewRowImpl;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;















































public class CodigoDefinidoUsuarioEncabezadoViewRowImpl
  extends ViewRowImpl
{
  public static final int ENTITY_CODIGODEFINIDOUSUARIO = 0;
    public static final int IDCODIGODEFINIDOUSUARIO = AttributesEnum.IdCodigoDefinidoUsuario.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int GRUPO = AttributesEnum.Grupo.index();
    public static final int CODIGOTEXTO = AttributesEnum.CodigoTexto.index();
    public static final int CODIGONUMERO = AttributesEnum.CodigoNumero.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int ORDEN = AttributesEnum.Orden.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int CODIGODEFINIDOUSUARIODETALLEVIEW = AttributesEnum.CodigoDefinidoUsuarioDetalleView.index();
    public static final int CODIGODEFINIDOUSUARIOVIEWLOV1 = AttributesEnum.CodigoDefinidoUsuarioViewLOV1.index();
    public static final int MODULOVIEW1 = AttributesEnum.ModuloView1.index();











  
    public CodigoDefinidoUsuarioImpl getCodigoDefinidoUsuario() { return (CodigoDefinidoUsuarioImpl)getEntity(0); }






  
    public Integer getIdCodigoDefinidoUsuario() { return (Integer)getAttributeInternal(IDCODIGODEFINIDOUSUARIO); }






  
    public void setIdCodigoDefinidoUsuario(Integer value) { setAttributeInternal(IDCODIGODEFINIDOUSUARIO, value); }






  
    public Integer getIdModulo() { return (Integer)getAttributeInternal(IDMODULO); }






  
    public void setIdModulo(Integer value) { setAttributeInternal(IDMODULO, value); }






  
    public String getGrupo() { return (String)getAttributeInternal(GRUPO); }






  
    public void setGrupo(String value) { setAttributeInternal(GRUPO, value); }






  
    public String getCodigoTexto() { return (String)getAttributeInternal(CODIGOTEXTO); }






  
    public void setCodigoTexto(String value) { setAttributeInternal(CODIGOTEXTO, value); }






  
    public Integer getCodigoNumero() { return (Integer)getAttributeInternal(CODIGONUMERO); }






  
    public void setCodigoNumero(Integer value) { setAttributeInternal(CODIGONUMERO, value); }






  
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }






  
    public void setNombre(String value) { setAttributeInternal(NOMBRE, value); }






  
    public String getDescripcion() { return (String)getAttributeInternal(DESCRIPCION); }






  
    public void setDescripcion(String value) { setAttributeInternal(DESCRIPCION, value); }






  
    public Integer getOrden() { return (Integer)getAttributeInternal(ORDEN); }






  
    public void setOrden(Integer value) { setAttributeInternal(ORDEN, value); }






  
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }






  
    public void setEstado(String value) { setAttributeInternal(ESTADO, value); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public void setUsuario(String value) { setAttributeInternal(USUARIO, value); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public void setUsuarioFecha(Timestamp value) { setAttributeInternal(USUARIOFECHA, value); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }






  
    public void setUsuarioPrograma(String value) { setAttributeInternal(USUARIOPROGRAMA, value); }





  
    public RowIterator getCodigoDefinidoUsuarioDetalleView() { return (RowIterator)getAttributeInternal(CODIGODEFINIDOUSUARIODETALLEVIEW); }





  
    public RowSet getCodigoDefinidoUsuarioViewLOV1() { return (RowSet)getAttributeInternal(CODIGODEFINIDOUSUARIOVIEWLOV1); }





  
    public RowSet getModuloView1() { return (RowSet)getAttributeInternal(MODULOVIEW1); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/vista/CodigoDefinidoUsuarioEncabezadoViewRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */