// EstrategiaCalculoTardanzaSinControl: EstrategiaCalculoTardanzaSinControl.java
// 

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalculoTardanzaSinControl implements EstrategiaCalculoTardanza {
   /**
    * Calcula la tardanza de una marcada y guarda los minutos de descuento en el DTO de días a trabajar.
    * @param marcada marcada a comprobar la tardanza
    * @param dtoDAT DTO con los datos del día correspondiente a la marcada
    * @param vVRT vector de vigencias de los rangos de tardanza
    * @param diasPerdon días de perdón acumulados en el período
    * @return los días de perdón restantes
    */
   @Override
   public int calcularTardanza(Marcada marcada, DTODiaATrabajar dtoDAT, Vector vVRT, int diasPerdon){
      double horasHR = ServiciosTiempo.calcularTiempo(marcada.getHorarioRegimen().getHoraDesde(), marcada.getHorarioRegimen().getHoraHasta());
      
      dtoDAT.restarHorasRestantes(horasHR);
      
      return diasPerdon;
   } // fin del método calcularTardanza
} // fin de la clase EstrategiaCalculoTardanzaSinControl