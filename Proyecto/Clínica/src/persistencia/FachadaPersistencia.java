// FachadaPersistencia: FachadaPersistencia.java
// Primer intermediario para no acoplar los expertos con la persistencia en la BDR.

package persistencia;

import java.util.List;
import persistencia.criterios.Criterio;
import persistencia.FachadaPersistenciaInterna;

/**
 * Primer intermediario para no acoplar los expertos con la persistencia en la BDR.
 * @author Gabriel
 */
public class FachadaPersistencia {
   private static FachadaPersistencia instancia;
   
   public static FachadaPersistencia getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FachadaPersistencia();
      
      return instancia;
   } // fin del método getInstancia
   
   public Object nuevaEntidad(String entidad){
      return FachadaPersistenciaInterna.getInstancia().nuevaEntidad(entidad);
   } // fin del método nuevaEntidad
   
   public List buscar(String entidad, Criterio cc) {
      return FachadaPersistenciaInterna.getInstancia().buscar(entidad, cc);
   } // fin del método getColeccion
   
   public void guardar(String entidad , Object objeto){
      FachadaPersistenciaInterna.getInstancia().guardar(entidad,objeto);
   } // fin del método persistirEntidad
   
   public Criterio getCriterio(String atributo, String operador, String valor){
      return  FachadaPersistenciaInterna.getInstancia().getCriterio(atributo,operador,valor);
   } // fin del método getCriterio
   
   public Criterio and(List c) {
      return FachadaPersistenciaInterna.getInstancia().and(c);
   } // fin del método and
   
   public Criterio and(Criterio c1,Criterio c2){
      return  FachadaPersistenciaInterna.getInstancia().and(c1,c2);
   } // fin del método and
   
   public List getColeccion(String clase) {
       
                FachadaPersistenciaInterna FPI =FachadaPersistenciaInterna.getInstancia();
                List i = FPI.getColeccion(clase);
                return i;
                
        }
} // fin de la clase FachadaPersistencia