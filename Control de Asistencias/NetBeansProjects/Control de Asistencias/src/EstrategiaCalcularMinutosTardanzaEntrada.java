// EstrategiaCalcularMinutosTardanzaEntrada: EstrategiaCalcularMinutosTardanzaEntrada.java
// 

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalcularMinutosTardanzaEntrada implements EstrategiaCalcularMinutosTardanza {
   /**
    * Calcula el tiempo de tardanza a la entrada para la marcada recibida.
    * @param marcada marcada a calcularle la tardanza
    * @return el tiempo de tardanza a la entrada para la marcada recibida
    */
   @Override
   public double calcularMinutosTardanza(Marcada marcada) {
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaM, horaHR;
      
      horaM = marcada.getHoraEntrada();
      horaHR = HR.getHoraDesde();
      
      if(ServiciosTiempo.isHoraMenorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = ServiciosTiempo.calcularTiempo(horaHR, horaM);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaEntrada
} // fin de la clase EstrategiaCalcularMinutosTardanzaEntrada