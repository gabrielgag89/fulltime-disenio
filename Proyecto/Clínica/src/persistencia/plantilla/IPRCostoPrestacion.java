package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.CostoPrestacionAgente;
import persistencia.proxy.CostoPrestacionImpl;
import persistencia.proxy.ObjetoPersistente;

public class IPRCostoPrestacion extends IntermPersistenciaDBR{

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  costo_prestacion  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
        return "SELECT * FROM costo_prestacion WHERE oidcosto_prestacion = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        CostoPrestacionAgente costoPrestacion = (CostoPrestacionAgente)objeto;
        String fechaini = "'" + (costoPrestacion.getFechaInicio().getYear() + 1900) + (costoPrestacion.getFechaInicio().getMonth() + 1) + costoPrestacion.getFechaInicio().getDate() + "'";
        String fechafin = "'" + (costoPrestacion.getFechaFin().getYear() + 1900) + (costoPrestacion.getFechaFin().getMonth() + 1) + costoPrestacion.getFechaFin().getDate() + "'";
        return "INSERT INTO costo_prestacion (oidcosto_prestacion,fecha_inicio,fecha_fin,monto,oidprestacion) VALUES ('" + costoPrestacion.getOid() + "'," + fechaini + "," + fechafin + ",'" + costoPrestacion.getMonto() + "','" + costoPrestacion.getOidPrestacion() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        CostoPrestacionAgente costoPrestacion = (CostoPrestacionAgente)objeto;
        String fechaini = "'" + (costoPrestacion.getFechaInicio().getYear() + 1900) + (costoPrestacion.getFechaInicio().getMonth() + 1) + costoPrestacion.getFechaInicio().getDate() + "'";
        String fechafin = "'" + (costoPrestacion.getFechaFin().getYear() + 1900) + (costoPrestacion.getFechaFin().getMonth() + 1) + costoPrestacion.getFechaFin().getDate() + "'";
        return "UPDATE costo_prestacion SET fecha_inicio = " + fechaini + " , fecha_fin = " + fechafin + " , monto = '" + costoPrestacion.getMonto() + "' , oidprestacion = '" + costoPrestacion.getOidPrestacion() + "' WHERE oidcosto_prestacion = '" + costoPrestacion.getOid() + "'";
   }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaCostoPrestaciones =  new ArrayList<ObjetoPersistente>();
      try {
         while (resultado.next()){
            CostoPrestacionAgente CPA = new CostoPrestacionAgente();
            CPA.setImplementacion(new CostoPrestacionImpl());
            CPA.setOid(resultado.getString("oidcosto_prestacion"));
            CPA.setFechaInicio(resultado.getDate("fecha_inicio"));
            CPA.setFechaFin(resultado.getDate("fecha_fin"));
            CPA.setMonto(resultado.getFloat("monto"));
            CPA.setOidPrestacion(resultado.getString("oidprestacion"));
            ListaCostoPrestaciones.add(CPA);
         }
      } catch (SQLException ex) {
         System.out.println("IPRCostoPrestacion - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaCostoPrestaciones;
    }

    @Override
    public ObjetoPersistente nuevo() {
      CostoPrestacionAgente CPA = new CostoPrestacionAgente();
      CPA.setImplementacion(new CostoPrestacionImpl());
      return (ObjetoPersistente) CPA;
    }

}
