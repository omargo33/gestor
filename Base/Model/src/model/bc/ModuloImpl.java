package model.bc;

import java.math.BigDecimal;

import java.sql.ResultSet;

import java.text.SimpleDateFormat;

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
import model.bc.modulo.Reporte;
import model.bc.modulo.Rol;
import model.bc.vista.ArchivoViewImpl;
import model.bc.vistaNoDML.InformacionViewNoDMLImpl;
import model.bc.vistaNoDML.MenusPermisosViewNoDMLImpl;
import model.bc.vistaNoDML.ParametroViewNoDMLRowImpl;
import model.bc.vistaNoDML.UsuarioViewNoDMLImpl;

import oracle.jbo.JboException;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;


public class ModuloImpl extends ModuloAplicacion implements Modulo {
    Map<String, ParametroViewNoDMLRowImpl> mapaParametro;

    public ModuloImpl() {
        setNombreBundle("model.ModelBundle");
        this.mapaParametro = new HashMap<>();
    }


    public int base_excelCrear(String tabla, String usuario, String usuarioPrograma) {
        int idArchivo = 0;
        String pattern = "yyyy-MM-dd-HH-mm-ssZ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String nombrePagina = "Excel-Prueba-" + usuario + "-" + simpleDateFormat.format(new Date()) + ".xls";

        ResultSet resultSet = getBaseDML().ejecutaConsulta("select * from MV_001_00.v_manifiesto vm", new Object[0]);
        if (getBaseDML().getMensaje() != null) {
            throw new JboException("no consulta SQL");
        }


        idArchivo =
            Reporte.crearReporteExcel(this, resultSet, nombrePagina, getBundle("modulo.indice", new Object[0]), tabla,
                                      usuario, usuarioPrograma);


        return idArchivo;
    }


    public int base_excelBuscarArchivos(String esquema, String tabla, String usuario) {
        Logger.getLogger("global").log(Level.SEVERE, "omar omar " + esquema + " " + tabla + " " + usuario);

        int idUsuario = Reporte.buscarUsuario(this, usuario);

        Logger.getLogger("global").log(Level.SEVERE, "omar omar idUsuario " + idUsuario + " " + esquema + " " + tabla);

        int idGrupo = Grupo.buscarGrupo(this, idUsuario, esquema, tabla);
        Archivo.buscarArchivosByIdGrupo(this, idGrupo);
        return idGrupo;
    }


    public String base_rolesByNick(String nick) {
        return Rol.rolesActivosPorUsuario(this, nick);
    }


    public boolean base_isUsuarioRol(String nick, String rol) {
        return Rol.validarRol(this, nick, rol);
    }


    public boolean base_isOnlyUsuarioRol(String nick, String rol, String indiceModulo) {
        return Rol.validarRolPorModulo(this, indiceModulo,rol, nick);        
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


    public void base_archivoBorrar(int idArchivo, String informacion, String usuario, String usuarioPrograma) {
        Archivo.borrarArchivo(this, idArchivo, informacion, usuario, usuarioPrograma);
    }


    public int base_archivoCrear(int idGrupo, String nombre, String nombreRamdon, String extension, String pathRelativo,
                                 int largo, String informacion, String usuario, String usuarioPrograma) {
        int idArchivo =
            Archivo.crearArchivo(this, idGrupo, nombre, nombreRamdon, extension, pathRelativo, largo, usuario,
                                 usuarioPrograma);


        Archivo.crearEventeoArchivo(this, idArchivo, informacion, "C", usuario, usuarioPrograma);
        return idArchivo;
    }


    public int base_crearNotificacion(int idFormato, int idServicio, String titulo, String contenido,
                                      String direccionEnvio, String anular, Date fechaEnvio, String usuario,
                                      String usuarioPrograma, Map<String, String> mapaParametros,
                                      Map<String, String> mapaAdjuntos) {
        int idNotificacion =
            Notificaciones.enviarNotificacion(this, idFormato, idServicio, titulo, contenido, direccionEnvio, anular,
                                              fechaEnvio, usuario, usuarioPrograma, mapaParametros, mapaAdjuntos);


        return idNotificacion;
    }


    public int base_archivoCrearEvento(int idArchivo, String evento, String informacion, String usuario,
                                       String usuarioPrograma) {
        return Archivo.crearEventeoArchivo(this, idArchivo, informacion, evento, usuario, usuarioPrograma);
    }


    private ParametroViewNoDMLRowImpl obtenerParametro(String indiceParametro) {
        ParametroViewNoDMLRowImpl parametroRespuesta = this.mapaParametro.get(indiceParametro);
        if (parametroRespuesta == null) {
            this.mapaParametro = Parametros.obtenerParametros(this, getBundle("modulo.indice", new Object[0]));
            parametroRespuesta = this.mapaParametro.get(indiceParametro);
            if (parametroRespuesta == null) {
                Logger.getLogger("global")
                    .log(Level.SEVERE,
                         "Error Indice=" + indiceParametro + "-" + getBundle("modulo.indice", new Object[0]));
                throw new JboException(getBundle("ModuloImpl.obtenerParametro.txt_1",
                                                 new Object[] { indiceParametro,
                                                                getBundle("modulo.indice", new Object[0]) }));
            }
        }
        return parametroRespuesta;
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


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/ModuloImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */