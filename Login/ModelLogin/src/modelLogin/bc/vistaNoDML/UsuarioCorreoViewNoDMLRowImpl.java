package modelLogin.bc.vistaNoDML;import java.sql.Timestamp;import oracle.jbo.server.ViewRowImpl;// ---------------------------------------------------------------------// ---    File generated by Oracle ADF Business Components Design Time.// ---    Sun Jul 18 16:58:43 ECT 2021// ---    Custom code may be added to this class.// ---    Warning: Do not modify method signatures of generated methods.// ---------------------------------------------------------------------public class UsuarioCorreoViewNoDMLRowImpl extends ViewRowImpl {    /**     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.     */    protected enum AttributesEnum {        IdUsuario,        Nick,        ContadorIngreso,        ContadorFecha,        IdToken,        Token,        Estado,        Validador;        private static AttributesEnum[] vals = null;        private static final int firstIndex = 0;        protected int index() {            return AttributesEnum.firstIndex() + ordinal();        }        protected static final int firstIndex() {            return firstIndex;        }        protected static int count() {            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;        }        protected static final AttributesEnum[] staticValues() {            if (vals == null) {                vals = AttributesEnum.values();            }            return vals;        }    }    public static final int IDUSUARIO = AttributesEnum.IdUsuario.index();    public static final int NICK = AttributesEnum.Nick.index();    public static final int CONTADORINGRESO = AttributesEnum.ContadorIngreso.index();    public static final int CONTADORFECHA = AttributesEnum.ContadorFecha.index();    public static final int IDTOKEN = AttributesEnum.IdToken.index();    public static final int TOKEN = AttributesEnum.Token.index();    public static final int ESTADO = AttributesEnum.Estado.index();    public static final int VALIDADOR = AttributesEnum.Validador.index();    /**     * This is the default constructor (do not remove).     */    public UsuarioCorreoViewNoDMLRowImpl() {    }    /**     * Gets the attribute value for the calculated attribute IdUsuario.     * @return the IdUsuario     */    public Integer getIdUsuario() {        return (Integer) getAttributeInternal(IDUSUARIO);    }    /**     * Gets the attribute value for the calculated attribute Nick.     * @return the Nick     */    public String getNick() {        return (String) getAttributeInternal(NICK);    }    /**     * Gets the attribute value for the calculated attribute ContadorIngreso.     * @return the ContadorIngreso     */    public Integer getContadorIngreso() {        return (Integer) getAttributeInternal(CONTADORINGRESO);    }    /**     * Gets the attribute value for the calculated attribute ContadorFecha.     * @return the ContadorFecha     */    public Timestamp getContadorFecha() {        return (Timestamp) getAttributeInternal(CONTADORFECHA);    }    /**     * Gets the attribute value for the calculated attribute IdToken.     * @return the IdToken     */    public Integer getIdToken() {        return (Integer) getAttributeInternal(IDTOKEN);    }    /**     * Gets the attribute value for the calculated attribute Token.     * @return the Token     */    public String getToken() {        return (String) getAttributeInternal(TOKEN);    }    /**     * Gets the attribute value for the calculated attribute Estado.     * @return the Estado     */    public String getEstado() {        return (String) getAttributeInternal(ESTADO);    }    /**     * Gets the attribute value for the calculated attribute Validador.     * @return the Validador     */    public String getValidador() {        return (String) getAttributeInternal(VALIDADOR);    }}