package model.bc.vistaNoDML.common;

import oracle.jbo.ViewObject;

public interface UsuarioViewNoDML extends ViewObject {
  void ejecutarByIndice(int paramInt);
  
  void ejecutarByIndiceString(String paramString);
  
  void ejecutarByNick(String paramString);
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/common/UsuarioViewNoDML.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */