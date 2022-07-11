package model.bc.vistaNoDML;

import java.sql.Timestamp;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun May 16 13:34:46 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CodigoDefinidoUsuarioViewNoDMLRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdCodigoDefinidoUsuario,
        IdModulo,
        Grupo,
        CodigoTexto,
        CodigoNumero,
        Nombre,
        Descripcion,
        Orden,
        Estado,
        Usuario,
        UsuarioFecha,
        UsuarioPrograma;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int IDCODIGODEFINIDOUSUARIO = AttributesEnum.IdCodigoDefinidoUsuario.index();
    public static final int IDMODULO = AttributesEnum.IdModulo.index();
    public static final int GRUPO = AttributesEnum.Grupo.index();
    public static final int CODIGOTEXTO = AttributesEnum.CodigoTexto.index();
    public static final int CODIGONUMERO = AttributesEnum.CodigoNumero.index();
    public static final int NOMBRE = AttributesEnum.Nombre.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int ORDEN = AttributesEnum.Orden.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CodigoDefinidoUsuarioViewNoDMLRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute IdCodigoDefinidoUsuario.
     * @return the IdCodigoDefinidoUsuario
     */
    public Integer getIdCodigoDefinidoUsuario() {
        return (Integer) getAttributeInternal(IDCODIGODEFINIDOUSUARIO);
    }

    /**
     * Gets the attribute value for the calculated attribute IdModulo.
     * @return the IdModulo
     */
    public Integer getIdModulo() {
        return (Integer) getAttributeInternal(IDMODULO);
    }

    /**
     * Gets the attribute value for the calculated attribute Grupo.
     * @return the Grupo
     */
    public String getGrupo() {
        return (String) getAttributeInternal(GRUPO);
    }

    /**
     * Gets the attribute value for the calculated attribute CodigoTexto.
     * @return the CodigoTexto
     */
    public String getCodigoTexto() {
        return (String) getAttributeInternal(CODIGOTEXTO);
    }

    /**
     * Gets the attribute value for the calculated attribute CodigoNumero.
     * @return the CodigoNumero
     */
    public Integer getCodigoNumero() {
        return (Integer) getAttributeInternal(CODIGONUMERO);
    }

    /**
     * Gets the attribute value for the calculated attribute Nombre.
     * @return the Nombre
     */
    public String getNombre() {
        return (String) getAttributeInternal(NOMBRE);
    }

    /**
     * Gets the attribute value for the calculated attribute Descripcion.
     * @return the Descripcion
     */
    public String getDescripcion() {
        return (String) getAttributeInternal(DESCRIPCION);
    }

    /**
     * Gets the attribute value for the calculated attribute Orden.
     * @return the Orden
     */
    public Integer getOrden() {
        return (Integer) getAttributeInternal(ORDEN);
    }

    /**
     * Gets the attribute value for the calculated attribute Estado.
     * @return the Estado
     */
    public String getEstado() {
        return (String) getAttributeInternal(ESTADO);
    }

    /**
     * Gets the attribute value for the calculated attribute Usuario.
     * @return the Usuario
     */
    public String getUsuario() {
        return (String) getAttributeInternal(USUARIO);
    }

    /**
     * Gets the attribute value for the calculated attribute UsuarioFecha.
     * @return the UsuarioFecha
     */
    public Timestamp getUsuarioFecha() {
        return (Timestamp) getAttributeInternal(USUARIOFECHA);
    }

    /**
     * Gets the attribute value for the calculated attribute UsuarioPrograma.
     * @return the UsuarioPrograma
     */
    public String getUsuarioPrograma() {
        return (String) getAttributeInternal(USUARIOPROGRAMA);
    }
}

