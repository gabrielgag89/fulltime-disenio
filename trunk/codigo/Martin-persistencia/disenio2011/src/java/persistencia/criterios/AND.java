package persistencia.criterios;

public class AND extends CriterioCompuesto {

	public AND(){

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
                    registro = registro + " AND " + C.getStringCriterio();
                }
            }
            return registro;
        }
}
