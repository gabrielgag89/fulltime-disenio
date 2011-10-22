package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:39 p.m.
 */
public class CostoPrestacion {

	private Date fechaInicio;
	private Date fechaFin;
	private float monto;

	public CostoPrestacion(){

	}

	public void finalize() throws Throwable {

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

	public float getMonto(){
		return Monto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMonto(float newVal){
		Monto = newVal;
	}
}//end CostoPrestacion