package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {
        private static String bd = "clinica";
        private static String login = "root";
        private static String password = "";
        private static String host = "localhost";
        private static String url_bd = "jdbc:mysql://";
        private static String driver = "com.mysql.jdbc.Driver";
        private static Statement instruccion;
	private static ConectorBD instancia;
	private static Connection conexionBD = null;

	public static ConectorBD getInstance(){
            if (instancia == null) {
                instancia = new ConectorBD();
            }
            return instancia;
	}

	public synchronized static void cerrarConexionBD(){
            conexionBD = null;
            //instancia = null;
	}

        public synchronized void establecerConexion() throws Exception {
            if (conexionBD == null) {
                try {
                    Class.forName(driver);
                    conexionBD = DriverManager.getConnection(url_bd+host+"/"+bd,login,password);
                    instruccion = conexionBD.createStatement();
                    System.out.println("Se logro la conexion con la base de datos "+url_bd+host+"/"+bd+".");
                }
                catch (SQLException e) {
                    System.out.println (e.getMessage());
                }
            }
	}

        public static Connection getConexion() {
            return conexionBD;
        }

        /*
	public synchronized static ResultSet query(String consulta) throws SQLException{
		return instruccion.executeQuery(consulta);
	}

	public synchronized static boolean queryLMD(String consulta) throws SQLException{
		return instruccion.execute(consulta);
        }*/
        
}