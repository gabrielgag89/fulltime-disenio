package persistencia.proxy;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:20 p.m.
 */
public class Plan {

	private int codigoPlan;
	private String descripcion;
	public ObraSocial m_ObraSocial;

	public Plan(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoPlan(){
		return CodigoPlan;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoPlan(int newVal){
		CodigoPlan = newVal;
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

	public ObraSocial getOSocial(){
		return null;
	}

	/**
	 * 
	 * @param obras
	 */
	public setOSocial(ObraSocial obras){

	}
}//end Plan