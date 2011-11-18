// ConectorBD: ConectorBD.java
// Contiene los datos necesarios para entablar la conexión con la base de datos.

package persistencia;

import java.sql.*;

/**
 * Contiene los datos necesarios para entablar la conexión con la base de datos.
 * @author Gabriel
 */
public class ConectorBD {
   private static String bd = "clinica";
   private static String login = "fulltime";
   private static String password = "disenio";
   private static String host = "localhost";
   private static String url_bd = "jdbc:mysql://";
   private static String driver = "com.mysql.jdbc.Driver";
   private static ConectorBD instancia;
   private static Connection conexionBD = null;
   
   public static ConectorBD getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new ConectorBD();
      
      return instancia;
   } // fin del método getInstancia
   
   public synchronized void establecerConexion() throws Exception {
      if (conexionBD == null) {
         try {
            Class.forName(driver);
            conexionBD = DriverManager.getConnection(url_bd+host+"/"+bd,login,password);
            System.out.println("Se logro la conexion con la base de datos "+url_bd+host+"/"+bd+".");
         }
         catch (SQLException e) {
            System.out.println (e.getMessage());
         } // fin de try... catch
      } // fin de if
   } // fin del método establecerConexion
   
   public static Connection getConexion() {
      return conexionBD;
   } // fin del método getConexion
   
   public synchronized static void cerrarConexionBD(){
      conexionBD = null;
      instancia = null;
   } // fin del método cerrarConexionBD
} // fin de la clase ConectorBD