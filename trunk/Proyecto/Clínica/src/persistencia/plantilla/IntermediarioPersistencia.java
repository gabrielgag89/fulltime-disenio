// IntermediarioPersistencia: IntermediarioPersistencia.java
// Primer nivel de los intermediarios de la persistencia.

package persistencia.plantilla;

import java.util.List;
import persistencia.proxy.ObjetoPersistente;
import persistencia.criterios.Criterio;

/**
 * Primer nivel de los intermediarios de la persistencia.
 * @author Gabriel
 */
public abstract class IntermediarioPersistencia {
   public List<ObjetoPersistente> buscar(){
       List<ObjetoPersistente> buscados = materializar(criterio);
      
      if(!buscados.isEmpty()){
         for(ObjetoPersistente objeto : buscados){
            Cache.getInstancia().agregar(objeto.getOid(), objeto);
            objeto.setNuevo(false);
         } // fin de for
      } // fin de if
      
      return buscados;
   } // fin del método buscar
   
   public List<ObjetoPersistente> buscar(Criterio criterio){
      List<ObjetoPersistente> buscados = materializar(criterio);
      
      if(!buscados.isEmpty()){
         for(ObjetoPersistente objeto : buscados){
            Cache.getInstancia().agregar(objeto.getOid(), objeto);
            objeto.setNuevo(false);
         } // fin de for
      } // fin de if
      
      return buscados;
   } // fin del método buscar
   
   public ObjetoPersistente buscar(String oid){
      ObjetoPersistente buscado = Cache.getInstancia().enCache(oid);
      
      if(buscado == null) {
         buscado =  materializar(oid);
         Cache.getInstancia().agregar(oid, buscado);
         buscado.setNuevo(false);
      } // fin de if
      
      return buscado;
   } // fin del método buscar
   
   public void guardar(Object objeto){
      ObjetoPersistente obj = (ObjetoPersistente) objeto;
      desmaterializar(obj);
      Cache.getInstancia().quitar(obj.getOid());
   } // fin del método guardar
   
   public ObjetoPersistente nuevaEntidad(){
      ObjetoPersistente objPers = obtenerNuevaEntidad();
      objPers.setLimpio(true);
      objPers.setNuevo(true);
      
      Cache.getInstancia().agregar(objPers.getOid(),objPers);
      
      return objPers;
   } // fin del método nuevaEntidad
   
   public abstract ObjetoPersistente obtenerNuevaEntidad(); // método a implementar
   
   public abstract ObjetoPersistente materializar(String oid); // método a implementar
   
   public abstract List<ObjetoPersistente> materializar(Criterio criterio); // método a implementar
   
   public abstract void desmaterializar(ObjetoPersistente objeto); // método a implementar
} // fin de la clase IntermediarioPersistencia