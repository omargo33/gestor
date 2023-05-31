package model.bc.vistaNoDML;

import java.math.BigDecimal;
import java.sql.Timestamp;
import oracle.jbo.server.ViewRowImpl;








public class ParametroViewNoDMLRowImpl
  extends ViewRowImpl
{
  protected enum AttributesEnum
  {
      IdParametro,
      IdModulo,
      Indice,
      Clave,
      Nombre,
      Descripcion,
      ValorTexto01,
      ValorTexto02,
      ValorNumero01,
      ValorNumero02,
      DefaultTexto01,
      DefaultTexto02,
      DefaultNumero01,
      DefaultNumero02,
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
    public static final int IDPARAMETRO = AttributesEnum.IdParametro.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int CLAVE = AttributesEnum.Clave.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int VALORTEXTO01 = AttributesEnum.ValorTexto01.index();
    public static final int VALORTEXTO02 = AttributesEnum.ValorTexto02.index();
    public static final int VALORNUMERO01 = AttributesEnum.ValorNumero01.index();
    public static final int VALORNUMERO02 = AttributesEnum.ValorNumero02.index();
    public static final int DEFAULTTEXTO01 = AttributesEnum.DefaultTexto01.index();
    public static final int DEFAULTTEXTO02 = AttributesEnum.DefaultTexto02.index();
    public static final int DEFAULTNUMERO01 = AttributesEnum.DefaultNumero01.index();
    public static final int DEFAULTNUMERO02 = AttributesEnum.DefaultNumero02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();











  
    public Integer getIdParametro() { return (Integer)getAttributeInternal(IDPARAMETRO); }






  
    public Integer getIdModulo() { return (Integer)getAttributeInternal(IDMODULO); }






  
    public String getIndice() { return (String)getAttributeInternal(INDICE); }






  
    public String getClave() { return (String)getAttributeInternal(CLAVE); }






  
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }






  
    public String getDescripcion() { return (String)getAttributeInternal(DESCRIPCION); }






  
    public String getValorTexto01() { return (String)getAttributeInternal(VALORTEXTO01); }






  
    public String getValorTexto02() { return (String)getAttributeInternal(VALORTEXTO02); }






  
    public BigDecimal getValorNumero01() { return (BigDecimal)getAttributeInternal(VALORNUMERO01); }






  
    public BigDecimal getValorNumero02() { return (BigDecimal)getAttributeInternal(VALORNUMERO02); }






  
    public String getDefaultTexto01() { return (String)getAttributeInternal(DEFAULTTEXTO01); }






  
    public String getDefaultTexto02() { return (String)getAttributeInternal(DEFAULTTEXTO02); }






  
    public BigDecimal getDefaultNumero01() { return (BigDecimal)getAttributeInternal(DEFAULTNUMERO01); }






  
    public BigDecimal getDefaultNumero02() { return (BigDecimal)getAttributeInternal(DEFAULTNUMERO02); }






  
    public String getUsuario() { return (String)getAttributeInternal(USUARIO); }






  
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }






  
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/ParametroViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */