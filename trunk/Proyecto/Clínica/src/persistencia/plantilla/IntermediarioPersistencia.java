// IntermediarioPersistencia: IntermediarioPersistencia.java
// Primer nivel de los intermediarios de la persistencia relacional.

package persistencia.plantilla;

import java.util.Vector;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

/**
 * Primer nivel de los intermediarios de la persistencia relacional.
 * @author Gabriel
 */
public abstract class IntermediarioPersistencia {
   /**
    * Llama al método {@code obtenerNuevaEntidad} para que cree una entidad nueva.
    * @return devuelve la nueva entidad solicitada
    */
   public Object nuevaEntidad(){
      return obtenerNuevaEntidad();
   } // fin del método nuevaEntidad

   /**
    * Materializa todos los objetos del tipo correspondiente.
    * @return un vector con todas las entidades del tipo correspondiente
    */
   public Vector getColeccion(){
      // recupera de la BD las entidades del tipo correspondiente
      Vector buscados = (Vector) materializar();
      
      // si no se encontraron entidades del tipo correspondiente, el vector estará vacío
      if(buscados.isEmpty())
         return buscados;
      
      // si se encontró más de una entidad, se combierte el vector en un arreglo de Object, para
      // recorrerlo y guardarlos en la caché como Objetos Persistentes
      if (buscados.size() > 1){
         Object[] arreglo = buscados.toArray();
         
         for(int i = 0; i < arreglo.length; i++){
            Cache.getInstancia().agregarEntidad(((ObjetoPersistente) arreglo[i]).getOid(), arreglo[i]);
            ((ObjetoPersistente) arreglo[i]).setNuevo(false);
         } // fin de for
      }
      // sino, si se encontró sólo una entidad, se toma el primer elemento del vector y se guarde
      // en la caché como un Objeto Persistente
      else{
         Cache.getInstancia().agregarEntidad(((ObjetoPersistente) buscados.firstElement()).getOid(), buscados.firstElement());
         ((ObjetoPersistente) buscados.firstElement()).setNuevo(false);
      } // fin de if
      
      return buscados;
   } // fin del método getColeccion

   /**
    * Materializa el objeto buscado por su identificador.
    * @param id identificador del objeto buscado
    * @return el objeto buscado
    */
   public Object obtenerEntidad(String id){
      // comprueba si el objeto se encuentra en la caché
      Object buscado = Cache.getInstancia().enCache(id);
      
      // si no se encuentra en la caché, lo recupera de la BD
      if(buscado == null) {
         buscado =  materializar(id);
         Cache.getInstancia().agregarEntidad(id, buscado);
         ((ObjetoPersistente) buscado).setNuevo(false);
      } // fin de if
      
      return buscado;
   } // fin del método obtenerEntidad

   /**
    * Materializa el objeto buscado por un identificador externo de éste.
    * @param idForaneo nombre del atributo que es clave externa
    * @param id clave externa
    * @return el objeto buscado
    */
   public Object obtenerEntidad(String idForaneo, String id){
      // busca todos los objetos que tienen la clave externa de la entidad recibida como parámetro
      Vector buscados = (Vector) materializar(idForaneo, id);
      // combierte el vector en un arreglo para recorrerlo
      Object[] arreglo = buscados.toArray();
      
      for(int i = 0; i < arreglo.length; i++){
         Cache.getInstancia().agregarEntidad(((ObjetoPersistente) arreglo[i]).getOid(), arreglo[i]);
         ((ObjetoPersistente) arreglo[i]).setNuevo(false);
      } // fin de for
      
      return (Object) buscados;
   } // fin del método obtenerEntidad
   
