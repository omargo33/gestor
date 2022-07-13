  package model.bc.vistaNoDML;
  
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import model.bc.VistaObjeto;
  import model.bc.vistaNoDML.common.UsuarioViewNoDML;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class UsuarioViewNoDMLImpl
    extends VistaObjeto
    implements UsuarioViewNoDML
  {
    public void ejecutarByIndice(int idUsuario) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("UsuarioViewNoDMLCriteriaByIdUsuario");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idUsuario", Integer.valueOf(idUsuario));
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
  
    
    public void ejecutarByNick(String nick) {
      ViewCriteria vc = getViewCriteriaManager().getViewCriteria("UsuarioViewNoDMLCriteriaByNick");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_nick", nick);
      applyViewCriteria(vc, false);
      executeQuery();
      setApplyViewCriteriaName(null);
    }
  
  
  
  
  
    
    public void ejecutarByIndiceString(String indice) {
      int indiceInteger = 0;
      if (indice != null) {
        try {
          indiceInteger = Integer.parseInt(indice);
        } catch (Exception e) {
          Logger.getLogger("global").log(Level.SEVERE, "convert error=" + e.toString());
          indiceInteger = 0;
        } 
      }
      ejecutarByIndice(indiceInteger);
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/vistaNoDML/UsuarioViewNoDMLImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */