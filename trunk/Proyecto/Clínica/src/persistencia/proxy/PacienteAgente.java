package persistencia.proxy;

import java.util.List;
import java.util.ArrayList;
import persistencia.FachadaPersistenciaInterna;
import persistencia.criterios.Criterio;

public class PacienteAgente extends ObjetoPersistente implements Paciente{
   private PacienteImpl impl;
   boolean heBuscadoPlanes = false;

   public void setImplementacion(PacienteImpl impl) {
      this.impl = impl;
   }

   public boolean isHeBuscadoPlanes() {
      return heBuscadoPlanes;
   }

   public void setHeBuscadoPlanes(boolean heBuscadoPlanes) {
      this.heBuscadoPlanes = heBuscadoPlanes;
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
   public List<Plan> getPlanes() {
      if(heBuscadoPlanes)
         return this.impl.getPlanes();
      else{
           Criterio criterio = FachadaPersistenciaInterna.getInstancia().getCriterio("OIDPaciente","=",super.getOid());
           List<Plan> planes = FachadaPersistenciaInterna.getInstancia().buscar("Plan", criterio);
         for(Plan p: planes )
            this.impl.addPlan(p);
         
         this.heBuscadoPlanes = true;
         
         return this.impl.getPlanes();
      }
   }

   @Override
   public void setPlanes(List<Plan> planes) {
      this.impl.setPlanes(planes);
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

   @Override
   public void addPlan(Plan p) {
      this.impl.addPlan(p);
   }

   @Override
   public void removerPlan(Plan p) {
      this.impl.removerPlan(p);
   }
}//fin paciente agente