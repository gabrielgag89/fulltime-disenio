package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.EstadoFacturaClienteAgente;
import persistencia.proxy.EstadoFacturaClienteImpl;
import persistencia.criterios.Criterio;

public class IPREstadoFacturaCliente extends IntermPersistenciaDBR{
    @Override
    public String select() {
        return "SELECT * FROM estado_factura";
    }

    @Override
    public String select(Criterio criterio) {
        return "SELECT * FROM estado_factura WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
return "SELECT  *  FROM  estado_factura  WHERE oidestado_factura ='" + oid +"'";
    }

    @Override
    public String insertar(Object objeto) {
EstadoFacturaClienteAgente estado_factura = (EstadoFacturaClienteAgente) objeto;
      return "INSERT INTO estado_factura VALUES "
                  + "('" + estado_factura.getOid() + "', "
                         + estado_factura.getNombreEstado() + ", '";
    }

    @Override
    public String actualizar(Object objeto) {

        EstadoFacturaClienteAgente estado_factura = (EstadoFacturaClienteAgente)objeto;
        return "UPDATE FROM estado_factura WHERE "
                  + "oidestado_factura = '" + estado_factura.getOid() + "', "
                  + "nombre_estado = '" + estado_factura.getNombreEstado() + "'," ;    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
 List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      EstadoFacturaClienteAgente estado_factura;
      
      try {
         while(resultado.next()){
            estado_factura = new EstadoFacturaClienteAgente();
            
            estado_factura.setImplementacion(new EstadoFacturaClienteImpl());
            estado_factura.setOid(resultado.getString("oidestado_factura_cliente"));
            estado_factura.setNombreEstado(resultado.getString("nombre_estado"));
            
            lista.add(estado_factura);
         }
      } catch (SQLException ex) {
         System.err.println("IPREstadoFacturaCliente - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;    }

    @Override
    public ObjetoPersistente nuevo() {
 EstadoFacturaClienteAgente estado_factura = new EstadoFacturaClienteAgente();
      estado_factura.setImplementacion(new EstadoFacturaClienteImpl());
      
      return estado_factura;
    }
    
}
