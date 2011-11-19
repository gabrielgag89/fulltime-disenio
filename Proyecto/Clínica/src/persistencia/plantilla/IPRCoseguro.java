/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.plantilla;

import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import persistencia.criterios.Criterio;
import persistencia.proxy.ObjetoPersistente;
import persistencia.proxy.CoseguroAgente;
import persistencia.proxy.CoseguroImpl;

public class IPRCoseguro extends IntermPersistenciaDBR{
    @Override
    public String select() {
        return "SELECT * FROM coseguro";
    }

    @Override
    public String select(Criterio criterio) {
        return "SELECT * FROM coseguro WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
return "SELECT  *  FROM  coseguro  WHERE oidcoseguro ='" + oid +"'";
    }

    @Override
    public String insertar(Object objeto) {
CoseguroAgente coseguro = (CoseguroAgente) objeto;
      return "INSERT INTO coseguro VALUES "
                  + "('" + coseguro.getOid() + "', "
                         + coseguro.getCodigoCoseguro() + ", "
                         + coseguro.getPorcentaje();
    }

    @Override
    public String actualizar(Object objeto) {

        CoseguroAgente coseguro = (CoseguroAgente)objeto;
        return "UPDATE coseguro SET "
                  + "codigo = '" + coseguro.getCodigoCoseguro() + "', "  
                  + "porcentaje = " + coseguro.getPorcentaje() + " "
                  + "WHERE oidcoseguro = '" + coseguro.getOid() + "'";  
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
 List<ObjetoPersistente> lista = new ArrayList<ObjetoPersistente>();
      CoseguroAgente coseguro;
      
      try {
         while(resultado.next()){
            coseguro = new CoseguroAgente();
            
            coseguro.setImplementacion(new CoseguroImpl());
            coseguro.setOid(resultado.getString("oidcoseguro"));
            coseguro.setCodigoCoseguro(resultado.getInt("codigo_coseguro"));
            coseguro.setPorcentaje(resultado.getFloat("porcentaje"));
            
            lista.add(coseguro);
         }
      } catch (SQLException ex) {
         System.err.println("IPRCoseguro - convertirAObjeto(ResultSet resultado) - " + ex.getMessage());
      }
      
      return lista;    }

    @Override
    public ObjetoPersistente nuevo() {
 CoseguroAgente coseguro = new CoseguroAgente();
      coseguro.setImplementacion(new CoseguroImpl());
      
      return coseguro;
    }
    
}
    
