// DTODiaATrabajar: DTODiaATrabajar.java
// 

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class DTODiaATrabajar {
   private Date fecha;
   private double horasDia;
   private double minutosDescuento = 0;

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public double getHorasDia() {
      return horasDia;
   }

   public void setHorasDia(double horasDia) {
      this.horasDia = horasDia;
   }

   public double getMinutosDescuento() {
      return minutosDescuento;
   }

   public void setMinutosDescuento(double minutosDescuento) {
      this.minutosDescuento = minutosDescuento;
   }
   
   public void sumarHorasDia(double horasDia){
      this.horasDia += horasDia;
   }
   
   public void sumarMinutosDescuento(double minutosDescuento){
      this.minutosDescuento += minutosDescuento;
   }
} // fin de la clase DTODiaATrabajar