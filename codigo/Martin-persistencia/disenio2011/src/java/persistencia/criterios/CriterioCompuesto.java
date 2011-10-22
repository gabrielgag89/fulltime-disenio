package persistencia.criterios;

import java.util.Vector;

public class CriterioCompuesto implements Criterio{

        protected Vector CS= new Vector();

	public CriterioCompuesto(){

	}

        public Criterio setCriterio(Vector c) {
            CS = c;
            return (Criterio) this;
        }

        public void setCriterio(Criterio c) {
            CS.addElement(c);
        }
        
        public Criterio getCriterio(int index) {
            return (Criterio) CS.get(index);
        }

        public void limpiarCriterio(Criterio c) {
            CS.clear();
        }

        public String getStringCriterio() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
}
