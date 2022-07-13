  package WEB-INF.classes.modelLogin.bc.modulo;
  
  import java.sql.ResultSet;
  import java.sql.Timestamp;
  import java.util.ArrayList;
  import java.util.Calendar;
  import java.util.Date;
  import java.util.List;
  import model.utilidades.Atributos;
  import model.utilidades.GeneradorClaves;
  import model.utilidades.GeneradorEncripcion;
  import model.utilidades.estructuras.AccesoXML;
  import modelAuditoria.bc.entidad.AuditoriaImpl;
  import modelAuditoria.bc.modulo.estructura.Parametro;
  import modelLogin.bc.LoginModuloImpl;
  import modelLogin.bc.entidad.TokenServidorImpl;
  import modelLogin.bc.modulo.Login;
  import modelLogin.bc.vista.UsuarioViewRowImpl;
  import oracle.jbo.JboException;
  import oracle.jbo.Row;
  import oracle.jbo.VariableValueManager;
  import oracle.jbo.ViewCriteria;
  import oracle.jbo.ViewCriteriaManager;
  import oracle.jbo.server.ViewObjectImpl;
  
  
  
  
  
  
  
  
  
  
  
  
  
  public class Login
  {
    private static String SQL_CONTEXTO_INICIAL = "select xx.contexto from (select contexto from modulo where indice not in ('LG_001_00', 'US_001_00') and id_modulo in ( select DISTINCT id_modulo from menu where id_menu in ( select DISTINCT id_menu from permiso where id_rol in ( select DISTINCT id_rol from rol_usuario where id_usuario in ( select id_usuario from usuario where nick = ? ))))order by nombre) xx limit 1";
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    public static String validarUsuario(LoginModuloImpl moduloAplicacion, String nick, String password, String tokenGoogle, String ip, String userAgent, String usuarioPrograma) {
      String tokenApi = "";
      
      String SQL = "select * from (select u.id_usuario, u.nick, u.contador_ingreso, u.contador_fecha, tx.id_token, tx.token, tx.estado, tx.validador from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";
      
      String SQL_count = "select count(*) from (select  u.nick from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";
  
      
      String token = "";
      int contadorIngreso = 0;
      int idUsuario = 0;
      int idToken = 0;
      long contadorFecha = 0L;
      
      Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_count, new Object[] { nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
      
      if (String.valueOf(respuesta).compareTo("0") == 0) {
        auditarIngresosFallidos(moduloAplicacion, nick, ip, userAgent, usuarioPrograma);
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1", new Object[0]));
      } 
  
      
      ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL, new Object[] { nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
      
      try {
        while (resultSet.next()) {
          token = resultSet.getString("token");
          contadorIngreso = resultSet.getInt("contador_ingreso");
          idUsuario = resultSet.getInt("id_usuario");
          idToken = resultSet.getInt("id_token");
          if (resultSet.getTime("contador_fecha") == null) {
            contadorFecha = (new Date()).getTime(); continue;
          } 
          contadorFecha = resultSet.getTime("contador_fecha").getTime();
        }
      
      } catch (Exception e) {
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1", new Object[0]));
      } 
      
      String server = moduloAplicacion.base_obtenerParametroTexto01("100");
  
      
      double intentos = moduloAplicacion.base_obtenerParametroNumerico01("001").doubleValue();
      
      Date fecha = new Date();
      if (contadorIngreso >= intentos && fecha.getTime() < contadorFecha) {
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt2", new Object[0]));
      }
      
      if (contadorIngreso >= intentos && fecha.getTime() > contadorFecha) {
        actualizarContadores(moduloAplicacion, idUsuario, 0, usuarioPrograma);
        contadorIngreso = 0;
      } 
      
      String passwordEncript = GeneradorEncripcion.cifrarRealm(server, password);
      if (passwordEncript.compareToIgnoreCase(token) != 0) {
        actualizarContadores(moduloAplicacion, idUsuario, contadorIngreso + 1, usuarioPrograma);
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.validarUsuario_txt1", new Object[0]));
      } 
      actualizarContadores(moduloAplicacion, idUsuario, 0, usuarioPrograma);
      tokenApi = solicitarToken(moduloAplicacion, idToken, nick, password, usuarioPrograma);
  
      
      return tokenApi;
    }
  
  
  
  
  
  
  
    
    public static String contextoInicial(LoginModuloImpl moduloAplicacion, String nick) {
      String SQL = "select * from (select u.id_usuario, u.nick, u.contador_ingreso, u.contador_fecha, tx.id_token, tx.token, tx.estado, tx.validador from GS_001_00.usuario u, ( select t.* from GS_001_00.token t where t.tipo = 'C' and t.estado <> 'I' ) tx where u.id_usuario = tx.id_usuario and u.estado = 'A' ) xx where xx.nick = ?";
  
      
      String estado = "";
      String validador = "";
      
      ResultSet resultSet = moduloAplicacion.getBaseDML().ejecutaConsulta(SQL, new Object[] { nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        throw new JboException("no consulta SQL");
      }
      
      try {
        while (resultSet.next()) {
          estado = resultSet.getString("estado");
          validador = resultSet.getString("validador");
        } 
      } catch (Exception e) {
        throw new JboException("no de puede error 001");
      } 
      
      if ("C".compareTo(estado) == 0) {
        return moduloAplicacion.base_obtenerParametroTexto01("004");
      }
      
      if (validador.compareToIgnoreCase("changeServer") == 0) {
        return moduloAplicacion.base_obtenerParametroTexto01("004");
      }
      
      Object respuesta = moduloAplicacion.getBaseDML().ejecutaConsultaUnicoDato(SQL_CONTEXTO_INICIAL, new Object[] { nick });
      if (moduloAplicacion.getBaseDML().getMensaje() != null) {
        throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.contextoInicial_txt1", new Object[0]));
      }
      return String.valueOf(respuesta);
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static String solicitarToken(LoginModuloImpl moduloAplicacion, int idToken, String nick, String password, String usuarioPrograma) {
      String semilla = GeneradorClaves.getPassword("23456789ABCDEFGHJKMNPQRTUVWXYZabcdefghijkmnpqrtuvwxyz", 32);
      String base64 = "";
  
      
      Date fechaInicio = new Date();
  
      
      Date fechaFin = addMinutosToDate(fechaInicio, 1440);
      
      AccesoXML accesoXML = new AccesoXML();
      accesoXML.setFechaEmision(fechaInicio.getTime());
      accesoXML.setFechaValido(fechaFin.getTime());
      accesoXML.setSemilla(semilla);
      accesoXML.setUsuario(nick);
      accesoXML.setPassword(password);
      
      base64 = accesoXML.code();
      
      moduloAplicacion.auditoria_crearAcceso("validarUsuario()", semilla, base64, usuarioPrograma);
      crearTokenServidor(moduloAplicacion, idToken, GeneradorEncripcion.SHA1Weblogic12c(password), usuarioPrograma);
      
      return base64;
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static int crearTokenServidor(LoginModuloImpl moduloAplicacion, int idToken, String token, String usuarioPrograma) {
      int codigo = 0;
      boolean estado = true;
      ViewObjectImpl viewObjectImpl = moduloAplicacion.getTokenServidorView1();
      Row row = viewObjectImpl.createRow();
      
      row.setAttribute(TokenServidorImpl.IDTOKENSERVIDOR, Integer.valueOf(codigo));
      row.setAttribute(TokenServidorImpl.IDTOKEN, Integer.valueOf(idToken));
      row.setAttribute(TokenServidorImpl.TIPO, Atributos.stringLargo("JASCRIPT", "<NO APLICA>", 8));
      row.setAttribute(TokenServidorImpl.SERVIDOR, Atributos.stringLargo("WL12", "<NO APLICA>", 8));
      row.setAttribute(TokenServidorImpl.PASSWORD, Atributos.stringLargo(token, "<NO APLICA>", 512));
      row.setAttribute(TokenServidorImpl.USUARIOFECHA, Atributos.sysTime());
      row.setAttribute(TokenServidorImpl.USUARIOPROGRAMA, 
          Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
      
      row.validate();
      viewObjectImpl.insertRow(row);
      
      estado = moduloAplicacion.commitRollback(usuarioPrograma, "crearTokenServidor()");
      
      if (estado) {
        codigo = ((Integer)row.getAttribute(AuditoriaImpl.IDAUDITORIA)).intValue();
      } else {
        codigo = -1;
      } 
      return codigo;
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static void actualizarContadores(LoginModuloImpl moduloAplicacion, int idUsuario, int contador, String usuarioPrograma) {
      boolean estado = false;
      ViewObjectImpl viewObjectImpl = moduloAplicacion.getUsuarioView1();
      ViewCriteriaManager vcm = viewObjectImpl.getViewCriteriaManager();
      ViewCriteria vc = vcm.getViewCriteria("UsuarioViewCriteria");
      VariableValueManager vvm = vc.ensureVariableManager();
      vvm.setVariableValue("v_idUsuario", Integer.valueOf(idUsuario));
      viewObjectImpl.applyViewCriteria(vc, true);
      viewObjectImpl.executeQuery();
      
      while (viewObjectImpl.hasNext()) {
        Date date = new Date();
        if (contador > 0) {
  
          
          double horasAgragadas = moduloAplicacion.base_obtenerParametroNumerico01("002").doubleValue();
          date = addMinutosToDate(date, (int)(horasAgragadas * 60.0D));
        } 
        Timestamp ts = new Timestamp(date.getTime());
        
        UsuarioViewRowImpl usuarioViewRowImpl = (UsuarioViewRowImpl)viewObjectImpl.next();
        usuarioViewRowImpl.setContadorFecha(ts);
        usuarioViewRowImpl.setContadorIngreso(Integer.valueOf(contador));
        usuarioViewRowImpl.setUsuarioPrograma(Atributos.stringLargo(usuarioPrograma, "<NO APLICA>", 256));
        estado = moduloAplicacion.commitRollback("nick", "actualizarContadores()");
        if (!estado) {
          throw new JboException(moduloAplicacion.getBundle("modelLogin.bc.modulo.Login.actualizarContadores_txt1", new Object[0]));
        }
      } 
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    private static void auditarIngresosFallidos(LoginModuloImpl moduloAplicacion, String nick, String ip, String userAgent, String usuarioPrograma) {
      List<Parametro> parametros = new ArrayList<>();
      parametros.add(new Parametro("nick", "I", nick));
      parametros.add(new Parametro("ip", "I", ip));
      parametros.add(new Parametro("objeto", "I", usuarioPrograma));
      
      int idAuditoria = moduloAplicacion.auditoria_crearAuditoria(moduloAplicacion.getBundle("mudulo.nombre", new Object[0]), "validarUsuario()", "", usuarioPrograma);
      
      moduloAplicacion.auditoria_crearAuditoriaEvento(idAuditoria, userAgent, "S", 0);
      moduloAplicacion.auditoria_crearAuditoriaParametros(idAuditoria, parametros);
    }
  
  
  
  
  
  
  
  
  
  
    
    private static Date addMinutosToDate(Date fecha, int minutos) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha);
      calendar.add(12, minutos);
      return calendar.getTime();
    }
  }


/* Location:              /home/omarv/Documentos/jdeveloper/mywork122140/dup/Login-001/Login-0013288132286885651299.war!/WEB-INF/classes/modelLogin/bc/modulo/Login.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */