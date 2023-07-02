package model.bc;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.bc.common.Modulo;
import model.bc.modulo.Archivo;
import model.bc.modulo.Grupo;
import model.bc.modulo.Notificaciones;
import model.bc.modulo.Parametros;
import model.bc.modulo.Rol;
import model.bc.vista.ArchivoViewImpl;
import model.bc.vistaNoDML.InformacionViewNoDMLImpl;
import model.bc.vistaNoDML.MenusPermisosViewNoDMLImpl;
import model.bc.vistaNoDML.ParametroViewNoDMLRowImpl;
import model.bc.vistaNoDML.UsuarioViewNoDMLImpl;

import oracle.jbo.JboException;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;

/**
 * Objeto para dar objetos de modulo de aplicacion.
 *
 * @author omargo33@hotmail.com
 *
 */
public class ModuloImpl extends ModuloAplicacion implements Modulo {
    Map<String, ParametroViewNoDMLRowImpl> mapaParametro;

    public ModuloImpl() {
        setNombreBundle("model.ModelBundle");
        this.mapaParametro = new HashMap<>();
    }

    /**
     * Metodo para crear base de datos al crear archivo.
     *
     * @param idGrupo
     * @param nombre
     * @param nombreRamdon
     * @param extension
     * @param pathRelativo
     * @param largo
     * @param informacion
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int base_archivoCrear(int idGrupo, String nombre, String nombreRamdon, String extension, String pathRelativo,
                                 int largo, String informacion, String usuario, String usuarioPrograma) {
        int idArchivo =
            Archivo.crearArchivo(this, idGrupo, nombre, nombreRamdon, extension, pathRelativo, largo, usuario,
                                 usuarioPrograma);


        Archivo.crearEventeoArchivo(this, idArchivo, informacion, "C", usuario, usuarioPrograma);
        return idArchivo;
    }

    /**
     * Metodo para crear espacio de archivos.
     *
     * @param id
     * @param esquema
     * @param tabla
     * @param largoMaximo
     * @param extensiones
     * @param ancho
     * @param alto
     * @param maximoArchivo
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int base_archivoCrearGrupo(int id, String esquema, String tabla, int largoMaximo, String extensiones,
                                      int ancho, int alto, int maximoArchivo, String usuario, String usuarioPrograma) {
        int codigo = Grupo.buscarGrupo(this, id, esquema, tabla);

        if (codigo == 0) {
            codigo =
                Grupo.crearGrupo(this, id, esquema, tabla, largoMaximo, extensiones, ancho, alto, maximoArchivo,
                                 usuario, usuarioPrograma);
        }


        return codigo;
    }

    /**
     * Metodo para crear notificacion.
     *
     * @param idFormato
     * @param idServicio
     * @param titulo
     * @param contenido
     * @param direccionEnvio
     * @param anular
     * @param fechaEnvio
     * @param usuario
     * @param usuarioPrograma
     * @param mapaParametros
     * @param mapaAdjuntos
     * @return
     */
    public int base_crearNotificacion(int idFormato, int idServicio, String titulo, String contenido,
                                      String direccionEnvio, String anular, Date fechaEnvio, String usuario,
                                      String usuarioPrograma, Map<String, String> mapaParametros,
                                      Map<String, String> mapaAdjuntos) {
        int idNotificacion =
            Notificaciones.enviarNotificacion(this, idFormato, idServicio, titulo, contenido, direccionEnvio, anular,
                                              fechaEnvio, usuario, usuarioPrograma, mapaParametros, mapaAdjuntos);


        return idNotificacion;
    }

    /**
     * Metodo para crear un evento en los archivos.
     *
     * @param idArchivo
     * @param evento
     * @param informacion
     * @param usuario
     * @param usuarioPrograma
     * @return
     */
    public int base_archivoCrearEvento(int idArchivo, String evento, String informacion, String usuario,
                                       String usuarioPrograma) {
        return Archivo.crearEventeoArchivo(this, idArchivo, informacion, evento, usuario, usuarioPrograma);
    }

    /**
     * Metodo para buscar el listado de archivos y su indice.
     *
     * @param idGrupo
     * @return
     */
    public Map<String, String> base_grupoPathsArchivos(int idGrupo) {
        return Grupo.buscarPathArchivosByGrupo(this, idGrupo);
    }

    /**
     * Metodo para borrar todos los archivos de un grupo.
     *
     * @param idGrupo
     * @param informacion
     * @param usuario
     * @param usuarioPrograma
     */
    public void base_grupoBorrarArchivos(int idGrupo, String informacion, String usuario, String usuarioPrograma) {
        Grupo.borrarArchivosByGrupos(this, idGrupo, informacion, usuario, usuarioPrograma);
    }

    /**
     * Metodo buscar
     *
     * @param id
     * @param esquema
     * @param tabla
     * @return
     */
    public int base_grupoBuscarIdGrupo(int id, String esquema, String tabla) {
        return Grupo.buscarGrupo(this, id, esquema, tabla);
    }

    /**
     * Metodo para conocer el u parametro por indice del modulo de ejecucion.
     *
     * @param indiceParametro
     * @return
     */
    private ParametroViewNoDMLRowImpl obtenerParametro(String indiceParametro) {
        ParametroViewNoDMLRowImpl parametroRespuesta = this.mapaParametro.get(indiceParametro);
        if (parametroRespuesta == null) {
            this.mapaParametro = Parametros.obtenerParametros(this, getBundle("modulo.indice"));
            parametroRespuesta = this.mapaParametro.get(indiceParametro);
            if (parametroRespuesta == null) {
                Logger.getLogger("global")
                    .log(Level.WARNING,
                         "Error Indice=" + indiceParametro + "-" + getBundle("modulo.indice"));
                throw new JboException(getBundle("ModuloImpl.obtenerParametro.txt_1",
                                                  indiceParametro,
                                                                getBundle("modulo.indice") ));
            }
        }
        return parametroRespuesta;
    }

    public String base_rolesByNick(String nick) {
        return Rol.rolesActivosPorUsuario(this, nick);
    }


    public boolean base_isUsuarioRol(String nick, String rol) {
        return Rol.validarRol(this, nick, rol);
    }


    public boolean base_isOnlyUsuarioRol(String nick, String rol, String indiceModulo) {
        return Rol.validarRolPorModulo(this, indiceModulo, rol, nick);
    }


    public String base_obtenerParametroTexto01(String indiceParametro) {
        return obtenerParametro(indiceParametro).getValorTexto01();
    }


    public String base_obtenerParametroTexto02(String indiceParametro) {
        return obtenerParametro(indiceParametro).getValorTexto02();
    }


    public BigDecimal base_obtenerParametroNumerico01(String indiceParametro) {
        return obtenerParametro(indiceParametro).getValorNumero01();
    }


    public BigDecimal base_obtenerParametroNumerico02(String indiceParametro) {
        return obtenerParametro(indiceParametro).getValorNumero02();
    }

    public void base_archivoBorrar(int idArchivo, String informacion, String usuario, String usuarioPrograma) {
        Archivo.borrarArchivo(this, idArchivo, informacion, usuario, usuarioPrograma);
    }


    public ViewObjectImpl getBase_CodigoDefinidoUsuarioViewNoDML1() {
        return (ViewObjectImpl) findViewObject("Base_CodigoDefinidoUsuarioViewNoDML1");
    }


    public ViewObjectImpl getBase_ErrorViewNoDML1() {
        return (ViewObjectImpl) findViewObject("Base_ErrorViewNoDML1");
    }


    public ViewObjectImpl getBase_ModuloViewNoDML1() {
        return (ViewObjectImpl) findViewObject("Base_ModuloViewNoDML1");
    }


    public ViewObjectImpl getBase_ParametroViewNoDML1() {
        return (ViewObjectImpl) findViewObject("Base_ParametroViewNoDML1");
    }


    public ViewObjectImpl getBase_CodigoDefinidoUsuarioViewNoDML2() {
        return (ViewObjectImpl) findViewObject("Base_CodigoDefinidoUsuarioViewNoDML2");
    }


    public ViewObjectImpl getBase_ParametroViewNoDML2() {
        return (ViewObjectImpl) findViewObject("Base_ParametroViewNoDML2");
    }


    public ViewLinkImpl getModuloCodigoDefinidoUsuarioViewLink1() {
        return (ViewLinkImpl) findViewLink("ModuloCodigoDefinidoUsuarioViewLink1");
    }


    public ViewLinkImpl getModuloParametroViewLink1() {
        return (ViewLinkImpl) findViewLink("ModuloParametroViewLink1");
    }


    public MenusPermisosViewNoDMLImpl getBase_MenusPermisosViewNoDML1() {
        return (MenusPermisosViewNoDMLImpl) findViewObject("Base_MenusPermisosViewNoDML1");
    }


    public InformacionViewNoDMLImpl getBase_InformacionViewNoDML1() {
        return (InformacionViewNoDMLImpl) findViewObject("Base_InformacionViewNoDML1");
    }


    public UsuarioViewNoDMLImpl getBase_UsuarioViewNoDML1() {
        return (UsuarioViewNoDMLImpl) findViewObject("Base_UsuarioViewNoDML1");
    }


    public VistaObjeto getBase_ArchivoEventoView1() {
        return (VistaObjeto) findViewObject("Base_ArchivoEventoView1");
    }


    public VistaObjeto getBase_GrupoView1() {
        return (VistaObjeto) findViewObject("Base_GrupoView1");
    }


    public ArchivoViewImpl getBase_ArchivoView1() {
        return (ArchivoViewImpl) findViewObject("Base_ArchivoView1");
    }


    public ArchivoViewImpl getBase_ArchivoView2() {
        return (ArchivoViewImpl) findViewObject("Base_ArchivoView2");
    }


    public ViewLinkImpl getGrupoArchivoFkLink1() {
        return (ViewLinkImpl) findViewLink("GrupoArchivoFkLink1");
    }


    public VistaObjeto getBase_NotificacionView1() {
        return (VistaObjeto) findViewObject("Base_NotificacionView1");
    }


    public VistaObjeto getBase_NotificacionParametroView1() {
        return (VistaObjeto) findViewObject("Base_NotificacionParametroView1");
    }
}
