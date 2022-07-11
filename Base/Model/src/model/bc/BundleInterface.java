package model.bc;


/**
 * Implementaciones para entidades, Modulo de aplicacion y demas elemetnos.
 *
 * @author omargo33@hotmail.com
 *
 */
public interface BundleInterface {

    /**
     * Metodo para setear el nombre del bundle.
     *
     * @param nombreBundle
     */
    public void setNombreBundle(String nombreBundle);

    /**
     * Metodo para usar el bundle.
     *
     * @param llaveBundle
     * @param parametros
     * @return
     */
    public String getBundle(String llaveBundle, Object... parametros);
}
