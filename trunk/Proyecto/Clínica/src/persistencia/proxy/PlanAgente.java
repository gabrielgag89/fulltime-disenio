/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Mesa
 */
public class PlanAgente implements Plan extends ObjetoPersistente {
     private PlanImplementacion implementacion;
     boolean heBuscandoObraSocial = false;
    
    public void setImplementacion(PlanImplementacion implementacion) {
        this.implementacion = implementacion;
    
    public boolean isHeBuscandoObraSocial() {
        return heBuscandoObraSocial;
    }

    public void setHeBuscandoPlanes(boolean heBuscandoObraSocial) {
        this.heBuscandoObraSocial = heBuscandoObraSocial;
    
        
    public int getCodigoPlan() {
        return this.implementacion.getCodigoPlan();
    }

    
    public void setCodigoPlan(int codigoPlan) {
        this.implementacion.setCodigoPlan(codigoPlan);
    }
    public String getDescripcionPlan() {
        return this.implementacion.getDescripcionPlan();
    }
    public void setDescripcionPlan(String descripcion) {
        this.implementacion.setCodigoPlan(descripcion);
    
    }
    
    public List<ObraSocial> getObraSocial() {
        if(heBuscandoObraSocial)
            return this.implementacion.getObraSocial();
        else{
            List<Criterio> criterios = new ArrayList<Criterio>();
            criterios.add(new Criterio("OIDObraSocial","=",super.getOid()));
            for(ObjetoPersistente obj: FachadaInterna.getInstancia().buscar("ObraSocial",criterios)){
               ObraSocial o = (ObraSocial)obj;
               this.implementacion.addObraSocial(o);
            }
            this.heBuscandoObraSocial = true;
            return this.implementacion.getObraSocial();
        }       
           

   
    public void setObraSocial(List<ObraSocial> obrasocial) {
        this.implementacion.setObraSocial(obrasocial);
    }
          public void addObraSocial(ObraSocial o) {
        this.implementacion.addObraSocial(o);
    }

    
    public void removerObraSocial(ObraSocial o) {
        this.implementacion.removerObraSocial(o);
    }    
    
    
}
