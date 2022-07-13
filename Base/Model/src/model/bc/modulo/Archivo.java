package model.bc.modulo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bc.ModuloImpl;
import model.bc.VistaObjeto;
import model.bc.entidad.ArchivoEventoImpl;
import model.bc.entidad.ArchivoImpl;
import model.bc.vista.ArchivoViewImpl;
import model.utilidades.Atributos;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaManager;























public class Archivo
{
  public static final String EVENTO_CARGAR = "C";
  public static final String EVENTO_DESCARGAR = "D";
  public static final String EVENTO_ELIMINAR = "X";
  
  public static int crearEventeoArchivo(ModuloImpl moduloAplicacion, int idArchivo, String informacion, String tipo, String usuario, String usuarioPrograma) {
      int codigo = 0;
      boolean estado = true;
    
      VistaObjeto vistaObjeto = moduloAplicacion.getBase_ArchivoEventoView1();
      Row row = vistaObjeto.createRow();
      row.setAttribute(ArchivoEventoImpl.IDARCHIVO, Integer.valueOf(idArchivo));
      row.setAttribute(ArchivoEventoImpl.INFORMACION, Atributos.stringLargo(informacion, "<NO APLICA>", 512));
      row.setAttribute(ArchivoEventoImpl.TIPO, Atributos.stringLargo(tipo, "<NO APLICA>", 8));
      row.setAttribute(ArchivoEventoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
      row.setAttribute(ArchivoEventoImpl.USUARIOPROGRAMA, 
          Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
      row.validate();
      vistaObjeto.insertRow(row);
      estado = moduloAplicacion.commitRollback(Integer.valueOf(idArchivo), "crearEventeoArchivo");
      if (estado) {
        codigo = ((Integer)row.getAttribute(ArchivoEventoImpl.IDARCHIVOEVENTO)).intValue();
    } else {
        codigo = -1;
    } 
      return codigo;
  }
















  
  public static int crearArchivo(ModuloImpl moduloAplicacion, int idGrupo, String nombre, String nombreRamdon, String extension, String pathRelativo, int largo, String usuario, String usuarioPrograma) {
      int codigo = 0;
      boolean estado = true;
    
      ArchivoViewImpl archivoViewImpl = moduloAplicacion.getBase_ArchivoView1();
      Row row = archivoViewImpl.createRow();
      row.setAttribute(ArchivoImpl.IDGRUPO, Integer.valueOf(idGrupo));
      row.setAttribute(ArchivoImpl.NOMBRERAMDON, Atributos.stringLargo(nombreRamdon, "<NO APLICA>", 128));
      row.setAttribute(ArchivoImpl.NOMBRE, Atributos.stringLargo(nombre, "<NO APLICA>", 256));
      row.setAttribute(ArchivoImpl.EXTENSION, Atributos.stringLargo(extension, "<NO APLICA>", 32));
      row.setAttribute(ArchivoImpl.LARGO, Integer.valueOf(largo));
      row.setAttribute(ArchivoImpl.PATHRELATIVO, Atributos.stringLargo(pathRelativo, "<NO APLICA>", 512));
      row.setAttribute(ArchivoImpl.ESTADO, Atributos.stringLargo("A", "<NO APLICA>", 8));
      row.setAttribute(ArchivoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
      row.setAttribute(ArchivoImpl.USUARIOPROGRAMA, Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
      row.validate();
      archivoViewImpl.insertRow(row);
      estado = moduloAplicacion.commitRollback(nombre, "crearArchivo");
      if (estado) {
        codigo = ((Integer)row.getAttribute(ArchivoImpl.IDARCHIVO)).intValue();
    } else {
        codigo = -1;
    } 
    
      return codigo;
  }











  
  public static void borrarArchivo(ModuloImpl moduloAplicacion, int idArchivo, String informacion, String usuario, String usuarioPrograma) {
      boolean estado = true;
      Key key = new Key(new Object[] { Integer.valueOf(idArchivo) });
      Row[] rows = moduloAplicacion.getBase_ArchivoView1().findByKey(key, 1);
    
      for (Row r : rows) {
        r.setAttribute(ArchivoImpl.ESTADO, "X");
        r.setAttribute(ArchivoImpl.USUARIO, Atributos.stringLargo(usuario, "<NO APLICA>", 128));
        r.setAttribute(ArchivoImpl.USUARIOPROGRAMA, 
            Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
    } 
    
      estado = moduloAplicacion.commitRollback(Integer.valueOf(idArchivo), "crearArchivo");
    
      if (estado) {
        crearEventeoArchivo(moduloAplicacion, idArchivo, informacion, "X", usuario, usuarioPrograma);
    }
  }







  
  public static void buscarArchivosByIdGrupo(ModuloImpl moduloAplicacion, int idGrupo) {
      Logger.getLogger("global").log(Level.SEVERE, "omar omar idGrupo " + idGrupo);
    
      Timestamp fechaInicio = new Timestamp((new Date()).getTime() - 180000L);
      Timestamp fechaFin = new Timestamp((new Date()).getTime() + 300000L);
    
      ArchivoViewImpl archivoViewImpl = moduloAplicacion.getBase_ArchivoView1();
      ViewCriteriaManager vcm = archivoViewImpl.getViewCriteriaManager();
      ViewCriteria vc = vcm.getViewCriteria("ArchivoViewCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idGrupo", Integer.valueOf(idGrupo));
      vvm.setVariableValue("v_fechaInicio", fechaInicio);
      vvm.setVariableValue("v_fechaFin", fechaFin);
      archivoViewImpl.applyViewCriteria(vc);
      archivoViewImpl.executeQuery();
    
      Logger.getLogger("global").log(Level.SEVERE, "omar omar omar " + idGrupo);
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/modulo/Archivo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */