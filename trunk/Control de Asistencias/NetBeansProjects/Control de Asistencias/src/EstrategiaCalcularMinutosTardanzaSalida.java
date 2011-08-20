// EstrategiaCalcularMinutosTardanzaSalida: EstrategiaCalcularMinutosTardanzaSalida.java
// 

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalcularMinutosTardanzaSalida implements EstrategiaCalcularMinutosTardanza {
   /**
    * Calcula el tiempo de tardanza a la salida para la marcada recibida.
    * @param marcada marcada a calcularle la tardanza
    * @return el tiempo de tardanza a la salida para la marcada recibida
    */
   @Override
   public double calcularMinutosTardanza(Marcada marcada) {
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaM, horaHR;
      
      horaM = marcada.getHoraSalida();
      horaHR = HR.getHoraHasta();
      
      if(ServiciosTiempo.isHoraMayorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = ServiciosTiempo.calcularTiempo(horaM, horaHR);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaSalida
} // fin de la clase EstrategiaCalcularMinutosTardanzaSalida