// HorarioRegimen: HorarioRegimen.java
// 

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class HorarioRegimen {
   private Time horaDesde;
   private Time horaHasta;
   private String nombreDia;

   public Time getHoraDesde() {
      return horaDesde;
   }

   public void setHoraDesde(Time horaDesde) {
      this.horaDesde = horaDesde;
   }

   public Time getHoraHasta() {
      return horaHasta;
   }

   public void setHoraHasta(Time horaHasta) {
      this.horaHasta = horaHasta;
   }

   public String getNombreDia() {
      return nombreDia;
   }

   public void setNombreDia(String nombreDia) {
      this.nombreDia = nombreDia;
   }
} // fin de la clase HorarioRegimen