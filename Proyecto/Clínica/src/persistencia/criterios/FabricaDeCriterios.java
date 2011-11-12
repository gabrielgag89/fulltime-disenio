// FabricaDeCriterios: FabricaDeCriterios.java
// Fábrica encargada de crear el criterio correspondiente a la solicitud.

package persistencia.criterios;

import java.util.List;
import java.util.ArrayList;

/**
 * Fábrica encargada de crear el criterio correspondiente a la solicitud.
 * @author Gabriel
 */
public class FabricaDeCriterios {
   /**
    * Instancia de la fábrica de criterios.
    */
   private static FabricaDeCriterios instancia;
   
   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static FabricaDeCriterios getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FabricaDeCriterios();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Crea un criterio simple formado por el nombre del atributo, el operador a utilizar 
    * en la comparación y el valor a comparar.
    * @param atributo nombre del atributo a comparar
    * @param operador operador a utilizar en la comparación
    * @param valor valor a comparar
    * @return el criterio resultante
    */
   public Criterio getCriterio(String atributo, String operador, String valor) {
      return new CriterioSimple(atributo, operador, valor);
   } // fin del método getCriterio

   /**
    * Crea un {@code Criterio Compuesto} unido mediante OR
    * @param c vector de criterios a unir con OR
    * @return el criterio resultante
    */
   public Criterio or(List<Criterio> c) {
      return new OR().setCriterio(c);
   } // fin del método or

   /**
    * Crea un {@code Criterio Compuesto} unido mediante AND.
    * @param c vector de criterios a unir con AND
    * @return el criterio resultante
    */
   public Criterio and(List<Criterio> c) {
      return new AND().setCriterio(c);
   } // fin del método and

   /**
    * Crea un {@code Criterio Compuesto} unido mediante AND.
    * @param c1 primer criterio a unir
    * @param c2 segundo criterio a unir
    * @return el criterio 1 y el criterio 2 unidos por un AND
    */
   public Criterio and(Criterio c1, Criterio c2) {
      List V = new ArrayList();
      V.add(c1);
      V.add(c2);
      return this.and(V);
   } // fin del método and
} // fin de la clase FabricaDeCriterios