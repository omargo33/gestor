package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.RolUsuarioImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;










































public class RolUsuarioImpl
  extends Entidad
{
    public static final int IDROLUSUARIO = AttributesEnum.IdRolUsuario.index();
    public static final int IDROL = AttributesEnum.IdRol.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ROL2 = AttributesEnum.Rol2.index();
    public static final int USUARIO1 = AttributesEnum.Usuario1.index();













  
    public static Key createPrimaryKey(Integer idRolUsuario) { return new Key(new Object[] { idRolUsuario }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.RolUsuario"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);

    
      if (operation == 1)
        setAttribute(IDROLUSUARIO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/RolUsuarioImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */