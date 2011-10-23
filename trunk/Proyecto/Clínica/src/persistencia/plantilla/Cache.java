// Cache: Cache.java
// Caché en la que se almacenarán las entidades que se han buscado, de manera de que no se
// hagan llamadas innecesarias a la persistencia.

package persistencia.plantilla;

import java.util.HashMap;

/**
 * Caché en la que se almacenarán las entidades que se han buscado, de manera de que no se 
 * hagan llamadas innecesarias a la persistencia.
 * @author Gabriel
 */
public class Cache {
   /**
    * Instancia de la caché.
    */
   private static Cache instancia;
   /**
    * Mapa de hash que contendrá las referencias a los pbjetos guardados en memoria
    * y sus identificadores.
    */
   private HashMap objetos = new HashMap();
   
   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static Cache getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new Cache();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Agrega el objeto y su identificador al mapa de hash.
    * @param id identificador del objeto a guardar
    * @param objeto objeto a guardar
    */
   public void agregarEntidad(String id, Object objeto){
      objetos.put(id.toString(), objeto);
   } // fin del método agregarEntidad

   /**
    * Comprueba si ya existe almacenado el identificador recibido.
    * @param id identificador a comprobar
    * @return {@code true} - si el identificador ya existe<br>
    * {@code false} - si el identificador no existe
    */
   public boolean existe(String id) {
      return objetos.containsKey(id.toString());
   } // fin del método existe

   /**
    * Quita del mapa de hash el objeto correspondiente al identificador recibido.
    * @param id identificador del objeto a quitar
    */
   public void quitarEntidad(String id) {
      objetos.remove(id.toString());
   } // fin del método quitarEntidad

   /**
    * Comprueba si existe el objeto, que tiene el identificador recibido, en el mapa de hash, 
    * y si existe lo devuelve.
    * @param id identificador del objeto buscado
    * @return el objeto buscado, si se encuentra en el mapa de hash<br>
    * {@code null} - si el objeto no se encuentra en el mapa de hash
    */
   public Object enCache(String id){
      if (existe(id))
         return objetos.get(id.toString());
      else 
         return null;
   } // fin del método enCache
} // fin de la clase Cache