import java.sql.SQLException;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class FabricaConexiones {
   private String usuario = "fulltime";
   private String contrasenia = "disenio";
   private String db = "clinica";
   private static String host = "localhost";
   private String url = "jdbc:mysql://";
   private static String driver = "com.mysql.jdbc.Driver";
   private static Connection con = null;
   private static FabricaConexiones instancia = null;
   
   public static FabricaConexiones getInstancia(){
      if(con == null)
         instancia = new FabricaConexiones();
      return instancia;
   }
   
   public Connection getConexion() throws ClassNotFoundException{
      if(con == null){
         try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url + host + "/" + db, usuario, contrasenia);
            if(con != null)
               System.out.println("Conexion a la base de datos " + url + host + "/" + db + " :OK..");
            else
               System.out.println("Error al conectarse con la base de datos");
         }
         catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
         }
      }else 
         System.out.println("Retorno la conexion ya creada..");
      
      return con;
   }
}