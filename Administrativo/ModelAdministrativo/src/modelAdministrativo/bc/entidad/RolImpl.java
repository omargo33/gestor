package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.RolImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;









































public class RolImpl
  extends Entidad
{
    public static final int IDROL = AttributesEnum.IdRol.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ROLUSUARIO = AttributesEnum.RolUsuario.index();
    public static final int PERMISO = AttributesEnum.Permiso.index();













  
    public static Key createPrimaryKey(Integer idRol) { return new Key(new Object[] { idRol }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Rol"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { ROLUSUARIO, PERMISO });
    }
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDROL, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/RolImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */