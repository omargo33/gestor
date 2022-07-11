package model.utilidades;


/**
 *
 * Objeto con metodos para generar diversas claves randomicas.
 *
 * @author omargo33@hotmail.com
 *
 */
public class GeneradorClaves {
    /**
     * Llave utilizada para la genercion de codigo de verificacion
     */
    public static final String KEY_ALFANUMERICOS = "23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz";

    /**
     * Numeros.
     */
    public static final String KEY_NUMEROS = "0123456789";

    /**
     * Mayusculas.
     */
    public static final String KEY_MAYUSCULAS = "ABCDEFGHJKMNPQRTUVWXYZ";

    /**
     * Minusculas.
     */
    public static final String KEY_MINUSCULAS = "abcdefghijkmnpqrtuvwxyz";

    
    /**
     * Método para la generacion del código de verificacion.
     *
     * @param key
     * @param length
     * @return
     */
    public static String getPassword(String key, int length) {
        StringBuilder pswd = new StringBuilder();
        for (int i = 0; i < length; i++) {
            pswd.append((key.charAt((int) (Math.random() * key.length()))));
        }
        return pswd.toString();
    }

    /**
     * Metodo para dar formato decimal a valores.
     *
     * @param texto
     * @return
     */
    public String enmascarar(String texto) {
        try {
            int caracteresVisibles = 2;
            String pattern = "(\\d)";
            String visible = texto.substring(texto.length() - caracteresVisibles, texto.length());
            return texto.substring(1, texto.length() - caracteresVisibles).replaceAll(pattern, "X") + visible;
        } catch (Exception e) {
            return texto;
        }
    }
}
