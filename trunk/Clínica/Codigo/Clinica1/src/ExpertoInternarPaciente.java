


import java.sql.SQLException;

public class ExpertoInternarPaciente {

   public DtoPaciente buscarPaciente(String dni) throws SQLException {
      DtoPaciente paciente = new DtoPaciente();
      Paciente p = (Paciente) FachadaPersistencia.getInstancia().buscar("Paciente", dni);
      //lleno el dto con los datos del paciente
      paciente.setDni(p.getDni());             
      paciente.setNombre(p.getNombre());
      paciente.setTel(p.getTel());
      
      return paciente;        
   }
   
}
