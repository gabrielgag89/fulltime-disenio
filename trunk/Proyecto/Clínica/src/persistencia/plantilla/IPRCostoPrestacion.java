
package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.CostoPrestacionAgente;
import persistencia.proxy.CostoPrestacionImpl;
import persistencia.proxy.ObjetoPersistente;


public class IPRCostoPrestacion extends IntermPersistenciaDBR {

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  costo_prestacion  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT  *  FROM  costo_prestacion  WHERE oidcosto_prestacion ='" + oid +"')";
    }

    @Override
    public String insertar(Object objeto) {
        CostoPrestacionAgente costo = (CostoPrestacionAgente)objeto;
        
      return "INSERT INTO costo_prestacion VALUES "
                  + "('" + costo.getOid() + "','"
                         + costo.getFechaInicio() + "','"                            
                         + costo.getFechaFin() + "',"
                         + costo.getMonto() + ",'"
                         + costo.getOidPrestacion()+ "')";
    }

    @Override
    public String actualizar(Object objeto) {
        CostoPrestacionAgente costo = (CostoPrestacionAgente)objeto;
        return "UPDATE FROM costo_prestacion WHERE "
                  + "oidcosto_prestacion = '" + costo.getOid() + "', "
                  + "fecha_inicio = '" + costo.getFechaInicio() + "',"                            
                  + "fecha_fin  = '" + costo.getFechaFin() + "',"
                  + "monto = " + costo.getMonto() + ", "
                  + "oidprestacion = '"+ costo.getOidPrestacion()+ "'";
                
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
        List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
        CostoPrestacionAgente costo;
      
      try {
         while(resultado.next()){
            costo = new CostoPrestacionAgente();
            
            costo.setImplementacion(new CostoPrestacionImpl());
            costo.setOid(resultado.getString("oidcosto_prestacion"));
            costo.setFechaInicio(resultado.getDate("fecha_inicio"));
            costo.setFechaFin(resultado.getDate("fecha_fin"));
            costo.setMonto(resultado.getFloat("monto"));
            costo.setOidPrestacion(resultado.getString("oidprestacion"));
                        
            lista.add(costo);
         }
      } catch (SQLException ex) {
         System.err.println("IPRCostoPrestacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
    }

    @Override
    public ObjetoPersistente nuevo() {
        CostoPrestacionAgente costo = new CostoPrestacionAgente();
        costo.setImplementacion(new CostoPrestacionImpl());
        return costo;
    }
    
}
