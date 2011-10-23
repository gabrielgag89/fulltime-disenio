// FabricaDeIntermediarios: FabricaDeIntermediarios.java
// Fábrica encargada de crear el intermediario correspondiente a la solicitud.

package persistencia.plantilla;

/**
 * Fábrica encargada de crear el intermediario correspondiente a la solicitud.
 * @author Gabriel
 */
public class FabricaDeIntermediarios {
   /**
    * Instancia de la fábrica de intermediarios.
    */
   private static FabricaDeIntermediarios instancia;

   /**
    * Devuelve la instancia almacenada en el atributo {@code instancia}. Si actualmente su valor
    * es {@code null}, crea una instancia y se la asigna, sino devuelve la referencia a la instancia
    * ya existente.
    * @return la instancia almacenada en el atributo {@code instancia}
    */
   public static FabricaDeIntermediarios getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FabricaDeIntermediarios();
      
      return instancia;
   } // fin del método getInstancia

   /**
    * Crea y devuelve el intermediario solicitado, correspondiente al nombre de la entidad recibido 
    * como parámetro.
    * @param entidad nombre del intermediario solicitado
    * @return el intermediario solicitado
    */
   public IntermediarioPersistencia getIntermediario(String entidad){
      try {
         String claseInt = "persistencia.plantilla.IPR" + entidad;
         return (IntermediarioPersistencia) Class.forName(claseInt).newInstance();
      }
      catch (InstantiationException ex) {
         System.out.println("FabricaDeIntermediarios - InstantiationException: " + ex.getMessage());
         return null;
      }
      catch (IllegalAccessException ex) {
         System.out.println("FabricaDeIntermediarios - IllegalAccessException: " + ex.getMessage());
         return null;
      }
      catch (ClassNotFoundException ex) {
         System.out.println("FabricaDeIntermediarios - ClassNotFoundException: " + ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método getIntermediario
} // fin de la clase 