package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.ErrorImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;













































public class ErrorImpl
  extends Entidad
{
    public static final int IDERROR = AttributesEnum.IdError.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int MENSAJE = AttributesEnum.Mensaje.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();













  
    public static Key createPrimaryKey(Integer idError) { return new Key(new Object[] { idError }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Error"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDERROR, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/ErrorImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */