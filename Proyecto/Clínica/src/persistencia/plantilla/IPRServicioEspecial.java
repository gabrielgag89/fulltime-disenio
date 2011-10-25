// IPRServicioEspecial: IPRServicioEspecial.java
// 

package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.proxy.ServicioEspecialAgente;
import persistencia.proxy.ServicioEspecialImpl;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

/**
 *
 * @author Gabriel
 */
public class IPRServicioEspecial extends IntermPersistenciaDBR{
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM servicio_especial WHERE " + criterio.getStringCriterio();
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM servicio_especial WHERE oidservicio_especial = '" + oid + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      ServicioEspecialAgente serv = (ServicioEspecialAgente) objeto;
      return "INSERT INTO servicio_especial VALUES "
                  + "('" + serv.getOid() + "', "
                         + serv.getCodigoServicio() + ", '"
                         + serv.getNombreServicio() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      ServicioEspecialAgente serv = (ServicioEspecialAgente) objeto;
      return "UPDATE FROM servicio_especial WHERE"
                  + "oidservicio_especial =  '" + serv.getOid() + "', "
                  + "codigo_servicio_especial = " + serv.getCodigoServicio() + ", "
                  + "nombre_servicio_especial = '" + serv.getNombreServicio() +"'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      ServicioEspecialAgente serv;
      
      try {
         while(resultado.next()){
            serv = new ServicioEspecialAgente();
            
            serv.setImplementacion(new ServicioEspecialImpl());
            serv.setOid(resultado.getString("oidservicio_especial"));
            serv.setCodigoServicio(resultado.getInt("codigo_servicio_especial"));
            serv.setNombreServicio(resultado.getString("nombre_servicio_especial"));
            
            lista.add(serv);
         }
      } catch (SQLException ex) {
         System.err.println("IPRPrestacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      ServicioEspecialAgente serv = new ServicioEspecialAgente();
      serv.setImplementacion(new ServicioEspecialImpl());
      
      return serv;
   } // fin del método nuevo
} // fin de la clase IPRServicioEspecial