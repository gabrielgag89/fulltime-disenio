// FabricaEstrategiaCalculoTardanza: FabricaEstrategiaCalculoTardanza.java
// 

/**
 *
 * @author Gabriel
 */
public class FabricaEstrategiaCalculoTardanza {
   private static FabricaEstrategiaCalculoTardanza instancia;
   
   /**
    * 
    * @return 
    */
   public static FabricaEstrategiaCalculoTardanza getInstancia(){
      if(instancia == null)
         instancia = new FabricaEstrategiaCalculoTardanza();
      
      return instancia;
   } // fin del método getInstancia
   
   public EstrategiaCalculoTardanza getEstrategiaCalculoTardanza(Marcada marcada){
      String nombre = marcada.getRegimenAsignado().getTipoCH().getDescripcion();
      
      try {
         String claseInt = "EstrategiaCalculoTardanza"+nombre;
         return (EstrategiaCalculoTardanza) Class.forName(claseInt).newInstance();
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
} // fin de la clase FabricaEstrategiaCalculoTardanza