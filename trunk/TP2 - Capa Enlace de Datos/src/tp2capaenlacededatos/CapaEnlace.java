// CapaEnlace: CapaEnlace.java
// 

package tp2capaenlacededatos;

/**
 *
 * @author gabriel
 */
public class CapaEnlace {
   public static final char esMsj = 10;
   public static final char esAck = 20;
   
   public void enviarPaquete(Trama trama){
      
   }
   
   public void desdeFisica(Trama trama){
      
   }
   
   public char calcSumVerif(Trama t){
      long suma = t.getByteInicio() + t.getNumSec() + t.getDato() + t.getByteFin();
      
      return (char) suma;
   }
} // fin de la clase CapaEnlace