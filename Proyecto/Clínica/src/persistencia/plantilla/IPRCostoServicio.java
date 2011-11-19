package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.CostoServicioAgente;
import persistencia.proxy.CostoServicioImpl;
import persistencia.proxy.ObjetoPersistente;
import util.ServiciosTiempo;

public class IPRCostoServicio extends IntermPersistenciaDBR {
   @Override
   public String select() {
      return "SELECT * FROM costo_servicio";
   }
   
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM costo_servicio WHERE " + criterio.getStringCriterio();
   }

   @Override
   public String select(String oid) {
      return "SELECT * FROM costo_servicio WHERE oidcosto_servicio = '" + oid + "'";
   }

   @Override
   public String insertar(Object objeto) {
      CostoServicioAgente costoservicio = (CostoServicioAgente) objeto;
      return "INSERT INTO costo_servicio VALUES "
                  + "('" + costoservicio.getOid() + "', '"
                         + ServiciosTiempo.getInstancia().dateToString(costoservicio.getFechaInicio()) + "', '"
                         + ServiciosTiempo.getInstancia().dateToString(costoservicio.getFechaFin()) + "', "
                         + costoservicio.getMonto()+ ", '"
                         + costoservicio.getOidServicioEspecial() + "')";
   }

   @Override
   public String actualizar(Object objeto) {
      CostoServicioAgente costoservicio = (CostoServicioAgente) objeto;
      
      return "UPDATE costo_servicio SET "
                  + "fecha_inicio = '"+ ServiciosTiempo.getInstancia().dateToString(costoservicio.getFechaInicio()) + "', "
                  + "fecha_fin = '" + ServiciosTiempo.getInstancia().dateToString(costoservicio.getFechaFin()) + "', "
                  + "monto = " + costoservicio.getMonto() + ", "
                  + "oidservicio_especial = '" + costoservicio.getOidServicioEspecial() + "' "
                  + "WHERE oidcosto_servicio =  '" + costoservicio.getOid() + "'";
   }

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      CostoServicioAgente costoservicio;
      try {
         while(resultado.next()){
            costoservicio = new CostoServicioAgente();
            costoservicio.setImplementacion(new CostoServicioImpl());
            costoservicio.setOid(resultado.getString("oidcosto_servicio"));
            costoservicio.setFechaInicio(resultado.getDate("fecha_inicio"));
            costoservicio.setFechaFin(resultado.getDate("fecha_fin"));
            costoservicio.setMonto(resultado.getFloat("monto"));
            costoservicio.setOidServicioEspecial(resultado.getString("oidservicio_especial"));
            lista.add(costoservicio);
         }
      } catch (SQLException ex) {
         System.err.println("IPRCostoServicio - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }

      return lista;
   }

   @Override
   public ObjetoPersistente nuevo() {
      CostoServicioAgente costoservicio = new CostoServicioAgente();
      costoservicio.setImplementacion(new CostoServicioImpl());
      return costoservicio;
   }
}