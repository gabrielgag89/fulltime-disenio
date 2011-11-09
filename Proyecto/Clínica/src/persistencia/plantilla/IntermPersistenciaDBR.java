// IntermPersistenciaDBR: IntermPersistenciaDBR.java
// Segundo nivel de los intermediarios de la persistencia, para bases de datos
// relacionales.

package persistencia.plantilla;


//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;
import persistencia.ConectorBD;

/**
 * Segundo nivel de los intermediarios de la persistencia, para bases de datos 
 * relacionales.
 * @author Gabriel
 */
public abstract class IntermPersistenciaDBR extends IntermediarioPersistencia{
    
    @Override
   public List<ObjetoPersistente> materializar(){
      try {
         String sql = select();
         ResultSet resultado = ejecutarSQL(sql);
         List<ObjetoPersistente> buscado = convertirAObjeto(resultado);
         
         return buscado;
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar() - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar
   
   @Override
   public ObjetoPersistente materializar(String oid){
      try {
         String sql = select(oid);
         ResultSet resultado = ejecutarSQL(sql);
         List<ObjetoPersistente> buscado = convertirAObjeto(resultado);
         
         return buscado.get(0);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar(String oid) - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar
   
   @Override
   public List<ObjetoPersistente> materializar(Criterio criterio){
      try {
         String sql = select(criterio);
         ResultSet resultado = ejecutarSQL(sql);
         
         return convertirAObjeto(resultado);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar(Criterio criterio) - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar
   
   @Override
   public void desmaterializar(ObjetoPersistente objeto){
      String sql;
      
      if(objeto.getNuevo())
         sql = insertar(objeto);
      else
         sql = actualizar(objeto);
      
      try {
         ejecutarSQL(sql);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-desmaterializar(ObjetoPersistente objeto) - SQLException: " + ex.getMessage());
      }
   } // fin del método desmaterializar
   
   @Override
   public ObjetoPersistente obtenerNuevaEntidad(){
      ObjetoPersistente objPers = nuevo();
      objPers.setOid(objPers.generarOid());
      
      return objPers;
   } // fin del método obtenerNuevaEntidad

   private ResultSet ejecutarSQL(String sql) throws SQLException{
      return ConectorBD.getConexion().prepareStatement(sql).executeQuery();
   } // fin del método ejecutarSQL
   
   public abstract String select(Criterio criterio); // método a implementar
   
   public abstract String select(String oid); // método a implementar
   
   public abstract String select(); // método a implementar
   
   public abstract String insertar(Object objeto); // método a implementar
   
   public abstract String actualizar(Object objeto); // método a implementar
   
   public abstract List<ObjetoPersistente> convertirAObjeto(ResultSet resultado); // método a implementar
   
   public abstract ObjetoPersistente nuevo(); // método a implementar
   

} // fin de la clase IntermPersistenciaDBR