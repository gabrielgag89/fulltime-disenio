package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.HabitacionAgente;
import persistencia.proxy.HabitacionImpl;
import persistencia.criterios.Criterio;

public class IPRHabitacion  extends IntermPersistenciaDBR {
   @Override
   public String select() {
      return "SELECT  *  FROM  habitacion";
   } // fin del método select

   @Override
   public String select(Criterio criterio) {
      return "SELECT  *  FROM  habitacion  WHERE " + criterio.getStringCriterio();
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM habitacion WHERE oidhabitacion = '" + oid  + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      HabitacionAgente habitacion = (HabitacionAgente)objeto;
      return "INSERT INTO habitacion (oidhabitacion,numero_habitacion,oidsector,oidtipo_habitacion) VALUES ('" + habitacion.getOid() + "','" + habitacion.getNroHabitacion() + "','" + habitacion.getOidSector() + "','" + habitacion.getOidTipoHabitacion() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      HabitacionAgente habitacion = (HabitacionAgente)objeto;
      return "UPDATE habitacion SET numero_habitacion = '" + habitacion.getNroHabitacion() + "', oidsector = '" + habitacion.getOidSector() + "', oidtipo_habitacion = '" + habitacion.getOidTipoHabitacion() + "' WHERE oidhabitacion = '" + habitacion.getOid() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet rs) {
      List<ObjetoPersistente> ListaHabitaciones =  new ArrayList<ObjetoPersistente>();
      try {
         while (rs.next()){
            HabitacionAgente HA = new HabitacionAgente();
            HA.setImplementacion(new HabitacionImpl());
            HA.setOid(rs.getString("oidhabitacion"));
            HA.setNroHabitacion(rs.getInt("numero_habitacion"));
            HA.setOidSector(rs.getString("oidsector"));
            HA.setOidTipoHabitacion(rs.getString("oidtipo_habitacion"));
            ListaHabitaciones.add(HA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRHabitacionn - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaHabitaciones;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      HabitacionAgente HA = new HabitacionAgente();
      HA.setImplementacion(new HabitacionImpl());
      return (ObjetoPersistente) HA;
   } // fin del método nuevo
}