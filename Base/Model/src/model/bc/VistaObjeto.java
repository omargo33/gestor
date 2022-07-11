package model.bc;

import model.utilidades.GeneradorFile;

import oracle.jbo.CriteriaClauses;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ViewObjectImpl;

/**
 * Objeto para dar soporte a las personalizaciones de ViewObjectImpl para el trabajo con la base de datos MYSQL
 *
 * @author omargo33@hotmail.com
 */
public class VistaObjeto extends ViewObjectImpl {
    public VistaObjeto() {
        super();
    }

    /**
     * Metodo para ejecutar las consultas de view Criteria con like (Contains)
     *
     * @param viewCriteria
     * @return
     */
    @Override
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
     * Metodo para exportar al excel el contenido de una vista.
     *
     * @param pathBase
     * @param esquema
     * @param tabla
     * @param nombreArchivo
     * @return
     */
    public String exportarExcel(String pathBase, String esquema, String tabla, String nombreArchivo) {
        String fullPath = GeneradorFile.creaDirectorio(pathBase, esquema, tabla, nombreArchivo);


        return fullPath;
    }
}
