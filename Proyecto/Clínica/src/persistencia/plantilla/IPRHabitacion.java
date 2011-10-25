package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.HabitacionAgente;
import persistencia.proxy.HabitacionImpl;
import persistencia.proxy.ObjetoPersistente;

public class IPRHabitacion  extends IntermPersistenciaDBR {

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  habitacion  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT * FROM habitacion WHERE oidhabitacion = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        HabitacionAgente habitacion = (HabitacionAgente)objeto;
        return "INSERT INTO habitacion (oidhabitacion,numero_habitacion,oidsector,oidtipo_habitacion) VALUES ('" + habitacion.getOid() + "','" + habitacion.getNroHabitacion() + "','" + habitacion.getOidSector() + "','" + habitacion.getOidTipoHabitacion() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        HabitacionAgente habitacion = (HabitacionAgente)objeto;
        return "UPDATE habitacion SET numero_habitacion = '" + habitacion.getNroHabitacion() + "', oidsector = '" + habitacion.getOidSector() + "', oidtipo_habitacion = '" + habitacion.getOidTipoHabitacion() + "' WHERE oidhabitacion = '" + habitacion.getOid() + "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet rs) {
        List<ObjetoPersistente> ListaHabitaciones = null;
        try {
            if (!rs.next()) {
                return ListaHabitaciones;
            }
            do{
                HabitacionAgente HA = new HabitacionAgente();
                HA.setImplementacion(new HabitacionImpl());
                HA.setOid(rs.getString("oidhabitacion"));
                HA.setNroHabitacion(rs.getInt("numero_habitacion"));
                HA.setOidSector(rs.getString("oidsector"));
                HA.setOidTipoHabitacion(rs.getString("oidtipo_habitacion"));
                ListaHabitaciones.add((ObjetoPersistente)HA);
            }while (rs.next());
            return ListaHabitaciones;
        } catch (SQLException ex) {
            System.out.println("IPRHabitacionn - convertirAObjeto - SQLException: "+ex.getMessage());
            return null;
        }
    }

    @Override
    public ObjetoPersistente nuevo() {
            HabitacionAgente HA = new HabitacionAgente();
            HA.setImplementacion(new HabitacionImpl());
            return (ObjetoPersistente) HA;
    }

}
