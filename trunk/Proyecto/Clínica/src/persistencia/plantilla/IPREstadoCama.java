
package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.EstadoCamaAgente;
import persistencia.proxy.EstadoCamaImpl;
import persistencia.proxy.ObjetoPersistente;


public class IPREstadoCama extends IntermPersistenciaDBR {
    @Override
    public String select() {
        return "SELECT  *  FROM  estado_cama";
    }

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  estado_cama  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT  *  FROM  estado_cama  WHERE oidestado_cama = '" + oid +"'";
    }

    @Override
    public String insertar(Object objeto) {
        EstadoCamaAgente estadoC = (EstadoCamaAgente)objeto;
        
      return "INSERT INTO estado_cama VALUES "
                  + "('" + estadoC.getOid() + "','"
                         + estadoC.getNombreEstado()+ "')";
    }

    @Override
    public String actualizar(Object objeto) {
        EstadoCamaAgente estadoC = (EstadoCamaAgente)objeto;
        return "UPDATE estado_cama SET "
                  + "nombre_estado = '" + estadoC.getNombreEstado() + "' "
                  + "WHERE oidestado_cama = '" + estadoC.getOid() + "'";                            
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
        List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
        EstadoCamaAgente estadoC;
      
      try {
         while(resultado.next()){
            estadoC = new EstadoCamaAgente();
            
            estadoC.setImplementacion(new EstadoCamaImpl());
            estadoC.setOid(resultado.getString("oidestado_cama"));
            estadoC.setNombreEstado(resultado.getString("nombre_estado"));
                                    
            lista.add(estadoC);
         }
      } catch (SQLException ex) {
         System.err.println("IPREstadoCama - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
    }

    @Override
    public ObjetoPersistente nuevo() {
        EstadoCamaAgente estadoC = new EstadoCamaAgente();
        estadoC.setImplementacion(new EstadoCamaImpl());
        return estadoC;
    }
    
}
