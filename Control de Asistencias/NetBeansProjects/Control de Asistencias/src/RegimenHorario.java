// RegimenHorario: RegimenHorario.java
// 

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class RegimenHorario {
   private int codigoRH;
   private String nombreRH;
   private Vector horariosRegimen;

   public int getCodigoRH() {
      return codigoRH;
   }

   public void setCodigoRH(int codigoRH) {
      this.codigoRH = codigoRH;
   }

   public String getNombreRH() {
      return nombreRH;
   }

   public void setNombreRH(String nombreRH) {
      this.nombreRH = nombreRH;
   }

   public Vector getHorariosRegimen() {
      return horariosRegimen;
   }

   public void setHorariosRegimen(Vector horariosRegimen) {
      this.horariosRegimen = horariosRegimen;
   }
} // fin de la clase RegimenHorario