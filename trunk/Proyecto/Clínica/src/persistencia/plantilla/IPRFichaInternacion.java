package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.FichaInternacionAgente;
import persistencia.proxy.FichaInternacionImpl;
import persistencia.proxy.ObjetoPersistente;
import util.ServiciosTiempo;

public class IPRFichaInternacion extends IntermPersistenciaDBR{
   @Override
   public String select() {
   return "SELECT  *  FROM  ficha_internacion";
   }

   @Override
   public String select(Criterio criterio) {
   return "SELECT  *  FROM  ficha_internacion  WHERE " + criterio.getStringCriterio();
   }

   @Override
   public String select(String oid) {
   return "SELECT * FROM ficha_internacion WHERE oidficha_internacion = '" + oid  + "'";
   }

   @Override
   public String insertar(Object objeto) {
      FichaInternacionAgente fichaInternacion = (FichaInternacionAgente)objeto;
      
      return "INSERT INTO ficha_internacion (oidficha_internacion,numero_ficha_internacion,fecha,oidprestacion,oidestado_ficha_internacion,oidcama,oidpaciente) " +
                     "VALUES ('" + fichaInternacion.getOid() + "', '"
                                 + fichaInternacion.getNroFicha() + "', '"
                                 + ServiciosTiempo.getInstancia().dateToString(fichaInternacion.getFechaCreacion()) + "', '"
                                 + fichaInternacion.getOidprestacion() + "', '"
                                 + fichaInternacion.getOidestadoFichaInternacion() + "', '"
                                 + fichaInternacion.getOidcama() + "', '"
                                 + fichaInternacion.getOidpaciente() + "')";
   }

   @Override
   public String actualizar(Object objeto) {
      FichaInternacionAgente fichaInternacion = (FichaInternacionAgente)objeto;

      return "UPDATE ficha_internacion SET "
                     + "numero_ficha_internacion = '" + fichaInternacion.getNroFicha() + "', "
                     + "fecha = '" + ServiciosTiempo.getInstancia().dateToString(fichaInternacion.getFechaCreacion()) + "', "
                     + "oidprestacion = '" + fichaInternacion.getOidprestacion() + "', "
                     + "oidestado_ficha_internacion = '" + fichaInternacion.getOidestadoFichaInternacion() + "', "
                     + "oidcama = '" + fichaInternacion.getOidcama() + "', "
                     + "oidpaciente = '" + fichaInternacion.getOidpaciente() + "' "
                     + "WHERE oidficha_internacion = '" + fichaInternacion.getOid() + "'";
   }

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaFichaInternaciones =  new ArrayList<ObjetoPersistente>();
      
      try {
         while (resultado.next()){
            FichaInternacionAgente FIA = new FichaInternacionAgente();
            FIA.setImplementacion(new FichaInternacionImpl());
            FIA.setOid(resultado.getString("oidficha_internacion"));
            FIA.setNroFicha(resultado.getInt("numero_ficha_internacion"));
            FIA.setFechaCreacion(resultado.getDate("fecha"));
            FIA.setOidprestacion(resultado.getString("oidprestacion"));
            FIA.setOidestadoFichaInternacion(resultado.getString("oidestado_ficha_internacion"));
            FIA.setOidcama(resultado.getString("oidcama"));
            FIA.setOidpaciente(resultado.getString("oidpaciente"));
            
            ListaFichaInternaciones.add(FIA);
         }
      }
      catch (SQLException ex) {
         System.out.println("IPRFichaInternacion - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      
      return ListaFichaInternaciones;
   }

   @Override
   public ObjetoPersistente nuevo() {
      FichaInternacionAgente FIA = new FichaInternacionAgente();
      FIA.setImplementacion(new FichaInternacionImpl());

      return (ObjetoPersistente) FIA;
   }
}