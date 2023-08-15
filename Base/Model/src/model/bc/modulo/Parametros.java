package model.bc.modulo;

import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;

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

        Logger.getLogger("global").log(Level.INFO, ".obtenerParametros() " + moduloAplicacion + " " + indiceModulo);


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
