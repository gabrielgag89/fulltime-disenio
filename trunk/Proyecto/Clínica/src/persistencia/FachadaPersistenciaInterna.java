// FachadaPersistenciaInterna: FachadaPersistenciaInterna.java
// 

package persistencia;

import java.util.List;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import persistencia.plantilla.FabricaDeIntermediarios;
import persistencia.criterios.FabricaDeCriterios;
import persistencia.criterios.Criterio;

/**
 * Segundo intermediario para no acoplar los expertos con la persistencia en la BDR.
 * @author Gabriel
 */
public class FachadaPersistenciaInterna {
   private static FachadaPersistenciaInterna instancia;
   
   public static FachadaPersistenciaInterna getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FachadaPersistenciaInterna();
      
      return instancia;
   } // fin del método getInstancia
   
   public static Connection iniciarTransaccion() throws SQLException, Exception{
      ConectorBD.getInstancia().establecerConexion();
      Connection con = (Connection) ConectorBD.getConexion();
      Statement stmt = (Statement) con.createStatement();
      stmt.execute("START TRANSACTION WITH CONSISTENT SNAPSHOT");
      
      return con;
   } // fin del método iniciarTransaccion
   
   public static void finalizarTransaccion() throws SQLException{
      Connection con = (Connection) ConectorBD.getConexion();
      Statement stmt = (Statement) con.createStatement();
      stmt.execute("COMMIT");
      ConectorBD.cerrarConexionBD();
   } // fin del método finalizarTransaccion
   
   public Object nuevaEntidad(String entidad){
      return FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).nuevaEntidad();
   } // fin del método nuevaEntidad
   
   public List buscar(String objeto, Criterio cc) {
      return FabricaDeIntermediarios.getInstancia().getIntermediario(objeto).buscar(cc);
   } // fin del método getColeccion
   
   public Object buscar(String entidad, String oid){
      return FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).buscar(oid);
   } // fin del método obtenerEntidad
   
   public void guardar(String entidad, Object objeto){
      FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).guardar(objeto);
   } // fin del método persistirEntidad
   
   public Criterio getCriterio(String atributo, String operador, String valor){
      return FabricaDeCriterios.getInstancia().getCriterio(atributo,operador,valor);
   } // fin del método getCriterio
   
   public Criterio and(List c) {
      return FabricaDeCriterios.getInstancia().and(c);
   } // fin del método and
   
   public Criterio and(Criterio c1,Criterio c2){
      return  FabricaDeCriterios.getInstancia().and(c1,c2);
   } // fin del método and
} // fin de la clase FachadaPersistenciaInterna