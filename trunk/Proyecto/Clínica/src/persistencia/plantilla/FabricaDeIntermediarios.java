// FabricaDeIntermediarios: FabricaDeIntermediarios.java
// Fábrica encargada de crear el intermediario correspondiente a la solicitud.

package persistencia.plantilla;

/**
 * Fábrica encargada de crear el intermediario correspondiente a la solicitud.
 * @author Gabriel
 */
public class FabricaDeIntermediarios {
   private static FabricaDeIntermediarios instancia;
   
   public static FabricaDeIntermediarios getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FabricaDeIntermediarios();
      
      return instancia;
   } // fin del método getInstancia
   
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
} // fin de la clase FabricaDeIntermediarios