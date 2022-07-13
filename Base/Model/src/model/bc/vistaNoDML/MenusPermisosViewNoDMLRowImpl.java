package model.bc.vistaNoDML;

import oracle.jbo.server.ViewRowImpl;






public class MenusPermisosViewNoDMLRowImpl
  extends ViewRowImpl
{
  protected enum AttributesEnum
  {
      IdMenusPermisos,
      Nick,
      IndiceModulo,
      NombreModulo,
      Contexto,
      IdMenu,
      Tipo,
      IndiceMenu,
      NombreMenu,
      TaskFlow,
      TaskFlowInformacion,
      Orden,
      Crear,
      Actualizar,
      Borrar,
      VerAuditoria; private static AttributesEnum[] vals; static  {
        vals = null;
    }
    private static final int firstIndex = 0;
    
      protected int index() { return firstIndex() + ordinal(); }


    
      protected static final int firstIndex() { return 0; }


    
      protected static int count() { return firstIndex() + (staticValues()).length; }

    
    protected static final AttributesEnum[] staticValues() {
        if (vals == null) {
          vals = values();
      }
        return vals;
    }
  }

  
    public static final int IDMENUSPERMISOS = AttributesEnum.IdMenusPermisos.index();
    public static final int NICK = AttributesEnum.Nick.index();
    public static final int INDICEMODULO = AttributesEnum.IndiceModulo.index();
    public static final int NOMBREMODULO = AttributesEnum.NombreModulo.index();
    public static final int CONTEXTO = AttributesEnum.Contexto.index();
    public static final int IDMENU = AttributesEnum.IdMenu.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
    public static final int INDICEMENU = AttributesEnum.IndiceMenu.index();
    public static final int NOMBREMENU = AttributesEnum.NombreMenu.index();
    public static final int TASKFLOW = AttributesEnum.TaskFlow.index();
    public static final int TASKFLOWINFORMACION = AttributesEnum.TaskFlowInformacion.index();
    public static final int ORDEN = AttributesEnum.Orden.index();
    public static final int CREAR = AttributesEnum.Crear.index();
    public static final int ACTUALIZAR = AttributesEnum.Actualizar.index();
    public static final int BORRAR = AttributesEnum.Borrar.index();
    public static final int VERAUDITORIA = AttributesEnum.VerAuditoria.index();











  
    public Integer getIdMenusPermisos() { return (Integer)getAttributeInternal(IDMENUSPERMISOS); }






  
    public void setIdMenusPermisos(Integer value) { setAttributeInternal(IDMENUSPERMISOS, value); }






  
    public String getNick() { return (String)getAttributeInternal(NICK); }






  
    public String getIndiceModulo() { return (String)getAttributeInternal(INDICEMODULO); }






  
    public String getNombreModulo() { return (String)getAttributeInternal(NOMBREMODULO); }






  
    public String getContexto() { return (String)getAttributeInternal(CONTEXTO); }






  
    public Integer getIdMenu() { return (Integer)getAttributeInternal(IDMENU); }






  
    public String getTipo() { return (String)getAttributeInternal(TIPO); }






  
    public String getIndiceMenu() { return (String)getAttributeInternal(INDICEMENU); }






  
    public String getNombreMenu() { return (String)getAttributeInternal(NOMBREMENU); }






  
    public String getTaskFlow() { return (String)getAttributeInternal(TASKFLOW); }






  
    public String getTaskFlowInformacion() { return (String)getAttributeInternal(TASKFLOWINFORMACION); }






  
    public Integer getOrden() { return (Integer)getAttributeInternal(ORDEN); }






  
    public String getCrear() { return (String)getAttributeInternal(CREAR); }






  
    public String getActualizar() { return (String)getAttributeInternal(ACTUALIZAR); }






  
    public String getBorrar() { return (String)getAttributeInternal(BORRAR); }






  
    public String getVerAuditoria() { return (String)getAttributeInternal(VERAUDITORIA); }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/MenusPermisosViewNoDMLRowImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */