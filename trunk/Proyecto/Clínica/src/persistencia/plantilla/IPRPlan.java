/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.plantilla;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.PlanAgente;
import persistencia.proxy.PlanImplementacion;
import persistencia.criterios.Criterio;


public class IPRPlan extends IntermPersistenciaDBR {
   @Override
   public String select() {
      return "SELECT * FROM plan";
   } 

   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM plan WHERE " + criterio.getStringCriterio();
   } 

   @Override
   public String select(String oid) {
      return "SELECT * FROM plan WHERE oidplan = '" + oid + "'";
   } 

   @Override
   public String insertar(Object objeto) {
      PlanAgente plant = (PlanAgente) objeto;
      return "INSERT INTO plan VALUES "
                  + "('" + plant.getOid() + "', "
                         + plant.getCodigoPlan() + ", '"
                         + plant.getDescripcion() + "', '"
                         + plant.getOidObraSocial() + "')";
   } 

   @Override
   public String actualizar(Object objeto) {
      PlanAgente plant = (PlanAgente) objeto;
      return "UPDATE plan SET "
                  + "codigo_plan = " + plant.getCodigoPlan() + ", "
                  + "descripcion = '" + plant.getDescripcion() + "', "
                  + "oidobra_social = '" + plant.getOidObraSocial() + "' "
                  + "WHERE oidplan =  '" + plant.getOid() + "'";
   } 

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      PlanAgente plant;
      
      try {
         while(resultado.next()){
            plant = new PlanAgente();
            
            plant.setImplementacion(new PlanImplementacion());
            plant.setOid(resultado.getString("oidplan"));
            plant.setCodigoPlan(resultado.getInt("codigo_plan"));
            plant.setDescripcion(resultado.getString("descripcion"));
            plant.setOidObraSocial(resultado.getString("oidobra_social"));
            
            lista.add(plant);
         }
      } catch (SQLException ex) {
         System.err.println("IPRPlan - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } 

   @Override
   public ObjetoPersistente nuevo() {
      PlanAgente plant = new PlanAgente();
      plant.setImplementacion(new PlanImplementacion());
      
      return plant;
   } 
} 
