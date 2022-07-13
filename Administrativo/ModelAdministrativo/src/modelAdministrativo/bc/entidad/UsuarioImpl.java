package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.UsuarioImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;














































public class UsuarioImpl
  extends Entidad
{
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDARCHIVO = AttributesEnum.IdArchivo.index();
    public static final int NICK = AttributesEnum.Nick.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int APELLIDO = AttributesEnum.Apellido.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int CONTADORINGRESO = AttributesEnum.ContadorIngreso.index();
    public static final int CONTADORFECHA = AttributesEnum.ContadorFecha.index();
    public static final int ROLUSUARIO = AttributesEnum.RolUsuario.index();
    public static final int TOKEN = AttributesEnum.Token.index();













  
    public static Key createPrimaryKey(Integer idUsuario) { return new Key(new Object[] { idUsuario }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Usuario"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 2) {
        setAttribute(VALIDADOR, String.valueOf(getAttribute(NICK).hashCode()));
    }
      if (operation == 3) {
        noBorrar(new int[] { ROLUSUARIO, TOKEN });
    }
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDUSUARIO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/UsuarioImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */