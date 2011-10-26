package persistencia.proxy;

import persistencia.FachadaPersistenciaInterna;

public class PacienteAgente extends ObjetoPersistente implements Paciente{
   private PacienteImpl impl;
   private String oidPlan;
   private boolean plan = false;

   public void setImplementacion(PacienteImpl impl) {
      this.impl = impl;
   }

    public String getOidPlan() {
        return oidPlan;
    }
    
    public void setOidPlan(String oidPlan) {
        this.oidPlan = oidPlan;
    }

   @Override
   public int getDni() {
      return this.impl.getDni();
   }

   @Override
   public void setDni(int dni) {
      this.impl.setDni(dni);
   }

   @Override
   public String getDomicilio() {
      return this.impl.getDomicilio();
   }

   @Override
   public void setDomicilio(String domicilio) {
      this.impl.setDomicilio(domicilio);
   }

   @Override
   public Plan getPlan() {
      if(!plan){
           this.impl.setPlan((Plan)FachadaPersistenciaInterna.getInstancia()
                   .buscar("Plan", oidPlan));        
           this.plan = true;
      }
       return this.impl.getPlan();
   }

   @Override
   public void setPlan(Plan plan) {
      this.impl.setPlan(plan);
   }

   @Override
   public String getNombre() {
      return this.impl.getNombre();
   }

   @Override
   public void setNombre(String nombreP) {
      this.impl.setNombre(nombreP);
   }

   @Override
   public int getNumPaciente() {
      return this.impl.getNumPaciente();
   }

   @Override
   public void setNumPaciente(int numPaciente) {
      this.impl.setNumPaciente(numPaciente);
   }

   @Override
   public String getTelefono() {
      return this.impl.getTelefono();
   }

   @Override
   public void setTelefono(String telefono) {
      this.impl.setTelefono(telefono);
   }


    public void setOidPlan(String oidPlan) {
        this.oidPlan = oidPlan;
    }

    public String getOidPlan() {
        return oidPlan;
    }
    

}//fin paciente agente