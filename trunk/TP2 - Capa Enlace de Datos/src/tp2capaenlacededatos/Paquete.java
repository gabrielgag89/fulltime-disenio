// Paquete: Paquete.java
// 
package tp2capaenlacededatos;

/**
 *
 * @author gabriel
 */
public class Paquete {
   char[] mensaje;
   
   public Paquete(){
      
   }
   
   public Paquete(char[] mensaje){
      this.mensaje = mensaje;
   }

   public char[] getMensaje() {
      return mensaje;
   }

   public void setMensaje(char[] mensaje) {
      this.mensaje = mensaje;
   }
} // fin de la clase Paquete
