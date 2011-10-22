package persistencia.criterios;

public class CriterioSimple implements Criterio {

	private String Valor;
	private String Operador;
	private String Entidad;
	private String Atributo;

	public CriterioSimple(String a,String o,String v){
                Valor = v;
                Operador = o;
                Atributo = a;
	}

	public String getStringCriterio(){
		return Atributo + " " + Operador + " '" + Valor + "'";
	}

	public void setEntidad(String e){
            Entidad = e;
	}

	public void setValor(String v){
            Valor = v;
	}

	public void setOperador(String o){
            Operador = o;
	}

	public void setAtributo(String a){
            Atributo = a;
	}

}
