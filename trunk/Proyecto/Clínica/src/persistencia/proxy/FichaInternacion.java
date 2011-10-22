package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:24 p.m.
 */
public class FichaInternacion {

	private int n°Ficha;
	private int fechaCreacion;
	public Cama m_Cama;
	public Paciente m_Paciente;
	public Prestacion m_Prestacion;
	public EstadoFichaInternacion m_EstadoFichaInternacion;
	public Habitacion m_Habitacion;
	public DetalleFicha m_DetalleFicha;

	public FichaInternacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getN°Ficha(){
		return N°Ficha;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN°Ficha(int newVal){
		N°Ficha = newVal;
	}

	public int getFechaCreacion(){
		return FechaCreacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaCreacion(int newVal){
		FechaCreacion = newVal;
	}

	public EstadoFichaInternacion getEstadoFicha(){
		return null;
	}

	/**
	 * 
	 * @param sstadoFicha
	 */
	public void setEstadoFicha(EstadoFichaInternacion sstadoFicha){

	}

	public Cama getCama(){
		return null;
	}

	/**
	 * 
	 * @param cama
	 */
	public void setCama(Cama cama){

	}

	public Paciente getPaciente(){
		return null;
	}

	/**
	 * 
	 * @param paciente
	 */
	public void setPaciente(Paciente paciente){

	}

	public Prestacion getPrestacion(){
		return null;
	}

	/**
	 * 
	 * @param prestacion
	 */
	public void setPrestacion(Prestacion prestacion){

	}

	public Habitacion getHabitacion(){
		return null;
	}

	/**
	 * 
	 * @param habitacion
	 */
	public void setHabitacion(Habitacion habitacion){

	}

	public Prestacion getPrestacion(){
		return null;
	}

	/**
	 * 
	 * @param prestacion
	 */
	public void setPrestacion(Prestacion prestacion){

	}
}//end FichaInternacion