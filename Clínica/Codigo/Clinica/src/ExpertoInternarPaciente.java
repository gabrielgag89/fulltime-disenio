import java.sql.SQLException;

public class ExpertoInternarPaciente {
   public DTOPaciente buscarPaciente(String dni) throws SQLException {
      DTOPaciente paciente = null;
      Paciente p = (Paciente) FachadaPersistencia.getInstancia().buscar("Paciente", dni);
      if(p != null){
          paciente = new DTOPaciente();
          paciente.setDni(p.getDni());             
          paciente.setNombre(p.getNombre());
          paciente.setTel(p.getTel());
          paciente.setNombrePlan(p.getPlan().getNombrePlan());
      } 
      
      return paciente;        
   }
}