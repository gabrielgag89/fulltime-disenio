package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:32 p.m.
 */
public class Recibo {

	private int n°Recibo;
	private Date fecha;
	private double monto;
	public Monto m_Monto;

	public Recibo(){

	}

	public void finalize() throws Throwable {

	}
	public int getN°Recibo(){
		return N°Recibo;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN°Recibo(int newVal){
		N°Recibo = newVal;
	}

	public Monto getMonto(){
		return null;
	}

	/**
	 * 
	 * @param monto
	 */
	public void setMonto(Monto monto){

	}

	public Date getFecha(){
		return fecha;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFecha(Date newVal){
		fecha = newVal;
	}

	public double getMonto(){
		return monto;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMonto(double newVal){
		monto = newVal;
	}
}//end Recibo