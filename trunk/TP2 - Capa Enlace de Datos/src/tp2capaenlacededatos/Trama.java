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
} // fin de la clase Trama
