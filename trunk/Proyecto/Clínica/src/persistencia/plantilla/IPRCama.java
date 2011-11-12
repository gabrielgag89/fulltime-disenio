package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.CamaAgente;
import persistencia.proxy.CamaImpl;
import persistencia.proxy.ObjetoPersistente;

public class IPRCama extends IntermPersistenciaDBR {

    @Override
    public String select() {
       return "SELECT * FROM cama";
    }

   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM cama WHERE " + criterio.getStringCriterio();
   }

   @Override
   public String select(String oid) {
      return "SELECT * FROM cama WHERE oidcama = '" + oid + "'";
   }

   @Override
   public String insertar(Object objeto) {
      CamaAgente cama = (CamaAgente) objeto;
      return "INSERT INTO cama VALUES "
                  + "('" + cama.getOid() + "', "
                         + cama.getNumCama() + ", '"
                         + cama.getOidHabitacion()+ "', '"
                         + cama.getOidEstadoCama() + "')";
   }

   @Override
   public String actualizar(Object objeto) {
      CamaAgente cama = (CamaAgente) objeto;
      return "UPDATE FROM cama WHERE"
                  + "oidcama =  '" + cama.getOid() + "', "
                  + "numero_cama = " + cama.getNumCama() + ", "
                  + "oidhabitacion = '" + cama.getOidHabitacion() + "', "
                  + "oidestado_cama = '" + cama.getOidEstadoCama() + "'";
   }

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      CamaAgente cama;
      try {
         while(resultado.next()){
            cama = new CamaAgente();
            cama.setImplementacion(new CamaImpl());
            cama.setOid(resultado.getString("oidcama"));
            cama.setNumCama(resultado.getInt("numero_cama"));
            cama.setOidHabitacion(resultado.getString("oidhabitacion"));
            cama.setOidEstadoCama(resultado.getString("oidestado_cama"));
            lista.add(cama);
         }
      } catch (SQLException ex) {
         System.err.println("IPRCama - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }

      return lista;
   }

   @Override
   public ObjetoPersistente nuevo() {
      CamaAgente cama = new CamaAgente();
      cama.setImplementacion(new CamaImpl());
      return cama;
   }
}
