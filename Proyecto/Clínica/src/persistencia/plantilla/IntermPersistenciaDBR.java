// IntermPersistenciaDBR: IntermPersistenciaDBR.java
// Segundo nivel de los intermediarios de la persistencia, para bases de datos
// relacionales.

package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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
      String sql = select();
      ResultSet resultado = ejecutarSQL(sql);

      return convertirAObjeto(resultado);
   } // fin del método materializar
   
   @Override
   public ObjetoPersistente materializar(String oid){
      String sql = select(oid);
      ResultSet resultado = ejecutarSQL(sql);
      List<ObjetoPersistente> buscado = convertirAObjeto(resultado);

      return buscado.get(0);
   } // fin del método materializar
   
   @Override
   public List<ObjetoPersistente> materializar(Criterio criterio){
      String sql = select(criterio);
      ResultSet resultado = ejecutarSQL(sql);

      return convertirAObjeto(resultado);
   } // fin del método materializar
   
   @Override
   public void desmaterializar(ObjetoPersistente objeto){
      String sql;
      
      if(objeto.getNuevo()){
         sql = insertar(objeto);
         ejecutarSQLSave(sql);
      }
      else{
         sql = actualizar(objeto);
         ejecutarSQLSave(sql);
      }
          
   } // fin del método desmaterializar
   
   @Override
   public ObjetoPersistente obtenerNuevaEntidad(){
      ObjetoPersistente objPers = nuevo();
      objPers.setOid(objPers.generarOid());
      
      return objPers;
   } // fin del método obtenerNuevaEntidad

   private void ejecutarSQLSave(String sql){
      try{
         System.out.println(sql);
         PreparedStatement consulta = ConectorBD.getConexion().prepareStatement(sql);

         consulta.execute();
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-ejecutarSQL(String sql) - SQLException: " + ex.getMessage());
      }
   } // fin del método ejecutarSQLSave

   private ResultSet ejecutarSQL(String sql){
      try{
         System.out.println(sql);
         PreparedStatement consulta = ConectorBD.getConexion().prepareStatement(sql);

         return consulta.executeQuery(sql);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-ejecutarSQL(String sql) - SQLException: " + ex.getMessage());
         return null;
      }
   } // fin del método ejecutarSQL
   
   public abstract String select(); // método a implementar
   
   public abstract String select(Criterio criterio); // método a implementar
   
   public abstract String select(String oid); // método a implementar
   
   public abstract String insertar(Object objeto); // método a implementar
   
   public abstract String actualizar(Object objeto); // método a implementar
   
   public abstract List<ObjetoPersistente> convertirAObjeto(ResultSet resultado); // método a implementar
   
   public abstract ObjetoPersistente nuevo(); // método a implementar
} // fin de la clase IntermPersistenciaDBR