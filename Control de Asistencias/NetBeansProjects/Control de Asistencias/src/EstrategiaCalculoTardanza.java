// EstrategiaCalculoTardanza: EstrategiaCalculoTardanza.java
//

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public interface EstrategiaCalculoTardanza {
   /**
    * 
    * @param marcada
    * @param dtoDAT
    * @return 
    */
   public int calcularTardanza(Marcada marcada, DTODiaATrabajar dtoDAT, Vector vVRT, int diasPerdon);
}