package persistencia.plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.proxy.EstadoCamaAgente;
import persistencia.proxy.EstadoCamaImpl;
import persistencia.proxy.ObjetoPersistente;

public class IPREstadoCama extends IntermPersistenciaDBR{

    @Override
    public String select(Criterio criterio) {
        return "SELECT  *  FROM  estado_cama  WHERE " + criterio.getStringCriterio();
    }

    @Override
    public String select(String oid) {
         return "SELECT * FROM estado_cama WHERE oidestado_cama = '" + oid  + "'";
    }

    @Override
    public String insertar(Object objeto) {
        EstadoCamaAgente estadoCama = (EstadoCamaAgente)objeto;
        return "INSERT INTO estado_cama (oidestado_cama,nombre_estado_cama) VALUES ('" + estadoCama.getOid() + "','" + estadoCama.getNombreEstado() + "')";
    }

    @Override
    public String actualizar(Object objeto) {
        EstadoCamaAgente estadoCama = (EstadoCamaAgente)objeto;
        return "UPDATE estado_cama SET nombre_estado_cama = '" + estadoCama.getNombreEstado() + "' WHERE oidestado_cama = '" + estadoCama.getOid() + "'";
    }

    @Override
    public List<ObjetoPersistente> convertirAObjeto(ResultSet resultado) {
      List<ObjetoPersistente> ListaEstadosCama =  new ArrayList<ObjetoPersistente>();
      try {
         while (resultado.next()){
            EstadoCamaAgente ECA = new EstadoCamaAgente();
            ECA.setImplementacion(new EstadoCamaImpl());
            ECA.setOid(resultado.getString("oidestado_cama"));
            ECA.setNombreEstado(resultado.getString("nombre_estado_cama"));
            ListaEstadosCama.add(ECA);
         }
      } catch (SQLException ex) {
         System.out.println("IPREstadosCama - convertirAObjeto - SQLException: "+ex.getMessage());
      }
      return ListaEstadosCama;
    }

    @Override
    public ObjetoPersistente nuevo() {
      EstadoCamaAgente ECA = new EstadoCamaAgente();
      ECA.setImplementacion(new EstadoCamaImpl());
      return (ObjetoPersistente) ECA;
    }

}
