package persistencia.proxy;

import java.util.Date;

public class ReciboImpl implements Recibo{
   private int nroRecibo;
   private Date fecha;
   private FacturaCliente facturaCliente;

   @Override
   public int getNroRecibo() {
      return this.nroRecibo;
   }

   @Override
   public void setNroRecibo(int nroRecibo) {
      this.nroRecibo = nroRecibo;
   }

   @Override
   public Date getFecha() {
      return this.fecha;
   }

   @Override
   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   @Override
   public FacturaCliente getFacturaCliente() {
      return this.facturaCliente;
   }

   @Override
   public void setFacturaCliente(FacturaCliente facturaCliente) {
      this.facturaCliente = facturaCliente;
   }
} // fin de la clase ReciboImpl