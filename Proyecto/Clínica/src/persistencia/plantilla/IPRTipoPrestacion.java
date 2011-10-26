package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.TipoPrestacionAgente;
import persistencia.proxy.TipoPrestacionImpl;

public class IPRTipoPrestacion extends IntermPersistenciaDBR{

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  tipo_prestacion  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT * FROM tipo_prestacion WHERE oidtipo_prestacion = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        TipoPrestacionAgente tipoPrestacion = (TipoPrestacionAgente)objeto;
        return "INSERT INTO tipo_prestacion (oidtipo_prestacion,codigo_tipo_prestacion,nombre_tipo_prestacion,oidtipo_habitacion) VALUES ('" + tipoPrestacion.getOid() + "','" + tipoPrestacion.getCodigoTipoPrestacion() + "','" + tipoPrestacion.getNombreTipoPrestacion() + "','" + tipoPrestacion.getOidTipoHabitacion() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        TipoPrestacionAgente tipoPrestacion = (TipoPrestacionAgente)objeto;
        return "UPDATE tipo_prestacion SET codigo_tipo_prestacion = '" + tipoPrestacion.getCodigoTipoPrestacion() + "', nombre_tipo_prestacion = '" + tipoPrestacion.getNombreTipoPrestacion() + "' , oidtipo_habitacion = '" + tipoPrestacion.getOidTipoHabitacion() + "' WHERE oidtipo_prestacion = '" + tipoPrestacion.getOid() + "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaTipoPrestaciones =  new ArrayList<ObjetoPersistente>();
      try {
         while (resultado.next()){
            TipoPrestacionAgente TPA = new TipoPrestacionAgente();
            TPA.setImplementacion(new TipoPrestacionImpl());
            TPA.setOid(resultado.getString("oidtipo_prestacion"));
            TPA.setCodigoTipoPrestacion(resultado.getInt("codigo_tipo_prestacion"));
            TPA.setNombreTipoPrestacion(resultado.getString("nombre_tipo_prestacion"));
            TPA.setOidTipoHabitacion(resultado.getString("oidtipo_habitacion"));
            ListaTipoPrestaciones.add(TPA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRTipoPrestacion - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaTipoPrestaciones;
    }

    @Override
    public ObjetoPersistente nuevo() {
      TipoPrestacionAgente TPA = new TipoPrestacionAgente();
      TPA.setImplementacion(new TipoPrestacionImpl());
      return (ObjetoPersistente) TPA;
    }

}
