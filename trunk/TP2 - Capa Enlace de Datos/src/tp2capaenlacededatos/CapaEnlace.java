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
   private  static char tramaEsperada = '0';
   
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
         
         boolean recibo = false;
         
         while(!recibo){
            CapaFisica.getinstancia().enviarTrama(trama);
            
            int intentos = 3;
            
            while(intentos > 0){
               if(recibos[numSec] == false){
                  for(int i = 0; i < 5000; i++){
                     // espera
                  }
                  
                  intentos--;
               }
               else{
                  recibo = true;
                  break;
               }
            }
         }
         
         numSec++;
      }
   }
   
   public void desdeFisica(Trama trama) {
              
       if(trama.getMsj_ack() == CapaEnlace.esMsj){//recibo datos
          if(trama.getNumSec() == tramaEsperada){//es la trama esperada
             if(trama.getSumVerif() == this.calcSumVerif(trama)){//cumple suma verif
                 //muestra en la capa de red
                 CapaRed.getCapa().recibirPaquete(trama.tramaToString().toCharArray());
                 Trama t = new Trama((char)tramaEsperada, CapaEnlace.esAck, '1');
                 CapaFisica.getinstancia().enviarTrama(t);//envio confirmacion
                 tramaEsperada = (char)((int)tramaEsperada + 1);
             } 
          } 
       }else {// es ack
           recibos[(int)tramaEsperada] = true;
       }
   }//fin desde fisica
   
   private char calcSumVerif(Trama t){
      long suma = t.getByteInicio() + t.getNumSec() + t.getDato() + t.getByteFin();      
      return (char) suma;
   }
} // fin de la clase CapaEnlace