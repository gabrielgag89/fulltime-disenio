package Clases;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:29 p.m.
 */
public class ServicioEspecial {

	private int codigoServicio;
	private String nombreServicio;
	public CostoServicio m_CostoServicio;

	public ServicioEspecial(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoServicio(){
		return CodigoServicio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoServicio(int newVal){
		CodigoServicio = newVal;
	}

	public String getNombreServicio(){
		return NombreServicio;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreServicio(String newVal){
		NombreServicio = newVal;
	}

	public CostoServicio getCostoServicio(){
		return null;
	}

	/**
	 * 
	 * @param costoServicio
	 */
	public void setCostoServicio(CostoServicio costoServicio){

	}
}//end ServicioEspecial