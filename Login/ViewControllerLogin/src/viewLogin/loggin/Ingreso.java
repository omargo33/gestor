  package WEB-INF.classes.viewLogin.loggin;
  
  import javax.faces.context.ExternalContext;
  import oracle.adf.model.BindingContext;
  import oracle.binding.BindingContainer;
  import oracle.binding.OperationBinding;
  import view.plantilla.BaseBean;
  import viewLogin.loggin.Ingreso;
  
  
  
  
  
  
  
  
  
  
  public class Ingreso
    extends BaseBean
  {
    String token = "";
    String url = "";
  
  
    
    ExternalContext externalContext;
  
  
    
    public Ingreso() { setNombreBundle("viewLogin.ViewControllerLoginBundle"); }
  
  
    
    public BindingContainer getBindings() { return BindingContext.getCurrent().getCurrentBindingsEntry(); }
  
  
  
  
  
  
    
    public String actionIngresar() {
      if (crearToken() && 
        crearUrl()) {
        getSession().setAttribute("url", this.url);
        getSession().setAttribute("token", this.token);
        return "login";
      } 
      
      return null;
    }
  
  
  
  
  
    
    public boolean crearToken() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("validarUsuario");
      this.token = String.valueOf(operationBinding.execute());
      return operationBinding.getErrors().isEmpty();
    }
  
  
  
  
  
    
    private boolean crearUrl() {
      BindingContainer bindings = getBindings();
      OperationBinding operationBinding = bindings.getOperationBinding("contextoInicial");
      this.url = String.valueOf(operationBinding.execute());
      return operationBinding.getErrors().isEmpty();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/viewLogin/loggin/Ingreso.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */