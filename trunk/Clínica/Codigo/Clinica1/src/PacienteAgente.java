


public class PacienteAgente implements Paciente {

   private PacienteImplementacion implementacion;
   private String oidPlan;
   private boolean isPlan = false; 
   
   
   
   public PacienteAgente() {
      this.implementacion = new PacienteImplementacion();
   }
   
   
   @Override
   public String getDni() {
      return this.implementacion.getDni();
   }

   @Override
   public void setDni(String dni) {
      this.implementacion.setDni(dni);
   }

   @Override
   public String getNombre() {
      return this.implementacion.getNombre();
   }

   @Override
   public void setNombre(String nombre) {
      this.implementacion.setNombre(nombre);
   }

   @Override
   public String getTel() {
      return this.implementacion.getTel();
   }

   @Override
   public void setTel(String tel) {
      this.implementacion.setTel(tel);
   }

   @Override
   public Plan getPlan() {
      if(this.isPlan)
         return this.implementacion.getPlan();
      else{
         Plan p =(Plan) FachadaPersistencia.getInstancia().buscar("Plan", this.oidPlan);
         this.implementacion.setPlan(p);
         this.isPlan = true;
         return p;      
      
      }
   }

   @Override
   public void setPlan(Plan p) {
      this.implementacion.setPlan(p);
   }
   
   public boolean isIsPlan() {
      return isPlan;
   }

   public void setIsPlan(boolean isPlan) {
      this.isPlan = isPlan;
   }

   public String getOidPlan() {
      return oidPlan;
   }

   public void setOidPlan(String oidPlan) {
      this.oidPlan = oidPlan;
   }
  
     
}
