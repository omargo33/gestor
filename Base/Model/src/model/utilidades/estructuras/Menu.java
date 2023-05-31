package model.utilidades.estructuras;






























public class Menu
{
  private int idMenusPermisos;
  private int orden;
  private String nick;
  private String indiceModulo;
  private String nombreModulo;
  private String contexto;
  private int idMenu;
  private String tipo;
  private String indiceMenu;
  private String nombreMenu;
  private String taskFlow;
  private String taskFlowInformacion;
  private boolean crear;
  private boolean actualizar;
  private boolean borrar;
  private boolean verAuditoria;
  
  public Menu(int idMenusPermisos, int orden, String nick, String indiceModulo, String nombreModulo, String contexto, int idMenu, String tipo, String indiceMenu, String nombreMenu, String taskFlow, String taskFlowInformacion, boolean crear, boolean actualizar, boolean borrar, boolean verAuditoria) {
      this.idMenusPermisos = idMenusPermisos;
      this.orden = orden;
      this.nick = nick;
      this.indiceModulo = indiceModulo;
      this.nombreModulo = nombreModulo;
      this.contexto = contexto;
      this.idMenu = idMenu;
      this.tipo = tipo;
      this.indiceMenu = indiceMenu;
      this.nombreMenu = nombreMenu;
      this.taskFlow = taskFlow;
      this.taskFlowInformacion = taskFlowInformacion;
      this.crear = crear;
      this.actualizar = actualizar;
      this.borrar = borrar;
      this.verAuditoria = verAuditoria;
  }

  
    public int getIdMenusPermisos() { return this.idMenusPermisos; }


  
    public void setIdMenusPermisos(int idMenusPermisos) { this.idMenusPermisos = idMenusPermisos; }


  
    public int getOrden() { return this.orden; }


  
    public void setOrden(int orden) { this.orden = orden; }


  
    public String getNick() { return this.nick; }


  
    public void setNick(String nick) { this.nick = nick; }


  
    public String getIndiceModulo() { return this.indiceModulo; }


  
    public void setIndiceModulo(String indiceModulo) { this.indiceModulo = indiceModulo; }


  
    public String getNombreModulo() { return this.nombreModulo; }


  
    public void setNombreModulo(String nombreModulo) { this.nombreModulo = nombreModulo; }


  
    public String getContexto() { return this.contexto; }


  
    public void setContexto(String contexto) { this.contexto = contexto; }


  
    public int getIdMenu() { return this.idMenu; }


  
    public void setIdMenu(int idMenu) { this.idMenu = idMenu; }


  
    public String getTipo() { return this.tipo; }


  
    public void setTipo(String tipo) { this.tipo = tipo; }


  
    public String getIndiceMenu() { return this.indiceMenu; }


  
    public void setIndiceMenu(String indiceMenu) { this.indiceMenu = indiceMenu; }


  
    public String getNombreMenu() { return this.nombreMenu; }


  
    public void setNombreMenu(String nombreMenu) { this.nombreMenu = nombreMenu; }


  
    public String getTaskFlow() { return this.taskFlow; }


  
    public void setTaskFlow(String taskFlow) { this.taskFlow = taskFlow; }


  
    public boolean getCrear() { return this.crear; }


  
    public void setCrear(boolean crear) { this.crear = crear; }
  
  
    
    public boolean getActualizar() { return this.actualizar; }
  
  
    
    public void setActualizar(boolean actualizar) { this.actualizar = actualizar; }
  
  
    
    public boolean getBorrar() { return this.borrar; }
  
  
    
    public void setBorrar(boolean borrar) { this.borrar = borrar; }
  
  
    
    public boolean getVerAuditoria() { return this.verAuditoria; }
  
  
    
    public void setVerAuditoria(boolean verAuditoria) { this.verAuditoria = verAuditoria; }
  
  
    
    public String getTaskFlowInformacion() { return this.taskFlowInformacion; }
  
  
    
    public void setTaskFlowInformacion(String taskFlowInformacion) { this.taskFlowInformacion = taskFlowInformacion; }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/utilidades/estructuras/Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */