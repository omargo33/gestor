package model.bc.entidad;

import model.bc.Entidad;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;














public class GrupoImpl
  extends Entidad
{
  protected enum AttributesEnum
  {
      IdGrupo,
      Id,
      Esquema,
      Tabla,
      LargoMaximo,
      Extensiones,
      Ancho,
      Alto,
      MaximoArchivo,
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

  
    public static final int IDGRUPO = AttributesEnum.IdGrupo.index();
    public static final int ID = AttributesEnum.Id.index();
    public static final int ESQUEMA = AttributesEnum.Esquema.index();
    public static final int TABLA = AttributesEnum.Tabla.index();
    public static final int LARGOMAXIMO = AttributesEnum.LargoMaximo.index();
    public static final int EXTENSIONES = AttributesEnum.Extensiones.index();
    public static final int ANCHO = AttributesEnum.Ancho.index();
    public static final int ALTO = AttributesEnum.Alto.index();
    public static final int MAXIMOARCHIVO = AttributesEnum.MaximoArchivo.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ARCHIVO = AttributesEnum.Archivo.index();













  
    public static Key createPrimaryKey(Integer idGrupo) { return new Key(new Object[] { idGrupo }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("model.bc.entidad.Grupo"); }






  
    public void lock() { super.lock(); }







  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { ARCHIVO });
    }
      super.doDML(operation, e);
      if (operation == 1)
        setAttribute(IDGRUPO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/entidad/GrupoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */