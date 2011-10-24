package persistencia.proxy;

import java.util.List;

public class PacienteImplementacion implements Paciente {
   private int numeroPaciente;
   private String nombrePaciente;
   private int dni;
   private String domicilio;
   private String telefono;
   private List<Plan> planes;

   @Override
   public int getDni() {
      return this.dni;
   }

   @Override
   public void setDni(int dni) {
      this.dni = dni;
   }

   @Override
   public String getDomicilio() {
      return this.domicilio;
   }

   @Override
   public void setDomicilio(String domicilio) {
      this.domicilio = domicilio;
   }

   @Override
   public List<Plan> getPlanes() {
      return this.planes;
   }

   @Override
   public void setPlanes(List<Plan> plans) {
      this.planes = plans;
   }

   @Override
   public String getNombre() {
      return this.nombrePaciente;
      }

   @Override
   public void setNombre(String nombreP) {
      this.nombrePaciente = nombreP;
   }

   @Override
   public int getNumPaciente() {
      return this.numeroPaciente;
   }

   @Override
   public void setNumPaciente(int numPaciente) {
      this.numeroPaciente = numPaciente;
   }

   @Override
   public String getTelefono() {
      return this.telefono;
   }

   @Override
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   @Override
   public void addPlan(Plan p) {
      this.planes.add(p);
   }

   @Override
   public void removerPlan(Plan p) {
      this.planes.remove(p);
   }
}//end Paciente