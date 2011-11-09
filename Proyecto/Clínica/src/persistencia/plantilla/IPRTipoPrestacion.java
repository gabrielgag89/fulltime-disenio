
package persistencia.plantilla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.TipoPrestacionAgente;
import persistencia.proxy.TipoPrestacionImpl;


public class IPRTipoPrestacion extends IntermPersistenciaDBR {

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
        TipoPrestacionAgente tipoP = (TipoPrestacionAgente)objeto;
        
      return "INSERT INTO tipo_prestacion VALUES "
                  + "('" + tipoP.getOid() + "', "
                         + tipoP.getCodigoTipoPrestacion() + ",'"                            
                         + tipoP.getNombreTipoPrestacion() + "','"
                         + tipoP.getOidTipoHabitacion()+ "')";
    }

    @Override
    public String actualizar(Object objeto) {
        TipoPrestacionAgente tipoP = (TipoPrestacionAgente)objeto;
        return "UPDATE FROM tipo_prestacion WHERE "
                  + "oidtipo_prestacion = '" + tipoP.getOid() + "', "
                  + "codigo_tipo_prestacion = " + tipoP.getCodigoTipoPrestacion() + ","                            
                  + "nombre_tipo_prestacion = '" + tipoP.getNombreTipoPrestacion() + "',"
                  + "oidtipo_habitacion = '"+ tipoP.getOidTipoHabitacion()+ "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
        List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
        TipoPrestacionAgente tipoP;
      
      try {
         while(resultado.next()){
            tipoP = new TipoPrestacionAgente();
            
            tipoP.setImplementacion(new TipoPrestacionImpl());
            tipoP.setOid(resultado.getString("oidtipo_prestacion"));
            tipoP.setCodigoTipoPrestacion(resultado.getInt("codigo_tipo_prestacion"));
            tipoP.setNombreTipoPrestacion(resultado.getString("nombre_tipo_prestacion"));
            tipoP.setOidTipoHabitacion(resultado.getString("oidtipo_habitacion"));
                        
            lista.add(tipoP);
         }
      } catch (SQLException ex) {
         System.err.println("IPRTipoPrestacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
    }

    @Override
    public ObjetoPersistente nuevo() {
        TipoPrestacionAgente tipoP = new TipoPrestacionAgente();
        tipoP.setImplementacion(new TipoPrestacionImpl());
        return tipoP;
    }

  

    @Override
    public String select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
