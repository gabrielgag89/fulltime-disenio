package persistencia;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorBD {
   private static String bd = "clinica";
   private static String login = "fulltime";
   private static String password = "disenio";
   private static String host = "localhost";
   private static String url_bd = "jdbc:mysql://";
   private static String driver = "com.mysql.jdbc.Driver";
   private static ConectorBD instancia;
   private static Connection conexion = null;
   
   private ConectorBD(){}
   
   public static ConectorBD getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new ConectorBD();
      
      return instancia;
   } // fin del método getInstancia
   
   public void establecerConexion() throws Exception {
      if (conexion == null) {
         try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url_bd+host+"/"+bd,login,password);
            conexion.setAutoCommit(false);
            System.out.println("Se logro la conexion con la base de datos "+url_bd+host+"/"+bd+".");
         }
         catch (SQLException e) {
            System.out.println (e.getMessage());
         } // fin de try... catch
      } // fin de if
   } // fin del método establecerConexion
   
   public Connection getConexion() {
      return conexion;
   } // fin del método getConexion
   
   public void cerrarConexion(){
      try {
         conexion.commit();
         conexion = null;
         instancia = null;
      } // fin del método cerrarConexionBD
      catch (SQLException ex) {
         Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
      }
   } // fin del método cerrarConexionBD
} // fin de la clase ConectorBD