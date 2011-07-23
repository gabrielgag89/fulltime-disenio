// EstrategiaCalculoTardanzaEntrada: EstrategiaCalculoTardanzaEntrada.java
// 

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class EstrategiaCalculoTardanzaEntrada implements EstrategiaCalculoTardanza {
   /**
    * 
    * @param marcada
    * @param dtoDAT
    * @return 
    */
   @Override
   public int calcularTardanza(Marcada marcada, DTODiaATrabajar dtoDAT, Vector vVRT, int diasPerdon){
      VigenciaRangoTardanza vigenciaRT = buscarVigencia(vVRT, marcada.getFecha(), dtoDAT.getHorasDia());
      Vector vRangoT = vigenciaRT.getRangoDeTardanza();
      
      double minutosTardanza = calcularTardanzaEntrada(marcada);

      RangoDeTardanza rangoT = buscarRangoTardanza(vRangoT, minutosTardanza);
      double porcentajeDesc = rangoT.getPorcentajeDescuento();
      
      if(minutosTardanza > 0 && diasPerdon++ >= rangoT.getCdadDiasPerdon())
         dtoDAT.sumarMinutosTardanza(porcentajeDesc * dtoDAT.getHorasDia() / 100);
      
      return diasPerdon;
   }

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
            
            if(perteneceRango(vigencia.getFechaDesde(), vigencia.getFechaHasta(), fechaM) &&
                    perteneceRango(tHT.getHoraDesde(), tHT.getHoraHasta(), horas))
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
      
      if(isHoraMenorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = calcularTiempo(horaHR, horaM);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaEntrada

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
         
         if(perteneceRango(rangoT.getMinutosDesde(), rangoT.getMinutosHasta(), minutosTardanza))
            return rangoT;
      } // fin de for
      
      return null;
   } // fin del método buscarRangoTardanza
    
   /**
    * Comprueba si {@code horaC} se encuentran en el rango.
    * @param hRI hora de inicio del rango 
    * @param hRF hora de fin del rango 
    * @param horaC hora consulta
    * @return 
    */
   private boolean perteneceRango(double hRI, double hRF, double horaC){
      int hD, hH, hAT;
      hD = (int) (hRI * 100);
      hH = (int) (hRF * 100);
      hAT = (int) (horaC * 100);
      
      if(hD < hAT && hH > hAT)
         return true;
      
      return false;
   } // fin del método perteneceRango
   
   /**
    * Comprueba si la primer hora es menor o igual a la segunda.
    * @param h1 hora 1
    * @param h2 hora 2
    * @return {@code true} - si {@code h1} es menor o igual que {@code h2}<br>
    * {@code false} - si {@code h1} es mayor que {@code h2}
    */
   private boolean isHoraMenorIgual(Time h1, Time h2){
      if(h1.getHora() < h2.getHora())
         return true;
              
      else if(h1.getHora() == h2.getHora() && h1.getMinuto() < h2.getMinuto())
         return true;
      
      else if(h1.getHora() == h2.getHora() && h1.getMinuto() == h2.getMinuto() && h1.getSegundo() <= h2.getSegundo())
         return true;
         
      return false;
   } // fin del método isHoraMenorIgual
   
   /**
    * Calcula el tiempo en horas a trabajar en el rango indicado.
    * @param horaDesde hora de comienzo del rango
    * @param horaHasta hora de fin del rango
    * @return tiempo en horas, como un {@code double}, a trabajar en el rango indicado
    */
   private double calcularTiempo(Time horaDesde, Time horaHasta){
      double horas, minutos, segundos;
      
      // cálculo de las horas
      horas = horaHasta.getHora() - horaDesde.getHora();
      
      // cálculo de los minutos
      if(horaDesde.getMinuto() > horaHasta.getMinuto()){
         horas--;
         minutos = (horaHasta.getMinuto() + 60 - horaDesde.getMinuto()) % 60;
      }
      else
         minutos = horaHasta.getMinuto() - horaDesde.getMinuto();
      
      // cálculo de los segundos
      if(horaDesde.getSegundo() > horaHasta.getSegundo()){
         minutos--;
         segundos = (horaHasta.getSegundo() + 60 - horaDesde.getSegundo()) % 60;
      }
      else
         segundos = horaHasta.getSegundo() - horaDesde.getSegundo();
              
      return horas + ((double) minutos / 60) + ((double) segundos / 3600);
   } // fin del método calcularHorasDia

   /**
    * Comprueba si la fecha recibida a comparar pertenece al período de consulta.
    * @param fConsultaDesde fecha de inicio de la consulta
    * @param fConsultaHasta fecha de fin de la consulta
    * @param fechaComp fecha a comparar
    * @return {@code true} - si la fecha a comparar pertenece al período de consulta<br>
    * {@code false} - si la fecha a comparar no pertenece al período de consulta
    */
   private boolean perteneceRango(Date fConsultaDesde, Date fConsultaHasta, Date fechaComp){
      if(isFechaMayorIgual(fechaComp, fConsultaDesde) && isFechaMenorIgual(fechaComp, fConsultaHasta))
         return true;
      
      return false;
   } // fin del método perteneceRango
   
   /**
    * Comprueba si la primer fecha ingresada es mayor o igual a la segunda.
    * @param f1 fecha 1
    * @param f2 fecha 2
    * @return {@code true} - si {@code f1} es mayor o igual que {@code f2}<br>
    * {@code false} - si {@code f1} es menor que {@code f2}
    */
   private boolean isFechaMayorIgual(Date f1, Date f2){
      if(f1.getYear() > f2.getYear())
         return true;
      else if(f1.getYear() == f2.getYear() && f1.getMonth() > f2.getMonth())
         return true;
      else if(f1.getYear() == f2.getYear() && f1.getMonth() == f2.getMonth() && f1.getDate() >= f2.getDate())
         return true;
      
      return false;
   } // fin del método isFechaMayorIgual
   
   /**
    * Comprueba si la primer fecha ingresada es menor o igual a la segunda.
    * @param f1 fecha 1
    * @param f2 fecha 2
    * @return {@code true} - si {@code f1} es menor o igual que {@code f2}<br>
    * {@code false} - si {@code f1} es mayor que {@code f2}
    */
   private boolean isFechaMenorIgual(Date f1, Date f2){
      if(f1.getYear() < f2.getYear())
         return true;
      else if(f1.getYear() == f2.getYear() && f1.getMonth() < f2.getMonth())
         return true;
      else if(f1.getYear() == f2.getYear() && f1.getMonth() == f2.getMonth() && f1.getDate() <= f2.getDate())
         return true;
      
      return false;
   } // fin del método isFechaMenorIgual
} // fin de la clase EstrategiaCalculoTardanzaEntrada