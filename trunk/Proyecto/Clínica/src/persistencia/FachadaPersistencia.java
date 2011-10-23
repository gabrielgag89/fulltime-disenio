// FachadaPersistencia: FachadaPersistencia.java
// Primer intermediario para no acoplar los expertos con la persistencia en la BDR.

package persistencia;

import java.util.Vector;
import persistencia.criterios.Criterio;

/**
 * Primer intermediario para no acoplar los expertos con la persistencia en la BDR.
 * @author Gabriel
 */
public class FachadaPersistencia {
   /**
    * Instancia de la fachada persistencia.
    */
   private static FachadaPersistencia instancia;

   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static FachadaPersistencia getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FachadaPersistencia();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Solicita a la fachada interna que cree una nueva entidad.
    * @param entidad nombre de la entidad a crear
    * @return la entidad solicitada
    */
   public Object nuevaEntidad(String entidad){
      return FachadaPersistenciaInterna.getInstancia().nuevaEntidad(entidad);
   } // fin del método nuevaEntidad

   /**
    * Solicita a la fachada interna que recupere todas las entidades del tipo indicado.
    * @param entidad nombre de las entidades a recuperar
    * @return un vector que contiene las entidades recuperadas
    */
   public Vector getColeccion(String entidad) {
      return FachadaPersistenciaInterna.getInstancia().getColeccion(entidad);
   } // fin del método getColeccion
   
   /**
    * Solicita a la fachada interna que obtenga la entidad solicitada, según su OID.
    * @param entidad nombre de la entidad a buscar
    * @param ido identificador del objeto que se quiere obtener
    * @return la entidad buscada
    */
   public Object obtenerEntidad(String entidad, String ido){
      return FachadaPersistenciaInterna.getInstancia().obtenerEntidad(entidad, ido);
   } // fin del método obtenerEntidad

   /**
    * Solicita a la fachada interna que realice una búsqueda, de uno o varios objetos, por criterio.
    * @param objeto nombre del objeto a buscar
    * @param cc criterio con el que se realizará la búsqueda del objeto
    * @return un vector con los objetos buscados
    */
   public Vector getPorCriterio(String objeto, Criterio cc){
      return FachadaPersistenciaInterna.getInstancia().getPorCriterio(objeto,cc);
   } // fin del método getPorCriterio

   /**
    * Solicita a la fachada interna que guarde el objeto recibido como parámetro.
    * @param entidad nombre de la entidad a guardar
    * @param objeto objeto a guardar
    */
   public void persistirEntidad(String entidad , Object objeto){
      FachadaPersistenciaInterna.getInstancia().persistirEntidad(entidad,objeto);
   } // fin del método persistirEntidad
   
   /**
    * Solicita a la fachada interna que borre el objeto recibido como parámetro.
    * @param entidad nombre de la entidad a borrar
    * @param object objeto a borrar
    */
   public void borrarEntidad(String entidad, Object object){
      FachadaPersistenciaInterna.getInstancia().borrarEntidad(entidad, object);
   } // fin del método borrarEntidad

   /**
    * Solicita a la fachada interna que cree un criterio para la búsqueda en la base de datos.
    * @param atributo nombre del atributo a comparar
    * @param operador operador a utilizar en la comparación
    * @param valor valor con el que se comparará el atributo
    * @return el criterio solicitado
    */
   public Criterio getCriterio(String atributo, String operador, String valor){
      return  FachadaPersistenciaInterna.getInstancia().getCriterio(atributo,operador,valor);
   } // fin del método getCriterio

   /**
    * Solicita a la fachada interna que cree un criterio compuesto, unidos con AND.
    * @param c vector de criterios a unir
    * @return un criterio listo para ser enviado a una consulta
    */
   public Criterio and(Vector c) {
      return FachadaPersistenciaInterna.getInstancia().and(c);
   } // fin del método and

   /**
    * Solicita a la fachada interna que cree un criterio compuesto de dos criterios, unidos por 
    * un AND.
    * @param c1 criterio 1
    * @param c2 criterio 2
    * @return un criterio compuesto, formado por {@code c1 AND c2}
    */
   public Criterio and(Criterio c1,Criterio c2){
      return  FachadaPersistenciaInterna.getInstancia().and(c1,c2);
   } // fin del método and
} // fin de la clase FachadaPersistencia