package persistencia.proxy;

import java.util.Date;


public class CostoPrestacionImplementacion implements CostoPrestacion {

    private Date fechaInicio;
    private Date fechaFin;
    private float monto;

    
    @Override
    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public Date getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public float getMonto() {
        return monto;
    }

    @Override
    public void setMonto(float monto) {
        this.monto = monto;
    }

   
}//end CostoPrestacion