


public class FachadaPersistencia {
   
   private static FachadaPersistencia instancia = null;

   
   public static FachadaPersistencia getInstancia() {
      if(instancia == null)
         instancia = new FachadaPersistencia();
      return instancia;
   }
   
   public Object buscar(String tipo, String valor){            
      return FabricaIntermediarios.getInstancia().getIntermediario(tipo).buscar(valor);
   }
   
   public void guardar(String tipo, Object objeto){
      FabricaIntermediarios.getInstancia().getIntermediario(tipo).guardar(objeto);        
      
   }
}
