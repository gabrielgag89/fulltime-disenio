package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:25 p.m.
 */
public class Habitacion {

	private int n°Habitacion;
	public Sector m_Sector;
	public TipoHabitacion m_TipoHabitacion;

	public Habitacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getN°Habitacion(){
		return N°Habitacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN°Habitacion(int newVal){
		N°Habitacion = newVal;
	}

	public Sector getSector(){
		return null;
	}

	/**
	 * 
	 * @param sector
	 */
	public void setSector(Sector sector){

	}

	public TipoHabitacion getTipoHabitacion(){
		return null;
	}

	/**
	 * 
	 * @param tipohab
	 */
	public setTipoHabitacion(TipoHabitacion tipohab){

	}
}//end Habitacion