  package WEB;

import oracle.jbo.JboException;
  
  import java.sql.CallableStatement;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import modelAdministrativo.bc.AdministrativoModuloImpl;
  import oracle.jbo.JboException;
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class CodigoDefinidoUsuario
  {
    public static int unMovimiento(AdministrativoModuloImpl moduloAplicacion, int idCodigoDefinidoUsuario, boolean arriba) {
      String sql = arriba ? "CALL codigo_definido_usuario_subir(?,?)" : "CALL codigo_definido_usuario_bajar(?,?)";
      int respuesta = -1;
      
      try {
        moduloAplicacion
          .getDBTransaction(); CallableStatement st = moduloAplicacion.getDBTransaction().createCallableStatement(sql, -1);
        st.setInt(1, idCodigoDefinidoUsuario);
        st.registerOutParameter(2, -5);
        st.execute();
        respuesta = st.getInt(2);
      }
      catch (Exception e) {
        Logger.getLogger("global")
          .log(Level.SEVERE, moduloAplicacion
            .getBundle("000003", new Object[] {
                sql, "modelAdministrativo.bc.modulo", "unMovimiento", e.toString() }));
        throw new JboException(moduloAplicacion.getBundle("CodigoDefinidoUsuario.unMovimiento", new Object[0]));
      } 
      return respuesta;
    }
  
  
  
  
  
  
  
  
  
  
    
    public static int ejecutarExtremos(AdministrativoModuloImpl moduloAplicacion, int idCodigoDefinidoUsuario, int ubicacion) {
      String sql = "CALL codigo_definido_usuario_extremos(?,?,?)";
      int respuesta = -1;
      
      try {
        moduloAplicacion
          .getDBTransaction(); CallableStatement st = moduloAplicacion.getDBTransaction().createCallableStatement(sql, -1);
        st.setInt(1, idCodigoDefinidoUsuario);
        st.setInt(2, ubicacion);
        st.registerOutParameter(3, -5);
        st.execute();
        respuesta = st.getInt(3);
      }
      catch (Exception e) {
        Logger.getLogger("global")
          .log(Level.SEVERE, moduloAplicacion
            .getBundle("000003", new Object[] {
                sql, "modelAdministrativo.bc.modulo", "ejecutarExtremos", e.toString() }));
        throw new JboException(moduloAplicacion.getBundle("CodigoDefinidoUsuario.ejecutarExtremos", new Object[0]));
      } 
      return respuesta;
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Administrativo-001/Administrativo-0013319179167455158583.war!/WEB-INF/classes/modelAdministrativo/bc/modulo/CodigoDefinidoUsuario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */