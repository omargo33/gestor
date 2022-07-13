package model.bc.vistaNoDML;

import java.sql.Timestamp;
import oracle.jbo.server.ViewRowImpl;







public class ErrorViewNoDMLRowImpl
  extends ViewRowImpl
{
  protected enum AttributesEnum
  {
      IdError,
      Indice,
      Mensaje,
      Descripcion,
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
    public static final int IDERROR = AttributesEnum.IdError.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int MENSAJE = AttributesEnum.Mensaje.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();











  
    public Integer getIdError() { return (Integer)getAttributeInternal(IDERROR); }






  
    public String getIndice() { return (String)getAttributeInternal(INDICE); }






  
    public String getMensaje() { return (String)getAttributeInternal(MENSAJE); }






  
    public String getDescripcion() { return (String)getAttributeInternal(DESCRIPCION); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/ErrorViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */