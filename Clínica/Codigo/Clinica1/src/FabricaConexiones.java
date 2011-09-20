


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FabricaConexiones {
   private String usuario = "root";
   private String contrasenia = "root";
   private String db = "clinica";
   private String url = "jdbc:mysql://localhost:3306/"+db;
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
            Class.forName("org.gjt.mm.mysql.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, contrasenia);
            if(con != null)
               System.out.println("conexion a la base de datos "+ url+" :OK..");
            else
               System.out.println("Error al conectarse con la base de datos");
         } catch (SQLException ex) {
            Logger.getLogger(FabricaConexiones.class.getName()).log(Level.SEVERE, null, ex);
         }
      }else 
         System.out.println("Retorno la conexion ya creada..");
      
      return con;
   }
   
}
