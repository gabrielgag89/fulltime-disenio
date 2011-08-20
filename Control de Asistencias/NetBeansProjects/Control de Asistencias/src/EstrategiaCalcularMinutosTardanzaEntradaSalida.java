// EstrategiaCalcularMinutosTardanzaEntradaSalida: EstrategiaCalcularMinutosTardanzaEntradaSalida.java
// 

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalcularMinutosTardanzaEntradaSalida implements EstrategiaCalcularMinutosTardanza {
   /**
    * Calcula la tardanza de una marcada y guarda los minutos de descuento en el DTO de días a trabajar.
    * @param marcada marcada a comprobar la tardanza
    * @param dtoDAT DTO con los datos del día correspondiente a la marcada
    * @param vVRT vector de vigencias de los rangos de tardanza
    * @param diasPerdon días de perdón acumulados en el período
    * @return los días de perdón restantes
    */
   @Override
   public double calcularMinutosTardanza(Marcada marcada){
      double minutosTardanza = calcularTardanzaEntrada(marcada);
      minutosTardanza += calcularTardanzaSalida(marcada);
      
      return minutosTardanza;
   } // fin del método calcularMinutosTardanza

   /**
    * Calcula el tiempo de tardanza a la entrada para la marcada recibida.
    * @param marcada marcada a calcularle la tardanza
    * @return el tiempo de tardanza a la entrada para la marcada recibida
    */
   private double calcularTardanzaEntrada(Marcada marcada) {
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaM, horaHR;
      
      horaM = marcada.getHoraEntrada();
      horaHR = HR.getHoraDesde();
      
      if(ServiciosTiempo.isHoraMenorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = ServiciosTiempo.calcularTiempo(horaHR, horaM);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaEntrada

   /**
    * Calcula el tiempo de tardanza a la salida para la marcada recibida.
    * @param marcada marcada a calcularle la tardanza
    * @return el tiempo de tardanza a la salida para la marcada recibida
    */
   private double calcularTardanzaSalida(Marcada marcada) {
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaM, horaHR;
      
      horaM = marcada.getHoraSalida();
      horaHR = HR.getHoraHasta();
      
      if(ServiciosTiempo.isHoraMayorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = ServiciosTiempo.calcularTiempo(horaM, horaHR);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaSalida
} // fin de la clase EstrategiaCalcularMinutosTardanzaEntradaSalida