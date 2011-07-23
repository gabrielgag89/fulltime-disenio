// : DTODiaATrabajar.java
// 

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class DTODiaATrabajar {
   private Date fecha;
   private String nombreDia;
   private double horasDia;
   private double minutosTardanza = 0;

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

   public String getNombreDia() {
      return nombreDia;
   }

   public void setNombreDia(String nombreDia) {
      this.nombreDia = nombreDia;
   }

   public double getMinutosTardanza() {
      return minutosTardanza;
   }

   public void setMinutosTardanza(double minutosTardanza) {
      this.minutosTardanza = minutosTardanza;
   }
   
   public void sumarHorasDia(double horasDia){
      this.horasDia += horasDia;
   }
   
   public void sumarMinutosTardanza(double minutosTardanza){
      this.minutosTardanza += minutosTardanza;
   }
} // fin de la clase DTODiaATrabajar