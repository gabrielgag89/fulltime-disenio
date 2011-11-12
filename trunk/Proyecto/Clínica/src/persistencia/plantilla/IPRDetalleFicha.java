package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.DetalleFichaAgente;
import persistencia.proxy.DetalleFichaImpl;
import persistencia.proxy.ObjetoPersistente;

public class IPRDetalleFicha extends IntermPersistenciaDBR {

    @Override
    public String select() {
       return "SELECT * FROM detalle_ficha";
    }

   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM detalle_ficha WHERE " + criterio.getStringCriterio();
   }

   @Override
   public String select(String oid) {
      return "SELECT * FROM detalle_ficha WHERE oidcama = '" + oid + "'";
   }

   @Override
   public String insertar(Object objeto) {
      DetalleFichaAgente detalleficha = (DetalleFichaAgente) objeto;
      return "INSERT INTO detalle_ficha VALUES "
                  + "('" + detalleficha.getOid() + "', "
                         + detalleficha.getOidFichaInternacion() + ", '"
                         + detalleficha.getOidServicioEspecial() + "')";
   }

   @Override
   public String actualizar(Object objeto) {
      DetalleFichaAgente detalleficha = (DetalleFichaAgente) objeto;
      return "UPDATE FROM detalle_ficha WHERE"
                  + "oiddetalle_ficha =  '" + detalleficha.getOid() + "', "
                  + "oidficha_internacion = " + detalleficha.getOidFichaInternacion() + ", "
                  + "oidservicio_especial = '" + detalleficha.getOidServicioEspecial() + "'";
   }

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      DetalleFichaAgente detalleficha;
      try {
         while(resultado.next()){
            detalleficha = new DetalleFichaAgente();
            detalleficha.setImplementacion(new DetalleFichaImpl());
            detalleficha.setOid(resultado.getString("oiddetalle_ficha"));
            detalleficha.setOidFichaInterncaion(resultado.getString("oidficha_internacion"));
            detalleficha.setOidServicioEspecial(resultado.getString("oidservicio_especial"));
            lista.add(detalleficha);
         }
      } catch (SQLException ex) {
         System.err.println("IPRDetalleFicha - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      return lista;
   }

   @Override
   public ObjetoPersistente nuevo() {
      DetalleFichaAgente cama = new DetalleFichaAgente();
      cama.setImplementacion(new DetalleFichaImpl());
      return cama;
   }
}
