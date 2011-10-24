// FachadaPersistenciaInterna: FachadaPersistenciaInterna.java
// Segundo intermediario para no acoplar los expertos con la persistencia en la BDR.

package persistencia;

import java.util.List;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Connection;
import persistencia.plantilla.FabricaDeIntermediarios;
import persistencia.criterios.FabricaDeCriterios;
import persistencia.plantilla.ConectorBD;
import persistencia.criterios.Criterio;

/**
 * Segundo intermediario para no acoplar los expertos con la persistencia en la BDR.
 * @author Gabriel
 */
public class FachadaPersistenciaInterna {
   /**
    * Instancia de la fachada persistencia interna.
    */
   private static FachadaPersistenciaInterna instancia;

   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static FachadaPersistenciaInterna getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FachadaPersistenciaInterna();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Inicia la transacción con la BDR.
    * @return la conexión a utilizar
    * @throws SQLException
    * @throws Exception 
    */
   public static Connection iniciarTransaccion() throws SQLException, Exception{
      ConectorBD.getInstancia().establecerConexion();
      Connection con = (Connection) ConectorBD.getConexion();
      Statement stmt = (Statement) con.createStatement();
      stmt.execute("START TRANSACTION WITH CONSISTENT SNAPSHOT");
      
      return con;
   } // fin del método iniciarTransaccion

   /**
    * Termina la transacción con la BDR.
    * @throws SQLException 
    */
   public static void finalizarTransaccion() throws SQLException{
      Connection con = (Connection) ConectorBD.getConexion();
      Statement stmt = (Statement) con.createStatement();
      stmt.execute("COMMIT");
      ConectorBD.cerrarConexionBD();
   } // fin del método finalizarTransaccion

   /**
    * Solicita al intermediario, correspondiente al objeto a crear, que cree una nueva entidad.
    * @param entidad nombre de la entidad a crear
    * @return la entidad solicitada
    */
   public Object nuevaEntidad(String entidad){
      return FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).nuevaEntidad();
   } // fin del método nuevaEntidad

   /**
    * Solicita al intermediario, correspondiente al objeto a buscar, que recupere todas las 
    * entidades del tipo indicado.
    * @param objeto nombre de las entidades a recuperar
    * @return un vector que contiene las entidades recuperadas
    */
   public List buscar(String objeto) {
      return FabricaDeIntermediarios.getInstancia().getIntermediario(objeto).getColeccion();
   } // fin del método getColeccion

   /**
    * Solicita al intermediario, correspondiente al objeto a buscar, que obtenga la 
    * entidad solicitada, según su OID.
    * @param entidad nombre de la entidad a buscar
    * @param oid identificador del objeto que se quiere obtener
    * @return la entidad buscada
    */
   public Object buscar(String entidad, String oid){
      return FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).obtenerEntidad(oid);
   } // fin del método obtenerEntidad

   /**
    * Solicita al intermediario, correspondiente al objeto a persistir, que guarde el objeto 
    * recibido como parámetro.
    * @param entidad nombre de la entidad a guardar
    * @param objeto objeto a guardar
    */
   public void guardar(String entidad, Object objeto){
      FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).persistirEntidad(objeto);
   } // fin del método persistirEntidad
   
   /**
    * Solicita al intermediario, correspondiente al objeto a eliminar, que borre el objeto 
    * recibido como parámetro.
    * @param entidad nombre de la entidad a borrar
    * @param objeto objeto a borrar
    */
   public void eliminar(String entidad, Object objeto){
      FabricaDeIntermediarios.getInstancia().getIntermediario(entidad).eliminar(objeto);
   } // fin del método borrarEntidad

   /**
    * Crea el criterio solicitado.
    * @param atributo nombre del atributo a comparar
    * @param operador operador a utilizar en la comparación
    * @param valor valor con el que se comparará el atributo
    * @return el criterio solicitado
    */
   public Criterio getCriterio(String atributo, String operador, String valor){
      return FabricaDeCriterios.getInstancia().getCriterio(atributo,operador,valor);
   } // fin del método getCriterio

   /**
    * Crea un criterio compuesto, unidos con AND.
    * @param c vector de criterios a unir
    * @return un criterio listo para ser enviado a una consulta
    */
   public Criterio and(List c) {
      return FabricaDeCriterios.getInstancia().and(c);
   } // fin del método and

   /**
    * Crea un criterio compuesto de dos criterios, unidos por un AND.
    * @param c1 criterio 1
    * @param c2 criterio 2
    * @return un criterio compuesto, formado por {@code c1 AND c2}
    */
   public Criterio and(Criterio c1,Criterio c2){
      return  FabricaDeCriterios.getInstancia().and(c1,c2);
   } // fin del método and
} // fin de la clase FachadaPersistenciaInterna