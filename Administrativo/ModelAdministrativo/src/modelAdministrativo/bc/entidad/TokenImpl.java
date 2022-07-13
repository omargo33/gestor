package WEB-INF.classes.modelAdministrativo.bc.entidad;

import model.bc.Entidad;
import modelAdministrativo.bc.entidad.TokenImpl;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;












































public class TokenImpl
  extends Entidad
{
    public static final int IDTOKEN = AttributesEnum.IdToken.index();
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int SOCIALNICK = AttributesEnum.SocialNick.index();
    public static final int CORREO = AttributesEnum.Correo.index();
    public static final int TOKEN = AttributesEnum.Token.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int USUARIO1 = AttributesEnum.Usuario1.index();













  
    public static Key createPrimaryKey(Integer idToken) { return new Key(new Object[] { idToken }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("modelAdministrativo.bc.entidad.Token"); }






  
    public void lock() { super.lock(); }










  
  protected void doDML(int operation, TransactionEvent e) {
      if (operation != 3) {
        String data = String.valueOf(getAttribute(SOCIALNICK).hashCode());
        setAttribute(VALIDADOR, data);
    } 
    
      super.doDML(operation, e);
    
      if (operation == 1)
        setAttribute(IDTOKEN, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/entidad/TokenImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */