// CriterioCompuesto: CriterioCompuesto.java
// Criterio compuesto para la consulta a la BDR.

package persistencia.criterios;

import java.util.List;
import java.util.ArrayList;

/**
 * Criterio compuesto para la consulta a la BDR.
 * @author Gabriel
 */
public class CriterioCompuesto implements Criterio{
   /**
    * Vector de criterios.
    */
   protected List<Criterio> CS = new ArrayList<Criterio>();

   /**
    * Combierte el criterio en un {@code String}.<br>
    * ¡¡¡NO IMPLEMENTADO AÚN!!! <- Gabriel, se usa en un nivel mas abajo
    * @return el criterio combertido a {@code String}
    */
   @Override
   public String getStringCriterio() {
      throw new UnsupportedOperationException("Not supported yet.");
   } // fin del método getStringCriterio
        
   /**
    * Recupera el criterio correspondiente a la posición indicada.
    * @param index posición del criterio a recuperar
    * @return el criterio recuperado
    */
   public Criterio getCriterio(int index) {
      return (Criterio) CS.get(index);
   } // fin del método getCriterio
   
   /**
    * Establece el vector de criterios.
    * @param c vector de criterios
    * @return el criterio resultante
    */
   public Criterio setCriterio(List<Criterio> c) {
      this.CS = c;
      return (Criterio) this;
   } // fin del método setCriterio

   /**
    * Agrega criterios al vector de criterios.
    * @param c criterio a agregar al vector de criterios.
    */
   public void setCriterio(Criterio c) {
      this.CS.add(c);
   } // fin del método setCriterio

   /**
    * Limpia el vector de criterios.
    * @param c ¡¡¡Ignoro para qué se recibe este criterio si no se utiliza para nada!!!
    */
   public void limpiarCriterio(Criterio c) {
      this.CS.clear();
   } // fin del método limpiarCriterio
} // fin de la clase CriterioCompuesto