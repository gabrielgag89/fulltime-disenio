// CapaEnlace: CapaEnlace.java
// 

package tp2capaenlacededatos;

/**
 *
 * @author gabriel
 */
public class CapaEnlace {
   private static CapaEnlace capaEnlace;
   
   private static final char esMsj = 10;
   private static final char esAck = 20;
   private boolean[] recibos;
   
   public static CapaEnlace getInstancia(){
      if(capaEnlace == null)
         capaEnlace = new CapaEnlace();
      
      return capaEnlace;
   }
   
   public void enviarPaquetes(char[] paquetes){
      this.recibos = new boolean[paquetes.length];
      
      for(boolean recibo : recibos)
         recibo = false;
      
      Trama[] tramas = new Trama[paquetes.length];
      
      int numSec = 0;
         
      for(char paquete : paquetes){
         Trama trama = new Trama((char) numSec, CapaEnlace.esMsj, paquete);
         trama.setSumVerif(calcSumVerif(trama));
         
         tramas[numSec] = trama;
         
         CapaFisica.getinstancia().enviarTrama(trama);
         
         numSec++;
      }
   }
   
   public void desdeFisica(Trama trama){
      
   }
   
   private char calcSumVerif(Trama t){
      long suma = t.getByteInicio() + t.getNumSec() + t.getDato() + t.getByteFin();
      
      return (char) suma;
   }
} // fin de la clase CapaEnlace