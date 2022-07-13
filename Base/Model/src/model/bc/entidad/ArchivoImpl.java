package model.bc.entidad;

import model.bc.Entidad;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;











public class ArchivoImpl
  extends Entidad
{
  public void remove() {
      setAttribute(ESTADO, "X");
    
      super.remove();
  }



  
  protected enum AttributesEnum
  {
      IdArchivo,
      IdGrupo,
      NombreRamdon,
      Nombre,
      Extension,
      Largo,
      PathRelativo,
      Estado,
      Usuario,
      UsuarioFecha,
      UsuarioPrograma,
      Grupo,
      ArchivoEvento; static  {
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

  
    public static final int IDARCHIVO = AttributesEnum.IdArchivo.index();
    public static final int IDGRUPO = AttributesEnum.IdGrupo.index();
    public static final int NOMBRERAMDON = AttributesEnum.NombreRamdon.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int EXTENSION = AttributesEnum.Extension.index();
    public static final int LARGO = AttributesEnum.Largo.index();
    public static final int PATHRELATIVO = AttributesEnum.PathRelativo.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int GRUPO = AttributesEnum.Grupo.index();
    public static final int ARCHIVOEVENTO = AttributesEnum.ArchivoEvento.index();













  
    public static Key createPrimaryKey(Integer idArchivo) { return new Key(new Object[] { idArchivo }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("model.bc.entidad.Archivo"); }






  
    public void lock() { super.lock(); }







  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        operation = 2;
    }
    
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDARCHIVO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/entidad/ArchivoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */