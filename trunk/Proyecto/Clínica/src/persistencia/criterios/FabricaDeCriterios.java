package persistencia.criterios;

import java.util.List;
import java.util.ArrayList;

public class FabricaDeCriterios {
   private static FabricaDeCriterios instancia;
   
   private FabricaDeCriterios(){}
   
   public static FabricaDeCriterios getInstancia(){
      // si no contenía una referencia anteriormente, la crea
      if (instancia == null)
         instancia = new FabricaDeCriterios();
      
      return instancia;
   } // fin del método getInstancia
   
   public Criterio getCriterio(String atributo, String operador, Object valor) {
      return new CriterioSimple(atributo, operador, valor);
   } // fin del método getCriterio
   
   public Criterio or(List<Criterio> c) {
      return new OR().setCriterio(c);
   } // fin del método or
   
   public Criterio and(List<Criterio> c) {
      return new AND().setCriterio(c);
   } // fin del método and
   
   public Criterio and(Criterio c1, Criterio c2) {
      List V = new ArrayList();
      V.add(c1);
      V.add(c2);
      return this.and(V);
   } // fin del método and
} // fin de la clase FabricaDeCriterios