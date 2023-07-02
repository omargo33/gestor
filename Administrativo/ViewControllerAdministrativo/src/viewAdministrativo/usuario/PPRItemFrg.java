package viewAdministrativo.usuario;


import oracle.adf.view.rich.component.rich.fragment.RichRegion;

import view.plantilla.BasePPR;

import view.utilidades.ADFUtils;

public class PPRItemFrg extends BasePPR {

    private RichRegion r1;
    private RichRegion r2;

    /**
     * Clase para dar soporte para la item de muletos.
     *
     */
    public PPRItemFrg() {
        setNombreBundle("viewAdministrativo.ViewControllerAdministrativoBundle");

        setR1(new RichRegion());
        setR2(new RichRegion());
    }

    /**
     * Accion Guardar.
     *
     * @return
     */
    public String actionGuardar() {
        if (ADFUtils.commitRollback(getBindings(), view.plantilla
                                                       .utilidades
                                                       .Flow
                                                       .ACCION_COMMIT, view.plantilla
                                                                           .utilidades
                                                                           .Flow
                                                                           .ACCION_ROLLBACK,
                                    getBundle("msg_guardar_ko"), getBundle("msg_guardar_ok"))) {
            setAccionEstadoTaskFlow(TASK_FLOW_EDITAR);


            doPartialRefresh(getR1().getParent());
            doPartialRefresh(getR2().getParent());

            return view.plantilla
                       .utilidades
                       .Flow
                       .FLOW_NULL;
        }

        return view.plantilla
                   .utilidades
                   .Flow
                   .FLOW_INICIO;
    }


    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }


    public RichRegion getR1() {
        return this.r1;
    }


    public void setR2(RichRegion r2) {
        this.r2 = r2;
    }


    public RichRegion getR2() {
        return this.r2;
    }


    /*
    public boolean isCrear() {
        return verificarPermiso("#{pageFlowScope.pPermisoCrear}");
    }


    public boolean isActualizar() {
        return verificarPermiso("#{pageFlowScope.pPermisoActualizar}");
    }


    public boolean isBorrar() {
        return verificarPermiso("#{pageFlowScope.pPermisoBorrar}");
    }
*/
}
