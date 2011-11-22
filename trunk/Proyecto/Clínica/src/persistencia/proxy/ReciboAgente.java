package persistencia.proxy;

import java.util.Date;
import persistencia.FachadaPersistenciaInterna;

public class ReciboAgente extends ObjetoPersistente implements Recibo {
   private ReciboImpl impl;
   private boolean facturacliente = false;
   private String oidFacturaCliente;

   public void setImplementacion(ReciboImpl impl) {
      this.impl = impl;
   }

   @Override
   public int getNroRecibo() {
      return this.impl.getNroRecibo();
   }

   @Override
   public void setNroRecibo(int nroRecibo) {
      this.impl.setNroRecibo(nroRecibo);
   }

   @Override
   public Date getFecha() {
      return  this.impl.getFecha();
   }

   @Override
   public void setFecha(Date fecha) {
      this.impl.setFecha(fecha);
   }

   @Override
   public FacturaCliente getFacturaCliente() {
      if(!facturacliente){
         this.impl.setFacturaCliente((FacturaCliente) FachadaPersistenciaInterna.getInstancia().buscar("FacturaCliente", oidFacturaCliente));
         this.facturacliente = true;
      }
      
      return this.impl.getFacturaCliente();
   }

   @Override
   public void setFacturaCliente(FacturaCliente facturaCliente) {
      this.impl.setFacturaCliente(facturaCliente);
      this.oidFacturaCliente = ((ObjetoPersistente) facturaCliente).getOid();
   }

   public String getOidFacturaCliente() {
      return oidFacturaCliente;
   }

   public void setOidFacturaCliente(String oidFacturaCliente) {
      this.oidFacturaCliente = oidFacturaCliente;
   }
} // fin de la clase ReciboAgente