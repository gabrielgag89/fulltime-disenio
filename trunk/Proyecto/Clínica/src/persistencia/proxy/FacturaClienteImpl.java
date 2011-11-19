// FacturaClienteImpl: FacturaClienteImpl.java
// 

package persistencia.proxy;

import java.util.Date;

/**
 * @author Cristian
 * @version 1.0
 * @created 22-oct-2011 07:16:23 p.m.
 */
public class FacturaClienteImpl implements FacturaCliente{
   private int numFactura;
   private Date fechaEmision;
   private double monto;
   public FichaInternacion fichaInternacion;
   public EstadoFacturaCliente estadoFacturaCliente;

   @Override
   public int getNumFactura() {
      return numFactura;
   }

   @Override
   public void setNumFactura(int numFactura) {
      this.numFactura = numFactura;
   }

   @Override
   public Date getFechaEmision() {
      return fechaEmision;
   }

   @Override
   public void setFechaEmision(Date fechaEmision) {
      this.fechaEmision = fechaEmision;
   }

   @Override
   public double getMonto() {
      return monto;
   }

   @Override
   public void setMonto(double monto) {
      this.monto = monto;
   }

   @Override
   public FichaInternacion getFichaInternacion() {
      return fichaInternacion;
   }

   @Override
   public void setFichaInternacion(FichaInternacion fichaInternacion) {
      this.fichaInternacion = fichaInternacion;
   }

   @Override
   public EstadoFacturaCliente getEstadoFacturaCliente() {
      return estadoFacturaCliente;
   }

   @Override
   public void setEstadoFacturaCliente(EstadoFacturaCliente estadoFacturaCliente) {
      this.estadoFacturaCliente = estadoFacturaCliente;
   }
} // fin de la clase FacturaClienteImpl