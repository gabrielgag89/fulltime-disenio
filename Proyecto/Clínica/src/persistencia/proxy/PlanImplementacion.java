package persistencia.proxy;

import java.util.List;


  
 //* @author Cristian Mesa
 
public class PlanImplementacion implements Plan {

	private int codigoPlan;
	private String descripcion;
	public ObraSocial m_ObraSocial;
        private List<ObraSocial> ObraSocial;

    public List<ObraSocial> getObraSocial() {
        return ObraSocial;
    }

    public void setObraSocial(List<ObraSocial> ObraSocial) {
        this.ObraSocial = ObraSocial;
    }
        
        
    public int getCodigoPlan() {
        return codigoPlan;
    }

    public void setCodigoPlan(int codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObraSocial getM_ObraSocial() {
        return m_ObraSocial;
    }

    public void setM_ObraSocial(ObraSocial m_ObraSocial) {
        this.m_ObraSocial = m_ObraSocial;
    }
   
    public void addObraSocial(ObraSocial o) {
        this.ObraSocial.add(o);
    }

    
    public void removerObrasocial(ObraSocial o) {
        this.ObraSocial.remove(o);

	

	
}
}
