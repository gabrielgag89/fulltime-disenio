// IPRPrestacion: IPRPrestacion.java
// 

package persistencia.plantilla;

import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.PrestacionAgente;
import persistencia.proxy.PrestacionImpl;
import persistencia.criterios.Criterio;

/**
 *
 * @author Gabriel
 */
public class IPRPrestacion extends IntermPersistenciaDBR{
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM prestacion WHERE " + criterio.getStringCriterio();
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM prestacion WHERE oidprestacion = '" + oid + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      PrestacionAgente prest = (PrestacionAgente) objeto;
      return "INSERT INTO prestacion VALUES "
                  + "('" + prest.getOid() + "', "
                         + prest.getCodigoPrestacion() + ", '"
                         + prest.getDescripcion() + "', '"
                         + prest.getOidTipoPrestacion() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      PrestacionAgente prest = (PrestacionAgente) objeto;
      return "UPDATE FROM prestacion WHERE"
                  + "oidprestacion =  '" + prest.getOid() + "', "
                  + "codigo_prestacion = " + prest.getCodigoPrestacion() + ", "
                  + "descripcion = '" + prest.getDescripcion() + "', "
                  + "oidtipo_prestacion = '" + prest.getOidTipoPrestacion() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      PrestacionAgente prest;
      
      try {
         while(resultado.next()){
            prest = new PrestacionAgente();
            
            prest.setImplementacion(new PrestacionImpl());
            prest.setOid(resultado.getString("oidprestacion"));
            prest.setCodigoPrestacion(resultado.getInt("codigo_prestacion"));
            prest.setDescripcion(resultado.getString("descripcion"));
            prest.setOidTipoPrestacion(resultado.getString("oidtipo_prestacion"));
            
            lista.add(prest);
         }
      } catch (SQLException ex) {
         System.err.println("IPRPrestacion - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      PrestacionAgente prest = new PrestacionAgente();
      prest.setImplementacion(new PrestacionImpl());
      
      return prest;
   } // fin del método nuevo

    @Override
    public String select() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
} // fin de la clase IPRPrestacion