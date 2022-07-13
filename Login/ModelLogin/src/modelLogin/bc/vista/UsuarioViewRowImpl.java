  package WEB-INF.classes.modelLogin.bc.vista;
  
  import java.sql.Timestamp;
  import modelLogin.bc.entidad.UsuarioImpl;
  import modelLogin.bc.vista.UsuarioViewRowImpl;
  import oracle.jbo.server.ViewRowImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class UsuarioViewRowImpl
    extends ViewRowImpl
  {
    public static final int ENTITY_USUARIO = 0;
    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();
    public static final int IDARCHIVO = AttributesEnum.IdArchivo.index();
    public static final int NICK = AttributesEnum.Nick.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int APELLIDO = AttributesEnum.Apellido.index();
    public static final int USUARIO1 = AttributesEnum.Usuario1.index();
    public static final int VALIDADOR = AttributesEnum.Validador.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int CONTADORINGRESO = AttributesEnum.ContadorIngreso.index();
    public static final int CONTADORFECHA = AttributesEnum.ContadorFecha.index();
  
  
  
  
  
  
  
  
  
  
  
    
    public UsuarioImpl getUsuario() { return (UsuarioImpl)getEntity(0); }
  
  
  
  
  
  
    
    public Integer getIdUsuario() { return (Integer)getAttributeInternal(IDUSUARIO); }
  
  
  
  
  
  
    
    public void setIdUsuario(Integer value) { setAttributeInternal(IDUSUARIO, value); }
  
  
  
  
  
  
    
    public Integer getIdArchivo() { return (Integer)getAttributeInternal(IDARCHIVO); }
  
  
  
  
  
  
    
    public void setIdArchivo(Integer value) { setAttributeInternal(IDARCHIVO, value); }
  
  
  
  
  
  
    
    public String getNick() { return (String)getAttributeInternal(NICK); }
  
  
  
  
  
  
    
    public void setNick(String value) { setAttributeInternal(NICK, value); }
  
  
  
  
  
  
    
    public String getNombre() { return (String)getAttributeInternal(NOMBRE); }
  
  
  
  
  
  
    
    public void setNombre(String value) { setAttributeInternal(NOMBRE, value); }
  
  
  
  
  
  
    
    public String getApellido() { return (String)getAttributeInternal(APELLIDO); }
  
  
  
  
  
  
    
    public void setApellido(String value) { setAttributeInternal(APELLIDO, value); }
  
  
  
  
  
  
    
    public String getUsuario1() { return (String)getAttributeInternal(USUARIO1); }
  
  
  
  
  
  
    
    public void setUsuario1(String value) { setAttributeInternal(USUARIO1, value); }
  
  
  
  
  
  
    
    public String getValidador() { return (String)getAttributeInternal(VALIDADOR); }
  
  
  
  
  
  
    
    public void setValidador(String value) { setAttributeInternal(VALIDADOR, value); }
  
  
  
  
  
  
    
    public Timestamp getUsuarioFecha() { return (Timestamp)getAttributeInternal(USUARIOFECHA); }
  
  
  
  
  
  
    
    public void setUsuarioFecha(Timestamp value) { setAttributeInternal(USUARIOFECHA, value); }
  
  
  
  
  
  
    
    public String getUsuarioPrograma() { return (String)getAttributeInternal(USUARIOPROGRAMA); }
  
  
  
  
  
  
    
    public void setUsuarioPrograma(String value) { setAttributeInternal(USUARIOPROGRAMA, value); }
  
  
  
  
  
  
    
    public String getEstado() { return (String)getAttributeInternal(ESTADO); }
  
  
  
  
  
  
    
    public void setEstado(String value) { setAttributeInternal(ESTADO, value); }
  
  
  
  
  
  
    
    public Integer getContadorIngreso() { return (Integer)getAttributeInternal(CONTADORINGRESO); }
  
  
  
  
  
  
    
    public void setContadorIngreso(Integer value) { setAttributeInternal(CONTADORINGRESO, value); }
  
  
  
  
  
  
    
    public Timestamp getContadorFecha() { return (Timestamp)getAttributeInternal(CONTADORFECHA); }
  
  
  
  
  
  
    
    public void setContadorFecha(Timestamp value) { setAttributeInternal(CONTADORFECHA, value); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/vista/UsuarioViewRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */