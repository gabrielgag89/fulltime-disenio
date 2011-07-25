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
         
         if(ServiciosTiempo.perteneceRango(fRegDesde, fRegHasta, fechaD, fechaH)){
            fInicio = ServiciosTiempo.buscarDiaInicio(fRegDesde, fechaD);
            fFin = ServiciosTiempo.buscarDiaFin(fRegHasta, fechaH);
            RH = RA.getRegimenHorario();
            vHR = RH.getHorariosRegimen();
            
            for(int j = 0; j < vHR.size(); j++){
               HR = (HorarioRegimen) vHR.get(j);
               
               hDesde = HR.getHoraDesde();
               hHasta = HR.getHoraHasta();
               
               dtoDH = new DTODiasHoras();
               dtoDH.setNombreDia(HR.getNombreDia());
               dtoDH.setHorasDia(ServiciosTiempo.calcularTiempo(hDesde, hHasta));
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
         
         if(ServiciosTiempo.perteneceRango(fechaD, fechaH, fechaM)){
            dtoDAT = buscarDTODiaATrabajar(vDtoDAT, fechaM);
            
            if(dtoDAT != null){
               estrategia = FabricaEstrategiaCalculoTardanza.getInstancia().getEstrategiaCalculoTardanza(marcada);
               diasPerdon = estrategia.calcularTardanza(marcada, dtoDAT, vVRT, diasPerdon);
            } // fin de de if
         } // fin de if externo
      } // fin de for
      
      for(int i = 0; i < vDtoDAT.size(); i++){
         dtoDAT = (DTODiaATrabajar) vDtoDAT.get(i);
         
         if(dtoDAT.getHorasRestantes() > 0)
            dtoDAT.setMinutosDescuento(dtoDAT.getHorasRestantes() * 60);
         
      } // fin de for
      
      return vDtoDAT;
   } // fin del método calcularPorcentajeAsistencia
   
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
         nombreDiaCons = ServiciosTiempo.buscarNombreDia(fInicio.getDay());
         
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
         
         fInicio = ServiciosTiempo.incrFecha(fInicio);
      }while(ServiciosTiempo.isFechaMenorIgual(fInicio, fFin)); // fin de do... while
   } // fin del método agregaDias
   
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
         
         if(ServiciosTiempo.sonFechasIguales(dtoDATv.getFecha(), dtoDAT.getFecha())){
            dtoDATv.sumarHorasDia(dtoDAT.getHorasDia());
            return true;
            
         } // fin de if
      } // fin de for
      
      return false;
   } // fin del método isDTOEnVector
   
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
         
         if(ServiciosTiempo.sonFechasIguales(dtoDAT.getFecha(), fechaM))
            return dtoDAT;
         
      } // fin de for
      
      return null;
   } // fin del método buscarDiaATrabajar
} // fin de la clase ExpertoCalcularPorcentajeAsistencia