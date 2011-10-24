package persistencia.proxy;

import java.util.Date;

public interface CostoPrestacion {
   public Date getFechaInicio();

   public void setFechaInicio(Date fechaInicio);

   public Date getFechaFin();

   public void setFechaFin(Date fechaFin);

   public float getMonto();

   public void setMonto(float monto);  public Prestacion getPrestacion();

   public void setPrestacion(Prestacion prestacion);
} // fin interface CostoPrestacion