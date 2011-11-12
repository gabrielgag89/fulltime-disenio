// Cache: Cache.java
// Caché en la que se almacenarán las entidades que se han buscado, de manera de que no se
// hagan llamadas innecesarias a la persistencia.

package persistencia.plantilla;

import java.util.HashMap;
import persistencia.proxy.ObjetoPersistente;

/**
 * Caché en la que se almacenarán las entidades que se han buscado, de manera de que no se 
 * hagan llamadas innecesarias a la persistencia.
 * @author Gabriel
 */
public class Cache {
   private static Cache instancia;
   private HashMap objetos = new HashMap();
   
   public static Cache getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new Cache();
      
      return instancia;
   } // fin del método getInstancia
   
   public void agregar(String oid, Object objeto){
      objetos.put(oid, objeto);
   } // fin del método agregar
   
   public boolean existe(String oid) {
      return objetos.containsKey(oid);
   } // fin del método existe
   
   public void quitar(String oid) {
      objetos.remove(oid);
   } // fin del método quitar
   
   public ObjetoPersistente enCache(String oid){
      if (existe(oid))
         return (ObjetoPersistente) objetos.get(oid);
      else 
         return null;
   } // fin del método enCache
} // fin de la clase Cache