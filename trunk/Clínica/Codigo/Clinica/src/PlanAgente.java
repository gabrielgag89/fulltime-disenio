public class PlanAgente implements Plan {
   private PlanImplementacion implementacion;
    
   @Override
   public int getCodigoPlan() {
      return this.implementacion.getCodigoPlan();
   }
   
   @Override
   public void setCodigoPlan(int codigoPlan) {
      this.implementacion.setCodigoPlan(codigoPlan);      
   }

   @Override
   public String getNombrePlan() {
      return this.implementacion.getNombrePlan();
   }
   
   @Override
   public void setNombrePlan(String nombrePlan) {
      this.implementacion.setNombrePlan(nombrePlan);
              
   }
}