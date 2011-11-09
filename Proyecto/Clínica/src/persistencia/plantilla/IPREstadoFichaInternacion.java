package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.EstadoFichaInternacionAgente;
import persistencia.proxy.EstadoFichaInternacionImpl;
import persistencia.criterios.Criterio;

public class IPREstadoFichaInternacion extends IntermPersistenciaDBR{

    @Override
    public String select(Criterio criterio) {
        return "SELECT * FROM estado_ficha_internacion WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
return "SELECT  *  FROM  estado_ficha_internacion  WHERE oidestado_ficha_prestacion ='" + oid +"'";
    }

    @Override
    public String insertar(Object objeto) {
EstadoFichaInternacionAgente estadoFicha = (EstadoFichaInternacionAgente) objeto;
      return "INSERT INTO estado_ficha VALUES "
                  + "('" + estadoFicha.getOid() + "', "
                         + estadoFicha.getNombreEstado() + ", '";
    }

    @Override
    public String actualizar(Object objeto) {

        EstadoFichaInternacionAgente estadoFicha = (EstadoFichaInternacionAgente)objeto;
        return "UPDATE FROM estado_ficha WHERE "
                  + "oidestado_ficha = '" + estadoFicha.getOid() + "', "
                  + "nombre_estado = '" + estadoFicha.getNombreEstado() + "'," ;    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
 List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      EstadoFichaInternacionAgente estado_ficha;
      
      try {
         while(resultado.next()){
            estado_ficha = new EstadoFichaInternacionAgente();
            
            estado_ficha.setImplementacion(new EstadoFichaInternacionImpl());
            estado_ficha.setOid(resultado.getString("oidestado_ficha"));
            estado_ficha.setNombreEstado(resultado.getString("nombre_estado"));
            
            lista.add(estado_ficha);
         }
      } catch (SQLException ex) {
         System.err.println("IPREstadoFichaInternacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;    }

    @Override
    public ObjetoPersistente nuevo() {
 EstadoFichaInternacionAgente estado_ficha = new EstadoFichaInternacionAgente();
      estado_ficha.setImplementacion(new EstadoFichaInternacionImpl());
      
      return estado_ficha;
    }

   
    @Override
    public String select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
