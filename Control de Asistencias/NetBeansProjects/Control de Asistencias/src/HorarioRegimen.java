// : HorarioRegimen.java
// 

import java.util.Vector;

/**
 *
 * @author Gabriel
 */
public class HorarioRegimen {

	private Time horaDesde;
	private Time horaHasta;
	private String nombreDia;

	public HorarioRegimen(){

	}

	public void finalize() throws Throwable {

	}
	public Time getHoraDesde(){
		return horaDesde;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHoraDesde(Time newVal){
		horaDesde = newVal;
	}

	public Time getHoraHasta(){
		return horaHasta;
	}

	public String getNombreDia(){
		return nombreDia;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHoraHasta(Time newVal){
		horaHasta = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombreDia(String newVal){
		nombreDia = newVal;
	}
} // fin de la clase HorarioRegimen
