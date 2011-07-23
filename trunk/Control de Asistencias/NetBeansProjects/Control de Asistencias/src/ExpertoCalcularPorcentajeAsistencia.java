// ExpertoCalcularPorcentajeAsistencia: ExpertoCalcularPorcentajeAsistencia.java
// Experto encargado del cálculo de las asistencias de un empleado.

import java.util.Date;
import java.util.Vector;

/**
 * Experto encargado del cálculo de las asistencias de un empleado.
 * @author gabriel
 */
public class ExpertoCalcularPorcentajeAsistencia {
   /**
    * Calcula el porcentaje de asistencia del empleado correspondiente al legajo ingresado, para la fecha de consulta.
    * @param legajo lejago correspondiente al empleado al que se le liquidará el sueldo
    * @param fechaD fecha inicial de la consulta
    * @param fechaH fecha final de la consulta
    * @return todavía no sabemos =S, pero se supone que es un porcentaje de algo ({@code double})
    */
   public Vector calcularPorcentajeAsistencia(int legajo, Date fechaD, Date fechaH){
      Vector vRegimenesAsignados = (Vector) IndireccionPersistencia.getInstancia().buscar("RegimenAsignado", "legajo = " + legajo);
      
      Vector vDtoDAT = new Vector();
      Vector vDtoDH = new Vector();
      RegimenAsignado RA;
      RegimenHorario RH;
      HorarioRegimen HR;
      Vector vHR;
      Date fRegDesde, fRegHasta, fInicio, fFin;
      DTODiasHoras dtoDH;
      Time hDesde, hHasta;
      
      for(int i = 0; i < vRegimenesAsignados.size(); i++){
         RA = (RegimenAsignado) vRegimenesAsignados.get(i);
         fRegDesde = RA.getFechaDesde();
         fRegHasta = RA.getFechaHasta();
         
         if(fRegHasta == null)
            fRegHasta = new Date();
         
         if(perteneceRango(fRegDesde, fRegHasta, fechaD, fechaH)){
            fInicio = buscarDiaInicio(fRegDesde, fechaD);
            fFin = buscarDiaFin(fRegHasta, fechaH);
            RH = RA.getRegimenHorario();
            vHR = RH.getHorariosRegimen();
            
            for(int j = 0; j < vHR.size(); j++){
               HR = (HorarioRegimen) vHR.get(j);
               
               hDesde = HR.getHoraDesde();
               hHasta = HR.getHoraHasta();
               
               dtoDH = new DTODiasHoras();
               dtoDH.setNombreDia(HR.getNombreDia());
               dtoDH.setHorasDia(calcularTiempo(hDesde, hHasta));
               vDtoDH.addElement(dtoDH);
            } // fin de for interno
            
            agregaDias(fInicio, fFin, vDtoDAT, vDtoDH);
         } // fin de if
      } // fin de for externo
      
      Vector vMarcadas = (Vector) IndireccionPersistencia.getInstancia().buscar("Marcada", "legajo = " + legajo + " AND validez = 'Válida' ORDER BY ASC");
      Vector vVRT = (Vector)IndireccionPersistencia.getInstancia().buscar("VigenciaRangoTardanza", null);
      
      Marcada marcada;
      Date fechaM;
      DTODiaATrabajar dtoDAT;
      EstrategiaCalculoTardanza estrategia;
      int diasPerdon = 0;
      
      for(int i = 0; i < vMarcadas.size(); i++){
         marcada = (Marcada) vMarcadas.get(i);
         fechaM = marcada.getFecha();
         
         if(perteneceRango(fechaD, fechaH, fechaM)){
            dtoDAT = buscarDTODiaATrabajar(vDtoDAT, fechaM);
            
            if(dtoDAT != null){
               estrategia = FabricaEstrategiaCalculoTardanza.getInstancia().getEstrategiaCalculoTardanza(marcada);
               
               diasPerdon = estrategia.calcularTardanza(marcada, dtoDAT, vVRT, diasPerdon);
            } // fin de de if
         } // fin de if externo
      } // fin de for
      
      return vDtoDAT;
   } // fin del método calcularPorcentajeAsistencia

   /**
    * Comprueba si las fechas recibidas a comparar pertenecen al período de consulta.
    * @param fCompDesde fecha de inicio a comparar
    * @param fCompHasta fecha de fin a comparar
    * @param fConsultaDesde fecha de inicio de la consulta
    * @param fConsultaHasta fecha de fin de la consulta
    * @return {@code true} - si el régimen asignado pertenece al período de consulta<br>
    * {@code false} - si el régimen asignado no pertenece al período de consulta
    */
   private boolean perteneceRango(Date fCompDesde, Date fCompHasta, Date fConsultaDesde, Date fConsultaHasta){
      if(isFechaMayorIgual(fConsultaDesde, fCompDesde) && isFechaMenorIgual(fConsultaDesde, fCompHasta))
         return true;
      else if(isFechaMayorIgual(fConsultaHasta, fCompDesde) && isFechaMenorIgual(fConsultaHasta, fCompHasta))
         return true;
      else if(isFechaMayorIgual(fCompDesde, fConsultaDesde) && isFechaMenorIgual(fCompHasta, fConsultaHasta))
         return true;
      
      return false;
   } // fin del método perteneceRango

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

