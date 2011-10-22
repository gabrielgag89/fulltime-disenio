package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:23 p.m.
 */
public class FacturaCliente {

	private int n°Factura;
	private Date fechaEmision;
	public FichaInternacion m_FichaInternacion;
	public Recibo m_Recibo;
	public EstadoFacturaCliente m_EstadoFacturaCliente;

	public FacturaCliente(){

	}

	public void finalize() throws Throwable {

	}
	public int getN°Factura(){
		return N°Factura;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN°Factura(int newVal){
		N°Factura = newVal;
	}

	public Date getFechaEmision(){
		return FechaEmision;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaEmision(Date newVal){
		FechaEmision = newVal;
	}

	public FichaInternacion getFichaInternacion(){
		return null;
	}

	/**
	 * 
	 * @param fichaInternacion
	 */
	public void setFichaInternacion(FichaInternacion fichaInternacion){

	}

	public EstadoFacturaCliente getEstadoFactura(){
		return null;
	}

	/**
	 * 
	 * @param estadoFactura
	 */
	public void setEstadoFactura(EstadoFacturaCliente estadoFactura){

	}

	public Recibo getRecibo(){
		return null;
	}

	/**
	 * 
	 * @param recibo
	 */
	public void setRecibo(Recibo recibo){

	}
}//end FacturaCliente