   /**
    * Materializa los objetos encontrados de acuerdo al criterio recibido como parámetro.
    * @param criterio criterio de búsqueda de las entidades
    * @return un vector con las entidades encontradas que cumplen el criterio
    */
   public Vector getPorCriterio(Criterio criterio){
      // recupera de la BD las entidades que cumplen con el criterio
      Vector buscados = (Vector) materializar(criterio);
      
      // si no se encontraron entidades que cumplen con el criterio, el vector estará vacío
      if(buscados.isEmpty())
         return buscados;
      
      // si se encontró más de una entidad, se combierte el vector en un arreglo de Object, para
      // recorrerlo y guardarlos en la caché como Objetos Persistentes
      if (buscados.size() > 1){
         Object[] arreglo = buscados.toArray();
         
         for(int i = 0; i < arreglo.length; i++){
            Cache.getInstancia().agregarEntidad(((ObjetoPersistente) arreglo[i]).getOid(), arreglo[i]);
            ((ObjetoPersistente) arreglo[i]).setNuevo(false);
         } // fin de for
      }
      // sino, si se encontró sólo una entidad, se toma el primer elemento del vector y se guarde
      // en la caché como un Objeto Persistente
      else{
         Cache.getInstancia().agregarEntidad(((ObjetoPersistente) buscados.firstElement()).getOid(), buscados.firstElement());
         ((ObjetoPersistente) buscados.firstElement()).setNuevo(false);
      } // fin de if
      
      return buscados;
   } // fin del método getPorCriterio

   /**
    * Guarda el objeto recibido como parámetro en la BD.
    * @param objeto objeto a persistir
    */
   public void persistirEntidad(Object objeto){
      // combierte el objeto recibido en un ObjetoPersistente
      ObjetoPersistente obj = (ObjetoPersistente) objeto;
      // guarda el objeto en la BD (si es nuevo, lo inserta, sino, lo actualiza
      desmaterializar(obj);
      // quita el objeto de la caché
      Cache.getInstancia().quitarEntidad(((ObjetoPersistente) objeto).getOid());
   } // fin del método persistirEntidad

   /**
    * Elimina el objeto de la caché.
    * @param objeto objeto a quitar de la cahé
    */
   public void eliminar(Object objeto){
      Cache.getInstancia().quitarEntidad(((ObjetoPersistente) objeto).getOid());
   } // fin del método eliminar
   
   /**
    * Crea una nueva entidad del tipo correspondiente.
    * @return la nueva entidad creada
    */
   public abstract Object obtenerNuevaEntidad(); // método a implementar

   /**
    * Recupera todas las entidades del tipo correspondiente.
    * @return un vector con los objetos del tipo correspondiente recuperados
    */
   public abstract Object materializar(); // método a implementar
   
   /**
    * Recupera la entidad correspondiente al identificador recibido.
    * @param id identificador de la entidad a recuperar
    * @return la entidad materializada
    */
   public abstract Object materializar(String id); // método a implementar
   
   /**
    * Recupera las entidades que contienen la clave foránea indicada.
    * @param idForaneo nombre del atributo que es clave foránea
    * @param id clave foránea
    * @return un vector con los objetos que tienen la clave foránea recibida
    */
   public abstract Object materializar(String idForaneo, String id); // método a implementar
   
   /**
    * Recupera las entidades que cumplen con el criterio recibido.
    * @param criterio criterio mediante el cuál se buscarán las entidades
    * @return un vector con los objetos que cumplen el criterio recibido
    */
   public abstract Object materializar(Criterio criterio); // método a implementar
   
   /**
    * Si el objeto es nuevo, lo inserta en la BD, sino lo actualiza.
    * @param objeto objeto a persistir
    */
   public abstract void desmaterializar(ObjetoPersistente objeto); // método a implementar
   
   /**
    * Inserta el objeto recibido en la BDR.
    * @param objeto objeto a insertar
    */
   public abstract void insertar(Object objeto); // método a implementar
   
   /**
    * Actualiza el objeto recibido en la BDR.
    * @param objeto objeto a actualizar
    */
   public abstract void actualizar(Object objeto); // método a implementar
} // fin de la clase IntermediarioPersistencia