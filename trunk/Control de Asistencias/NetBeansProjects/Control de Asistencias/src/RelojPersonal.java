// : RelojPersonal.java
// 

/**
 *
 * @author Gabriel
 */
public class RelojPersonal {

	private int codReloj;
	private int numeroSerie;
	public Oficina m_Oficina;
	public Modelo m_Modelo;

	public RelojPersonal(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodReloj(){
		return codReloj;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodReloj(int newVal){
		codReloj = newVal;
	}

	public int getNumeroSerie(){
		return numeroSerie;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNumeroSerie(int newVal){
		numeroSerie = newVal;
	}

	public Oficina getOficina(){
		return null;
	}

	public Modelo getModelo(){
		return null;
	}

	/**
	 * 
	 * @param Oficina
	 */
	public void setOficina(Oficina Oficina){

	}

	/**
	 * 
	 * @param Modelo
	 */
	public void setModelo(Modelo Modelo){

	}
} // fin de la clase RelojPersonal
