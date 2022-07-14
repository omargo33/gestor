package model.bc.modulo;

import java.util.HashMap;
import java.util.Map;

import model.bc.ModuloImpl;
import model.bc.vistaNoDML.ModuloViewNoDMLRowImpl;
import model.bc.vistaNoDML.ParametroViewNoDMLRowImpl;

import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.server.ViewObjectImpl;


public class Parametros {
    public static Map<String, ParametroViewNoDMLRowImpl> obtenerParametros(ModuloImpl moduloAplicacion,
                                                                           String indiceModulo) {
        Map<String, ParametroViewNoDMLRowImpl> mapaParametro = new HashMap<>();
        ViewObjectImpl viewObjectImpl = moduloAplicacion.getBase_ModuloViewNoDML1();
        ViewCriteriaManager vcm = viewObjectImpl.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("ModuloViewNoDMLCriteriaByIndice");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_indice", indiceModulo);
        viewObjectImpl.applyViewCriteria(vc);
        viewObjectImpl.executeQuery();
        while (viewObjectImpl.hasNext()) {
            ModuloViewNoDMLRowImpl modulo = (ModuloViewNoDMLRowImpl) viewObjectImpl.next();
            for (Row r : modulo.getParametroView().getAllRowsInRange()) {
                ParametroViewNoDMLRowImpl parametro = (ParametroViewNoDMLRowImpl) r;
                mapaParametro.put(parametro.getIndice(), parametro);
            }
        }
        return mapaParametro;
    }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/modulo/Parametros.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */