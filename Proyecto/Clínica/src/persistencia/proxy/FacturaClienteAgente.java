package persistencia.proxy;

import java.util.Date;
import persistencia.FachadaPersistenciaInterna;

public class FacturaClienteAgente extends ObjetoPersistente implements FacturaCliente{
   private FacturaClienteImpl impl;
   private boolean fichaInternacion = false;
   private boolean estadoFacturaCliente = false;
   private String oidFichaInternacion;
   private String oidEstadoFacturaCliente;
   
   public void setImplementacion(FacturaClienteImpl impl){
      this.impl = impl;
   }

   @Override
   public int getNumFactura() {
      return this.impl.getNumFactura();
   }

   @Override
   public void setNumFactura(int numFactura) {
      this.impl.setNumFactura(numFactura);
   }

   @Override
   public Date getFechaEmision() {
      return this.impl.getFechaEmision();
   }

   @Override
   public void setFechaEmision(Date fechaEmision) {
      this.impl.setFechaEmision(fechaEmision);
   }

   @Override
   public double getMonto() {
      return this.impl.getMonto();
   }

   @Override
   public void setMonto(double monto) {
      this.impl.setMonto(monto);
   }

   @Override
   public FichaInternacion getFichaInternacion() {
      if(!this.fichaInternacion){
         this.impl.setFichaInternacion((FichaInternacion) FachadaPersistenciaInterna.getInstancia().buscar("FichaInternacion", this.oidFichaInternacion));
         this.fichaInternacion = true;
      }
      
      return this.impl.getFichaInternacion();
   }

   @Override
   public void setFichaInternacion(FichaInternacion fichaInternacion) {
      this.impl.setFichaInternacion(fichaInternacion);
      this.oidFichaInternacion = ((ObjetoPersistente) fichaInternacion).getOid();
   }

   @Override
   public EstadoFacturaCliente getEstadoFacturaCliente() {
      if(!this.estadoFacturaCliente){
         this.impl.setEstadoFacturaCliente((EstadoFacturaCliente) FachadaPersistenciaInterna.getInstancia().buscar("EstadoFacturaCliente", this.oidEstadoFacturaCliente));
         this.estadoFacturaCliente = true;
      }
      
      return this.impl.getEstadoFacturaCliente();
   }

   @Override
   public void setEstadoFacturaCliente(EstadoFacturaCliente estadoFacturaCliente) {
      this.impl.setEstadoFacturaCliente(estadoFacturaCliente);
      this.oidEstadoFacturaCliente = ((ObjetoPersistente) estadoFacturaCliente).getOid();
   }

   public String getOidFichaInternacion() {
      return oidFichaInternacion;
   }

   public void setOidFichaInternacion(String oidFichaInternacion) {
      this.oidFichaInternacion = oidFichaInternacion;
   }

   public String getOidEstadoFacturaCliente() {
      return oidEstadoFacturaCliente;
   }

   public void setOidEstadoFacturaCliente(String oidEstadoFacturaCliente) {
      this.oidEstadoFacturaCliente = oidEstadoFacturaCliente;
   }
} // fin de la clase FacturaClienteAgente