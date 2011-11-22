package persistencia.proxy;

import java.util.Date;

public interface Recibo {
   public int getNroRecibo();
   
   public void setNroRecibo(int nroRecibo);
   
   public Date getFecha();
   
   public void setFecha(Date fecha);
   
   public FacturaCliente getFacturaCliente();
   
   public void setFacturaCliente(FacturaCliente facturaCliente);
}