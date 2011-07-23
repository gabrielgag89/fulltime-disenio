// : Fabricante.java
// 

/**
 *
 * @author Gabriel
 */
public class Fabricante {

	private String nombreFabricante;

	public Fabricante(){

	}

	public void finalize() throws Throwable {

	}
	public String getNombreFabricante(){
		return nombreFabricante;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreFabricante(String newVal){
		nombreFabricante = newVal;
	}
} // fin de la clase Fabricante
