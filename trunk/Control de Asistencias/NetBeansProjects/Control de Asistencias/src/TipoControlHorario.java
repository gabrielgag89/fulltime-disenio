// : TipoControlHorario.java
// 

/**
 *
 * @author Gabriel
 */
public class TipoControlHorario {

	private int codigo;
	private String descripcion;

	public TipoControlHorario(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigo(){
		return codigo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigo(int newVal){
		codigo = newVal;
	}

	public String getDescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescripcion(String newVal){
		descripcion = newVal;
	}
} // fin de la clase TipoControlHorario
