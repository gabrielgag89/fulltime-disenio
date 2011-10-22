package persistencia.criterios;

public class OR extends CriterioCompuesto {

	public OR(){

	}

    @Override
        public String getStringCriterio() {
            String registro = null;
            Criterio C;
            for(int i=0;i < super.CS.size();i++){
                C = (Criterio) super.CS.get(i);
                if(i == 0){
                    registro = C.getStringCriterio();
                }else{
                    registro = registro + " OR " + C.getStringCriterio();
                }
            }
            return registro;
        }

}
