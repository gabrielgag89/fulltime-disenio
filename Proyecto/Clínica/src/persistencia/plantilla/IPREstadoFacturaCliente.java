package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.proxy.EstadoFacturaClienteAgente;
import persistencia.proxy.EstadoFacturaClienteImpl;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

public class IPREstadoFacturaCliente extends IntermPersistenciaDBR{
   public IPREstadoFacturaCliente(){
      this.mapeo.put("oid", "oidestado_factura_cliente");
      this.mapeo.put("nombreEstado", "nombre_estado_factura_cliente");
   } // fin del constructor
   
   @Override
   public String select() {
      return "SELECT * FROM estado_factura_cliente";
   } // fin del método select

   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM estado_factura_cliente WHERE " + criterio.getStringCriterio();
   } // fin del método select

   @Override
   public String select(String oid) {
      return "SELECT * FROM estado_factura_cliente WHERE oidestado_factura_cliente = '" + oid +"'";
   } // fin del método select

   @Override
   public String insertar(Object objeto) {
      EstadoFacturaClienteAgente estado = (EstadoFacturaClienteAgente) objeto;

      return "INSERT INTO estado_factura_cliente "
                  + "VALUES ('" + estado.getOid() + "', '"
                                + estado.getNombreEstado() + "'";
   } // fin del método insertar

   @Override
   public String actualizar(Object objeto) {
      EstadoFacturaClienteAgente estado = (EstadoFacturaClienteAgente)objeto;

      return "UPDATE estado_factura_cliente SET "
               + "nombre_estado_factura_cliente = '" + estado.getNombreEstado() + "' "
               + "WHERE oidestado_factura_cliente = '" + estado.getOid() + "'";
   } // fin del método actualizar

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      EstadoFacturaClienteAgente estado;

      try {
         while(resultado.next()){
            estado = new EstadoFacturaClienteAgente();

            estado.setImplementacion(new EstadoFacturaClienteImpl());
            estado.setOid(resultado.getString("oidestado_factura_cliente"));
            estado.setNombreEstado(resultado.getString("nombre_estado_factura_cliente"));

            lista.add(estado);
         } // fin de while de creación de agentes
      } // fin de try de error en la obtención del valor de una columna
      catch (SQLException ex) {
         System.err.println("IPREstadoFacturaCliente - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      } // fin de catch de error en la obtención del valor de una columna

      return lista;
   } // fin del método convertirAObjeto

   @Override
   public ObjetoPersistente nuevo() {
      EstadoFacturaClienteAgente estado = new EstadoFacturaClienteAgente();
      estado.setImplementacion(new EstadoFacturaClienteImpl());

      return estado;
   } // fin del método nuevo
} // fin de la clase IPREstadoFacturaCliente