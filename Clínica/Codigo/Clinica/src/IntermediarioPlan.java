import java.sql.ResultSet;
import java.sql.SQLException;

class IntermediarioPlan implements IntermediarioPersistencia {
   public IntermediarioPlan() {
   }
   
   @Override
   public Object buscar(String valor) {
      PlanAgente p = new PlanAgente();
      String consulta = "SELECT * FROM plan WHERE codigo = "+valor;
      ResultSet rs;
      
      try {
         rs = FabricaConexiones.getInstancia().getConexion().createStatement().executeQuery(consulta);
         while(rs.next()){
            p.setCodigoPlan(rs.getInt("codigo"));
            p.setNombrePlan(rs.getString("nombre"));
         }
      } catch (SQLException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      } catch (ClassNotFoundException ex) {
         System.err.println("ERROR:"+ex.getMessage());
      }
      
      return p;
   }

   @Override
   public void guardar(Object objeto) {
      PlanAgente p = (PlanAgente)objeto;
      String consulta = String.format("INSERT INTO plan VALUES (%d, '%s')", p.getCodigoPlan(), p.getNombrePlan());
      
      try{
         FabricaConexiones.getInstancia().getConexion().createStatement().executeQuery(consulta);
      }
      catch(SQLException e){
         System.err.println("ERROR:"+e.getMessage());
      }
      catch(ClassNotFoundException ex ){
         System.err.println("ERROR:"+ex.getMessage());
      }
   }
}