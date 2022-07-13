  package model.utilidades.estructuras;
  
  import java.util.Comparator;
  
  
  
  
  
  
  
  
  
  
  public class MenuSorter
    implements Comparator<Menu>
  {
    public int compare(Menu m1, Menu m2) { return ("" + m1.getOrden()).compareToIgnoreCase("" + m2.getOrden()); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/estructuras/MenuSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */