package WEB-INF.classes.modelLogin.bc.common;

import java.math.BigDecimal;
import model.bc.common.Modulo;

public interface LoginModulo extends Modulo {
  void enviarToken(String paramString1, String paramString2, String paramString3, String paramString4);
  
  String validarUsuario(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  String contextoInicial(String paramString);
  
  BigDecimal base_obtenerParametroNumerico01(String paramString);
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/common/LoginModulo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */