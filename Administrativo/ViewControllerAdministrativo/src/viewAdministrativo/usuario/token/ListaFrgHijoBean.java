package viewAdministrativo.usuario.token;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichListView;

import oracle.jbo.Row;

import view.plantilla.BaseBean;

import view.utilidades.ADFUtils;

import viewAdministrativo.utilidades.Flow;

/**
 * Objeto de metodo de cambio de crear clave.
 *
 * @author omargo33@hotmail.com
 */
public class ListaFrgHijoBean extends BaseBean {
    @SuppressWarnings("compatibility:8871270327023564777")
    private static final long serialVersionUID = 1L;
    private RichPopup popCrearClave;
    private int idCodigo;
    private RichListView lv12;

    /**
     * Metodo para crear el objeto.
     *
     */
    public ListaFrgHijoBean() {
        super();
        setNombreBundle(Flow.BUNDLE);
        init();
    }

    /**
     * Metodo para inicializar datos.
     */
    private void init() {
        setLv12(new RichListView());
    }

    /**
     * Accion Borrar.
     * @return
     */
    public String actionCrearToken() {
        popCrearClave.hide();
        DCIteratorBinding iterator = ADFUtils.getIterator("TokenView1Iterator");
        Row[] rows = iterator.getAllRowsInRange();
        if (rows != null && rows.length > 0) {
            for (Row r : rows) {
                if (String.valueOf(r.getAttribute("Tipo")).compareTo("C") == 0) {
                    Map map = new HashMap();
                    map.put("idToken", String.valueOf(r.getAttribute("IdToken")));
                    ADFUtils.ejecutaAction(getBindings(), "administrativo_crearToken",
                                           getBundle("usuario_token_crear_token_ko"),
                                           getBundle("usuario_token_crear_token_ok"), map);
                }
            }
        }

        return Flow.FLOW_INICIO;
    }

    /** Presenta el popUp.
     *
     * @param actionEvent
     */
    public void actionListenerError(ActionEvent actionEvent) {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        popCrearClave.show(hints);
    }

    //Propiedades.
    public RichPopup getPopCrearClave() {
        return popCrearClave;
    }

    public void setPopCrearClave(RichPopup popCrearClave) {
        this.popCrearClave = popCrearClave;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public void setLv12(RichListView lv12) {
        this.lv12 = lv12;
    }

    public RichListView getLv12() {
        return lv12;
    }
}
