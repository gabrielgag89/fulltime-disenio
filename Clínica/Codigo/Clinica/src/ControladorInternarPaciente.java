import java.sql.SQLException;

public class ControladorInternarPaciente {
   public DTOPaciente buscarPaciente(String dni) throws SQLException {
      ExpertoInternarPaciente exp = new ExpertoInternarPaciente();
      return exp.buscarPaciente(dni);
   }
}