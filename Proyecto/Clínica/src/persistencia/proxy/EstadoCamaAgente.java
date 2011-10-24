
package persistencia.proxy;

public class EstadoCamaAgente extends ObjetoPersistente implements EstadoCama {

    EstadoCamaImplementacion implementacion;

    
    public void setImplementacion(EstadoCamaImplementacion implementacion) {
        this.implementacion = implementacion;
    }  
    
    @Override
    public String getNombreEstado() {
        return this.implementacion.getNombreEstado();
    }

    @Override
    public void setNombreEstado(String nombreEstado) {
        this.implementacion.setNombreEstado(nombreEstado);
    }    
    
    
}//fin EstadoCama Agente
