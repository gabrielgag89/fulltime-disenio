// Marcada: Marcada.java
// 

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Marcada {
   private Date fecha;
   private Time horaEntrada;
   private Time horaSalida;
   private String validez;
   public Empleado empleado;
   public RelojPersonal relojPersonal;
   public HorarioRegimen horarioRegimen;
   public RegimenAsignado regimenAsignado;

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public Time getHoraEntrada() {
      return horaEntrada;
   }

   public void setHoraEntrada(Time horaEntrada) {
      this.horaEntrada = horaEntrada;
   }

   public Time getHoraSalida() {
      return horaSalida;
   }

   public void setHoraSalida(Time horaSalida) {
      this.horaSalida = horaSalida;
   }

   public String getValidez() {
      return validez;
   }

   public void setValidez(String validez) {
      this.validez = validez;
   }

   public Empleado getEmpleado() {
      return empleado;
   }

   public void setEmpleado(Empleado empleado) {
      this.empleado = empleado;
   }

   public RelojPersonal getRelojPersonal() {
      return relojPersonal;
   }

   public void setRelojPersonal(RelojPersonal relojPersonal) {
      this.relojPersonal = relojPersonal;
   }

   public HorarioRegimen getHorarioRegimen() {
      return horarioRegimen;
   }

   public void setHorarioRegimen(HorarioRegimen horarioRegimen) {
      this.horarioRegimen = horarioRegimen;
   }

   public RegimenAsignado getRegimenAsignado() {
      return regimenAsignado;
   }

   public void setRegimenAsignado(RegimenAsignado regimenAsignado) {
      this.regimenAsignado = regimenAsignado;
   }
} // fin de la clase Marcada