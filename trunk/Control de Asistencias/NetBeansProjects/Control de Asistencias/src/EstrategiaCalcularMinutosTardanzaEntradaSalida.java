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
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaME, horaMS, horaHRE, horaHRS;
      double horasTardanza = 0;

      // calcula horas tardanza entrada
      horaME = marcada.getHoraEntrada();
      horaHRE = HR.getHoraDesde();

      if(!ServiciosTiempo.isHoraMenorIgual(horaME, horaHRE))
         horasTardanza = ServiciosTiempo.calcularTiempo(horaHRE, horaME);

      // calcula horas tardanza salida
      horaMS = marcada.getHoraSalida();
      horaHRS = HR.getHoraHasta();

      if(!ServiciosTiempo.isHoraMayorIgual(horaMS, horaHRS))
          horasTardanza += ServiciosTiempo.calcularTiempo(horaMS, horaHRS);
      
      return horasTardanza * 60;
   } // fin del método calcularMinutosTardanza
} // fin de la clase EstrategiaCalcularMinutosTardanzaEntradaSalida