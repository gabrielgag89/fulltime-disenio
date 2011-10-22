package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:34 p.m.
 */
public class Convenio {

	private Date fechaInicio;
	private Date fechaFin;
	public Plan m_Plan;
	public Coseguro m_Coseguro;
	public Prestacion m_Prestacion;

	public Convenio(){

	}

	public void finalize() throws Throwable {

	}
	public Date getFechaInicio(){
		return FechaInicio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaInicio(Date newVal){
		FechaInicio = newVal;
	}

	public Date getFechaFin(){
		return FechaFin;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaFin(Date newVal){
		FechaFin = newVal;
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

	public Coseguro getCoseguro(){
		return null;
	}

	/**
	 * 
	 * @param coseguro
	 */
	public void setCoseguro(Coseguro coseguro){

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
}//end Convenio