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
import oracle.jbo.ViewObject;

/**
 *
 * @author omargo33@hotmail.com
 *
 * Objeto para consultar los parametros.
 *
 *
 */
public class Parametros {

    /**
     * Metodo para obtener los parametros
     *
     * @param moduloAplicacion
     * @param indiceModulo
     * @return
     */
    public static Map<String, ParametroViewNoDMLRowImpl> obtenerParametros(ModuloImpl moduloAplicacion,
                                                                           String indiceModulo) {
        Map<String, ParametroViewNoDMLRowImpl> mapaParametro = new HashMap<String, ParametroViewNoDMLRowImpl>();
        ViewObject vo = moduloAplicacion.getBase_ModuloViewNoDML1();
        ViewCriteriaManager vcm = vo.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("ModuloViewNoDMLCriteriaByIndice");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("v_indice", indiceModulo);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        while (vo.hasNext()) {
            ModuloViewNoDMLRowImpl modulo = (ModuloViewNoDMLRowImpl) vo.next();
            for (Row r : modulo.getParametroView().getAllRowsInRange()) {
                ParametroViewNoDMLRowImpl parametro = (ParametroViewNoDMLRowImpl) r;
                mapaParametro.put(parametro.getIndice(), parametro);
            }
        }
        return mapaParametro;
    }
}
