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
import util.ServiciosTiempo;

/**
 *
 * @author Gabriel
 */
public class IPRFacturaCliente extends IntermPersistenciaDBR{
   @Override
   public String select() {
      return "SELECT * FROM factura_cliente";
   } // fin del método select

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
      
      return "INSERT INTO factura_cliente VALUES "
                  + "('" + fact.getOid() + "', "
                         + fact.getNumFactura() + ", "
                         + ServiciosTiempo.getInstancia().dateToString(fact.getFechaEmision()) + ", '"
                         + fact.getOidEstadoFacturaCliente() + "', '"
                         + fact.getOidFichaInternacion() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      FacturaClienteAgente fact = (FacturaClienteAgente) objeto;
      
      return "UPDATE factura_cliente SET "
                  + "numero_factura_cliente = " + fact.getNumFactura() + ", "
                  + "fecha = '" + ServiciosTiempo.getInstancia().dateToString(fact.getFechaEmision()) + "', "
                  + "oidestado_factura_cliente = '" + fact.getOidEstadoFacturaCliente() + "', "
                  + "oidficha_internacion = '" + fact.getOidFichaInternacion() + "' "
                  + "WHERE oidfactura_cliente =  '" + fact.getOid() + "'";
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
            fact.setMonto(resultado.getDouble("monto"));
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