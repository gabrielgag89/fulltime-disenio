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
   private boolean tieneMarcada;

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

   public boolean isTieneMarcada() {
      return tieneMarcada;
   }

   public void setTieneMarcada(boolean tieneMarcada) {
      this.tieneMarcada = tieneMarcada;
   }
} // fin de la clase DTODiaATrabajar