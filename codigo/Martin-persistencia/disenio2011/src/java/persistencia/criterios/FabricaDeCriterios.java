package persistencia.criterios;

import java.util.List;

public class FabricaDeCriterios {

    private static FabricaDeCriterios instancia;

	public static FabricaDeCriterios getInstance(){
            if (instancia == null) {
                instancia = new FabricaDeCriterios();
            }
            return instancia;
	}

        public Criterio getCriterio(String atributo, String operador, String valor) {
            return new CriterioSimple(atributo,operador,valor);
        }

        public Criterio and(List c) {
            return new AND().setCriterio(c);
        }

        public Criterio or(List c) {
            return new OR().setCriterio(c);
        }

}
