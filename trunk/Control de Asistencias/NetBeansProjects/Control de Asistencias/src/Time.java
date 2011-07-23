// : Time.java
// 

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Time {
   private int hora;
   private int minuto;
   private int segundo;
   
   public Time(){
      
   }
   
   public Time(Date fecha){
      this.hora = fecha.getHours();
      this.minuto = fecha.getMinutes();
      this.segundo = fecha.getSeconds();
   }
   
   public Time(int hora, int minuto, int segundo){
      this.hora = hora;
      this.minuto = minuto;
      this.segundo = segundo;
   }

   public int getHora() {
      return hora;
   }

   public int getMinuto() {
      return minuto;
   }

   public int getSegundo() {
      return segundo;
   }

   public void setHora(int hora) {
      this.hora = hora;
   }

   public void setMinuto(int minuto) {
      this.minuto = minuto;
   }

   public void setSegundo(int segundo) {
      this.segundo = segundo;
   }
} // fin de la clase Time
