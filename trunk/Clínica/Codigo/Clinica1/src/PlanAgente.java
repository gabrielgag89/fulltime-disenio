


public class PlanAgente {
   
   private PlanImplementacion implementacion;
   
    
   public int getCodigoPlan() {
      return this.implementacion.getCodigoPlan();
   }
   
   public void setCodigoPlan(int codigoPlan) {
      this.implementacion.setCodigoPlan(codigoPlan);      
   }

   public String getNombrePlan() {
      return this.implementacion.getNombrePlan();
   }
   
   public void setNombrePlan(String nombrePlan) {
      this.implementacion.setNombrePlan(nombrePlan);
              
   }
     
   
}
