/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.proxy;
import persistencia.FachadaPersistenciaInterna;

/**
 *
 * @author Cristian Mesa
 */
public class PlanAgente extends ObjetoPersistente implements Plan {
     private PlanImplementacion implementacion;
     private boolean obrasocial = false;
     private String oidObraSocial;

    public void setImplementacion(PlanImplementacion implementacion) {
        this.implementacion = implementacion;
    }

    @Override
    public int getCodigoPlan() {
        return this.implementacion.getCodigoPlan();
    }
    
    @Override
    public void setCodigoPlan(int codigoPlan) {
        this.implementacion.setCodigoPlan(codigoPlan);
    }

    @Override
    public String getDescripcion() {
        return this.implementacion.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.implementacion.setDescripcion(descripcion);
    }
    
    @Override
    public ObraSocial getObraSocial() {
        if(!obrasocial){
            this.implementacion.setObraSocial((ObraSocial)FachadaPersistenciaInterna.getInstancia().buscar("ObraSocial",oidObraSocial));
            this.obrasocial = true;
        }
            return this.implementacion.getObraSocial();
        }       
     
    @Override
    public void setObraSocial(ObraSocial obrasocial) {
        this.implementacion.setObraSocial(obrasocial);
    }
}
