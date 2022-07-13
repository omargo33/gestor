package model.bc.vistaNoDML;

import java.sql.Timestamp;
import oracle.jbo.RowIterator;
import oracle.jbo.server.ViewRowImpl;







public class ModuloViewNoDMLRowImpl
  extends ViewRowImpl
{
  protected enum AttributesEnum
  {
      IdModulo,
      Indice,
      Nombre,
      Contexto,
      Usuario,
      UsuarioFecha,
      UsuarioPrograma,
      Estado,
      ParametroView,
      CodigoDefinidoUsuarioView; private static AttributesEnum[] vals; static  {
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

  
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int CONTEXTO = AttributesEnum.Contexto.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int PARAMETROVIEW = AttributesEnum.ParametroView.index();
    public static final int CODIGODEFINIDOUSUARIOVIEW = AttributesEnum.CodigoDefinidoUsuarioView.index();











  
    public Integer getIdModulo() { return (Integer)getAttributeInternal(IDMODULO); }






  
    public String getIndice() { return (String)getAttributeInternal(INDICE); }






  
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }






  
    public String getContexto() { return (String)getAttributeInternal(CONTEXTO); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }






  
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }





  
    public RowIterator getParametroView() { return (RowIterator)getAttributeInternal(PARAMETROVIEW); }





  
    public RowIterator getCodigoDefinidoUsuarioView() { return (RowIterator)getAttributeInternal(CODIGODEFINIDOUSUARIOVIEW); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/ModuloViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */