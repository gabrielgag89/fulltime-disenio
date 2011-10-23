package persistencia.criterios;

import java.util.List;

public class CriterioCompuesto implements Criterio{

        protected List CS;

        public Criterio setCriterio(List c) {
            CS = c;
            return (Criterio) this;
        }

        public void setCriterio(Criterio c) {
            CS.add(c);
        }
        
        public Criterio getCriterio(int index) {
            return (Criterio) CS.get(index);
        }

        public void limpiarCriterio(Criterio c) {
            CS.clear();
        }

        public String getStringCriterio() {
            throw new UnsupportedOperationException("No es soportado en este nivel");
        }
}
