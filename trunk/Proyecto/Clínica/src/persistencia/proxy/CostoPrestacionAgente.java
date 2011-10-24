
package persistencia.proxy;

import java.util.Date;


public class CostoPrestacionAgente extends ObjetoPersistente implements CostoPrestacion {
    
    private CostoPrestacionImplementacion implementacion;

    
    public void setImplementacion(CostoPrestacionImplementacion implementacion) {
        this.implementacion = implementacion;
    }
    
    @Override
    public Date getFechaFin() {
        return this.implementacion.getFechaFin();
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        this.implementacion.setFechaFin(fechaFin);
    }

    @Override
    public Date getFechaInicio() {
        return this.implementacion.getFechaInicio();
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.implementacion.setFechaInicio(fechaInicio);
    }

    @Override
    public float getMonto() {
        return this.implementacion.getMonto();
    }

    @Override
    public void setMonto(float monto) {
        this.implementacion.setMonto(monto);
    }
    
    
}//fin CostoPrestacionAgente
