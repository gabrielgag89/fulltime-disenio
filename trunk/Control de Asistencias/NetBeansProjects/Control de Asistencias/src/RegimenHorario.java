// RegimenHorario: RegimenHorario.java
// 

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class RegimenHorario {
   private int codigo;
   private String nombre;
   private Vector horariosRegimen;

   public int getCodigo() {
      return codigo;
   }

   public void setCodigo(int codigo) {
      this.codigo = codigo;
   }

   public Vector getHorariosRegimen() {
      return horariosRegimen;
   }

   public void setHorariosRegimen(Vector horariosRegimen) {
      this.horariosRegimen = horariosRegimen;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
} // fin de la clase RegimenHorario