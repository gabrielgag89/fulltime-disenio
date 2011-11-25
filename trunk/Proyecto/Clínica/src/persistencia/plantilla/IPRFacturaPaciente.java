package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.proxy.FacturaPacienteAgente;
import persistencia.proxy.FacturaPacienteImpl;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;
import util.ServiciosTiempo;

public class IPRFacturaPaciente extends IntermPersistenciaDBR{
   public IPRFacturaPaciente(){
      this.mapeo.put("oid", "oidfactura_cliente");
      this.mapeo.put("numFactura", "numero_factura_cliente");
      this.mapeo.put("fechaEmision", "fecha");
      this.mapeo.put("monto", "monto");
      this.mapeo.put("estadoFacturaPaciente", "oidestado_factura_cliente");
      this.mapeo.put("fichaInternacion", "oidficha_internacion");
   } // fin del constructor
   
   @Override
   public String select() {
      return "SELECT * FROM factura_cliente";
   } // fin del método select

   @Override
   public String select(List<Criterio> criterios) {
      String sql = "SELECT * FROM factura_cliente WHERE ";
      int cont = 0;
      
      for(Criterio criterio : criterios){
         sql += " (" + this.getNombreColumna(criterio.getAtributo()) + " "
                 + criterio.getOperador() + " '"
                 + criterio.getValor().toString() + "') "
                 + criterio.getOpLogico();
         
         cont++;
      }
      
      return sql;
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM factura_cliente WHERE oidfactura_cliente = '" + oid + "'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      FacturaPacienteAgente fact = (FacturaPacienteAgente) objeto;
      
      return "INSERT INTO factura_cliente "
                  + "VALUES ('" + fact.getOid() + "', "
                                + fact.getNumFactura() + ", '"
                                + ServiciosTiempo.getInstancia().dateToString(fact.getFechaEmision()) + "', "
                                + fact.getMonto() + ", '"
                                + fact.getOidEstadoFacturaCliente() + "', '"
                                + fact.getOidFichaInternacion() + "')";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      FacturaPacienteAgente fact = (FacturaPacienteAgente) objeto;
      
      return "UPDATE factura_cliente SET "
                  + "numero_factura_cliente = " + fact.getNumFactura() + ", "
                  + "fecha = '" + ServiciosTiempo.getInstancia().dateToString(fact.getFechaEmision()) + "', "
                  + "monto = " + fact.getMonto() + ", "
                  + "oidestado_factura_cliente = '" + fact.getOidEstadoFacturaCliente() + "', "
                  + "oidficha_internacion = '" + fact.getOidFichaInternacion() + "' "
                  + "WHERE oidfactura_cliente =  '" + fact.getOid() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      FacturaPacienteAgente factura;
      
      try {
         while(resultado.next()){
            factura = new FacturaPacienteAgente();
            
            factura.setImplementacion(new FacturaPacienteImpl());
            factura.setOid(resultado.getString("oidfactura_cliente"));
            factura.setNumFactura(resultado.getInt("numero_factura_cliente"));
            factura.setFechaEmision(resultado.getDate("fecha"));
            factura.setMonto(resultado.getDouble("monto"));
            factura.setOidEstadoFacturaPaciente(resultado.getString("oidestado_factura_cliente"));
            factura.setOidFichaInternacion(resultado.getString("oidficha_internacion"));
            
            lista.add(factura);
         } // fin de while de creación de agentes
      } // fin de try de error en la obtención del valor de una columna
      catch (SQLException ex) {
         System.err.println("IPRFacturaCliente - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      } // fin de catch de error en la obtención del valor de una columna
      
      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      FacturaPacienteAgente factura = new FacturaPacienteAgente();
      factura.setImplementacion(new FacturaPacienteImpl());
      
      return factura;
   } // fin del método nuevo
} // fin de la clase IPRFacturaPaciente