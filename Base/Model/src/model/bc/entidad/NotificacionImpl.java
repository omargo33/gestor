package model.bc.entidad;

import model.bc.Entidad;
import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.TransactionEvent;







public class NotificacionImpl
  extends Entidad
{
  protected enum AttributesEnum
  {
      IdNotificacion,
      IdFormato,
      IdServicio,
      Titulo,
      Contenido,
      DireccionEnvio,
      Estado,
      Anular,
      FechaEnvio,
      Usuario,
      UsuarioFecha,
      UsuarioPrograma; private static AttributesEnum[] vals; static  {
        vals = null;
    }
    private static final int firstIndex = 0;
    
      protected int index() { return firstIndex() + ordinal(); }


    
      protected static final int firstIndex() { return 0; }


    
      protected static int count() { return firstIndex() + (staticValues()).length; }

    
    protected static final AttributesEnum[] staticValues() {
        if (vals == null) {
          vals = values();
      }
        return vals;
    }
  }

  
    public static final int IDNOTIFICACION = AttributesEnum.IdNotificacion.index();
    public static final int IDFORMATO = AttributesEnum.IdFormato.index();
    public static final int IDSERVICIO = AttributesEnum.IdServicio.index();
    public static final int TITULO = AttributesEnum.Titulo.index();
    public static final int CONTENIDO = AttributesEnum.Contenido.index();
    public static final int DIRECCIONENVIO = AttributesEnum.DireccionEnvio.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int ANULAR = AttributesEnum.Anular.index();
    public static final int FECHAENVIO = AttributesEnum.FechaEnvio.index();
    public static final int USUARIO = AttributesEnum.Usuario.index();
    public static final int USUARIOFECHA = AttributesEnum.UsuarioFecha.index();
    public static final int USUARIOPROGRAMA = AttributesEnum.UsuarioPrograma.index();













  
    public static Key createPrimaryKey(Integer idNotificacion) { return new Key(new Object[] { idNotificacion }); }





  
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("model.bc.entidad.Notificacion"); }






  
    public void lock() { super.lock(); }






  
  protected void doDML(int operation, TransactionEvent e) {
      super.doDML(operation, e);
      if (operation == 1)
        setAttribute(IDNOTIFICACION, Integer.valueOf(getUltimoId())); 
  }
}


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/entidad/NotificacionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */