// EstrategiaCalculoTardanzaEntradaSalida: EstrategiaCalculoTardanzaEntradaSalida.java
// 

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalculoTardanzaEntradaSalida implements EstrategiaCalculoTardanza {
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
      VigenciaRangoTardanza vigenciaRT = buscarVigencia(vVRT, marcada.getFecha(), dtoDAT.getHorasDia());
      Vector vRangoT = vigenciaRT.getRangoDeTardanza();
      
      double horasHR = ServiciosTiempo.calcularTiempo(marcada.getHorarioRegimen().getHoraDesde(), marcada.getHorarioRegimen().getHoraHasta());
      
      double minutosTardanza = calcularTardanzaEntrada(marcada);
      minutosTardanza += calcularTardanzaSalida(marcada);
      
      RangoDeTardanza rangoT = buscarRangoTardanza(vRangoT, minutosTardanza);
      double porcentajeDesc = rangoT.getPorcentajeDescuento();
      
      if(minutosTardanza > 0 && diasPerdon++ >= rangoT.getCdadDiasPerdon())
         dtoDAT.sumarMinutosDescuento(porcentajeDesc * dtoDAT.getHorasDia() / 100);
      
      dtoDAT.restarHorasRestantes(horasHR);
      
      return diasPerdon;
   } // fin del método calcularTardanza

   /**
    * Devuelve la vigencia a la que pertenece la marcada.
    * @param vVRT vector que contiene las vigencias
    * @param fechaM fecha de la marcada
    * @param horas horas a trabajar para el día
    * @return la vigencia a la que pertenece la marcada<br>
    * {@code null} si ninguna coincide con la fecha
    */
   private VigenciaRangoTardanza buscarVigencia(Vector vVRT, Date fechaM, double horas) {
      VigenciaRangoTardanza vigencia;
      TipoHorasTrabajadas tHT;
      
      for(int i = 0; i < vVRT.size(); i++){
            vigencia = (VigenciaRangoTardanza) vVRT.get(i);
            tHT = vigencia.getTipoHorasTrabajadas();
            
            if(ServiciosTiempo.perteneceRango(vigencia.getFechaDesde(), vigencia.getFechaHasta(), fechaM) &&
                    ServiciosTiempo.perteneceRango(tHT.getHoraDesde(), tHT.getHoraHasta(), horas))
               return vigencia;
            
      } // fin de for
      
      return null;
   } // fin del método buscarVigencia

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

   /**
    * Busca el rango de tardanza correspondiente a los minutos de tardanza recibidos.
    * @param vRangoT vector de rangos de tardanza
    * @param minutosTardanza minutos de tardanza
    * @return el rango de tardanza correspondiente a los minutos de tardanza recibidos
    */
   private RangoDeTardanza buscarRangoTardanza(Vector vRangoT, double minutosTardanza) {
      RangoDeTardanza rangoT;
      
      for(int i = 0; i < vRangoT.size(); i++){
         rangoT = (RangoDeTardanza) vRangoT.get(i);
         
         if(ServiciosTiempo.perteneceRango(rangoT.getMinutosDesde(), rangoT.getMinutosHasta(), minutosTardanza))
            return rangoT;
         
      } // fin de for
      
      return null;
   } // fin del método buscarRangoTardanza
} // fin de la clase EstrategiaCalculoTardanzaEntradaSalida