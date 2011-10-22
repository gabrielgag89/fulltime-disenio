package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:22 p.m.
 */
public class Prestacion {

	private int codigoPrestacion;
	private String descripcion;
	public CostoPrestacion m_CostoPrestacion;
	public TipoPrestacion m_TipoPrestacion;

	public Prestacion(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoPrestacion(){
		return CodigoPrestacion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoPrestacion(int newVal){
		CodigoPrestacion = newVal;
	}

	public String getDescripcion(){
		return Descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescripcion(String newVal){
		Descripcion = newVal;
	}

	public Vector getCosto(){
		return null;
	}

	/**
	 * 
	 * @param costo
	 */
	public void setCosto(Vector costo){

	}

	public TipoPrestacion getTipoPrestacion(){
		return null;
	}

	/**
	 * 
	 * @param tipoPrestacion
	 */
	public void setTipo(TipoPrestacion tipoPrestacion){

	}
}//end Prestacion