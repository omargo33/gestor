package viewAdministrativo.clave;

import view.plantilla.BaseBean;

import view.utilidades.ADFUtils;


public class ListaFrg extends BaseBean {
    public ListaFrg() {
        setNombreBundle("view.ViewUtilidadesBundle");
    }


    public String cambiarClave() {
        if (ADFUtils.ejecutaAction(getBindings(), "cambiarClaveCompleto", null, null)) {
            return "salir";
        }


        return null;
    }
}


