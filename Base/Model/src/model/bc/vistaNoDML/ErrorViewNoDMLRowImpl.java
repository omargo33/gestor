package model.bc.vistaNoDML;

import java.sql.Timestamp;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun May 16 13:34:55 ECT 2021
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ErrorViewNoDMLRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        IdError,
        Indice,
        Mensaje,
        Descripcion,
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
    public static final int IDERROR = AttributesEnum.IdError.index();
    public static final int INDICE = AttributesEnum.Indice.index();
    public static final int MENSAJE = AttributesEnum.Mensaje.index();
    public static final int DESCRIPCION = AttributesEnum.Descripcion.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ErrorViewNoDMLRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute IdError.
     * @return the IdError
     */
    public Integer getIdError() {
        return (Integer) getAttributeInternal(IDERROR);
    }

    /**
     * Gets the attribute value for the calculated attribute Indice.
     * @return the Indice
     */
    public String getIndice() {
        return (String) getAttributeInternal(INDICE);
    }

    /**
     * Gets the attribute value for the calculated attribute Mensaje.
     * @return the Mensaje
     */
    public String getMensaje() {
        return (String) getAttributeInternal(MENSAJE);
    }

    /**
     * Gets the attribute value for the calculated attribute Descripcion.
     * @return the Descripcion
     */
    public String getDescripcion() {
        return (String) getAttributeInternal(DESCRIPCION);
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

