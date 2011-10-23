// ObjetoPersistente: ObjetoPersistente.java
// Objeto con los datos necesarios para persistir las entidades.

package persistencia.proxy;

import java.util.UUID;

/**
 * Objeto con los datos necesarios para persistir las entidades.
 * @author gabriel
 */
public class ObjetoPersistente {
   /**
    * Identificador del objeto.
    */
   protected String ido;
   /**
    * Indica si el objeto es nuevo o se ha recuperado.
    */
   protected boolean nuevo;

   /**
    * Genera y devuelve un identificador de objeto.
    * @return un identificador de objeto
    */
   public String generarOid(){
      return UUID.randomUUID().toString();
   } // fin del método generarOid

   /**
    * Obtiene el identificador del objeto.
    * @return el identificador del objeto
    */
   public String getOid(){
      return ido;
   } // fin del método getOid

   /**
    * Establece el identificador del objeto.
    * @param id identificador del objeto a establecer
    */
   public void setOid(String ido){
      this.ido = ido;
   } // fin del método setOid

   /**
    * Comprueba si el objeto es nuevo.
    * @return {@code true} - si es nuevo<br>
    * {@code false} - si no es nuevo
    */
   public boolean getNuevo(){
      return nuevo;
   } // fin del método getNuevo

   /**
    * Establece si el objeto es nuevo.
    * @param nuevo estado a asignar al objeto
    */
   public void setNuevo(boolean nuevo){
      this.nuevo = nuevo;
   } // fin del método setNuevo
} // fin de la clase ObjetoPersistente