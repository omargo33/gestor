  package model.bc.modulo;
  
  import model.bc.ModuloImpl;
  import model.bc.VistaObjeto;
  import model.bc.entidad.GrupoImpl;
  import model.utilidades.Atributos;
  import oracle.jbo.Row;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  import oracle.jbo.ViewCriteriaManager;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class Grupo
  {
    public static int crearGrupo(ModuloImpl moduloAplicacion, int id, String esquema, String tabla, int largoMaximo, String extensiones, int ancho, int alto, int maximoArchivo, String usuario, String usuarioPrograma) {
      int codigo = 0;
      boolean estado = true;
      
      VistaObjeto vistaObjeto = moduloAplicacion.getBase_GrupoView1();
      
      Row row = vistaObjeto.createRow();
      row.setAttribute(GrupoImpl.ID, Integer.valueOf(id));
      row.setAttribute(GrupoImpl.ESQUEMA, Atributos.stringLargo(esquema, "<NO APLICA>", 16));
      row.setAttribute(GrupoImpl.TABLA, Atributos.stringLargo(tabla, "<NO APLICA>", 32));
      row.setAttribute(GrupoImpl.LARGOMAXIMO, Integer.valueOf(largoMaximo * 1024));
      row.setAttribute(GrupoImpl.EXTENSIONES, Atributos.stringLargo(extensiones, "<NO APLICA>", 128));
      row.setAttribute(GrupoImpl.ANCHO, Integer.valueOf(ancho));
      row.setAttribute(GrupoImpl.ALTO, Integer.valueOf(alto));
      row.setAttribute(GrupoImpl.MAXIMOARCHIVO, Integer.valueOf(maximoArchivo));
      row.setAttribute(GrupoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
      row.setAttribute(GrupoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
      row.validate();
      vistaObjeto.insertRow(row);
      estado = moduloAplicacion.commitRollback(tabla, "crearGrupo");
      if (estado) {
        codigo = ((Integer)row.getAttribute(GrupoImpl.IDGRUPO)).intValue();
      } else {
        codigo = -1;
      } 
      return codigo;
    }
  
  
  
  
  
  
  
  
  
  
    
    public static int buscarGrupo(ModuloImpl moduloAplicacion, int id, String esquema, String tabla) {
      int codigo = 0;
      
      VistaObjeto vistaObjeto = moduloAplicacion.getBase_GrupoView1();
      ViewCriteriaManager vcm = vistaObjeto.getViewCriteriaManager();
      ViewCriteria vc = vcm.getViewCriteria("GrupoViewCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_Id", Integer.valueOf(id));
      vvm.setVariableValue("v_Esquema", esquema);
      vvm.setVariableValue("v_Tabla", tabla);
      vistaObjeto.applyViewCriteria(vc);
      vistaObjeto.executeQuery();
      while (vistaObjeto.hasNext()) {
        Row r = vistaObjeto.next();
        codigo = ((Integer)r.getAttribute(GrupoImpl.IDGRUPO)).intValue();
      } 
      return codigo;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/modulo/Grupo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */