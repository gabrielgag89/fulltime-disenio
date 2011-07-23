// RegimenAsignado: RegimenAsignado.java
// 

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class RegimenAsignado {
   private Date fechaDesde;
   private Date fechaHasta;
   private RegimenHorario regimenHorario;
   private Oficina oficina;
   private TipoControlHorario tipoCH;
   private Empleado empleado;

   public Empleado getEmpleado() {
      return empleado;
   } // fin del método getEmpleado

   public void setEmpleado(Empleado empleado) {
      this.empleado = empleado;
   } // fin del método setEmpleado

   public Date getFechaDesde() {
      return fechaDesde;
   } // fin del método getFechaDesde

   public void setFechaDesde(Date fechaDesde) {
      this.fechaDesde = fechaDesde;
   } // fin del método setFechaDesde

   public Date getFechaHasta() {
      return fechaHasta;
   } // fin del método getFechaHasta

   public void setFechaHasta(Date fechaHasta) {
      this.fechaHasta = fechaHasta;
   } // fin del método setFechaHasta

   public Oficina getOficina() {
      return oficina;
   } // fin del método getOficina

   public void setOficina(Oficina oficina) {
      this.oficina = oficina;
   } // fin del método setOficina

   public RegimenHorario getRegimenHorario() {
      return regimenHorario;
   } // fin del método getRegimenHorario

   public void setRegimenHorario(RegimenHorario regimenHorario) {
      this.regimenHorario = regimenHorario;
   } // fin del método setRegimenHorario

   public TipoControlHorario getTipoCH() {
      return tipoCH;
   } // fin del método getTipoCH

   public void setTipoCH(TipoControlHorario tipoCH) {
      this.tipoCH = tipoCH;
   } // fin del método setTipoCH
} // fin de la clase RegimenAsignado