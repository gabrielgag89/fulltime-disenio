import java.sql.ResultSet;
import java.sql.SQLException;

public class IntermediarioPaciente implements IntermediarioPersistencia{
   @Override
   public Object buscar(String valor) {
      PacienteAgente p = null;
      String consulta = "SELECT * FROM paciente WHERE dni = '"+valor+"'";
      System.out.println(consulta);
      ResultSet rs;
      
      try {
         rs = FabricaConexiones.getInstancia().getConexion().createStatement().executeQuery(consulta);
         p = new PacienteAgente();
         while(rs.next()){
            p.setDni(rs.getString("dni"));
            p.setNombre(rs.getString("nombre_paciente"));
            p.setTel(rs.getString("telefono"));
            p.setOidPlan(rs.getString("oidplan"));
         }
      } catch (SQLException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      } catch (ClassNotFoundException e){
         System.err.println("ERROR:"+e.getMessage());
      }     
      return p;
   }

   @Override
   public void guardar(Object objeto) {      
      PacienteAgente p = (PacienteAgente)objeto;
      String consulta = String.format("INSERT INTO paciente VALUES ('%s', '%s', '%s', '%s')", p.getDni(), p.getNombre(), p.getTel(), p.getOidPlan());
      try{
      FabricaConexiones.getInstancia().getConexion().createStatement().executeQuery(consulta);
      } catch (SQLException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      } catch (ClassNotFoundException e){
         System.err.println("ERROR:"+e.getMessage());
      }
   }
}