package viewLogin.loggin;

import javax.faces.context.ExternalContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.plantilla.BaseBean;

import viewLogin.loggin.Ingreso;

/**
 * Clase para dar ingreso al sistema de ingreso.
 * 
 * @author omargo33@gmail.com
 * 
 */
public class Ingreso extends BaseBean {
    String token = "";
    String url = "";
    ExternalContext externalContext;

    /**
     * Metodo para crear clases.
     */
    public Ingreso() {
        setNombreBundle("viewLogin.ViewControllerLoginBundle");
    }


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public String actionIngresar() {
        if (crearToken() && crearUrl()) {
            getSession().setAttribute("url", this.url);
            getSession().setAttribute("token", this.token);


            return "login";
        }

        return null;
    }

    /**
     * Metodo para crear token.
     * 
     * @return
     */
    public boolean crearToken() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("validarUsuario");
        this.token = String.valueOf(operationBinding.execute());
        return operationBinding.getErrors().isEmpty();
    }

    /**
     * Metodo para crear el url de salida.
     *
     * @return
     */
    private boolean crearUrl() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("contextoInicial");
        this.url = String.valueOf(operationBinding.execute());
        return operationBinding.getErrors().isEmpty();
    }
}