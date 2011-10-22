package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:33 p.m.
 */
public class Coseguro {

	private int codigoCoseguro;
	private float porcentajeDescuento;

	public Coseguro(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoCoseguro(){
		return CodigoCoseguro;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoCoseguro(int newVal){
		CodigoCoseguro = newVal;
	}

	public float getPorcentage(){
		return Porcentage;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPorcentage(float newVal){
		Porcentage = newVal;
	}

	public float getPorcentajeDescuento(){
		return porcentajeDescuento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPorcentajeDescuento(float newVal){
		porcentajeDescuento = newVal;
	}
}//end Coseguro