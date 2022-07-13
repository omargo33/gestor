  package WEB-INF.classes.viewAdministrativo.clave;
  
  import view.plantilla.BaseBean;
  import view.utilidades.ADFUtils;
  import viewAdministrativo.clave.ListaFrg;
  
  
  public class ListaFrg
    extends BaseBean
  {
    public ListaFrg() { setNombreBundle("view.ViewUtilidadesBundle"); }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public String cambiarClave() {
      if (ADFUtils.ejecutaAction(getBindings(), "cambiarClaveCompleto", null, null))
      {
        return "salir";
      }
  
      
      return null;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/viewAdministrativo/clave/ListaFrg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */