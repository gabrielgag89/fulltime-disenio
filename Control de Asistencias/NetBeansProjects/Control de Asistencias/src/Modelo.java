// : Modelo.java
// 

/**
 *
 * @author Gabriel
 */
public class Modelo {

	private String nombreModelo;
	public Fabricante m_Fabricante;

	public Modelo(){

	}

	public void finalize() throws Throwable {

	}
	public String getNombreModelo(){
		return nombreModelo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreModelo(String newVal){
		nombreModelo = newVal;
	}

	public Fabricante getFabricante(){
		return null;
	}

	/**
	 * 
	 * @param Fabricante
	 */
	public void setFabricante(Fabricante Fabricante){

	}
} // fin de la clase Modelo
