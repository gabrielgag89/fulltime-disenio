package persistencia.proxy;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:37 p.m.
 */
public class DetalleFicha {

	private Date fechaAlta;
	public ServicioEspecial m_ServicioEspecial;

	public DetalleFicha(){

	}

	public void finalize() throws Throwable {

	}
	public Date getFechaAlta(){
		return FechaAlta;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFechaAlta(Date newVal){
		FechaAlta = newVal;
	}

	public ServicioEspecial getServicioEspecial(){
		return null;
	}

	/**
	 * 
	 * @param servicioEspecial
	 */
	public void setServicioEspecial(ServicioEspecial servicioEspecial){

	}
}//end DetalleFicha