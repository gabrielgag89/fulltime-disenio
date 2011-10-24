
package persistencia.proxy;

import java.util.Date;


public interface CostoPrestacion {

    public Date getFechaFin();
    public void setFechaFin(Date fechaFin);
    public Date getFechaInicio();
    public void setFechaInicio(Date fechaInicio);
    public float getMonto();
    public void setMonto(float monto);

}//fin interface Costo prestacion
