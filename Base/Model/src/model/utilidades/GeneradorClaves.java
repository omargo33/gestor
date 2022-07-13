  package model.utilidades;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class GeneradorClaves
  {
    public static final String KEY_ALFANUMERICOS = "23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz";
    public static final String KEY_NUMEROS = "0123456789";
    public static final String KEY_MAYUSCULAS = "ABCDEFGHJKMNPQRTUVWXYZ";
    public static final String KEY_MINUSCULAS = "abcdefghijkmnpqrtuvwxyz";
    
    public static String getPassword(String key, int length) {
      StringBuilder pswd = new StringBuilder();
      for (int i = 0; i < length; i++) {
        pswd.append(key.charAt((int)(Math.random() * key.length())));
      }
      return pswd.toString();
    }
  
  
  
  
  
  
    
    public String enmascarar(String texto) {
      try {
        int caracteresVisibles = 2;
        String pattern = "(\\d)";
        String visible = texto.substring(texto.length() - caracteresVisibles, texto.length());
        return texto.substring(1, texto.length() - caracteresVisibles).replaceAll(pattern, "X") + visible;
      } catch (Exception e) {
        return texto;
      } 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/GeneradorClaves.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */