


public class PlanImplementacion implements Plan {
   
   private int codigoPlan;
   private String nombrePlan;

   
   
   @Override
   public int getCodigoPlan() {
      return codigoPlan;
   }

   @Override
   public void setCodigoPlan(int codigoPlan) {
      this.codigoPlan = codigoPlan;
   }

   @Override
   public String getNombrePlan() {
      return nombrePlan;
   }

   @Override
   public void setNombrePlan(String nombrePlan) {
      this.nombrePlan = nombrePlan;
   }
     
   
}
