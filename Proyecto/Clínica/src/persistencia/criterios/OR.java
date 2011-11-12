// OR: OR.java
// Criterio compuesto mediante la disyunción (OR).

package persistencia.criterios;

/**
 * Criterio compuesto mediante la disyunción (OR).
 * @author Gabriel
 */
public class OR extends CriterioCompuesto {
   /**
    * Combierte el criterio en un {@code String}.
    * @return el criterio combertido a {@code String}
    */
   @Override
   public String getStringCriterio() {
      String registro = null;
      Criterio C;
      
      for(int i=0;i < super.CS.size();i++){
         C = (Criterio) super.CS.get(i);
         
         if(i == 0)
            registro = C.getStringCriterio();
         else
            registro = registro + " OR " + C.getStringCriterio();
      } // fin de for
      
      return registro;
   } // fin del método getStringCriterio
} // fin de la clase OR