   /**
    * Busca la fecha en la que comienza la consulta para el régimen asignado correspondiente.
    * @param fRegimen fecha de inicio de la vigencia del régimen asignado
    * @param fConsulta fecha de inicio de la consulta
    * @return la fecha en la que comienza la consulta para el régimen asignado correspondiente
    */
   private Date buscarDiaInicio(Date fRegimen, Date fConsulta){
      if(isFechaMayorIgual(fConsulta, fRegimen))
         return fConsulta;
      else
         return fRegimen;
   } // fin del método buscarDiaInicio

   /**
    * Busca la fecha en la que termina la consulta para el régimen asignado correspondiente.
    * @param fRegimen fecha de fin de la vigencia del régimen asignado
    * @param fConsulta fecha de fin de la consulta
    * @return la fecha en la que termina la consulta para el régimen asignado correspondiente
    */
   private Date buscarDiaFin(Date fRegimen, Date fConsulta){
      if(isFechaMenorIgual(fConsulta, fRegimen))
         return fConsulta;
      else
         return fRegimen;
   } // fin del método buscarDiaFin
   
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
    * Agrega en el vector de DTOs de días a trabajar los días a trabajar por el empleado para cada régimen asignado. 
    * Para esto se recibe un vector de DTOs con los nombres de los días y las horas a trabajar para esos días.
    * @param fInicio fecha en la que comienza la consulta para el régimen asignado correspondiente
    * @param fFin fecha en la que termina la consulta para el régimen asignado correspondiente
    * @param vDtoDAT vector de DTOs de días a trabajar
    * @param vDtoDH vector de DTOs con los nombres de los días y las horas a trabajar para esos días
    */
   private void agregaDias(Date fInicio, Date fFin, Vector vDtoDAT, Vector vDtoDH){
      DTODiaATrabajar dtoDAT;
      DTODiasHoras dtoDH;
      String nombreDiaCons, nombreDiaTrab;
      double horasDia;
      
      do{
         nombreDiaCons = buscarNombreDia(fInicio.getDay());
         
         for(int i = 0; i < vDtoDH.size(); i++){
            dtoDH = (DTODiasHoras) vDtoDH.get(i);
            nombreDiaTrab = dtoDH.getNombreDia();
            
            if(nombreDiaTrab.equals(nombreDiaCons)){
               horasDia = dtoDH.getHorasDia();
               
               dtoDAT = new DTODiaATrabajar();
               dtoDAT.setFecha(fInicio);
               dtoDAT.setHorasDia(horasDia);
               
               if(!isDTOEnVector(vDtoDAT, dtoDAT))
                  vDtoDAT.addElement(dtoDAT);
               
               break;
            } // fin de if
         } // fin de for
         
         fInicio = incrFecha(fInicio);
      }while(isFechaMenorIgual(fInicio, fFin)); // fin de do... while
   } // fin del método agregaDias
   
   /**
    * Transforma el número del día de la semana recibido y lo transforma a su correspondiente representación como {@code String}. 
    * De la siguiente forma:<br>
    * 0 = Domingo<br>1 = Lunes<br>2 = Martes<br>3 = Miércoles<br>
    * 4 = Jueves<br>5 = Viernes<br>6 = Sábado
    * @param dia número de día a convertir
    * @return el día en su representación como {@code String}
    */
   private String buscarNombreDia(int dia){
      switch(dia){
         case 0:
            return "Domingo";
         case 1:
            return "Lunes";
         case 2:
            return "Martes";
         case 3:
            return "Miércoles";
         case 4:
            return "Jueves";
         case 5:
            return "Viernes";
         default:
            return "Sábado";
      } // fin de switch
   } // fin del método getNombreMes
   
   /**
    * Comprueba si en el vector de DTOs de días a trabajar ya se encuentra el DTO para la fecha que se quiere
    * agregar. Si ya existe, se suman las horas a trabajar para el día.
    * @param vDtoDAT vector de DTOs de días a trabajar
    * @param dtoDAT DTO del día a trabajar a agregar
    * @return {@code true} - si el DTO a agregar ya se encuentra en el vector<br>
    * {@code false} - si el DTO a agregar no se encuentra en el vector
    */
   private boolean isDTOEnVector(Vector vDtoDAT, DTODiaATrabajar dtoDAT){
      DTODiaATrabajar dtoDATv;
      
      for(int i = 0; i < vDtoDAT.size(); i++){
         dtoDATv = (DTODiaATrabajar) vDtoDAT.get(i);
         
         if(sonFechasIguales(dtoDATv.getFecha(), dtoDAT.getFecha())){
            dtoDATv.sumarHorasDia(dtoDAT.getHorasDia());
            return true;
         } // fin de if
      } // fin de for
      
      return false;
   } // fin del método isDTOEnVector
   
