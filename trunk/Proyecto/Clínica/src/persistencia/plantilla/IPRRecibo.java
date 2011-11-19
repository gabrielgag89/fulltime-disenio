package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.ReciboAgente;
import persistencia.proxy.ReciboImpl;
import util.ServiciosTiempo;

public class IPRRecibo  extends IntermPersistenciaDBR {
    @Override
    public String select() {
        return "SELECT * FROM  recibo";
    }

    @Override
    public String select(Criterio criterio) {
        return "SELECT * FROM  recibo  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
         return "SELECT * FROM recibo WHERE oidrecibo = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        ReciboAgente recibo = (ReciboAgente)objeto;
        return "INSERT INTO recibo (oidrecibo, numero_recibo, fecha, oidfactura_cliente) "
                           + "VALUES ('" + recibo.getOid() + "', "
                                         + recibo.getNroRecibo() + ", '"
                                         + ServiciosTiempo.dateToString(recibo.getFecha()) + "', '"
                                         + recibo.getOidFacturaCliente() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        ReciboAgente recibo = (ReciboAgente)objeto;
        return "UPDATE recibo SET "
                + "numero_recibo = " +  recibo.getNroRecibo() + ", "
                + "fecha = '" + ServiciosTiempo.dateToString(recibo.getFecha()) + ", "
                + "oidfactura_cliente = '" + recibo.getOidFacturaCliente() + "' "
                + "WHERE oidrecibo = '" + recibo.getOid() + "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaRecibos =  new ArrayList<ObjetoPersistente>();
      try {
         while (resultado.next()){
            ReciboAgente HA = new ReciboAgente();
            HA.setImplementacion(new ReciboImpl());
            HA.setOid(resultado.getString("oidrecibo"));
            HA.setNroRecibo(resultado.getInt("numero_recibo"));
            HA.setFecha(resultado.getDate("fecha"));
            HA.setOidFacturaCliente(resultado.getString("oidfactura_cliente"));
            ListaRecibos.add(HA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRRecibo - convertirAObjeto - SQLException: "+ex.getMessage());
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
