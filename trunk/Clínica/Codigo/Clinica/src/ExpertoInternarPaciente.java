import java.sql.SQLException;

public class ExpertoInternarPaciente {
   public DTOPaciente buscarPaciente(String dni) throws SQLException {
      DTOPaciente paciente = new DTOPaciente();
      Paciente p = (Paciente) FachadaPersistencia.getInstancia().buscar("Paciente", dni);
      
      //lleno el dto con los datos del paciente
      paciente.setDni(p.getDni());             
      paciente.setNombre(p.getNombre());
      paciente.setTel(p.getTel());
      paciente.setNombrePlan(p.getPlan().getNombrePlan());
      
      return paciente;        
   }
}