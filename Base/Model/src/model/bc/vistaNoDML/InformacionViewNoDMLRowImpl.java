  package model.bc.vistaNoDML;
  
  import oracle.jbo.server.ViewRowImpl;
  
  
  
  
  
  
  public class InformacionViewNoDMLRowImpl
    extends ViewRowImpl
  {
    protected enum AttributesEnum
    {
      IdInformacion,
      Nombre,
      Valor01,
      Valor02,
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
    public static final int IDINFORMACION = AttributesEnum.IdInformacion.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int VALOR01 = AttributesEnum.Valor01.index();
    public static final int VALOR02 = AttributesEnum.Valor02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/InformacionViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */