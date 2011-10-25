// IPRFacturaCliente: IPRFacturaCliente.java
// 

package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.proxy.FacturaClienteAgente;
import persistencia.proxy.FacturaClienteImpl;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

/**
 *
 * @author Gabriel
 */
public class IPRFacturaCliente extends IntermPersistenciaDBR{
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM factura_cliente WHERE " + criterio.getStringCriterio();
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM factura_cliente WHERE oidfactura_cliente = '" + oid + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      FacturaClienteAgente fact = (FacturaClienteAgente) objeto;
      String fecha = "'" + (fact.getFechaEmision().getYear() + 1900) + (fact.getFechaEmision().getMonth() + 1) + fact.getFechaEmision().getDate() + "'";
      
      return "INSERT INTO factura_cliente VALUES "
                  + "('" + fact.getOid() + "', "
                         + fact.getNumFactura() + ", "
                         + fecha + ", '"
                         + fact.getOidEstadoFacturaCliente() + "', '"
                         + fact.getOidFichaInternacion() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      FacturaClienteAgente fact = (FacturaClienteAgente) objeto;
      String fecha = "'" + (fact.getFechaEmision().getYear() + 1900) + (fact.getFechaEmision().getMonth() + 1) + fact.getFechaEmision().getDate() + "'";
      
      return "UPDATE FROM factura_cliente WHERE"
                  + "oidfactura_cliente =  '" + fact.getOid() + "', "
                  + "numero_factura_cliente = " + fact.getNumFactura() + ", "
                  + "fecha = " + fecha + ", "
                  + "oidestado_factura_cliente = '" + fact.getOidEstadoFacturaCliente() + "', "
                  + "oidficha_internacion = '" + fact.getOidFichaInternacion() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      FacturaClienteAgente fact;
      
      try {
         while(resultado.next()){
            fact = new FacturaClienteAgente();
            
            fact.setImplementacion(new FacturaClienteImpl());
            fact.setOid(resultado.getString("oidfactura_cliente"));
            fact.setNumFactura(resultado.getInt("numero_factura_cliente"));
            fact.setFechaEmision(resultado.getDate("fecha"));
            fact.setOidEstadoFacturaCliente(resultado.getString("oidestado_factura_cliente"));
            fact.setOidFichaInternacion(resultado.getString("oidficha_internacion"));
            
            lista.add(fact);
         }
      } catch (SQLException ex) {
         System.err.println("IPRFacturaCliente - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      FacturaClienteAgente fact = new FacturaClienteAgente();
      fact.setImplementacion(new FacturaClienteImpl());
      
      return fact;
   } // fin del método nuevo
} // fin de la clase IPRFacturaCliente