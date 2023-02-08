package model.bc.common;

import java.math.BigDecimal;

import java.util.Date;
import java.util.Map;
import oracle.jbo.ApplicationModule;

public interface Modulo extends ApplicationModule {
  void base_archivoBorrar(int paramInt, String paramString1, String paramString2, String paramString3);
  
  int base_archivoCrear(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7);
  
  int base_archivoCrearEvento(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  int base_archivoCrearGrupo(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5);
  
  String base_obtenerParametroTexto01(String paramString);
  
  boolean base_isUsuarioRol(String paramString1, String paramString2);
  
  int base_excelCrear(String paramString1, String paramString2, String paramString3);
  
  int base_excelBuscarArchivos(String paramString1, String paramString2, String paramString3);
  
  int base_crearNotificacion(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, Date paramDate, String paramString5, String paramString6, Map<String, String> paramMap1, Map<String, String> paramMap2);
  
  String base_rolesByNick(String paramString);

    BigDecimal base_obtenerParametroNumerico01(String indiceParametro);

    BigDecimal base_obtenerParametroNumerico02(String indiceParametro);

    String base_obtenerParametroTexto02(String indiceParametro);

    boolean base_isOnlyUsuarioRol(String nick, String rol, String indiceModulo);
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/common/Modulo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */