package persistencia.proxy;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:27 p.m.
 */
public class Sector {

	private int codigoSector;
	private String descripcionSector;
	private int n�Piso;

	public Sector(){

	}

	public void finalize() throws Throwable {

	}
	public int getCodigoSector(){
		return CodigoSector;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodigoSector(int newVal){
		CodigoSector = newVal;
	}

	public String getDescripcionSector(){
		return DescripcionSector;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescripcionSector(String newVal){
		DescripcionSector = newVal;
	}

	public int getN�Piso(){
		return N�Piso;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setN�Piso(int newVal){
		N�Piso = newVal;
	}
}//end Sector