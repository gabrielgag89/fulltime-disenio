package persistencia.criterios;

import java.util.Vector;

public class FabricaDeCriterios {
	private static FabricaDeCriterios instancia;

	public FabricaDeCriterios(){

	}

	public static FabricaDeCriterios getInstance(){
            if (instancia == null) {
                instancia = new FabricaDeCriterios();
            }
            return instancia;
	}

        public Criterio getCriterio(String atributo, String operador, String valor) {
            return new CriterioSimple(atributo,operador,valor);
        }

        public Criterio and(Vector c) {
            return new AND().setCriterio(c);
        }

        public Criterio or(Vector c) {
            return new OR().setCriterio(c);
        }

        public Criterio and(Criterio c1, Criterio c2) {
            Vector V = new Vector();
            V.addElement(c1);
            V.addElement(c2);
            return this.and(V);
        }
}
