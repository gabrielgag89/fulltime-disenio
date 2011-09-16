


import java.sql.SQLException;

public class ControladorInternarPaciente {

   public DtoPaciente buscarPaciente(String dni) throws SQLException {
      ExpertoInternarPaciente exp = new ExpertoInternarPaciente();
      return exp.buscarPaciente(dni);
   }
   
}
