// FabricaEstrategiaCalcularMinutosTardanza: FabricaEstrategiaCalcularMinutosTardanza.java
// 

/**
 *
 * @author Gabriel
 */
public class FabricaEstrategiaCalcularMinutosTardanza {
   private static FabricaEstrategiaCalcularMinutosTardanza instancia;
   
   /**
    * 
    * @return 
    */
   public static FabricaEstrategiaCalcularMinutosTardanza getInstancia(){
      if(instancia == null)
         instancia = new FabricaEstrategiaCalcularMinutosTardanza();
      
      return instancia;
   } // fin del método getInstancia
   
   public EstrategiaCalcularMinutosTardanza getEstrategiaCalcularMinutosTardanza(Marcada marcada){
      String nombre = marcada.getRegimenAsignado().getTipoCH().getDescripcion();
      
      try {
         String claseInt = "EstrategiaCalcularMinutosTardanza"+nombre;
         return (EstrategiaCalcularMinutosTardanza) Class.forName(claseInt).newInstance();
      }
      catch (InstantiationException ex) {
         System.out.println("FabricaEstrategiaCalculoTardanza - InstantiationException: "+ex.getMessage());
         return null;
      }
      catch (IllegalAccessException ex) {
         System.out.println("FabricaEstrategiaCalculoTardanza - IllegalAccessException: "+ex.getMessage());
         return null;
      }
      catch (ClassNotFoundException ex) {
         System.out.println("FabricaEstrategiaCalculoTardanza - ClassNotFoundException: "+ex.getMessage());
         return null;
      } // fin de try... catch
   } // fin del método getEstrategiaCalculoTardanza
} // fin de la clase FabricaEstrategiaCalcularMinutosTardanza