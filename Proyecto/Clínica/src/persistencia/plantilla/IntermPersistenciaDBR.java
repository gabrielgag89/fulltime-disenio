// IntermPersistenciaDBR: IntermPersistenciaDBR.java
// Segundo nivel de los intermediarios de la persistencia relacional.

package persistencia.plantilla;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

/**
 * Segundo nivel de los intermediarios de la persistencia relacional.
 * @author Gabriel
 */
public abstract class IntermPersistenciaDBR extends IntermediarioPersistencia{
   /**
    * Crea una nueva entidad del tipo correspondiente.
    * @return la nueva entidad creada
    */
   @Override
   public Object obtenerNuevaEntidad(){
      ObjetoPersistente OP = (ObjetoPersistente) nuevo();
      OP.setOid(OP.generarOid());
      OP.setNuevo(true);
      
      return OP;
   } // fin del método obtenerNuevaEntidad

   /**
    * Recupera todas las entidades del tipo correspondiente.
    * @return un vector con los objetos del tipo correspondiente recuperados
    */
   @Override
   public Object materializar(){
      try {
         PreparedStatement psm = (PreparedStatement) SQLSelect(ConectorBD.getConexion());
         psm.execute();
         ResultSet filas = psm.getResultSet();
         return convertirAObjeto(filas);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar() - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar

   /**
    * Recupera la entidad correspondiente al identificador recibido.
    * @param id identificador de la entidad a recuperar
    * @return la entidad materializada
    */
   @Override
   public Object materializar(String id){
      try {
         PreparedStatement psm = (PreparedStatement) SQLSelect(id, ConectorBD.getConexion());
         psm.execute();
         ResultSet filas = psm.getResultSet();
         Vector buscado = (Vector) convertirAObjeto(filas);
         return buscado.firstElement();
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar(String id) - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar

   /**
    * Recupera las entidades que contienen la clave foránea indicada.
    * @param idForaneo nombre del atributo que es clave foránea
    * @param id clave foránea
    * @return un vector con los objetos que tienen la clave foránea recibida
    */
   @Override
   public Object materializar(String idForaneo, String id){
      try {
         PreparedStatement psm = (PreparedStatement) SQLSelect(idForaneo, id, ConectorBD.getConexion());
         psm.execute();
         ResultSet filas = psm.getResultSet();
         return convertirAObjeto(filas);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar(String idForaneo, String id) - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar

   /**
    * Recupera las entidades que cumplen con el criterio recibido.
    * @param criterio criterio mediante el cuál se buscarán las entidades
    * @return un vector con los objetos que cumplen el criterio recibido
    */
   @Override
   public Object materializar(Criterio criterio){
      try {
         PreparedStatement psm = (PreparedStatement) SQLSelect(criterio, ConectorBD.getConexion());
         psm.execute();
         ResultSet filas = psm.getResultSet();
         return convertirAObjeto(filas);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar(Criterio criterio) - SQLException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método materializar

   /**
    * Elimina de la BDR el objeto recibido.
    * @param objeto onjeto a eliminar
    */
   @Override
   public void eliminar(Object objeto){
      try {
         PreparedStatement psm = (PreparedStatement) SQLEliminar(objeto, ConectorBD.getConexion());
         psm.execute();
         super.eliminar(objeto);
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-materializar - SQLException: " + ex.getMessage());
      } // fin de try... catch
   } // fin del método eliminar
   
   /**
    * Si el objeto es nuevo, lo inserta en la BD, sino lo actualiza.
    * @param objeto objeto a persistir
    */
   @Override
   public void desmaterializar(ObjetoPersistente objeto){
      if(objeto.getNuevo())
         insertar(objeto);
      else
         actualizar(objeto);
   } // fin del método desmaterializar

   /**
    * Inserta el objeto recibido en la BDR.
    * @param objeto objeto a insertar
    */
   @Override
   public void insertar(Object objeto){
      try {
         PreparedStatement psm = (PreparedStatement) SQLInsertar(objeto, ConectorBD.getConexion());
         psm.execute();
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-insertar-SQLException: " + ex.getMessage());
      } // fin de try... catch
   } // fin del método insertar

   /**
    * Actualiza el objeto recibido en la BDR.
    * @param objeto objeto a actualizar
    */
   @Override
   public void actualizar(Object objeto){
      try {
         PreparedStatement psm = (PreparedStatement) SQLActualizar(objeto, ConectorBD.getConexion());
         psm.executeUpdate();
      }
      catch (SQLException ex) {
         System.out.println("IntermPersistenciaDBR-actualizar-SQLException: " + ex.getMessage());
      } // fin de try... catch
   } // fin del método actualizar
   
   /**
    * Actualiza los datos del objeto recibido en la base de datos.
    * @param objeto objeto al que se le actualizarán sus datos
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLActualizar(Object objeto, Connection conexion); // método a implementar
   
   /**
    * Inserta el objeto recibido en la base de datos.
    * @param objeto objeto que se insertará en la base de datos
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLInsertar(Object objeto, Connection conexion); // método a implementar
   
   /**
    * Elimina el objeto recibido de la base de datos.
    * @param objeto objeto que se eliminará de la base de datos
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLEliminar(Object objeto, Connection conexion); // método a implementar
   
   /**
    * Recupera todos los objetos del tipo correspondiente.
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLSelect(Connection conexion); // método a implementar
   
   /**
    * Recupera todos los objetos del tipo correspondiente que cumplen 
    * con el criterio recibido.
    * @param criterio criterio para realizar la búsqueda
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLSelect(Criterio criterio, Connection conexion); // método a implementar
   
   /**
    * Recupera el objeto cullo identificador corresponde con el recibido.
    * @param id identificador del teléfono a buscar
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLSelect(String id, Connection conexion); // método a implementar
   
   /**
    * Recupera los objetos que tienen como clave foránea el identificador recibido.
    * @param idClase nombre del atributo que es clave foránea
    * @param id clave foránea
    * @param conexion conexión actual con la BDR
    * @return la declaración que se utilizará en la consulta
    */
   public abstract PreparedStatement SQLSelect(String idClase, String id, Connection conexion); // método a implementar
   
   /**
    * Combierte el resultado de la búsqueda en la BDR en objetos.
    * @param filas resultado de la consulta a la base de datos
    * @return un vector con los objetos recuperados
    */
   public abstract Object convertirAObjeto(ResultSet filas); // método a implementar
   
   /**
    * Crea el nuevo objeto solicitado.
    * @return el nuevo objeto solicitado
    */
   public abstract ObjetoPersistente nuevo(); // método a implementar
} // fin de la clase IntermPersistenciaDBR