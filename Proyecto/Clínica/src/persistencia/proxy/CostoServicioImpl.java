package persistencia.proxy;

import java.util.Date;

/**
 * @author Matías
 */
public class CostoServicioImpl implements CostoServicio {
    
    private Date fechaInicio;
    private Date fechaFin;
    private float monto;
    private ServicioEspecial servicioEspecial;

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public float getMonto() {
        return monto;
    }

    @Override
    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public ServicioEspecial getServicioEspecial() {
        return servicioEspecial;
    }

    @Override
    public void setServicioEspecial(ServicioEspecial servicioEspecial) {
        this.servicioEspecial = servicioEspecial;
    }
    
}
