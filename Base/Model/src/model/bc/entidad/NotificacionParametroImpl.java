  package model.bc.entidad;
  
  import model.bc.Entidad;
  import oracle.jbo.Key;
  import oracle.jbo.server.EntityDefImpl;
  import oracle.jbo.server.TransactionEvent;
  
  
  
  
  
  
  
  public class NotificacionParametroImpl
    extends Entidad
  {
    protected enum AttributesEnum
    {
      IdNotificacionParametro,
      IdNotificacion,
      Llave,
      Valor,
      Tipo; private static AttributesEnum[] vals; static  {
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
  
    
    public static final int IDNOTIFICACIONPARAMETRO = AttributesEnum.IdNotificacionParametro.index();
    public static final int IDNOTIFICACION = AttributesEnum.IdNotificacion.index();
    public static final int LLAVE = AttributesEnum.Llave.index();
    public static final int VALOR = AttributesEnum.Valor.index();
    public static final int TIPO = AttributesEnum.Tipo.index();
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static Key createPrimaryKey(Integer idNotificacionParametro) { return new Key(new Object[] { idNotificacionParametro }); }
  
  
  
  
  
    
    public static synchronized EntityDefImpl getDefinitionObject() { return EntityDefImpl.findDefObject("model.bc.entidad.NotificacionParametro"); }
  
  
  
  
  
  
    
    public void lock() { super.lock(); }
  
  
  
  
  
  
    
    protected void doDML(int operation, TransactionEvent e) {
      if (operation == 3) {
        noBorrar(new int[] { IDNOTIFICACION });
      }
      super.doDML(operation, e);
      if (operation == 1)
        setAttribute(IDNOTIFICACIONPARAMETRO, Integer.valueOf(getUltimoId())); 
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/entidad/NotificacionParametroImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */