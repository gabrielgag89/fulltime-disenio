// ConectorBD: ConectorBD.java
// Contiene los datos necesarios para entablar la conexión con la base de datos.

package persistencia.plantilla;

import java.sql.*;

/**
 * Contiene los datos necesarios para entablar la conexión con la base de datos.
 * @author Gabriel
 */
public class ConectorBD {
   /**
    * Nombre de la base de datos.
    */
   private static String bd = "agendav10";
   /**
    * Usuario para iniciar la conexión.
    */
   private static String login = "gato";
   /**
    * Contraseña para el usuario escojido.
    */
   private static String password = "gato";
   /**
    * Dirección del servidor.
    */
   private static String host = "127.0.0.1";
   /**
    * URL de la base de datos.
    */
   private static String url_bd = "jdbc:mysql://";
   /**
    * Ruta del driver JDBC.
    */
   private static String driver = "com.mysql.jdbc.Driver";
   /**
    * Declaración utilizada para realizar consultas.
    */
   private static Statement instruccion;
   /**
    * Instancia del conector a la base de datos.
    */
   private static ConectorBD instancia;
   /**
    * Conexión a la base de datos.
    */
   private static Connection conexionBD = null;

   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static ConectorBD getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new ConectorBD();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Establece la conexión con la base de datos.
    * @throws Exception 
    */
   public synchronized void establecerConexion() throws Exception {
      if (conexionBD == null) {
         try {
            Class.forName(driver);
            conexionBD = DriverManager.getConnection(url_bd+host+"/"+bd,login,password);
            instruccion = conexionBD.createStatement();
         }
         catch (SQLException e) {
            System.out.println (e.getMessage());
         } // fin de try... catch
      } // fin de if
   } // fin del método establecerConexion

   /**
    * Obtiene la conexión actual.
    * @return la conexión actual
    */
   public static Connection getConexion() {
      return conexionBD;
   } // fin del método getConexion

   /**
    * Cierra la conexión con la base de datos.
    */
   public synchronized static void cerrarConexionBD(){
      conexionBD = null;
      instancia = null;
   } // fin del método cerrarConexionBD

   /*
   public synchronized static ResultSet query(String consulta) throws SQLException{
      return instruccion.executeQuery(consulta);
   }

   public synchronized static boolean queryLMD(String consulta) throws SQLException{
      return instruccion.execute(consulta);
   }*/
} // fin de la clase ConectorBD