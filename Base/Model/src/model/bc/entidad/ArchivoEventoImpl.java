package model.bc.entidad;

import model.bc.Entidad;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;








public class ArchivoEventoImpl
  extends Entidad
{
  protected enum AttributesEnum
  {
      IdArchivoEvento,
      IdArchivo,
      Informacion,
      Tipo,
      Usuario,
      UsuarioFecha,
      UsuarioPrograma,
      Archivo; static  {
        vals = null;
    }
    private static AttributesEnum[] vals;
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

  
    public static final int IDARCHIVOEVENTO = AttributesEnum.IdArchivoEvento.index();
    public static final int IDARCHIVO = AttributesEnum.IdArchivo.index();
    public static final int INFORMACION = AttributesEnum.Informacion.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ARCHIVO = AttributesEnum.Archivo.index();













  
    public static Key createPrimaryKey(Integer idArchivoEvento) { return new Key(new Object[] { idArchivoEvento }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("model.bc.entidad.ArchivoEvento"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDARCHIVOEVENTO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/entidad/ArchivoEventoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */