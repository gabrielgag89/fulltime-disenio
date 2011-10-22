package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:35 p.m.
 */
public class TipoPrestacion {

	private int codigoTipoPrestacion;
	private String nombreTipoPrestacion;
	public TipoHabitacion m_TipoHabitacion;

	public TipoPrestacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoTipoPrestacion(){
		return CodigoTipoPrestacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoTipoPrestacion(int newVal){
		CodigoTipoPrestacion = newVal;
	}

	public String getNombreTipoPrestacion(){
		return NombreTipoPrestacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreTipoPrestacion(String newVal){
		NombreTipoPrestacion = newVal;
	}

	public TipoHabitacion getTipoHabitacion(){
		return null;
	}

	/**
	 * 
	 * @param tipoHabitacion
	 */
	public void setTipoHabitacion(TipoHabitacion tipoHabitacion){

	}
}//end TipoPrestacion