



public class FabricaIntermediarios {
   
   private static FabricaIntermediarios instancia = null;

   
   public static FabricaIntermediarios getInstancia() {
      if(instancia == null)
         instancia = new FabricaIntermediarios();
      return instancia;
   }
   
   public IntermediarioPersistencia getIntermediario(String tipo){
      IntermediarioPersistencia i = null;
      if(tipo.equalsIgnoreCase("Paciente"))
         i = new IntermediarioPaciente();
      else if(tipo.equalsIgnoreCase("Plan"))
         i = new IntermediarioPlan();
      else if(tipo.equalsIgnoreCase("ObraSocial"))
         i = new IntermediarioObraSocial();
      return i;
   }
   
   
}
