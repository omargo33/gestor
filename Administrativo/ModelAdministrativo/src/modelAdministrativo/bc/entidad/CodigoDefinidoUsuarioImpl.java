package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.CodigoDefinidoUsuarioImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;
















































public class CodigoDefinidoUsuarioImpl
  extends Entidad
{
    public static final int IDCODIGODEFINIDOUSUARIO = AttributesEnum.IdCodigoDefinidoUsuario.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int GRUPO = AttributesEnum.Grupo.index();
    public static final int CODIGOTEXTO = AttributesEnum.CodigoTexto.index();
    public static final int CODIGONUMERO = AttributesEnum.CodigoNumero.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int ORDEN = AttributesEnum.Orden.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int MODULO = AttributesEnum.Modulo.index();
    public static final int CODIGOTEXTOCODIGODEFINIDOUSUARIO = AttributesEnum.CodigoTextoCodigoDefinidoUsuario.index();
    public static final int GRUPOCODIGODEFINIDOUSUARIO = AttributesEnum.GrupoCodigoDefinidoUsuario.index();













  
    public static Key createPrimaryKey(Integer idCodigoDefinidoUsuario) { return new Key(new Object[] { idCodigoDefinidoUsuario }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.CodigoDefinidoUsuario"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { CODIGOTEXTOCODIGODEFINIDOUSUARIO });
    }
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDCODIGODEFINIDOUSUARIO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/CodigoDefinidoUsuarioImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */