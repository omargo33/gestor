  package model.bc;
  
  import model.utilidades.GeneradorFile;
  import oracle.jbo.CriteriaClauses;
  import oracle.jbo.ViewCriteria;
  import oracle.jbo.server.ViewObjectImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class VistaObjeto
    extends ViewObjectImpl
  {
    public CriteriaClauses buildViewCriteriaClauses(ViewCriteria viewCriteria) {
      CriteriaClauses criteriaClauses = super.buildViewCriteriaClauses(viewCriteria);
      String where = criteriaClauses.getClauseForQuery();
      if (where != null) {
        where = where.replace("LIKE UPPER('%' || ? || '%')", "LIKE UPPER(CONCAT('%', ?, '%'))");
        criteriaClauses.setClauseForQuery(where);
      } 
      return criteriaClauses;
    }
  
  
  
  
  
  
  
  
  
    
    public String exportarExcel(String pathBase, String esquema, String tabla, String nombreArchivo) {
      String fullPath = GeneradorFile.creaDirectorio(pathBase, esquema, tabla, nombreArchivo);
  
      
      return fullPath;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/VistaObjeto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */