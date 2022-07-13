  package model.sql;
  
  import java.io.Serializable;
  import java.sql.SQLException;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class SobrecargaAcciones
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private String NO_DEFINIDO = "<NO-DEFINIDO>";
  
  
  
  
    
    public void accionExtra() { Logger.getLogger("global").log(Level.INFO, this.NO_DEFINIDO); }
  
  
  
  
  
  
  
  
  
    
    public void eachWorkResultSet() throws SQLException, Exception { Logger.getLogger("global").log(Level.INFO, this.NO_DEFINIDO); }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/sql/SobrecargaAcciones.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */