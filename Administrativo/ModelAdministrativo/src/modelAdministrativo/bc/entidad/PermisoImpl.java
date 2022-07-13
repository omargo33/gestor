package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.PermisoImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;












































public class PermisoImpl
  extends Entidad
{
    public static final int IDPERMISO = AttributesEnum.IdPermiso.index();
    public static final int IDMENU = AttributesEnum.IdMenu.index();
    public static final int IDROL = AttributesEnum.IdRol.index();
    public static final int CREAR = AttributesEnum.Crear.index();
    public static final int ACTUALIZAR = AttributesEnum.Actualizar.index();
    public static final int BORRAR = AttributesEnum.Borrar.index();
    public static final int VERAUDITORIA = AttributesEnum.VerAuditoria.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int MENU = AttributesEnum.Menu.index();
    public static final int ROL = AttributesEnum.Rol.index();













  
    public static Key createPrimaryKey(Integer idPermiso) { return new Key(new Object[] { idPermiso }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Permiso"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);

    
      if (operation == 1)
        setAttribute(IDPERMISO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/PermisoImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */