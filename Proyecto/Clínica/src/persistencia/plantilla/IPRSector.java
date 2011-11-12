/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.plantilla;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.SectorAgente;
import persistencia.proxy.SectorImplementacion;
import persistencia.proxy.ObjetoPersistente;

/**
 *
 * @author Cristian Mesa
 */
public class IPRSector extends IntermPersistenciaDBR {
   @Override
   public String select() {
      return "SELECT * FROM sector";
   } 
    
   @Override
   public String select(Criterio criterio) {
      return "SELECT * FROM sector WHERE " + criterio.getStringCriterio();
   } 

   @Override
   public String select(String oid) {
      return "SELECT * FROM sector WHERE oidsector = '" + oid + "'";
   } 

   @Override
   public String insertar(Object objeto) {
      SectorAgente sect = (SectorAgente) objeto;
      return "INSERT INTO sector VALUES "
                  + "('" + sect.getOid() + "', "
                         + sect.getCodigoSector() + ", '"
                         + sect.getDescripcionSector() + "',"
                         + sect.getNumeroPisoSector() + ")";
   } 

   @Override
   public String actualizar(Object objeto) {
      SectorAgente sect = (SectorAgente) objeto;
      return "UPDATE FROM sector WHERE"
                  + "oidsector =  '" + sect.getOid() + "', "
                  + "codigo_sector = " + sect.getCodigoSector() + ", "
                  + "descripcion_sector = '" + sect.getDescripcionSector() + "', "
                  + "numero_piso = " + sect.getNumeroPisoSector();
   } 

   @Override
   public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      SectorAgente sect;
      
      try {
         while(resultado.next()){
            sect = new SectorAgente();
            
            sect.setImplementacion(new SectorImplementacion());
            sect.setOid(resultado.getString("oidsector"));
            sect.setCodigoSector(resultado.getInt("codigo_sector"));
            sect.setDescripcionSector(resultado.getString("descripcion_sector"));
            sect.setNumeroPisoSector(resultado.getInt("numero_piso"));
            
            
            lista.add(sect);
         }
      } catch (SQLException ex) {
         System.err.println("IPRSector - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;
   } 

   @Override
   public ObjetoPersistente nuevo() {
      SectorAgente sect = new SectorAgente();
      sect.setImplementacion(new SectorImplementacion());
      
      return sect;
   } 
} 