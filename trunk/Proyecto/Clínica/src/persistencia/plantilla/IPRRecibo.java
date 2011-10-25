package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.ReciboAgente;
import persistencia.proxy.ReciboImpl;

public class IPRRecibo  extends IntermPersistenciaDBR {

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  recibo  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
         return "SELECT * FROM recibo WHERE oidrecibo = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        ReciboAgente recibo = (ReciboAgente)objeto;
        String fecha = "'" + (recibo.getFecha().getYear() + 1900) + (recibo.getFecha().getMonth() + 1) + recibo.getFecha().getDate() + "'";
      return "INSERT INTO habitacion (oidrecibo,numero_recibo,fecha,oidfactura_cliente) VALUES ('" + recibo.getOid() + "','" + recibo.getNroRecibo() + "','" + fecha + "','" + recibo.getOidFacturaCliente() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        ReciboAgente recibo = (ReciboAgente)objeto;
        String fecha = "'" + (recibo.getFecha().getYear() + 1900) + (recibo.getFecha().getMonth() + 1) + recibo.getFecha().getDate() + "'";
        return "UPDATE habitacion SET numero_recibo = '" +  recibo.getNroRecibo() + "', fecha = '" + fecha + "', oidfactura_cliente = '" + recibo.getOidFacturaCliente() + "' WHERE oidrecibo = '" + recibo.getOid() + "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet rs) {
      List<ObjetoPersistente> ListaRecibos =  new ArrayList<ObjetoPersistente>();
      try {
         while (rs.next()){
            ReciboAgente HA = new ReciboAgente();
            HA.setImplementacion(new ReciboImpl());
            HA.setOid(rs.getString("oidrecibo"));
            HA.setNroRecibo(rs.getInt("numero_recibo"));
            HA.setFecha(rs.getDate("fecha"));
            HA.setOidFacturaCliente(rs.getString("oidfactura_cliente"));
            ListaRecibos.add(HA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRHabitacionn - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaRecibos;
    }

    @Override
    public ObjetoPersistente nuevo() {
      ReciboAgente RA = new ReciboAgente();
      RA.setImplementacion(new ReciboImpl());
      return (ObjetoPersistente) RA;
    }

}
