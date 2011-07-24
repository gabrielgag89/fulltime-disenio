// IndireccionPersistencia: IndireccionPersistencia.java
// 

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class IndireccionPersistencia {
   private static IndireccionPersistencia instancia;
   private Vector vRA = new Vector();
   private Vector vMarcadas = new Vector();
   private Vector vVigenciaRT = new Vector();

   public IndireccionPersistencia(){
      Empleado empleado = cargaEmpleado();
      
      cargaRA1(empleado);
      cargaRA2(empleado);
      cargaMar(empleado);
      cargaVRT();
   } // fin del método IndireccionPersistencia
   
   /**
    * 
    * @return 
    */
   public static IndireccionPersistencia getInstancia(){
      if(instancia == null)
         instancia = new IndireccionPersistencia();
      
      return instancia;
   } // fin del método getInstancia
        
   /**
    * 
    * @param nombreObjeto
    * @param criterio
    * @return 
    */
   public Object buscar(String nombreObjeto, String criterio){
      if(nombreObjeto.equals("RegimenAsignado"))
         return buscarRA(Integer.parseInt(criterio.substring(9)));
              
      else if(nombreObjeto.equals("Marcada"))
         return buscarMarcada(Integer.parseInt(criterio.substring(9, 12)));
              
      else if(nombreObjeto.equals("VigenciaRangoTardanza"))
         return buscarVRT();
      
      return null;
   } // fin del método buscar
   
   /**
    * 
    * @param legajo
    * @return 
    */
   private Vector buscarRA(int legajo){
      Vector V = new Vector();
      RegimenAsignado RA;
      
      for(int i = 0; i < vRA.size(); i++){
         RA = (RegimenAsignado) vRA.get(i);
         
         if(legajo == RA.getEmpleado().getNroLegajo()){
            
            V.addElement(RA);
         }
      }
      
      return V;
   } // fin del método buscarRA
   
   /**
    * 
    * @param legajo
    * @return 
    */
   private Vector buscarMarcada(int legajo){
      Vector V = new Vector();
      Marcada marcada;
      
      for(int i = 0; i < vMarcadas.size(); i++){
         marcada = (Marcada) vMarcadas.get(i);
         
         if(legajo == marcada.getEmpleado().getNroLegajo()){
            
            V.addElement(marcada);
         }
      }
      
      return V;
   }
   
   /**
    * 
    * @return 
    */
   private Vector buscarVRT(){
      return vVigenciaRT;
   }

   /**
    * 
    * @param nombreObjeto
    * @return 
    */
   public Object crear(String nombreObjeto){
      return null;
   } // fin del método crear

   /**
    * 
    * @param nombreObjeto
    * @param objeto 
    */
   public void guardar(String nombreObjeto, Object objeto){

   } // fin del método guardar

   /**
    * 
    * @param nombreObjeto
    * @param objeto 
    */
   public void eliminar(String nombreObjeto, Object objeto){

   } // fin del método eliminar
   
   /**
    * 
    * @return 
    */
   private Empleado cargaEmpleado(){
      Empleado empleado;
      
      empleado = new Empleado();
      empleado.setNroLegajo(150);
      empleado.setNombre("Cristian");
      empleado.setApellido("Pichón");
      
      return empleado;
   }
   
   /**
    * 
    * @param empl 
    */
   private void cargaRA1(Empleado empl){
      RegimenAsignado RA;
      RegimenHorario RH;
      HorarioRegimen HR;
      TipoControlHorario tipoCH;
      Vector vHR = new Vector();
      Date fDesde, fHasta;
      Time horaDesde, horaHasta;
      
      horaDesde = new Time(8, 0, 0);
      horaHasta = new Time(12, 0, 0);
      
      // primer horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Lunes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // segundo horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Martes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // tercer horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Miércoles");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // cuarto horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Jueves");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // quinto horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Viernes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // régimen horario
      RH = new RegimenHorario();
      RH.setCodigo(1);
      RH.setNombre("Común Semana");
      RH.setHorariosRegimen(vHR);
      
      fDesde = new Date();
      fDesde.setDate(21);
      fDesde.setMonth(5 - 1);
      fDesde.setYear(2009 - 1900);
      
      fHasta = new Date();
      fHasta.setDate(5);
      fHasta.setMonth(12 - 1);
      fHasta.setYear(2010 - 1900);
      
      tipoCH = new TipoControlHorario();
      tipoCH.setCodigo(1);
      tipoCH.setDescripcion("Entrada");
      
      RA = new RegimenAsignado();
      RA.setEmpleado(empl);
      RA.setRegimenHorario(RH);
      RA.setFechaDesde(fDesde);
      RA.setFechaHasta(fHasta);
      RA.setTipoCH(tipoCH);
      
      vRA.addElement(RA);
   } // fin del método cargaRA1
   
   /**
    * 
    * @param empl 
    */
   private void cargaRA2(Empleado empl){
      RegimenAsignado RA;
      RegimenHorario RH;
      HorarioRegimen HR;
      TipoControlHorario tipoCH;
      Vector vHR = new Vector();
      Date fDesde, fHasta;
      Time horaDesde, horaHasta;
      
      horaDesde = new Time(14, 0, 0);
      horaHasta = new Time(18, 0, 0);
      
      // primer horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Lunes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // segundo horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Martes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // tercer horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Miércoles");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // cuarto horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Jueves");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // quinto horario régimen
      HR = new HorarioRegimen();
      HR.setNombreDia("Viernes");
      HR.setHoraDesde(horaDesde);
      HR.setHoraHasta(horaHasta);
      
      vHR.addElement(HR);
      
      // régimen horario
      RH = new RegimenHorario();
      RH.setCodigo(1);
      RH.setNombre("Común Semana");
      RH.setHorariosRegimen(vHR);
      
      fDesde = new Date();
      fDesde.setDate(21);
      fDesde.setMonth(5 - 1);
      fDesde.setYear(2009 - 1900);
      
      fHasta = new Date();
      fHasta.setDate(5);
      fHasta.setMonth(12 - 1);
      fHasta.setYear(2010 - 1900);
      
      tipoCH = new TipoControlHorario();
      tipoCH.setCodigo(1);
      tipoCH.setDescripcion("Entrada");
      
      RA = new RegimenAsignado();
      RA.setEmpleado(empl);
      RA.setRegimenHorario(RH);
      RA.setFechaDesde(fDesde);
      RA.setFechaHasta(fHasta);
      RA.setTipoCH(tipoCH);
      
      vRA.addElement(RA);
   } // fin del método cargaRA2
   
   private void cargaMar(Empleado empl){Marcada marcada;
      Time hE, hS;
      Date fecha;
      
      hE = new Time(8, 5, 0);
      hS = new Time(11, 55, 0);
      
      // marcada 1
      
      fecha = new Date();
      fecha.setDate(25);
      fecha.setMonth(5 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(0));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
      
      // marcada 2
      
      fecha = new Date();
      fecha.setDate(26);
      fecha.setMonth(5 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(1));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
      
      // marcada 3
      
      fecha = new Date();
      fecha.setDate(27);
      fecha.setMonth(5 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(2));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
      
      // marcada 4
      
      fecha = new Date();
      fecha.setDate(28);
      fecha.setMonth(5 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(3));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
      
      // marcada 5
      
      fecha = new Date();
      fecha.setDate(29);
      fecha.setMonth(5 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(4));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
      
      
      // marcada 6
      
      fecha = new Date();
      fecha.setDate(3);
      fecha.setMonth(6 - 1);
      fecha.setYear(2009 - 1900);
      
      marcada = new Marcada();
      
      marcada.setEmpleado(empl);
      marcada.setFecha(fecha);
      marcada.setHoraEntrada(hE);
      marcada.setHoraSalida(hS);
      marcada.setRegimenAsignado((RegimenAsignado) vRA.get(0));
      marcada.setHorarioRegimen((HorarioRegimen) ((RegimenAsignado) vRA.get(0))
              .getRegimenHorario().getHorariosRegimen().get(2));
      marcada.setValidez("Válida");
      
      vMarcadas.addElement(marcada);
   }
   
   private void cargaVRT(){
      VigenciaRangoTardanza vigenciaRT = new VigenciaRangoTardanza();
      RangoDeTardanza rangoT;
      
      TipoHorasTrabajadas tipoHT = new TipoHorasTrabajadas();
      tipoHT.setHoraDesde(7);
      tipoHT.setHoraHasta(9);
      
      Date fDesde = new Date();
      fDesde.setDate(1);
      fDesde.setMonth(1 - 1);
      fDesde.setYear(2009 - 1900);
      
      Date fHasta = new Date();
      fHasta.setDate(1);
      fHasta.setMonth(1 - 1);
      fHasta.setYear(2011 - 1900);
      
      // rango 1
      
      rangoT = new RangoDeTardanza();
      rangoT.setCdadDiasPerdon(3);
      rangoT.setMinutosDesde(1);
      rangoT.setMinutosHasta(6);
      rangoT.setPorcentajeDescuento(2);
      
      vigenciaRT.setRangoDeTardanza(rangoT);
      
      // rango 2
      
      rangoT = new RangoDeTardanza();
      rangoT.setCdadDiasPerdon(3);
      rangoT.setMinutosDesde(6);
      rangoT.setMinutosHasta(15);
      rangoT.setPorcentajeDescuento(5);
      
      vigenciaRT.setFechaDesde(fDesde);
      vigenciaRT.setFechaHasta(fHasta);
      vigenciaRT.setTipoHorasTrabajadas(tipoHT);
      
      vVigenciaRT.addElement(vigenciaRT);
   }
} // fin de la clase IndireccionPersistencia