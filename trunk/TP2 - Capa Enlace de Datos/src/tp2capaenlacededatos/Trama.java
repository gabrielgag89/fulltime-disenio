// Trama: Trama.java
// 

package tp2capaenlacededatos;

/**
 *
 * @author gabriel
 */
public class Trama {
   /**
    * Bandera de inicio.
    */
   private char byteInicio = '\t';
   /**
    * Número de secuencia de la trama.
    */
   private char numSec;
   /**
    * Indica si es una trama con datos o confirmacion de recepción.
    */
   private char msj_ack;
   /**
    * Dato a recibir.
    */
   private char dato;
   /**
    * Suma de verificación.
    */
   private char sumVerif;
   /**
    * Bandera de fin.
    */
   private char byteFin = '\n';
   
   public Trama(){
      
   }

   public Trama(char numSec, char msj_ack, char dato, char sumVerif){
      this.numSec = numSec;
      this.msj_ack = msj_ack;
      this.dato = dato;
      this.sumVerif = sumVerif;
   }
   
   public char getByteInicio() {
      return byteInicio;
   }

   public void setByteInicio(char byteInicio) {
      this.byteInicio = byteInicio;
   }

   public char getNumSec() {
      return numSec;
   }

   public void setNumSec(char numSec) {
      this.numSec = numSec;
   }

   public char getMsj_ack() {
      return msj_ack;
   }

   public void setMsj_ack(char msj_ack) {
      this.msj_ack = msj_ack;
   }

   public char getDato() {
      return dato;
   }

   public void setDato(char dato) {
      this.dato = dato;
   }

   public char getSumVerif() {
      return sumVerif;
   }

   public void setSumVerif(char sumVerif) {
      this.sumVerif = sumVerif;
   }

   public char getByteFin() {
      return byteFin;
   }

   public void setByteFin(char byteFin) {
      this.byteFin = byteFin;
   }
   
   public String tramaToString(){
      return ("" + byteInicio + numSec + msj_ack + dato + sumVerif + byteFin);
   }
} // fin de la clase Trama
