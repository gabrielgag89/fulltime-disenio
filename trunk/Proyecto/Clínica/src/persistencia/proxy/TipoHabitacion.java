package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:38 p.m.
 */
public class TipoHabitacion {

	private int codigoTipoHab;
	private String nombreTipo;

	public TipoHabitacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoTipoHab(){
		return CodigoTipoHab;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoTipoHab(int newVal){
		CodigoTipoHab = newVal;
	}

	public String getNombreTipo(){
		return NombreTipo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreTipo(String newVal){
		NombreTipo = newVal;
	}
}//end TipoHabitacion