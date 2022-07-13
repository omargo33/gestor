package model.bc.vistaNoDML;

import java.sql.Timestamp;
import oracle.jbo.server.ViewRowImpl;







public class CodigoDefinidoUsuarioViewNoDMLRowImpl
  extends ViewRowImpl
{
  protected enum AttributesEnum
  {
      IdCodigoDefinidoUsuario,
      IdModulo,
      Grupo,
      CodigoTexto,
      CodigoNumero,
      Nombre,
      Descripcion,
      Orden,
      Estado,
      Usuario,
      UsuarioFecha,
      UsuarioPrograma; private static AttributesEnum[] vals; static  {
        vals = null;
    }
    private static final int firstIndex = 0;
    
      protected int index() { return firstIndex() + ordinal(); }


    
      protected static final int firstIndex() { return 0; }


    
      protected static int count() { return firstIndex() + (staticValues()).length; }

    
    protected static final AttributesEnum[] staticValues() {
        if (vals == null) {
          vals = values();
      }
        return vals;
    }
  }
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











  
    public Integer getIdCodigoDefinidoUsuario() { return (Integer)getAttributeInternal(IDCODIGODEFINIDOUSUARIO); }






  
    public Integer getIdModulo() { return (Integer)getAttributeInternal(IDMODULO); }






  
    public String getGrupo() { return (String)getAttributeInternal(GRUPO); }






  
    public String getCodigoTexto() { return (String)getAttributeInternal(CODIGOTEXTO); }






  
    public Integer getCodigoNumero() { return (Integer)getAttributeInternal(CODIGONUMERO); }






  
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }






  
    public String getDescripcion() { return (String)getAttributeInternal(DESCRIPCION); }






  
    public Integer getOrden() { return (Integer)getAttributeInternal(ORDEN); }






  
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/CodigoDefinidoUsuarioViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */