package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:19 p.m.
 */
public class Paciente {

	private int n°Paciente;
	private String nombre;
	private int dni;
	private String domicilio;
	private int telefono;
	public Plan m_Plan;

	public Paciente(){

	}

	public void finalize() throws Throwable {

	}
	public int getN°Paciente(){
		return N°Paciente;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN°Paciente(int newVal){
		N°Paciente = newVal;
	}

	public String getNombre(){
		return Nombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombre(String newVal){
		Nombre = newVal;
	}

	public int getDni(){
		return Dni;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDni(int newVal){
		Dni = newVal;
	}

	public String getDomicilio(){
		return Domicilio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDomicilio(String newVal){
		Domicilio = newVal;
	}

	public int getTelefono(){
		return Telefono;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelefono(int newVal){
		Telefono = newVal;
	}

	public Plan getPlan(){
		return null;
	}

	/**
	 * 
	 * @param plan
	 */
	public void setPlan(Plan plan){

	}
}//end Paciente