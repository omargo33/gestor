package viewUsuario.clave;import view.plantilla.BaseBean;import view.utilidades.ADFUtils;/** * Metodo para ejecutar en la lista. * * @author omargo33@hotmail.com */public class ListaItemFrg extends BaseBean {    public ListaItemFrg() {        super();    }    public String cambiarClave() {        if (ADFUtils.ejecutaAction(getBindings(), "cambiarClaveCompleto", "No se puede cambiar la clave", "Clave Cambiada Satisfactoriamente, Salga y vuelva a Ingresar")) {                    }        return null;    }}