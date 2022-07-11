package modelAuditoria.bc.modulo.estructura;

/**
 * 
 * @author omargo33@hotmail.com
 *
 * Objeto para insertar un parametro.
 *
 */
public class Parametro {
    public static final String DIRECCION_ENTRADA="I";
    public static final String DIRECCION_SALIDA="O";
    
    private String nombre;
    private String direccion;
    private String valor;

    /**
     * Metodo para crear el dato.
     *
     * @param nombre
     * @param direccion
     * @param valor
     */
    public Parametro(String nombre, String direccion, String valor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.valor = valor;
    }

    //Propiedades
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}