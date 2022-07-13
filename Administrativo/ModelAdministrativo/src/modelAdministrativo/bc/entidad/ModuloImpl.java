package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.ModuloImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;












































public class ModuloImpl
  extends Entidad
{
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int CONTEXTO = AttributesEnum.Contexto.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int PARAMETRO = AttributesEnum.Parametro.index();
    public static final int CODIGODEFINIDOUSUARIO = AttributesEnum.CodigoDefinidoUsuario.index();
    public static final int MENU = AttributesEnum.Menu.index();













  
    public static Key createPrimaryKey(Integer idModulo) { return new Key(new Object[] { idModulo }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Modulo"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { PARAMETRO, CODIGODEFINIDOUSUARIO, MENU });
    }
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDMODULO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/ModuloImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */