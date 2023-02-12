package model.bc;

import com.aplicaciones13.tools.Archivo;

import model.utilidades.GeneradorFile;

import oracle.jbo.CriteriaClauses;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ViewObjectImpl;

/**
 * Objeto de soporte a view objects.
 * 
 * @author omargo33@hotmail.com
 * 
 */
public class VistaObjeto extends ViewObjectImpl {
    
    /**
     * Metodo para generar build view criteria.
     *
     * @param viewCriteria
     * @return
     */
    public CriteriaClauses buildViewCriteriaClauses(ViewCriteria viewCriteria) {
        CriteriaClauses criteriaClauses = super.buildViewCriteriaClauses(viewCriteria);
        String where = criteriaClauses.getClauseForQuery();
        if (where != null) {
            where = where.replace("LIKE UPPER('%' || ? || '%')", "LIKE UPPER(CONCAT('%', ?, '%'))");
            criteriaClauses.setClauseForQuery(where);
        }
        return criteriaClauses;
    }

    /**
     * Metodo para esportar excel.
     *
     * @param pathBase
     * @param esquema
     * @param tabla
     * @param nombreArchivo
     * @return
     */
    public String exportarExcel(String pathBase, String esquema, String tabla, String nombreArchivo) {
        String fullPath = Archivo.creaDirectorio(pathBase, esquema, tabla, nombreArchivo);
        return fullPath;
    }
}