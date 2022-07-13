package WEB-INF.classes.viewAdministrativo.usuario.token;

import java.util.HashMap;
import java.util.Map;
import javax.faces.event.ActionEvent;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichListView;
import oracle.jbo.Row;
import view.plantilla.BaseBean;
import view.utilidades.ADFUtils;
import viewAdministrativo.usuario.token.ListaFrgHijoBean;
















public class ListaFrgHijoBean
  extends BaseBean
{
  private static final long serialVersionUID = 1L;
  private RichPopup popCrearClave;
  private int idCodigo;
  private RichListView lv12;
  
  public ListaFrgHijoBean() {
      setNombreBundle("viewAdministrativo.ViewControllerAdministrativoBundle");
      init();
  }




  
    private void init() { setLv12(new RichListView()); }





  
  public String actionCrearToken() {
      this.popCrearClave.hide();
      DCIteratorBinding iterator = ADFUtils.getIterator("TokenView1Iterator");
      Row[] rows = iterator.getAllRowsInRange();
      if (rows != null && rows.length > 0) {
        for (Row r : rows) {
          if (String.valueOf(r.getAttribute("Tipo")).compareTo("C") == 0) {
            Map<Object, Object> map = new HashMap<>();
            map.put("idToken", String.valueOf(r.getAttribute("IdToken")));
            ADFUtils.ejecutaAction(getBindings(), "administrativo_crearToken", 
                getBundle("usuario_token_crear_token_ko", new Object[0]), 
                getBundle("usuario_token_crear_token_ok", new Object[0]), map);
        } 
      } 
    }
    
      return "Inicio";
  }




  
  public void actionListenerError(ActionEvent actionEvent) {
      RichPopup.PopupHints hints = new RichPopup.PopupHints();
      this.popCrearClave.show(hints);
  }


  
    public RichPopup getPopCrearClave() { return this.popCrearClave; }


  
    public void setPopCrearClave(RichPopup popCrearClave) { this.popCrearClave = popCrearClave; }


  
    public int getIdCodigo() { return this.idCodigo; }


  
    public void setIdCodigo(int idCodigo) { this.idCodigo = idCodigo; }


  
    public void setLv12(RichListView lv12) { this.lv12 = lv12; }


  
    public RichListView getLv12() { return this.lv12; }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/viewAdministrativo/usuario/token/ListaFrgHijoBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */