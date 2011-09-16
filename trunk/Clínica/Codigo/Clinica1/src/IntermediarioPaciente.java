


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class IntermediarioPaciente implements IntermediarioPersistencia{
   

   @Override
   public Object buscar(String tipo, String valor) {
      Paciente p = null;
      String consulta = "SELECT * FROM paciente WHERE dni = '"+valor+"'";
      ResultSet rs;
      try {
         rs = FabricaConexiones.getInstancia().getConexion().createStatement().executeQuery(consulta);
         while(rs.next()){
            p.setDni(rs.getString("dni"));
            p.setNombre(rs.getString("nombre"));
            p.setTel(rs.getString("telefono"));
         }
      } catch (SQLException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      } catch (ClassNotFoundException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      }
      
      return p;
   }

   @Override
   public void guardar(String tipo, Object objeto) {
      
      PacienteAgente p = (PacienteAgente)objeto;
   }
   
}
