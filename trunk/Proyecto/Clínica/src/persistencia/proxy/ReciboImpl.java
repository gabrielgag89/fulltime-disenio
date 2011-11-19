package persistencia.proxy;

import java.util.Date;
import java.util.List;

public class ReciboImpl implements Recibo{
   private int nroRecibo;
   private Date fecha;
   private FacturaCliente facturacliente;

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
      return this.facturacliente;
   }

   @Override
   public void setFacturaCliente(FacturaCliente facturacliente) {
      this.facturacliente = facturacliente;
   }
}