   /**
    * Comprueba si las fechas recibidas son iguales.
    * @param f1 fecha 1
    * @param f2 fecha 1
    * @return {@code true} - si las fechas recibidas son iguales<br>
    * {@code false} - si las fechas recibidas no son iguales
    */
   private boolean sonFechasIguales(Date f1, Date f2){
      if(f1.getDate() == f2.getDate() && f1.getMonth() == f2.getMonth() && f1.getYear() == f2.getYear())
         return true;
      
      return false;
   } // fin del método sonFechasIguales
   
   /**
    * Incrementa la fecha recibida en un día.
    * @return la fecha incrementada en un día
    */
   private Date incrFecha(Date f1){
      Date f2 = new Date();
      int dia, mes, anio;
      dia = f1.getDate();
      mes = f1.getMonth() + 1;
      anio = f1.getYear() + 1900;
      
      if(!validarFecha(dia + 1, mes, anio)){
         dia = 1;
         if((mes + 1) == 13){
            mes = 1;
            anio++;
         }
         else
            mes++;
      }
      else
         dia++;
      
      f2.setDate(dia);
      f2.setMonth(mes - 1);
      f2.setYear(anio - 1900);
      
      return f2;
   } // fin del método incrFecha

   /**
    * Comprueba que la fecha sea válida.
    * @param dia número de día del mes
    * @param mes número de mes
    * @param anio número del año
    * @return {@code true} - si la fecha es válida<br>
    * {@code false} - si la fecha es inválida
    */
   private boolean validarFecha(int dia, int mes, int anio){
      if(anio < 1900 || anio > 2050 || dia < 1 || mes < 1)
         return false;

      if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
         if(dia > 30)
            return false;
      }
      else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 ||
               mes == 8 || mes == 10 || mes == 12){
         if(dia > 31)
            return false;
      }
      else if((anio % 4) == 0){
         if(dia > 29)
            return false;
      }
      else{
         if(dia > 28)
            return false;
      } // fin de if

      return true;
   } // fin del método validarFecha
   
   /**
    * Busca el DTO del día a trabajar correspondiente a la fecha de la marcada.
    * @param vDtoDAT vector de DTOs de días a trabajar
    * @param fechaM fecha de la marcada
    * @return devuelve el DTO correspondiente a la fecha de la marcada<br>
    * {@code null} si ninguno coincide con la fecha
    */
   private DTODiaATrabajar buscarDTODiaATrabajar(Vector vDtoDAT, Date fechaM){
      DTODiaATrabajar dtoDAT;
      
      for(int i = 0; i < vDtoDAT.size(); i++){
         dtoDAT = (DTODiaATrabajar) vDtoDAT.get(i);
         
         if(sonFechasIguales(dtoDAT.getFecha(), fechaM))
            return dtoDAT;
      } // fin de for
      
      return null;
   } // fin del método buscarDiaATrabajar

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
    * Calcula el tiempo de tardanza a la salida para la marcada recibida.
    * @param marcada marcada a calcularle la tardanza
    * @return el tiempo de tardanza a la salida para la marcada recibida
    */
   private double calcularTardanzaSalida(Marcada marcada) {
      HorarioRegimen HR = marcada.getHorarioRegimen();
      Time horaM, horaHR;
      
      horaM = marcada.getHoraSalida();
      horaHR = HR.getHoraHasta();
      
      if(isHoraMayorIgual(horaM, horaHR))
         return 0;
      
      double horasTardanza = calcularTiempo(horaM, horaHR);
      
      return horasTardanza * 60;
   } // fin del método calcularTardanzaSalida
   
   /**
    * Comprueba si la primer hora es mayor o igual a la segunda.
    * @param h1 hora 1
    * @param h2 hora 2
    * @return {@code true} - si {@code h1} es mayor o igual que {@code h2}<br>
    * {@code false} - si {@code h1} es menor que {@code h2}
    */
   private boolean isHoraMayorIgual(Time h1, Time h2){
      if(h1.getHora() > h2.getHora())
         return true;
              
      else if(h1.getHora() == h2.getHora() && h1.getMinuto() > h2.getMinuto())
         return true;
      
      else if(h1.getHora() == h2.getHora() && h1.getMinuto() == h2.getMinuto() && h1.getSegundo() >= h2.getSegundo())
         return true;
         
      return false;
   } // fin del método isHoraMayorIgual
   
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
    * Busca el rango de tardanza correspondiente a los minutos de tardanza recibidos.
    * @param vRangoT vector de rangos de tardanza
    * @param minutosTardanza minutos de tardanza
    * @return el rango de tardanza correspondiente a los minutos de tardanza recibidos
    */
   private RangoDeTardanza buscarRangoTardanza(Vector vRangoT, double minutosTardanza) {
      RangoDeTardanza rangoT;
      
      for(int i = 0; i < vRangoT.size(); i++){
         rangoT = (RangoDeTardanza) vRangoT.get(i);
         
         if(this.perteneceRango(rangoT.getMinutosDesde(), rangoT.getMinutosHasta(), minutosTardanza))
            return rangoT;
      } // fin de for
      
      return null;
   } // fin del método buscarRangoTardanza
} // fin de la clase ExpertoCalcularPorcentajeAsistencia