/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.plantilla;
  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.TipoHabitacionAgente;
import persistencia.proxy.TipoHabitacionImplementacion;
import persistencia.proxy.ObjetoPersistente;


/**
 *
 * @author Cristian Mesa
 */
public class IPRTipoHabitacion extends IntermPersistenciaDBR{
 

@Override
   public String select(Criterio criterio) {
      return "SELECT * FROM tipo_habitacion WHERE " + criterio.getStringCriterio();
   } 

   @Override
   public String select(String oid) {
      return "SELECT * FROM tipo_habitacion WHERE oidtipo_habitacion = '" + oid + "'";
   } 

   @Override
   public String insertar(Object objeto) {
      TipoHabitacionAgente tiph = (TipoHabitacionAgente) objeto;
      return "INSERT INTO tipo_habitacion VALUES "
                  + "('" + tiph.getOid() + "', "
                         + tiph.getCodigoTipoHabitacion() + ", '"
                         + tiph.getNombreTipo() + "')";
                         
   } 

   @Override
   public String actualizar(Object objeto) {
      TipoHabitacionAgente tiph = (TipoHabitacionAgente) objeto;
      return "UPDATE FROM tipohabitacion WHERE"
                  + "oidtipo_habitacion =  '" + tiph.getOid() + "', "
                  + "codigo_tipo_habitacion = " + tiph.getCodigoTipoHabitacion() + ", "
                  + "nombre_tipo_habitacion = '" + tiph.getNombreTipo() + "') ";
                  
   } 

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      TipoHabitacionAgente tiph;
      
      try {
         while(resultado.next()){
            tiph = new TipoHabitacionAgente();
            
            tiph.setImplementacion(new TipoHabitacionImplementacion());
            tiph.setOid(resultado.getString("oidtipo_habitacion"));
            tiph.setCodigoTipoHabitacion(resultado.getInt("codigo_tipo_habitacion"));
            tiph.setNombreTipo(resultado.getString("nombre_tipo_habitacion"));
            
            
            
            lista.add(tiph);
         }
      } catch (SQLException ex) {
         System.err.println("IPRTipoHabitacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } 

   @Override
   public ObjetoPersistente nuevo() {
      TipoHabitacionAgente tiph = new TipoHabitacionAgente();
      tiph.setImplementacion(new TipoHabitacionImplementacion());
      
      return tiph;
   } 
} 

    

