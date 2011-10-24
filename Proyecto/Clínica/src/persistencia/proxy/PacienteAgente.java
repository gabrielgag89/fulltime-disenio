package persistencia.proxy;

import java.util.List;
import java.util.ArrayList;
import persistencia.FachadaPersistenciaInterna;
import persistencia.criterios.Criterio;

public class PacienteAgente extends ObjetoPersistente implements Paciente{
   private PacienteImplementacion implementacion;
   boolean heBuscadoPlanes = false;

   public void setImplementacion(PacienteImplementacion implementacion) {
      this.implementacion = implementacion;
   }

   public boolean isHeBuscadoPlanes() {
      return heBuscadoPlanes;
   }

   public void setHeBuscadoPlanes(boolean heBuscadoPlanes) {
      this.heBuscadoPlanes = heBuscadoPlanes;
   }

   @Override
   public int getDni() {
      return this.implementacion.getDni();
   }

   @Override
   public void setDni(int dni) {
      this.implementacion.setDni(dni);
   }

   @Override
   public String getDomicilio() {
      return this.implementacion.getDomicilio();
   }

   @Override
   public void setDomicilio(String domicilio) {
      this.implementacion.setDomicilio(domicilio);
   }

   @Override
   public List<Plan> getPlanes() {
      if(heBuscadoPlanes)
         return this.implementacion.getPlanes();
      else{
         List<Criterio> criterios = new ArrayList<Criterio>();
         criterios.add(new Criterio("OIDPlan","=",super.getOid()));

         for(ObjetoPersistente obj: FachadaPersistenciaInterna.getInstancia().buscar("Plan", criterios)){
            Plan p = (Plan)obj;
            this.implementacion.addPlan(p);
         }

         this.heBuscadoPlanes = true;

         return this.implementacion.getPlanes();
      }
   }

   @Override
   public void setPlanes(List<Plan> planes) {
      this.implementacion.setPlanes(planes);
   }

   @Override
   public String getNombre() {
      return this.implementacion.getNombre();
   }

   @Override
   public void setNombre(String nombreP) {
      this.implementacion.setNombre(nombreP);
   }

   @Override
   public int getNumPaciente() {
      return this.implementacion.getNumPaciente();
   }

   @Override
   public void setNumPaciente(int numPaciente) {
      this.implementacion.setNumPaciente(numPaciente);
   }

   @Override
   public String getTelefono() {
      return this.implementacion.getTelefono();
   }

   @Override
   public void setTelefono(String telefono) {
      this.implementacion.setTelefono(telefono);
   }

   @Override
   public void addPlan(Plan p) {
      this.implementacion.addPlan(p);
   }

   @Override
   public void removerPlan(Plan p) {
      this.implementacion.removerPlan(p);
   }
}//fin paciente agente