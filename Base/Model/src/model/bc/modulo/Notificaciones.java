package model.bc.modulo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import model.bc.ModuloImpl;
import model.bc.VistaObjeto;
import model.bc.entidad.NotificacionImpl;
import model.bc.entidad.NotificacionParametroImpl;
import model.utilidades.Atributos;
import oracle.jbo.Row;























public class Notificaciones
{
  public static final String NOTIFICACION_ANULAR = "S";
  public static final String NOTIFICACION_NO_ANULAR = "N";
  public static final String PARAMETRO = "P";
  public static final String ADJUNTO = "ADJ";
  
  public static int enviarNotificacion(ModuloImpl moduloAplicacion, int idFormato, int idServicio, String titulo, String contenido, String direccionEnvio, String anular, Date fechaEnvio, String usuario, String usuarioPrograma, Map<String, String> mapaParametros, Map<String, String> mapaAdjuntos) {
      int idNotificacion = crearNotificacion(moduloAplicacion, idFormato, idServicio, titulo, contenido, direccionEnvio, anular, fechaEnvio, usuario, usuarioPrograma);

    
      if (idNotificacion < 0) {
        return idNotificacion;
    }
    
      if (mapaParametros != null) {
        for (Map.Entry<String, String> entry : mapaParametros.entrySet()) {
          crearParametro(moduloAplicacion, idNotificacion, entry.getKey(), entry.getValue(), "P");
      }
    }
    
      if (mapaAdjuntos != null) {
        for (Map.Entry<String, String> entry : mapaAdjuntos.entrySet()) {
          crearParametro(moduloAplicacion, idNotificacion, entry.getKey(), entry.getValue(), "ADJ");
      }
    }



    
      return idNotificacion;
  }











  
  private static int crearParametro(ModuloImpl moduloAplicacion, int idNotificacion, String llave, String valor, String tipo) {
      int codigo = -1;
      VistaObjeto vistaObjeto = moduloAplicacion.getBase_NotificacionParametroView1();
      Row row = vistaObjeto.createRow();
    
      row.setAttribute(NotificacionParametroImpl.IDNOTIFICACION, Integer.valueOf(idNotificacion));
      row.setAttribute(NotificacionParametroImpl.LLAVE, Atributos.stringLargo(llave, "<NO APLICA>", 64));
      row.setAttribute(NotificacionParametroImpl.VALOR, Atributos.stringLargo(valor, "<NO APLICA>", 512));
      row.setAttribute(NotificacionParametroImpl.TIPO, Atributos.stringLargo(tipo, "<NO APLICA>", 8));
      row.validate();
      vistaObjeto.insertRow(row);
      if (moduloAplicacion.commitRollback(Integer.valueOf(codigo), "crearParametro")) {
        codigo = ((Integer)row.getAttribute(NotificacionParametroImpl.IDNOTIFICACIONPARAMETRO)).intValue();
    }
      return codigo;
  }

















  
  private static int crearNotificacion(ModuloImpl moduloAplicacion, int idFormato, int idServicio, String titulo, String contenido, String direccionEnvio, String anular, Date fechaEnvio, String usuario, String usuarioPrograma) {
      int codigo = -1;
      Timestamp time = new Timestamp(fechaEnvio.getTime());
      VistaObjeto vistaObjeto = moduloAplicacion.getBase_NotificacionView1();
      Row row = vistaObjeto.createRow();
    
      row.setAttribute(NotificacionImpl.IDFORMATO, Integer.valueOf(idFormato));
      row.setAttribute(NotificacionImpl.IDSERVICIO, Integer.valueOf(idServicio));
      row.setAttribute(NotificacionImpl.TITULO, Atributos.stringLargo(titulo, "<NO APLICA>", 256));
      row.setAttribute(NotificacionImpl.CONTENIDO, Atributos.stringLargo(contenido, "<NO APLICA>", 4096));
      row.setAttribute(NotificacionImpl.DIRECCIONENVIO, 
          Atributos.stringLargo(direccionEnvio, "<NO APLICA>", 256));
      row.setAttribute(NotificacionImpl.ESTADO, Atributos.stringLargo("P", "<NO APLICA>", 8));
      row.setAttribute(NotificacionImpl.ANULAR, Atributos.stringLargo(anular, "<NO APLICA>", 8));
      row.setAttribute(NotificacionImpl.FECHAENVIO, time);
      row.setAttribute(NotificacionImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
      row.setAttribute(NotificacionImpl.USUARIOPROGRAMA, 
          Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
      row.validate();
      vistaObjeto.insertRow(row);
      
    
      if (moduloAplicacion.commitRollback(Integer.valueOf(codigo), "crearNotificacion")) {
        codigo = ((Integer)row.getAttribute(NotificacionImpl.IDNOTIFICACION)).intValue();
    }
    
      return codigo;
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/modulo/Notificaciones.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */