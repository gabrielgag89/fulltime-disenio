// IPRConvenio: IPRConvenio.java
// 

package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.ConvenioAgente;
import persistencia.proxy.ConvenioImpl;

/**
 *
 * @author Gabriel
 */
public class IPRConvenio extends IntermPersistenciaDBR{
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM convenio WHERE " + criterio;
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM convenio WHERE oidconvenio = '" + oid + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      ConvenioAgente conv = (ConvenioAgente) objeto;
      String fInicio = "'" + (conv.getFechaInicio().getYear() + 1900) + (conv.getFechaInicio().getMonth() + 1) + conv.getFechaInicio().getDate() + "'";
      String fFin = "'" + (conv.getFechaFin().getYear() + 1900) + (conv.getFechaFin().getMonth() + 1) + conv.getFechaFin().getDate() + "'";
      
      return "INSERT INTO convenio VALUES "
                  + "('" + conv.getOid() + "', "
                         + fInicio + ", "
                         + fFin + ", '"
                         + conv.getOidPlan() + "', '"
                         + conv.getOidPrestacion() + "', '"
                         + conv.getOidCoseguro() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      ConvenioAgente conv = (ConvenioAgente) objeto;
      String fInicio = "'" + (conv.getFechaInicio().getYear() + 1900) + (conv.getFechaInicio().getMonth() + 1) + conv.getFechaInicio().getDate() + "'";
      String fFin = "'" + (conv.getFechaFin().getYear() + 1900) + (conv.getFechaFin().getMonth() + 1) + conv.getFechaFin().getDate() + "'";
      
      return "UPDATE FROM convenio WHERE"
                  + "oidconvenio =  '" + conv.getOid() + "', "
                  + "fecha_inicio = " + fInicio + ", "
                  + "fecha_fin = " + fFin + ", "
                  + "oidplan = '" + conv.getOidPlan() + "', "
                  + "oidprestacion = '" + conv.getOidPrestacion() + "', "
                  + "oidcoseguro = '" + conv.getOidCoseguro() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      ConvenioAgente conv;
      
      try {
         while(resultado.next()){
            conv = new ConvenioAgente();
            
            conv.setImplementacion(new ConvenioImpl());
            conv.setOid(resultado.getString("oidconvenio"));
            conv.setFechaInicio(resultado.getDate("fecha_inicio"));
            conv.setFechaFin(resultado.getDate("fecha_fin"));
            conv.setOidPlan(resultado.getString("oidplan"));
            conv.setOidPrestacion(resultado.getString("oidprestacion"));
            conv.setOidCoseguro(resultado.getString("oidcoseguro"));
            
            lista.add(conv);
         }
      } catch (SQLException ex) {
         System.err.println("IPRconvenio - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      ConvenioAgente conv = new ConvenioAgente();
      conv.setImplementacion(new ConvenioImpl());
      
      return conv;
   } // fin del método nuevo

    @Override
    public ObjetoPersistente materializar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
} // fin de la clase IPRConvenio