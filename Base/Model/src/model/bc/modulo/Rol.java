  package model.bc.modulo;
  
  import java.sql.ResultSet;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import model.bc.ModuloImpl;
  import oracle.jbo.JboException;
  
  
  
  
  
  
  
  
  
  
  public class Rol
  {
    private static String SQL_ROL_ACTIVO = "select count(*) from GS_001_00.rol_usuario ru, GS_001_00.rol r, GS_001_00.usuario u where ru.id_rol = r.id_rol and ru.id_usuario = u.id_usuario and upper(r.tipo) = upper( ? ) and upper(u.nick) = upper( ? )";
  
    
    private static String SQL_ROLES_USUARIO = "select r.nombre from rol r where r.estado = 'A' and r.id_rol in (select id_rol from rol_usuario ru where id_usuario = (select id_usuario from usuario u  where upper(nick) = upper(?) ))";
  
  
  
  
  
  
  
  
  
    
    public static boolean validarRol(ModuloImpl moduloAplicacion, String nick, String role) {
      int respuestaInt = 0;
      
      Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_ROL_ACTIVO, new Object[] { role, nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        Logger.getLogger("global")
          .log(Level.SEVERE, "error " + moduloAplicacion.getBaseDML().getMensaje());
        
        throw new JboException("no consulta SQL 001");
      } 
      try {
        respuestaInt = ((Long)respuesta).intValue();
      } catch (Exception e) {
        throw new JboException("no convertie");
      } 
      
      return (respuestaInt > 0);
    }
  
  
  
  
  
  
  
  
    
    public static String rolesActivosPorUsuario(ModuloImpl moduloAplicacion, String nick) {
      String respuesta = "";
      ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL_ROLES_USUARIO, new Object[] { nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
      
      try {
        while (resultSet.next()) {
          respuesta = respuesta + " " + resultSet.getString(1);
        }
      } catch (Exception e) {
        throw new JboException("no legible");
      } 
      return respuesta.trim();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Manifiesto-001/Manifiesto-0012171724535622629922.war!/WEB-INF/lib/BaseModelADFLib-01.jar!/model/bc/modulo/Rol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */