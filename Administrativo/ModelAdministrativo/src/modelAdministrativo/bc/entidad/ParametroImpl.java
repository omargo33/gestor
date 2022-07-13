package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.ParametroImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;


















































public class ParametroImpl
  extends Entidad
{
    public static final int IDPARAMETRO = AttributesEnum.IdParametro.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int CLAVE = AttributesEnum.Clave.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int VALORTEXTO01 = AttributesEnum.ValorTexto01.index();
    public static final int VALORTEXTO02 = AttributesEnum.ValorTexto02.index();
    public static final int VALORNUMERO01 = AttributesEnum.ValorNumero01.index();
    public static final int VALORNUMERO02 = AttributesEnum.ValorNumero02.index();
    public static final int DEFAULTTEXTO01 = AttributesEnum.DefaultTexto01.index();
    public static final int DEFAULTTEXTO02 = AttributesEnum.DefaultTexto02.index();
    public static final int DEFAULTNUMERO01 = AttributesEnum.DefaultNumero01.index();
    public static final int DEFAULTNUMERO02 = AttributesEnum.DefaultNumero02.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int MODULO1 = AttributesEnum.Modulo1.index();













  
    public static Key createPrimaryKey(Integer idParametro) { return new Key(new Object[] { idParametro }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Parametro"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDPARAMETRO, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/ParametroImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */